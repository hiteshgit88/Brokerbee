package createorganization_csvfile;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import RegisterAgentFromCsv.ReadAgentCsvFiles;
import au.com.bytecode.opencsv.CSVReader;
import createapplication_csvfile.createapp_csvfile;

import java.io.FileReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class createorg_csvfile {
	
	@Test
	public void testorg() throws Exception{
		
		// This will load csv file
        CSVReader reader2 = new CSVReader(new FileReader("C:\\Organizations.csv"));
        
     // this will load content into list
        List<String[]> li = reader2.readAll();
        System.out.println("Total rows which we have is " + li.size());
        
        for (Object[] str : li) {
            System.out.print(" Values are ");
            System.out.println(Arrays.toString(str));
            createorg_csvfile obj = new createorg_csvfile();
            obj.submitData((String[])str);
            
        }
		
	}
	
	public void submitData(String[] str) throws InterruptedException {
        
    	System.setProperty("webdriver.chrome.driver", "E:\\eclipse\\bin\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
        driver.get("https://stag-app.mybrokerbee.com/app/Login.php");
        driver.manage().window().maximize();
        
        WebElement UserName = driver.findElement(By.name("user_name"));
		UserName.sendKeys("rutam.desai");

		WebElement Password = driver.findElement(By.name("user_password"));
		Password.sendKeys("Temp#123");

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		String Title = "Rutam Desai - Applications - myBrokerBee";
		String GetTitle = driver.getTitle();
		AssertJUnit.assertEquals(Title, GetTitle);
		
		if ("Rutam Desai - Applications - myBrokerBee".equals(Title)) {

			driver.findElement(By.xpath("(//a[@href='index.php?module=Accounts&action=index'])[1]")).click();
			
			driver.findElement(By.xpath("//a[@class='icon btn  add']")).click();

			String Title1 = "Rutam Desai - Organizations - myBrokerBee";
			String GetTitle1 = driver.getTitle();
			AssertJUnit.assertEquals(Title1, GetTitle1);
			
			if ("Rutam Desai - Organizations - myBrokerBee".equals(Title1)) {
				
				// Organization Information
				WebElement organization_name = driver.findElement(By.name("accountname"));
				organization_name.sendKeys(str[0]);
				
				Select organization_type = new Select(driver.findElement(By.name("accounttype")));
				organization_type.selectByVisibleText(str[1]);

				WebElement org_phone = driver.findElement(By.id("phone"));
				org_phone.sendKeys(str[2]);
				
				WebElement lender_contact_first_name = driver.findElement(By.id("cf_2985"));
				lender_contact_first_name.sendKeys(str[3]);
				
				WebElement org_fax = driver.findElement(By.id("fax"));
				org_fax.sendKeys(str[4]);
				
				WebElement lender_contact_last_name = driver.findElement(By.id("cf_2986"));
				lender_contact_last_name.sendKeys(str[5]);
				
				WebElement other_phone = driver.findElement(By.id("otherphone"));
				other_phone.sendKeys(str[6]);
				
				WebElement org_email = driver.findElement(By.id("email1"));
				org_email.sendKeys(str[7]);
				
				WebElement no_of_employees = driver.findElement(By.id("employees"));
				no_of_employees.sendKeys(str[8]);
				
				WebElement org_website = driver.findElement(By.name("website"));
				org_website.sendKeys(str[9]);
				
				WebElement temp_used_inventory = driver.findElement(By.name("temp_used_inventory_amt"));
				temp_used_inventory.sendKeys(str[10]);
				
				Select dropdown_rating = new Select(driver.findElement(By.name("rating")));
				dropdown_rating.selectByVisibleText(str[11]);				
//				WebElement available_inventory_updated = driver.findElement(By.id("jscal_field_avail_inventory_update_date"));
//				available_inventory_updated.sendKeys("08111988");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("document.getElementById('jscal_field_avail_inventory_update_date').value='"+str[12]+"';");
				
				WebElement avail_inventory_amount = driver.findElement(By.id("avail_inventory_amt"));
				avail_inventory_amount.sendKeys(Keys.CONTROL + "a");
				avail_inventory_amount.sendKeys(Keys.DELETE);
				avail_inventory_amount.sendKeys(str[13]);
				
				driver.findElement(By.xpath("//select[contains(@name,'org_mortgagetype')]")).click();
				driver.findElement(By.xpath("//option[@value='Third']")).click();
				
				WebElement other_fees = driver.findElement(By.name("cf_3168"));
				other_fees.sendKeys(Keys.CONTROL + "a");
				other_fees.sendKeys(Keys.DELETE);
				other_fees.sendKeys(str[14]);
				
				WebElement other_fees_desc = driver.findElement(By.id("cf_3169"));
				other_fees_desc.sendKeys(str[15]);
				
				Select mortgage_type = new Select(driver.findElement(By.name("mortgagetype")));
				mortgage_type.selectByVisibleText(str[16]);
				
				WebElement min_loan_amt = driver.findElement(By.id("min_loan_amount"));
				min_loan_amt.sendKeys(str[17]);
				
				WebElement max_loan_amt = driver.findElement(By.id("max_loan_amount"));
				max_loan_amt.sendKeys(str[18]);
				

				// Solicitor
				WebElement firm_name = driver.findElement(By.id("solicitor_coname"));
				firm_name.sendKeys(str[19]);
				
				WebElement solicitor_name = driver.findElement(By.id("solicitor_name"));
				solicitor_name.sendKeys(str[20]);
				
				WebElement solicitor_phone = driver.findElement(By.id("solicitor_phone"));
				solicitor_phone.sendKeys(str[21]);
				
				WebElement solicitor_fax = driver.findElement(By.id("solicitor_fax"));
				solicitor_fax.sendKeys(str[22]);
				
				WebElement solicitor_email = driver.findElement(By.id("solicitor_email"));
				solicitor_email.sendKeys(str[23]);
				
				WebElement solicitor_street_num = driver.findElement(By.id("solicitor_streetnum"));
				solicitor_street_num.sendKeys(str[24]);
				
				WebElement solicitor_unit_num = driver.findElement(By.id("solicitor_unit"));
				solicitor_unit_num.sendKeys(str[25]);
				
				WebElement solicitor_street_name = driver.findElement(By.id("solicitor_streetname"));
				solicitor_street_name.sendKeys(str[26]);

				WebElement solicitorcity = driver.findElement(By.id("solicitor_city"));
				solicitorcity.sendKeys(str[27]);
				
				WebElement solicitorprovince = driver.findElement(By.id("solicitor_province"));
				solicitorprovince.sendKeys(str[28]);
				
				WebElement solicitor_postalcode = driver.findElement(By.id("solicitor_postalcode"));
				solicitor_postalcode.sendKeys(str[29]);
				

				//LTV 90.01-95% Credit < 500
				WebElement chk_ltv1 = driver.findElement(By.name("chk_ltv_gt80_cs_lt550"));
		        int i1 = 0;
		        while (i1 < 1) {
		        	chk_ltv1.click();
		            ++i1;
		        			  }
		        WebElement lender_fee1 = driver.findElement(By.id("lendfee_ltv_gt80_cs_lt550"));
		        lender_fee1.sendKeys(str[30]);
				
				WebElement lawyer_fee1 = driver.findElement(By.name("lawfee_ltv_gt80_cs_lt550"));
				lawyer_fee1.sendKeys(Keys.CONTROL + "a");
				lawyer_fee1.sendKeys(Keys.DELETE);
				lawyer_fee1.sendKeys(str[31]);
				
				WebElement lender_rate1 = driver.findElement(By.id("rate_ltv_gt80_cs_lt550"));
				lender_rate1.sendKeys(str[32]);
		        
		        
		        //LTV 90.01-95% Credit 500-680
				WebElement chk_ltv2 = driver.findElement(By.name("chk_ltv_gt80_cs_550_650"));
		        int i2 = 0;
		        while (i2 < 1) {
		        	chk_ltv2.click();
		            ++i2;
		        			  }
		        WebElement lender_fee2 = driver.findElement(By.id("lendfee_ltv_gt80_cs_550_650"));
		        lender_fee2.sendKeys(str[33]);
				
				WebElement lawyer_fee2 = driver.findElement(By.name("lawfee_ltv_gt80_cs_550_650"));
				lawyer_fee2.sendKeys(Keys.CONTROL + "a");
				lawyer_fee2.sendKeys(Keys.DELETE);
				lawyer_fee2.sendKeys(str[34]);
				
				WebElement lender_rate2 = driver.findElement(By.id("rate_ltv_gt80_cs_550_650"));
				lender_rate2.sendKeys(str[35]);
				
				
				//LTV 90.01-95% Credit > 680
				WebElement chk_ltv3 = driver.findElement(By.name("chk_ltv_gt80_cs_gt650"));
		        int i3 = 0;
		        while (i3 < 1) {
		        	chk_ltv3.click();
		            ++i3;
		        			  }
		        WebElement lender_fee3 = driver.findElement(By.id("lendfee_ltv_gt80_cs_gt650"));
		        lender_fee3.sendKeys(str[36]);
				
				WebElement lawyer_fee3 = driver.findElement(By.name("lawfee_ltv_gt80_cs_gt650"));
				lawyer_fee3.sendKeys(Keys.CONTROL + "a");
				lawyer_fee3.sendKeys(Keys.DELETE);
				lawyer_fee3.sendKeys(str[37]);
				
				WebElement lender_rate3 = driver.findElement(By.id("rate_ltv_gt80_cs_gt650"));
				lender_rate3.sendKeys(str[38]);
				
				
				//LTV 90.01-95% Credit None
				WebElement chk_ltv4 = driver.findElement(By.name("chk_ltv_gt80_cs_none"));
		        int i4 = 0;
		        while (i4 < 1) {
		        	chk_ltv4.click();
		            ++i4;
		        			  }
		        WebElement lender_fee4 = driver.findElement(By.id("lendfee_ltv_gt80_cs_none"));
		        lender_fee4.sendKeys(str[39]);
				
				WebElement lawyer_fee4 = driver.findElement(By.name("lawfee_ltv_gt80_cs_none"));
				lawyer_fee4.sendKeys(Keys.CONTROL + "a");
				lawyer_fee4.sendKeys(Keys.DELETE);
				lawyer_fee4.sendKeys(str[40]);
				
				WebElement lender_rate4 = driver.findElement(By.id("rate_ltv_gt80_cs_none"));
				lender_rate4.sendKeys(str[41]);
				
				
				
				
				//Description Information
				WebElement description_info = driver.findElement(By.name("description"));
				description_info.sendKeys(str[42]);
				
				
				
				
				
				//Address Information
				WebElement billing_address = driver.findElement(By.name("bill_street"));
				billing_address.sendKeys(str[43]);
				
				WebElement billing_city = driver.findElement(By.id("bill_city"));
				billing_city.sendKeys(str[44]);
				
				Select billing_state = new Select(driver.findElement(By.name("bill_state")));
				billing_state.selectByVisibleText(str[45]);
				
				WebElement billing_postal_code = driver.findElement(By.id("bill_code"));
				billing_postal_code.sendKeys(str[46]);
				
				WebElement billing_country = driver.findElement(By.id("bill_country"));
				billing_country.sendKeys(str[47]);
				
								
				
				//Lender Criteria
				WebElement postal_code = driver.findElement(By.name("cf_2832"));
				postal_code.sendKeys(str[48]);
				
				
				
				driver.findElement(By.className("save")).click();
				
				
				
				}
			
		}		
    }

  }