package testClassPackage;

import org.testng.annotations.Test;

import pomClassPackage.LoginpageModulescenerio;

public class RegistrationTest extends BaseClass

{
     @Test
     public void loginscenario() throws InterruptedException
     {
	LoginpageModulescenerio lms= new LoginpageModulescenerio(driver);
	
	lms.Userlogin();
}
}
