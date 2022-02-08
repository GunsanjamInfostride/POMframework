package TestBase;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParent 
{
	public static WebDriver driver;
    public static Properties prop;
    public TestParent()
    {
    try
    {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\Configuration\\config.properties\\");
        prop.load(fis);
    } 
     catch (IOException e)
    {
        e.printStackTrace();
    }
}
    public void initialization() {
       
    	WebDriverManager.chromedriver().setup();
    	driver =new ChromeDriver();
    	driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get(prop.getProperty("url"));
    }
}