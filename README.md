# AppiumProject

## Installation
1. run `appium-doctor`. Everything should be ok.
2. run `brew install allure` (or similar installer for your OS)

### iOS App Installation
1. Type `git clone https://github.com/panarik/App-IOS-TestFeatures.git`.
2. Build app via xCode.
3. First run app on your device. Make sure that app opened correctly.
4. Go to project settings `src/test/resources/settings.json` and put here your device credentials:
   1. `"platform_name": "iOS"`,
   2. `"platformVersion": "your device platform version"`,
   3. `"udid": "your device udid"`
      1. connect your device via USB 
      2. run `ios-deploy -c`. Its shows your device udid.
   4. `"app": "full/path/to/App-IOS-TestFeatures.app"`
      1. you can find it on target package in xCode. It appeared after you built app.

### Android App Installation
1. Compile this app: `https://github.com/panarik/App-Android-TestFeatures`
2. input full path to compiled apk here: src/test/resources/settings.json

## Run tests.
1. Input type OS of tests which needed here: src/test/java/com/github/panarik/appiumProject/model/base/Configs.java
   1. `ANDROID`.
   2. `IOS`.

2. Type `./gradlew testAppium`. 
      It starts custom Gradle task for running tests from src/test/resources/testNGAppium.xml

## Use Browserstack
1. Upload apk to browserstack.
2. Put your Browserstack credentials here: src/test/java/com/github/panarik/appiumProject/controller/AppiumInstance.java
3. Type `./gradlew testAppium`.