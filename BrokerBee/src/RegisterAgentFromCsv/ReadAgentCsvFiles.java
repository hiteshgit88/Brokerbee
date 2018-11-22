package RegisterAgentFromCsv;

import org.testng.annotations.Test;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import java.util.UUID;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ReadAgentCsvFiles {
	
	@Test
	public void test() throws Exception {
		
		// This will load csv file
        CSVReader reader = new CSVReader(new FileReader("C:\\demoN.csv"));
        
     // this will load content into list
        List<String[]> li = reader.readAll();
        System.out.println("Total rows which we have is " + li.size());
        
        for (Object[] str : li) {
            System.out.print(" Values are ");
            System.out.println(Arrays.toString(str));
            ReadAgentCsvFiles obj = new ReadAgentCsvFiles();
            obj.submitData((String[])str);
        }
    }

    public void submitData(String[] str) {
        //System.setProperty("webdriver.firefox.marionette", "G:\\eclipse\\bin\\geckodriver.exe");
    	//FirefoxDriver driver = new FirefoxDriver();
    	System.setProperty("webdriver.chrome.driver", "E:\\eclipse\\bin\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
        String expectedTitle = "myBrokerBee";
        String actualTitle = "";
        driver.get("https://stag-app.mybrokerbee.com/app/autoregister.php?module=signup");
        driver.manage().window().maximize();
        WebElement firstname = driver.findElement(By.name("first_name"));
        firstname.sendKeys(str[0]);
        WebElement lastname = driver.findElement(By.name("last_name"));
        lastname.sendKeys(str[1]);
        WebElement email = driver.findElement(By.name("email1"));
        email.sendKeys(str[2]);
        WebElement phone = driver.findElement(By.name("phone_mobile"));
        phone.sendKeys(str[3]);
        WebElement department = driver.findElement(By.name("department"));
        department.sendKeys(str[4]);
        WebElement brokerage_no = driver.findElement(By.name("brokerage_no"));
        brokerage_no.sendKeys(str[5]);
        WebElement agent_lic = driver.findElement(By.name("agent_lic"));
        agent_lic.sendKeys(str[6]);
        WebElement chkTerms = driver.findElement(By.name("terms_conditions"));
        int i = 0;
        while (i < 1) {
            chkTerms.click();
            driver.findElement(By.id("btn_sbmt")).click();
            ++i;
        }
    }
}