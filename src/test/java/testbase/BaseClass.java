package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	 @BeforeClass(groups={"sanity","regression","master","datadriven"})
    @Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException{
    	//loading config.properties file
    	FileInputStream file=new FileInputStream("./src//test//resources//config.properties");
    	p=new Properties();
    	p.load(file);
    	
    	logger=LogManager.getLogger(this.getClass());//this is for loading log4j2 xml file
    	
    	switch(br.toLowerCase()) {
    	
    	case "chrome":driver=new ChromeDriver();break;
    	case "firefox":driver=new FirefoxDriver();break;
    	case "edge":driver=new EdgeDriver();break;
    	default: System.out.println("invalid browser"); return;
    	}
    
    
    
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	@AfterClass(groups={"sanity","regression","master","datadriven"})
	public void teardown() {
		driver.quit();
	}
		
		public String RandomString() {
			String generatedstring=RandomStringUtils.randomAlphabetic(5);
			return generatedstring;
			
		}
		
		public String RandomNumber() {
			String generatednumber=RandomStringUtils.randomNumeric(10);
			return generatednumber;
		}
		
		
		public String RandomAlphanumeric() {
			String generatedstring=RandomStringUtils.randomAlphabetic(5);
			String generatednumber=RandomStringUtils.randomNumeric(4);
			return (generatedstring+"@"+generatednumber);
			
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


		



