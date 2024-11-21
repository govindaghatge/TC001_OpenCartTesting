package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.FileManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase
{
	  static public WebDriver driver;
      public Logger logger;
      public Properties p;
      
      @SuppressWarnings("deprecation")
	@BeforeClass(groups= {"sanity","regression","master"})
      @Parameters({"os","browser"})
      public void SetUp(String os, String br) throws IOException
      {
    	  FileReader file = new FileReader(".//src//test//resources//config.properties");
    	  p = new Properties();
    	  p.load(file);
    	  
    	  logger = LogManager.getLogger(this.getClass());
    	 
    	  if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
    	  {
    		  DesiredCapabilities capabilities=new DesiredCapabilities();
    		  
    		  if(os.equalsIgnoreCase("windows"))
    		  {
    			  capabilities.setPlatform(Platform.WIN10);
    		  }
    		  else if(os.equalsIgnoreCase("mac"))
    		  {
    			  capabilities.setPlatform(Platform.MAC);
    		  }
    		  else
    		  {
    			  System.out.println("No matching os");
  				  return;
    		  }
    		  
    		  switch(br.toLowerCase())
    		  {
    		    case "chrome": capabilities.setBrowserName("chrome"); break;
    		    case "firefox": capabilities.setBrowserName("firefox"); break;
    		    default: System.out.println("No matching browser"); return;
    		  }
    		  driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
    	  }
    	  
    	  
    	  if(p.getProperty("execution_env").equalsIgnoreCase("local"))
    	  {  
	    	  switch(br.toLowerCase())
	    	  {
	    	  case "chrome": driver = new ChromeDriver(); break;
	    	  case "firefox":driver = new FirefoxDriver(); break;
	    	  case "edge": driver = new EdgeDriver(); break;
	    	  default : System.out.println("Invalid browser"); 
    	      }
    	  }
    	  
    	  driver.manage().deleteAllCookies();
          driver.get(p.getProperty("appURL"));
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      }
      
      @AfterClass(groups= {"sanity","regression","master"})
      public void TearDown()
      {
    	  driver.quit();
      }
      
      
      public String randomString()
      {
    	  String getrandomString = RandomStringUtils.randomAlphabetic(5);
    	  return getrandomString;
      }
      
      public String randomNumber()
      {
     	 String generatedNumber = RandomStringUtils.randomNumeric(10);
     	 return generatedNumber;
      }
      
      public String randomAlphanumeric()
      {
     	 String generatedstring = RandomStringUtils.randomAlphabetic(3);
     	 String generatedNumber = RandomStringUtils.randomNumeric(3);
     	 return (generatedstring +"@" + generatedNumber);
      }

      public String captureScreen(String tname) throws IOException {

  		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
  				
  		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
  		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
  		
  		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
  		File targetFile=new File(targetFilePath);
  		
  		sourceFile.renameTo(targetFile);
  			
  		return targetFilePath;

  	}
  	
}