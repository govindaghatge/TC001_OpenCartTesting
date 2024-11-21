package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.TestBase;


public class TC001_RegistrationTesting extends TestBase
{
	    @Test(groups={"sanity","master"})
	    public void TestAccountRegistration()
	    {
	    	 logger.info("******Starting TC001_OpenCartApplication******");
	    	
	    	 try
	    	 {
	    		 HomePage hp = new HomePage(driver);
		    	 hp.MyAccount();
		    	 logger.info("Clicked on Account link");
		    	 
		    	 hp.MyRegister();
		    	 logger.info("Clicked on Register link");
		    	 
		    	 RegistrationPage ar = new RegistrationPage(driver);
		    	 
		    	 logger.info("Providing customer details...");
		    	 ar.SetFirstName(randomString().toUpperCase());
		    	 ar.SetLastName(randomString().toUpperCase());
		    	 ar.SetTelephone(randomNumber());
		    	 ar.SetEmail(randomString()+"@gmail.com");
		    	 
		    	 String password=randomAlphanumeric();
		    	 
		    	 ar.SetPassword(password);
		    	 ar.SetConfirmPassword(password);
		    	 ar.ClkButton();
		    	 ar.Clkcheckbox();
		    	 ar.ClkContinue();
		    	 
		    	 logger.info("Validating expected message");
		    	 String Confirm = ar.getConfirmationMessage();
		         if(Confirm.equals("Congratulations! Your new account has been successfully created!"))
		         {
		        	 Assert.assertTrue(true);
		         }
		         
		         else 
		         {
		        	 logger.error("Test failed");
		        	 logger.debug("Debug logs");
		        	 Assert.assertTrue(false);
		         }
		    	
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 Assert.fail();
	    	 }
	       
	    	    logger.info("****** Finished TC001_OpenCartApplication ******");
	    }
}
