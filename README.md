## REST-Assured Template project

### Project Configuration:

#### Java, Maven, REST-Assured, JUnit5, Reporting Plugin:

- JAVA 11 - temurin Eclipse Temurin 11.0.17
- Maven 3.8.6
- REST-Assured 5.3.0
- JUnit5 5.9.0
- Allure 2.2.1 (refer to next section)

### Test Framework:
**JUnit5** 

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

#### Test reporting:

$ mvn clean test

#### Generate HTML raport:

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
