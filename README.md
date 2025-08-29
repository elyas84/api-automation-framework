API Automation Framework

Overview

This project is an API automation framework built using RestAssured, TestNG, and Maven in Java.
It is designed to test API endpoints, validate responses, handle authentication, and generate detailed reports.

Key Features:
• Dynamic request and response handling.
• Centralized validation in helper classes.
• Token-based authentication for APIs.
• Data-driven testing with JSON/POJO support.
• Pagination and uniqueness validation.
• Extent report integration for clear reporting.

```
src/
│
├── base/                   # RequestSpecFactory, TestBase for setup and common logic
├── clients/                # API clients: endpoints, request sending, and response handling
├── config/                 # API config (baseURL, API key), appData (system properties), ConfigurationReader
├── extentReport/           # Extent report generation after each run
├── helper/                 # API request and response validation
├── listeners/              # TestNG listeners to handle events
├── modules/                # Request/Response POJOs for JSON serialization/deserialization
├── utility/                # Utility classes
└── tests/                  # Test classes
```

Folder Details
• Base: Contains RequestSpecFactory and TestBase for reusable setup logic.
• Clients: Handles API requests, endpoints, and response retrieval.
• Config: Stores API configurations (baseURL, API keys), system properties, and ConfigurationReader for reading property
files.
• ExtentReport: Generates HTML reports after each test run.
• Helper: Centralizes request and response validation logic.
• Listeners: Handles TestNG events, logging, and reporting triggers.
• Modules: Contains request and response models, POJO classes for sending/reading JSON payloads.

⸻

Authentication
• The framework supports token-based authentication.
• Token is returned when credentials are valid and can be reused in subsequent API calls.

⸻

How to Run Tests

1. Run Individually
   • Click Run on a specific test class in your IDE.

2. Run via TestNG XML
   • Execute a suite using TestNG XML file (e.g., apiSmoke.xml).

```
 mvn clean test -DconfigFile=config.properties -DsuiteXmlFile=apiSmoke.xml
```

Reports
• Extent Report is generated after each run.
• Reports are created whether tests are run from IDE, XML, or Maven command.
• The report contains details of test execution, pass/fail status, and request/response logs.

⸻

Notes
• Tests and validations are centralized in helper classes to keep test classes clean and readable.
• Framework supports dynamic configuration via config.properties and system properties.
• Can be extended easily for new endpoints or additional validations.

