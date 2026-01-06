package com.abdul.devops.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.time.LocalDateTime;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String dashboard(Model model) throws Exception {

        String hostname = InetAddress.getLocalHost().getHostName();
        String environment = System.getenv().getOrDefault(
                "ENVIRONMENT",
                "EC2 / Bare Metal"
        );

        model.addAttribute("hostname", hostname);
        model.addAttribute("time", LocalDateTime.now());
        model.addAttribute("environment", environment);
        model.addAttribute("status", "RUNNING");

        return "dashboard";
    }
}
