# AUTOMATION DEMO SITE - Selenium

## Summary
1. [About the project](#about-the-project)
2. [How to run](#how-to-run)
3. [Author](#author)

## About the project

This is a Selenium Automation project using the website: https://demo.automationtesting.in/Register.html

## How to run

To run the tests use the following steps:

**1. Clone the repository**

```shell
git clone https://github.com/Luancsn14/automationdemositeselenium.git
cd repo
```

**2. Environment configuration**

Make sure that Java JDK (version 8 or higher) is installed. You can verify the installation with:

```shell
java -version
```

**3. Dependencies**

The project uses Maven to manage dependencies. Check if Maven is installed:

```shell
mvn -v
```
If it is not, install it (https://maven.apache.org/download.cgi). 

**4. Install Project Dependencies**

Navigate to the project directory and run:

```shell
mvn install
```

**5. Run the tests**

To run the tests, use the following command:

```shell
mvn clean test -Dtest=TestsSuite
```

Test results will be displayed in the console and also saved in report files in the folder "target/surefire-reports".

## Author
* **Luan Castro**
   * [GitHub](https://github.com/Luancsn14)
   * [LinkedIn](https://www.linkedin.com/in/luan-castro-18a4636a/)
