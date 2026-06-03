# Automation Testing Framework (Web + API + E2E)

Framework ini digunakan untuk automation testing menggunakan:
- Selenium WebDriver (UI Testing)
- Cucumber BDD (Scenario-based testing)
- Rest Assured (API Testing)
- JUnit 4 (Test Runner)
- Gradle (Build Tool)
- Page Object Model (POM)

---

# 📁 Project Structure


# 📌 Table of Contents
- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Test Coverage](#test-coverage)
- [How to Run](#how-to-run)
- [Test Tagging](#test-tagging)
- [Cucumber Report](#cucumber-report)
- [CI/CD](#cicd)
- [Best Practices Implemented](#best-practices-implemented)

---

# 🧠 Overview

Framework ini mencakup:

- ✅ Web UI Testing (Selenium)
- ✅ API Testing (RestAssured)
- ✅ BDD dengan Gherkin & Cucumber
- ✅ Modular structure (Web & API dipisah)
- ✅ CI/CD dengan GitHub Actions

Simulasi CRM meliputi:
- Login user
- Pengelolaan data customer
- Validasi API backend

---

# 🛠 Tech Stack

| Tools | Description |
|------|------------|
| Java | Programming Language |
| Gradle | Build Tool |
| Selenium | Web UI Automation |
| RestAssured | API Automation |
| Cucumber | BDD Framework |
| JUnit | Test Runner |
| GitHub Actions | CI/CD |

---

# 📁 Project Structure

```
.
├── build
│   ├── classes
│   │   └── java
│   │       └── test
│   │           ├── api
│   │           │   ├── runners
│   │           │   │   └── ApiTestRunner.class
│   │           │   └── steps
│   │           │       ├── CustomerApiSteps.class
│   │           │       └── UserSteps.class
│   │           ├── utils
│   │           │   └── DriverManager.class
│   │           └── web
│   │               ├── pages
│   │               │   ├── CartPage.class
│   │               │   ├── HomePage.class
│   │               │   ├── LoginPage.class
│   │               │   └── ProductPage.class
│   │               ├── runners
│   │               │   ├── E2ETestRunner.class
│   │               │   └── WebTestRunner.class
│   │               └── steps
│   │                   ├── E2ESteps.class
│   │                   ├── Hooks.class
│   │                   └── LoginSteps.class
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       │       └── test
│   │       └── headers
│   │           └── java
│   │               └── test
│   ├── reports
│   │   ├── cucumber-report.html
│   │   ├── cucumber.json
│   │   └── tests
│   │       ├── apiTest
│   │       │   ├── classes
│   │       │   │   └── CRM-User-API.html
│   │       │   ├── css
│   │       │   │   ├── base-style.css
│   │       │   │   └── style.css
│   │       │   ├── index.html
│   │       │   ├── js
│   │       │   │   └── report.js
│   │       │   └── packages
│   │       │       └── default-package.html
│   │       ├── e2eTest
│   │       │   ├── classes
│   │       │   │   └── web.runners.E2ETestRunner.html
│   │       │   ├── css
│   │       │   │   ├── base-style.css
│   │       │   │   └── style.css
│   │       │   ├── index.html
│   │       │   ├── js
│   │       │   │   └── report.js
│   │       │   └── packages
│   │       │       └── web.runners.html
│   │       └── webTest
│   │           ├── classes
│   │           │   └── Demoblaze-Login.html
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           ├── js
│   │           │   └── report.js
│   │           └── packages
│   │               └── default-package.html
│   ├── resources
│   │   └── test
│   │       ├── api
│   │       │   └── features
│   │       │       ├── customer_api.feature
│   │       │       └── user.feature
│   │       └── web
│   │           └── features
│   │               ├── e2e_customer.feature
│   │               └── login.feature
│   ├── test-results
│   │   ├── apiTest
│   │   │   ├── TEST-CRM-User-API.xml
│   │   │   └── binary
│   │   │       ├── output.bin
│   │   │       ├── output.bin.idx
│   │   │       └── results.bin
│   │   ├── e2eTest
│   │   │   ├── TEST-web.runners.E2ETestRunner.xml
│   │   │   └── binary
│   │   │       ├── output.bin
│   │   │       ├── output.bin.idx
│   │   │       └── results.bin
│   │   └── webTest
│   │       ├── TEST-Demoblaze-Login.xml
│   │       └── binary
│   │           ├── output.bin
│   │           ├── output.bin.idx
│   │           └── results.bin
│   └── tmp
│       ├── apiTest
│       ├── compileTestJava
│       │   └── previous-compilation-data.bin
│       ├── e2eTest
│       └── webTest
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── readme.md
├── reports
│   ├── api.html
│   ├── api.json
│   ├── web.html
│   └── web.json
├── settings.gradle
├── src
│   ├── main
│   │   ├── java
│   │   │   └── sastimauli
│   │   │       └── demo
│   │   └── resources
│   └── test
│       ├── java
│       │   ├── api
│       │   │   ├── runners
│       │   │   │   └── ApiTestRunner.java
│       │   │   └── steps
│       │   │       ├── CustomerApiSteps.java
│       │   │       └── UserSteps.java
│       │   ├── utils
│       │   │   └── DriverManager.java
│       │   └── web
│       │       ├── pages
│       │       │   ├── CartPage.java
│       │       │   ├── CustomerPage.java
│       │       │   ├── HomePage.java
│       │       │   ├── LoginPage.java
│       │       │   └── ProductPage.java
│       │       ├── runners
│       │       │   ├── E2ETestRunner.java
│       │       │   └── WebTestRunner.java
│       │       └── steps
│       │           ├── E2ESteps.java
│       │           ├── Hooks.java
│       │           └── LoginSteps.java
│       └── resources
│           ├── api
│           │   └── features
│           │       ├── customer_api.feature
│           │       └── user.feature
│           └── web
│               └── features
│                   ├── e2e_customer.feature
│                   └── login.feature
└── target
    └── cucumber-reports
        ├── e2e-report.html
        └── e2e-report.json
```

---

# 🧪 Test Coverage

## 🌐 Web UI Testing
Target: https://www.saucedemo.com/

Scenario yang diuji:
- Login valid
- Login invalid
- Navigasi dashboard
- Add Cart
- Log Out

---

## 🔌 API Testing
Target: https://dummyapi.io/

Scenario yang diuji:
- Get User by ID
- Invalid User Request
- Validasi response status

Authentication menggunakan header:

```
app-id: 63a804408eb0cb069b57e43a
```

---

# ▶️ How to Run

## 🔹 Jalankan API Test
```bash
./gradlew apiTest
```

## 🔹 Jalankan Web Test
```bash
./gradlew webTest
```
## 🔹 Jalankan End to End Test
```bash
./gradlew e2eTest
---
```

# 🏷 Test Tagging

Framework menggunakan tagging Cucumber:

| Tag  | Description                 |
|------|-----------------------------|
| @web | Menjalankan Web UI test     |
| @api | Menjalankan API test        |
| @e2e | Menjalankan End To End test |
---


# 📊 Cucumber Report

Framework ini menggunakan **Cucumber Reporting** untuk menghasilkan hasil eksekusi test dalam format **HTML** dan **JSON**.

---

## 📍 Lokasi Report

Setelah test dijalankan, report akan otomatis tersimpan di folder:

```
reports/
├── web.html
├── web.json
├── api.html
└── api.json
```

---

## 🧪 Jenis Report

### 🔹 HTML Report
File:
```
reports/web.html
reports/api.html
```

Berfungsi untuk:
- Melihat hasil test secara visual di browser
- Menampilkan:
    - Scenario
    - Step (Given / When / Then)
    - Status (PASSED / FAILED)
    - Error message (jika gagal)

Cara membuka:
- Klik file `.html`
- Atau buka dengan browser

---

### 🔹 JSON Report
File:
```
reports/web.json
reports/api.json
reports/cucumber.json
```

Berfungsi untuk:
- Integrasi dengan tools lain (Allure, Jenkins, dll)
- Parsing hasil test automation

---

## ⚙️ Konfigurasi Report

Report dikonfigurasi di **Cucumber Runner Class**:

```java
@CucumberOptions(
    features = "src/test/resources/web/features",
    glue = "web.steps",
    tags = "@web",
    plugin = {
        "pretty",
        "html:reports/web.html",
        "json:reports/web.json"
    }
)
```

---

## ▶️ Cara Generate Report

Report akan otomatis dibuat setelah menjalankan test:

### Web Test
```bash
./gradlew webTest
```

### API Test
```bash
./gradlew apiTest
```
### End to End Test
```bash
./gradlew e2eTest
```
---

# 🤖 CI/CD

Pipeline menggunakan **GitHub Actions**

### Trigger:
- Pull Request
- Manual Trigger (workflow_dispatch)

### Workflow:
1. Checkout code
2. Setup Java
3. Run API Test
4. Run Web Test

---

# ✅ Best Practices Implemented

- Page Object Model (POM)
- Separation of concerns (Web vs API)
- Reusable Step Definitions
- Clean project structure
- Tag-based execution
- CI/CD Integration
- Maintainable & scalable framework

---

# 🚀 Future Improvements

- Parallel execution
- Allure Reporting
- Test data management
- Environment config (dev/staging/prod)
- Docker integration

---

# 👨‍💻 Author

Automation Test Framework ini dibuat untuk keperluan:
- Pembelajaran QA Automation
- Technical Assessment
- Portfolio QA Engineer

Created by : Sasti Mauli