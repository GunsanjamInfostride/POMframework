package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestParent;

public class LoginPage extends  TestParent{

	    public static Properties prop;
	    public static WebDriver driver;
		@FindBy(id = "txtUsername")
	    WebElement uname1;
	    @FindBy(id = "txtPassword")
	    WebElement upass1;
	    @FindBy(id = "btnLogin")
	    WebElement loginbtn;
	    @FindBy(partialLinkText = "Forgot your password?")
	    WebElement forgotbtn;
	    //initializing page objects
	    public LoginPage(WebDriver driver)
	    {
	    	this.driver =driver;
	    	PageFactory.initElements(driver,this);
	    }
	    public void Login() throws IOException
	    {
	    	String path =System.getProperty("user.dir")+"//Test Data/Login_Data.xlsx";
	    	FileInputStream f1 = new FileInputStream(path);
	    	XSSFWorkbook wr = new XSSFWorkbook(f1);
	    	XSSFSheet sh = wr.getSheetAt(0);

	    	if (sh == null) throw new IllegalArgumentException("Sheet with sheet name " + sh + " does not exist");
	    	System.out.println(" the sheet last row number is:"+sh.getLastRowNum());

	    	for(int i =1;i<=sh.getLastRowNum();i++) {
	    	String userName=sh.getRow(i).getCell(0).getStringCellValue();
	    	uname1.sendKeys(userName);
	    	String pass=sh.getRow(i).getCell(1).getStringCellValue();
	    	upass1.sendKeys(pass);
	        //uname.sendKeys("Admin");
	        //upass.sendKeys("admin123");
	        loginbtn.click();
	    	}
	    }
	    public void forgot()
	    {
	        forgotbtn.click();
	        driver.navigate().back();

	    }

	
}
