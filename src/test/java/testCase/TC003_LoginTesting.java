package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.TestBase;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC003_LoginTesting extends TestBase
{

	@Test(groups={"regression","master"})
	public void verify_loginTest()
	{
		//logger.info("***** Starting the TC003_LoginTesting *****");
	
		//Home page
			HomePage hp=new HomePage(driver);
			hp.MyAccount();
			hp.MyLogin(); //Login link under MyAccount
				
			//Login page
			LoginPage lp= new LoginPage(driver);
	    	lp.SetEmail(p.getProperty("email"));
	        lp.SetPassword(p.getProperty("password"));
	    	lp.ClkLogin();
				
			//My Account Page
			MyaccountPage macc=new MyaccountPage(driver);
			boolean targetPage=macc.getLoginConfirmation();
			
               if(targetPage==true)
				{
					macc.ClkLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			
		
		
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}
