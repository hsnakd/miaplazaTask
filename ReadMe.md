# **MiaPrep Online High School Application Testing Project**

## Project Overview
This project automates the testing of the application process for MiaPrep Online High School. It ensures users can navigate to the MiaPrep application page, fill in required sections, and submit the application form. Tests are implemented using the Cucumber framework, facilitating behavior-driven development (BDD) and providing clear test scenario documentation.

## Framework Overview
The project leverages the following technologies and frameworks:

### Technologies:
- **Java**: Primary programming language for test implementation.
- **Selenium WebDriver**: Automation tool for web application testing and interaction with web elements.
- **Cucumber**: Facilitates BDD, enabling test scenarios to be written in Gherkin language.
- **JUnit**: Used for test execution.
- **Maven**: Manages project and dependencies.
- **WebDriverManager**: Simplifies browser driver management.

### Components:
- **Feature Files**: Written in Gherkin syntax to define test scenarios.
- **Step Definitions**: Java classes mapping Gherkin steps to executable code.
- **Page Classes**: Represent web pages with @FindBy annotations for element identification.
- **Driver**: Manages WebDriver instances based on configuration.
- **BrowserUtils**: Provides reusable methods for browser operations.
- **ConfigurationReader**: Loads environment configurations from configuration.properties.
- **Hooks**: Defines pre- and post-condition actions for scenarios and steps, including screenshots.
- **Reports**: Utilizes Maven Cucumber Reporting for detailed test reports, including screenshots on failure.

### Project Structure:

src/test/java: Contains the test automation files including step definitions and runners.
src/test/java/com/miaplaza/utilities/drivers: Contains WebDriver binaries automatically managed by WebDriverManager.
src/test/resources: Contains feature files written in Gherkin syntax for defining test scenarios.
configuration.properties: Contains configuration files (configuration.properties) for environment and browser settings.

```
├── src
│   ├── test
│   │   ├── java
│   │   │   └── com
│   │   │       └── miaplaza
│   │   │           └── pages
│   │   │               └── Miaplaza_page
│   │   │           └── runners
│   │   │               └── CukesRunner.java
│   │   │               └── FailedTestRunner.java
│   │   │           └── step_definitions
│   │   │               └── Miaplaza_SD.java
│   │   │           └── utilities
│   │   ├── resources
│   │   │   └── features
│   │   │       └── miaplaza.feature
├── .gitignore
├── configuration.properties
├── pom.xml
└── README.md
```


## How to Run the Tests

### Prerequisites

1. Ensure Java Development Kit (JDK) 11 or higher is installed.
2. Ensure Chrome or Firefox browsers are available.

### Clone the Repository
Clone the project repository from GitHub.

### Import Project
Import the project into your preferred IDE (e.g., IntelliJ, Eclipse).

### Install Dependencies
- Ensure Maven dependencies are resolved. In IntelliJ, Maven should download dependencies automatically. 
- In Eclipse, right-click on the project → Maven → Update Project.

### Run Tests using CukesRunner
1. Navigate to `src/test/java/runners/CukesRunner.java`.
2. Right-click on `CukesRunner.java` and select "Run CukesRunner" or run it as a JUnit test.
    - This executes all feature files defined in `src/test/resources/features`.
    - Alternatively, use the `@miplaza` tag to run only the MiaPlaza tests.

### ReRun Failed Tests using FailedTestRunner
- If any tests fail, rerun them using `FailedTestRunner.java` for debugging:
    1. Right-click on `FailedTestRunner.java`.
    2. Select "Run FailedTestRunner" or run it as a JUnit test.
    - This executes only scenarios that previously failed.
      
### Generating Reports

1. After the test execution, reports can be found in the /target directory.
2. Open cucumber-report.html in browser to view detailed test results.
3. After finishing the test, you can also access the Cucumber.io report through the console.
4. 

## Notes

- **_Parent and student forms have been filled in as requested. Since the submission of the application is not required, the last two steps were implemented to simulate submissions._**

### Test Environment Details

- **Selenium Version**: 4.22.0
- **Chrome Version**: 26.0.6478.127 (Official Build) (arm64)
- **Device**: MacBook Pro
- **Operating System**: MacOS Sonoma 14.4

### Performance Optimization

- The framework supports parallel execution to enhance test suite performance.

