# Notes Automation Framework

## Project Overview

This project is a hybrid automation framework developed for the Notes Application using Selenium WebDriver, TestNG, Maven and REST Assured.

The framework automates both UI and API test scenarios and follows the Page Object Model (POM) design pattern for maintainability and scalability.

---

## Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- REST Assured
- WebDriverManager
- IntelliJ IDEA
- GitHub

---

## Framework Features

- Page Object Model (POM)
- UI Automation Testing
- API Automation Testing
- Reusable Components
- Driver Management
- Configuration Management
- Maven Execution
- Positive and Negative Test Scenarios

---

## Project Structure

src/main/java

- pages
- drivers
- utils
- base

src/test/java

- tests.ui
- tests.api
- tests.negative

resources

- config.properties
- testng.xml

---

## UI Test Cases

- Login Test
- Invalid Login Test
- Empty Field Validation Test
- Create Note Test
- Delete Note Test

---

## API Test Cases

- Login API Test
- Invalid Login API Test
- Create Note API Test
- Get Notes API Test
- Delete Note API Test
- Unauthorized API Test

---

## How To Run

```bash
mvn clean test
```
