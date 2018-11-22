package admin_createorganization;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class create_organization_admin {
	
	@Test
	public void CreateORG() throws InterruptedException {

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
				organization_name.sendKeys("Test Org");
				
				Select organization_type = new Select(driver.findElement(By.name("accounttype")));
				organization_type.selectByVisibleText("Lender");

				WebElement org_phone = driver.findElement(By.id("phone"));
				org_phone.sendKeys("(989) 898-0420");
				
				WebElement lender_contact_first_name = driver.findElement(By.id("cf_2985"));
				lender_contact_first_name.sendKeys("Morgan");
				
				WebElement org_fax = driver.findElement(By.id("fax"));
				org_fax.sendKeys("(989) 898-0420");
				
				WebElement lender_contact_last_name = driver.findElement(By.id("cf_2986"));
				lender_contact_last_name.sendKeys("Schneirden");
				
				WebElement other_phone = driver.findElement(By.id("otherphone"));
				other_phone.sendKeys("(989) 898-0421");
				
				WebElement org_email = driver.findElement(By.id("email1"));
				org_email.sendKeys("rutam.desai+test1@mybrokerbee.com");
				
				WebElement no_of_employees = driver.findElement(By.id("employees"));
				no_of_employees.sendKeys("200");
				
				WebElement org_website = driver.findElement(By.name("website"));
				org_website.sendKeys("www.google.com");
				
				WebElement temp_used_inventory = driver.findElement(By.name("temp_used_inventory_amt"));
				temp_used_inventory.sendKeys("111111");
				
				Select dropdown_rating = new Select(driver.findElement(By.name("rating")));
				dropdown_rating.selectByVisibleText("B");
				
//				WebElement available_inventory_updated = driver.findElement(By.id("jscal_field_avail_inventory_update_date"));
//				available_inventory_updated.sendKeys("08111988");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("document.getElementById('jscal_field_avail_inventory_update_date').value='08-11-1988';");
				
				WebElement avail_inventory_amount = driver.findElement(By.id("avail_inventory_amt"));
				avail_inventory_amount.sendKeys(Keys.CONTROL + "a");
				avail_inventory_amount.sendKeys(Keys.DELETE);
				avail_inventory_amount.sendKeys("111111");
				
				driver.findElement(By.xpath("//select[contains(@name,'org_mortgagetype')]")).click();
				driver.findElement(By.xpath("//option[@value='Third']")).click();
				
				WebElement other_fees = driver.findElement(By.name("cf_3168"));
				other_fees.sendKeys(Keys.CONTROL + "a");
				other_fees.sendKeys(Keys.DELETE);
				other_fees.sendKeys("111");
				
				WebElement other_fees_desc = driver.findElement(By.id("cf_3169"));
				other_fees_desc.sendKeys("Extra Charge");
				
				Select mortgage_type = new Select(driver.findElement(By.name("mortgagetype")));
				mortgage_type.selectByVisibleText("--None--");
				
				WebElement min_loan_amt = driver.findElement(By.id("min_loan_amount"));
				min_loan_amt.sendKeys("10000");
				
				WebElement max_loan_amt = driver.findElement(By.id("max_loan_amount"));
				max_loan_amt.sendKeys("999999");
				

				// Solicitor
				WebElement firm_name = driver.findElement(By.id("solicitor_coname"));
				firm_name.sendKeys("Lawyer Suite");
				
				WebElement solicitor_name = driver.findElement(By.id("solicitor_name"));
				solicitor_name.sendKeys("Solicitor Name");
				
				WebElement solicitor_phone = driver.findElement(By.id("solicitor_phone"));
				solicitor_phone.sendKeys("(989) 898-0430");
				
				WebElement solicitor_fax = driver.findElement(By.id("solicitor_fax"));
				solicitor_fax.sendKeys("(989) 898-0431");
				
				WebElement solicitor_email = driver.findElement(By.id("solicitor_email"));
				solicitor_email.sendKeys("rutam.desai+solicitor@mybrokerbee.com");
				
				WebElement solicitor_street_num = driver.findElement(By.id("solicitor_streetnum"));
				solicitor_street_num.sendKeys("143");
				
				WebElement solicitor_unit_num = driver.findElement(By.id("solicitor_unit"));
				solicitor_unit_num.sendKeys("786");
				
				WebElement solicitor_street_name = driver.findElement(By.id("solicitor_streetname"));
				solicitor_street_name.sendKeys("W2 Street");

				WebElement solicitorcity = driver.findElement(By.id("solicitor_city"));
				solicitorcity.sendKeys("Guelph");
				
				WebElement solicitorprovince = driver.findElement(By.id("solicitor_province"));
				solicitorprovince.sendKeys("Ontario");
				
				WebElement solicitor_postalcode = driver.findElement(By.id("solicitor_postalcode"));
				solicitor_postalcode.sendKeys("N1H 3R2");
				

				//LTV 90.01-95% Credit < 500
				WebElement chk_ltv1 = driver.findElement(By.name("chk_ltv_gt80_cs_lt550"));
		        int i1 = 0;
		        while (i1 < 1) {
		        	chk_ltv1.click();
		            ++i1;
		        			  }
		        WebElement lender_fee1 = driver.findElement(By.id("lendfee_ltv_gt80_cs_lt550"));
		        lender_fee1.sendKeys("2");
				
				WebElement lawyer_fee1 = driver.findElement(By.name("lawfee_ltv_gt80_cs_lt550"));
				lawyer_fee1.sendKeys(Keys.CONTROL + "a");
				lawyer_fee1.sendKeys(Keys.DELETE);
				lawyer_fee1.sendKeys("50");
				
				WebElement lender_rate1 = driver.findElement(By.id("rate_ltv_gt80_cs_lt550"));
				lender_rate1.sendKeys("1.5");
		        
		        
		        //LTV 90.01-95% Credit 500-680
				WebElement chk_ltv2 = driver.findElement(By.name("chk_ltv_gt80_cs_550_650"));
		        int i2 = 0;
		        while (i2 < 1) {
		        	chk_ltv2.click();
		            ++i2;
		        			  }
		        WebElement lender_fee2 = driver.findElement(By.id("lendfee_ltv_gt80_cs_550_650"));
		        lender_fee2.sendKeys("2.5");
				
				WebElement lawyer_fee2 = driver.findElement(By.name("lawfee_ltv_gt80_cs_550_650"));
				lawyer_fee2.sendKeys(Keys.CONTROL + "a");
				lawyer_fee2.sendKeys(Keys.DELETE);
				lawyer_fee2.sendKeys("55");
				
				WebElement lender_rate2 = driver.findElement(By.id("rate_ltv_gt80_cs_550_650"));
				lender_rate2.sendKeys("2");
				
				
				//LTV 90.01-95% Credit > 680
				WebElement chk_ltv3 = driver.findElement(By.name("chk_ltv_gt80_cs_gt650"));
		        int i3 = 0;
		        while (i3 < 1) {
		        	chk_ltv3.click();
		            ++i3;
		        			  }
		        WebElement lender_fee3 = driver.findElement(By.id("lendfee_ltv_gt80_cs_gt650"));
		        lender_fee3.sendKeys("3");
				
				WebElement lawyer_fee3 = driver.findElement(By.name("lawfee_ltv_gt80_cs_gt650"));
				lawyer_fee3.sendKeys(Keys.CONTROL + "a");
				lawyer_fee3.sendKeys(Keys.DELETE);
				lawyer_fee3.sendKeys("60");
				
				WebElement lender_rate3 = driver.findElement(By.id("rate_ltv_gt80_cs_gt650"));
				lender_rate3.sendKeys("2.5");
				
				
				//LTV 90.01-95% Credit None
				WebElement chk_ltv4 = driver.findElement(By.name("chk_ltv_gt80_cs_none"));
		        int i4 = 0;
		        while (i4 < 1) {
		        	chk_ltv4.click();
		            ++i4;
		        			  }
		        WebElement lender_fee4 = driver.findElement(By.id("lendfee_ltv_gt80_cs_none"));
		        lender_fee4.sendKeys("2.10");
				
				WebElement lawyer_fee4 = driver.findElement(By.name("lawfee_ltv_gt80_cs_none"));
				lawyer_fee4.sendKeys(Keys.CONTROL + "a");
				lawyer_fee4.sendKeys(Keys.DELETE);
				lawyer_fee4.sendKeys("52");
				
				WebElement lender_rate4 = driver.findElement(By.id("rate_ltv_gt80_cs_none"));
				lender_rate4.sendKeys("1.6");
				
				
				
				
				//Description Information
				WebElement description_info = driver.findElement(By.name("description"));
				description_info.sendKeys("Demo Description");
				
				
				
				
				
				//Address Information
				WebElement billing_address = driver.findElement(By.name("bill_street"));
				billing_address.sendKeys("14, Renfrew County and Lanark Highlands ,Township (Deep River),");
				
				WebElement billing_city = driver.findElement(By.id("bill_city"));
				billing_city.sendKeys("Toronto");
				
				Select billing_state = new Select(driver.findElement(By.name("bill_state")));
				billing_state.selectByVisibleText("ON");
				
				WebElement billing_postal_code = driver.findElement(By.id("bill_code"));
				billing_postal_code.sendKeys("H0H 0H0");
				
				WebElement billing_country = driver.findElement(By.id("bill_country"));
				billing_country.sendKeys("Canada");
				
								
				
				//Lender Criteria
				WebElement postal_code = driver.findElement(By.name("cf_2832"));
				postal_code.sendKeys("L4T,L3V,K1G,L6T,L0R,K2K,K9J,L4W,K0J,M2M 1M2,N1H 3R2");
				
				
				
				driver.findElement(By.className("save")).click();
				
			} 

		} 

	}

}