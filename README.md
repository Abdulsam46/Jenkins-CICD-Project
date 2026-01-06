# CI/CD and GitOps Pipeline for Java Spring Boot Application

<img width="1658" height="885" alt="image" src="https://github.com/user-attachments/assets/65d12383-0f7a-4775-9f71-98c20f423881" />




<br>
<br>

- Jenkins for automated build and CI orchestration
- SonarQube integrated for static code analysis and quality gates
- Docker used to build and push versioned application images
- Kubernetes used as the runtime orchestration platform
- Argo CD enables GitOps-based continuous deployment by syncing manifests from Git




### Pipeline Flow

Code Commit → Jenkins Build → SonarQube Scan → Docker Image Build & Push → Git Manifest Update → Argo CD Sync → Kubernetes Deployment
