# # QuickRideAutomation

The demo for automation test project of QuickRide android app using Appium & Java
### Prerequisites
Following softwares must be installed before runnning this automation

```
- Java
- Maven
- Android
- Appium Server
- TestNG 
```

## Steps to run this Automation
###### Clone git repository using this command git clone https://github.com/rahulkewlani/QuickRideAutomation.git
###### Connect your USB cable to mobile phone.
###### Go to setttings and enable USB debugging
###### This test can be run by two ways

- Using Default values configured in test setup.
 ```
  - mvn -Dtest=BookRide test
```
- Using Customised values.
```
  - mvn -DdeviceName=<deviceName> -DplatformName=<platformName> -platformVersion=<platformVersion> -DappPackage=<appPackage-DappActivity=<appActivity> -DserverURL=<serverURL> -DloginId=<loginId> -Dpassword=<password> -Dtest=BookRide test
```
