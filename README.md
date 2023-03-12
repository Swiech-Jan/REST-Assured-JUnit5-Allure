## REST-Assured Template project

### Project Configuration:

#### Java, Maven, REST-Assured, JUnit5, Reporting Plugin:

- JAVA 11.0.17 ORACLE LTS
- Maven 3.8.6
- REST-Assured 5.3.0
- JUnit5 5.9.0
- Allure 2.2.1 (refer to next section)

### Test Framework:

**JUnit5**

### Building Project

- Select Proper JDK and Maven versions in IntelliJ Idea
- Resolve Maven Dependencies
- Build with: 'mvn clean install'
- Project is ready for running Tests

### Test reports with Allure

#### Allure Documentation: [Allure](https://docs.qameta.io/allure/#_about)

#### Install Allure version 2.20.1: [Allure version 2.20.1](https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.20.1/)

#### Allure Installation Steps:

- Download the zip
- Extract zip and name it as: allure-commandline
- Put the folder to program files directory
- Execute bat script in /bin folder
- Add path variable to /bin folder
- Check version in CMD:
- $ allure --version

### Test reporting:

**First you must run a test in order to generate results in /target**

#### Generate HTML report:

$ allure serve target/allure-results

### Allure annotations:

- @Epic
- @Features
- @Stories/@Story
- @Severity(SeverityLevel.BLOCKER)
- @Description("In this cool test we will check cool thing")
- @Step
- @Attachment
- @Link

### REST-Assured Introduction

For REST-Assured Introduction refer
to: [REST-Assured Introduction](https://testautomationu.applitools.com/automating-your-api-tests-with-rest-assured/chapter1.html)