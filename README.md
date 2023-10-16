
# Appium Testing Framework for Calculator App
This project is an automation testing framework designed to test a calculator application using Appium, Java, and Cucumber in the Page Object Model (POM) structure.

**Prerequisites**

Java:
Download and install Java JDK.
Set JAVA_HOME environment variable to point to your JDK installation directory.

Android SDK:
Download and install Android Studio.
Set up one or more Android Virtual Devices (AVD) using the AVD Manager in Android Studio.
Set ANDROID_HOME environment variable to point to your SDK directory (typically Users/<username>/Library/Android/sdk on macOS and C:\Users\<username>\AppData\Local\Android\Sdk on Windows).
Add the platform-tools directory to your system's PATH, which includes essential tools like adb.

Appium:
Install Appium using npm: npm install -g appium or download and install from Appium's official site.
Ensure Appium server is running before executing tests.

Maven:
Download and install Maven.
Ensure MVN_HOME and MAVEN_HOME environment variables are set and that the Maven bin directory is added to your system's PATH.

Cucumber:
Dependencies for Cucumber are managed by Maven and are included in the pom.xml.

Calculator App:
The APK for the calculator app is stored within this code repository.

Device Connection
Connect physical device or emulator from Android studio
Try the command ADB devices to check the device is connected and ready for execution.
If it is physical device change the desired capabilities accordingly, currently specified for "emulator"

**Running Tests**

Clone this repository to your local machine.
Navigate to the project directory.
Run the following command:
**mvn clean test**
Once the tests have run, the reports can be found in the specified report directory.
