# 🚀 Project Setup Guide  

This guide explains how to set up and run the application locally, including both the backend (Spring Boot) and frontend (Electron-based).  

## 📦 Prerequisites  

Before starting, ensure the following are installed on your system:

- [Docker](https://www.docker.com/products/docker-desktop/)
- [Node.js and npm](https://nodejs.org/) (LTS version recommended)  

## 🛠️ Backend Setup (Spring Boot)  

Run the following command **inside the backend directory**, where `docker-compose.yml` is located:  

```bash
docker compose up -d
```  

This starts the Docker containers in detached mode (-d) based on the configuration defined in `docker-compose.yml`. It launches the PostgreSQL database needed by the backend.

Once the database is up, you can start the Spring Boot server.  

## 💻 Frontend Setup (Electron + npm)

1. Navigate to the app directory:  

```bash
cd frontend/lmapp
```  

2. Install dependencies:  

```bash
npm install
```

3. Start the frontend app:  

```bash
# Normal start
npm run dev

# OR

# Clean start (fresh build)
npm run dev:clean
```  

<!-- 
## 🧪 Troubleshooting  
-->