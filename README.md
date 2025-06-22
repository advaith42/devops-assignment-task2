
# Product Catalogue Microservice

## Setup Instructions (Windows)

1. Install Docker Desktop (with WSL2 backend)
2. Install Minikube (or use Docker Desktop Kubernetes)
3. Clone this repo
4. Build Docker Image:
```bash
docker build -t your-dockerhub-username/product-catalogue:v1.0.0 .
docker push your-dockerhub-username/product-catalogue:v1.0.0
```
5. Start Minikube:
```bash
minikube start --driver=docker
```
6. Apply Kubernetes:
```bash
kubectl apply -f kubernetes/
```
7. Access via: http://localhost/v1/products
