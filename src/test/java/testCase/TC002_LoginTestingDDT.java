package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.TestBase;
public class TC002_LoginTestingDDT  extends TestBase
{
	
	@Test(dataProvider="LoginData", dataProviderClass=Utilities.DataProviders.class)
     public void VerifyLoginTest(String email, String password, String exp)
     {
    	try 
    	 {
    		 HomePage hp = new HomePage(driver);
	    	 hp.MyAccount();
	    	 logger.info("Clicked on Account link");
	    	 
	    	 hp.MyLogin();
	    	 logger.info("Clicked on Login link");
	    	 
	    	 LoginPage lp= new LoginPage(driver);
	    	 lp.SetEmail(email);
	    	 lp.SetPassword(password);
	    	 lp.ClkLogin();
	    	 
	    	 MyaccountPage mp = new MyaccountPage(driver);
	    	 boolean targetPage = mp.getLoginConfirmation();
    	 
	    	 if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						mp.ClkLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true)
					{
						mp.ClkLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
			}
			catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
		
    	
     }
}
