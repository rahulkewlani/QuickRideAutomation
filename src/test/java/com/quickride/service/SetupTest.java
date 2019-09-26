package com.quickride.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.quickride.resource_id.Property;

import io.appium.java_client.android.AndroidDriver;

public class SetupTest {
static Properties prop = new Properties();

    public AndroidDriver getAndroidDriver() throws IOException {
    	  InputStream input = new FileInputStream("src/resources/config.properties");
    	  prop.load(input);
    	  
        AndroidDriver driver = null;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Property.DEVICE_NAME, prop.getProperty(Property.DEVICE_NAME));
        capabilities.setCapability(Property.PLATFORM_NAME,prop.getProperty(Property.PLATFORM_NAME));
        capabilities.setCapability(Property.PLATFORM_VERSION,prop.getProperty(Property.PLATFORM_VERSION));
        capabilities.setCapability(Property.APP_PACKAGE, prop.getProperty(Property.APP_PACKAGE));
        capabilities.setCapability(Property.APP_ACTIVITY, prop.getProperty(Property.APP_ACTIVITY));
        
        driver = new AndroidDriver(new URL(prop.getProperty(Property.SERVER_URL)),capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        return driver;
    }
    
}	