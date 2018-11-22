package Login_Success;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	
	@Test
	public void test() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse\\bin\\chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
        driver.get("https://stag-app.mybrokerbee.com/app/Login.php");
        driver.manage().window().maximize();
        WebElement UserName = driver.findElement(By.name("user_name"));
        UserName.sendKeys("vc_agent");
        WebElement Password = driver.findElement(By.name("user_password"));
        Password.sendKeys("vcagent");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //System.out.println(driver.getTitle());
        //String Title=driver.getTitle();
        String Title = "myBrokerbee | Dashboard";
		String GetTitle = driver.getTitle();
		AssertJUnit.assertEquals(Title, GetTitle);
//        if("myBrokerbee | Dashboard".equals(Title)){
//            System.out.println("Login is Successful" );
//            System.out.println("Page title is:" + Title );
//         }
//         else{
//             System.out.println("Login Unsuccessful");
//         }
//       
        //driver.quit();
        
	}

}