package com.abdul.devops.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.time.ZonedDateTime;
import java.time.ZoneId;

@Controller
public class DashboardController {

    private static final String DEFAULT_ENVIRONMENT = "EC2 / Bare Metal";
    private static final String STATUS_RUNNING = "RUNNING";

    private final String hostname;
    private final String environment;

    public DashboardController() {
        this.hostname = resolveHostname();
        this.environment = resolveEnvironment();
    }

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute("hostname", hostname);
        model.addAttribute("time", ZonedDateTime.now(ZoneId.of("UTC")));
        model.addAttribute("environment", environment);
        model.addAttribute("status", STATUS_RUNNING);

        return "dashboard";
    }

    private String resolveHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            return "unknown-host";
        }
    }

    private String resolveEnvironment() {
        return System.getenv().getOrDefault("ENVIRONMENT", DEFAULT_ENVIRONMENT);
    }
}
