# 🔐 Auth Service — Centralized Authentication & Token Validation System

A production-ready authentication microservice built using **Spring Boot** that handles secure user authentication, token generation, and centralized token validation across distributed services.

This service acts as a **dedicated Auth Server** in a microservice architecture — separating authentication from business logic and enabling scalable, secure communication between services.

---

## 🚀 Features

- User Registration & Login
- JWT Access Token Generation
- Token Validation API (for other services)
- Role-based authorization ready
- Centralized authentication for microservices
- Stateless authentication (no session storage)
- Secure password hashing
- Expirable tokens
- API Gateway friendly
- Horizontally scalable design

---

## 🏗️ Architecture

Client → API Gateway → Auth Service → Issues Token
↓
Other Microservices
verify token via Auth Service


Single source of truth for authentication across the system.

---

## 🧠 Why This Exists

In distributed systems, every microservice should NOT manage login logic.

### Problems without Auth Server
- Duplicate authentication logic
- Security vulnerabilities
- Difficult scaling
- Hard token revocation
- Poor monitoring

### This service solves
✔ Centralized identity  
✔ Standardized token validation  
✔ Improved security  
✔ Independent scaling

---

## 🛠️ Tech Stack

| Technology | Purpose |
|----------|------|
| Java | Core language |
| Spring Boot | Backend framework |
| Spring Security | Authentication & authorization |
| JWT | Stateless authentication |
| Gradle | Build system |
| REST APIs | Service communication |

---

## 📂 Project Structure

src/
└── main/
├── controller/ → API endpoints
├── service/ → Business logic
├── security/ → JWT & filters
├── model/ → Entities
├── repository/ → Database layer
└── config/ → Security configuration


---

## ⚙️ Setup & Run Locally

### 1️⃣ Clone the repository
```bash
git clone https://github.com/GaurangMundhra/Auth-Service.git
cd Auth-Service
2️⃣ Run the application
Linux / Mac:

./gradlew bootRun
Windows:

gradlew.bat bootRun
Server starts at:

http://localhost:8080
🔑 API Endpoints
Register User
POST /auth/register
Login
POST /auth/login
Returns:

JWT Access Token
Validate Token (For other services)
POST /auth/validate
🔐 Authentication Flow
User logs in

Auth Service verifies credentials

JWT token generated

Client sends token in header

Other services validate via Auth Service

Header Format:

Authorization: Bearer <token>
📌 Intended Use
Designed for integration with:

API Gateway systems

Microservice architectures

SaaS platforms

Distributed backend systems

Enterprise scalable applications

🔮 Future Improvements
Refresh Tokens

OAuth2 provider mode

Redis token blacklist

Role & permission management

Multi-tenant support

Rate limiting

Audit logging

👨‍💻 Author
Gaurang Mundhra
B.Tech AI & DS — VIT Pune
Backend & Systems Developer

📜 License
MIT License


---
