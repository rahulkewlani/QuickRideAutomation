
package com.quickride.testsuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.quickride.resource_id.FindRideId;
import com.quickride.resource_id.LoginId;
import com.quickride.resource_id.PermissionId;
import com.quickride.resource_id.Property;
import com.quickride.service.SetupTest;

import io.appium.java_client.android.AndroidDriver;

public class BookRide {

	  SetupTest setup = new com.quickride.service.SetupTest();

	    AndroidDriver driver;
	    Properties property;
	    
	    @BeforeTest
	    private void beforeTest() throws IOException {
	        driver = setup.getAndroidDriver();
	        property=setup.getConfigProperties();
	    }
	    
	    //Quit driver after test
	    @AfterTest
	    private void afterTest() {
	        driver.quit();
	    }
	    
	    
	    public void clickOn(String id) {
	        driver.findElement(By.id(id)).click();
	    }

	    public void sendKeys(String id, String keys) {
	        driver.findElement(By.id(id)).sendKeys(keys);
	    }

	    public void getBack()
	    {
	    	driver.navigate().back();
	    }
	    
   	   /* Book a ride 
	    	* GET Permissions
	        * GET Add Login Credentials
	        * Add Booking Details 
	   * */
	    //Run your test case
	    @Test
	    public void bookRide() {
	    	

	    	 getPermission();
	    	 addLoginCredentials();
	    	 addBookingDetails();
	    	 
	    }

   	 /* Grant Permission for location and File/Media Access*/
	    public void getPermission()
	    {
	    	 clickOn(PermissionId.PERMISSION_ALLOW);
	    	 clickOn(PermissionId.PERMISSION_ALLOW);    	 
	    	
	    }
	    /* Add Login Credentials*/
	    	
	    public void addLoginCredentials()
	    {
	    	
	    	 clickOn(LoginId.LOGIN_BUTTON);
	    	 sendKeys(LoginId.LOGIN_PHONE_EDIT_TEXT,property.getProperty(Property.LOGIN_ID));
	    	 sendKeys(LoginId.LOGIN_PHONE_PWD_EDIT_TEXT,property.getProperty(Property.LOGIN_PASSWORD));
	    	 getBack();
	    	 clickOn(LoginId.LOGIN_BUTTON);
	    	 
	    }
	    /* Add Booking Details
 	    * Source Location
 	    * Destination Location
 	    * Date & Time
 	    * Number Of Seats
 	    * Find Ride 
     */
	    public void addBookingDetails()
	    {
	    	
	    	 clickOn(FindRideId.SOURCE_LOCATION_ID);
	    	 sendKeys(FindRideId.SEARCH_LOCATION,FindRideId.SOURCE_LOCATION);	 
	    	 clickOn(FindRideId.SELECTED_LOCATION_NAME);
	    	 clickOn(FindRideId.DESTINATION_LOCATION_ID);
	    	 sendKeys(FindRideId.SEARCH_LOCATION,FindRideId.DESTINATION_LOCATION);
	    	 
	    	 clickOn(FindRideId.SELECTED_LOCATION_NAME);
	    	 clickOn(FindRideId.DATE_TIME);
	    	 clickOn(FindRideId.OK_BUTTON);
	    	 clickOn(FindRideId.SEAT);
	    	 clickOn(FindRideId.TWO_SEATS);
	    	 clickOn(FindRideId.CONFIRM_SEAT_BUTTON);
	    	 clickOn(FindRideId.FIND_RIDE_BUTTON);
	   
	    }
	    
	    
}
