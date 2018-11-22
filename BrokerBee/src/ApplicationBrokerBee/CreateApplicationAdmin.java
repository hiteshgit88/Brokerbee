package ApplicationBrokerBee;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateApplicationAdmin {

	@Test
	public void CreateAPP() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\eclipse\\bin\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://myb-311.mybrokerbee.com/app/Login.php");
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

			driver.findElement(By.xpath("//*[@id=\"toolbar-main\"]/a[1]")).click();

			String Title1 = "Rutam Desai - Applications - myBrokerBee";
			String GetTitle1 = driver.getTitle();
			AssertJUnit.assertEquals(Title1, GetTitle1);
			if ("Rutam Desai - Applications - myBrokerBee".equals(Title1)) {

				// Application Information
				Select dropdown_loanoption = new Select(driver.findElement(By.name("cf_3135")));
				dropdown_loanoption.selectByValue("Marketplace");
				
				Select dropdown_apppurpose = new Select(driver.findElement(By.id("txtbox_Application Purpose")));
				dropdown_apppurpose.selectByVisibleText("Purchase");

				WebElement broker_fee = driver.findElement(By.name("cf_2937"));
				broker_fee.sendKeys("10.00");

				WebElement shrt_prps_dscrptn = driver.findElement(By.id("cf_3037"));
				shrt_prps_dscrptn.sendKeys("Investment For Future");

//				WebElement acted_for_lenders = driver.findElement(By.id("acted_for"));
//				acted_for_lenders.sendKeys("25");

				WebElement referral_fee = driver.findElement(By.name("referral_fee"));
				referral_fee.sendKeys("100.00");

				// New Requested Mortgage Loan
				//WebElement loanclosingdate = driver.findElement(By.id("jscal_field_closingdate"));
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("document.getElementById('jscal_field_closingdate').value='12-15-2022';");
				//jse.executeScript("arguments[0].value='12-15-2022';", wb); OR
			    
				WebElement loan_amt_requested = driver.findElement(By.name("mortgageamount"));
				loan_amt_requested.sendKeys("11111.00");
				
				Select dropdown_loantype = new Select(driver.findElement(By.id("txtbox_Loan Type")));
				dropdown_loantype.selectByVisibleText("Mortgage");
				
				Select dropdown_mortgagetype = new Select(driver.findElement(By.id("txtbox_Mortgage Type")));
				dropdown_mortgagetype.selectByVisibleText("Second");
				
				Select dropdown_termtype = new Select(driver.findElement(By.id("txtbox_Term Type")));
				dropdown_termtype.selectByVisibleText("Open");
				
				Select dropdown_termmonth = new Select(driver.findElement(By.id("txtbox_Term (Months)")));
				dropdown_termmonth.selectByVisibleText("12");
				
				Select dropdown_ratetype = new Select(driver.findElement(By.id("txtbox_Rate Type")));
				dropdown_ratetype.selectByVisibleText("Fixed");
				
				Select dropdown_paymentfreq = new Select(driver.findElement(By.id("txtbox_Payment Frequency")));
				dropdown_paymentfreq.selectByVisibleText("Monthly");
				
//				WebElement amortization_months = driver.findElement(By.id("mortgageamortization"));
//				amortization_months.sendKeys("12");
				
				Select dropdown_repaymenttype = new Select(driver.findElement(By.name("cf_3094")));
				dropdown_repaymenttype.selectByVisibleText("Interest only");
				
/*				//Lender
				//jse.executeScript("document.getElementById('cf_3136').value='test123';");
				driver.findElement(By.id("cf_3136")).sendKeys("tes");
				Thread.sleep(5000);
				java.util.List<WebElement> autoSuggest = driver.findElements(By.xpath("//ul[@class='typeahead__list']").cssSelector("li.typeahead__item:nth-child(2) > a:nth-child(1) > span:nth-child(1)"));
				Thread.sleep(3000);
//			    System.out.println("Size of the AutoSuggets is = " + autoSuggest.size());
//			    for (WebElement a : autoSuggest) System.out.println("Values are = " + a.getText());
			    autoSuggest.get(0).click();
			    
				//Custom Lending Option (if Loan Options = Custom)
				WebElement lender_rate = driver.findElement(By.id("cf_3159"));
				lender_rate.sendKeys("10.00");
				
				WebElement lender_fee = driver.findElement(By.id("cf_3157"));
				lender_fee.sendKeys("2.00");
				
				jse.executeScript("document.getElementById('cf_3172').value='rutam.desai@mybrokerbee.com';");
//				WebElement lender_email = driver.findElement(By.id("cf_3172"));
//				lender_email.sendKeys("rutam.desai@mybrokerbee.com");
				
				WebElement lender_solicitor_fee = driver.findElement(By.name("cf_3158"));
				lender_solicitor_fee.sendKeys("100.00");
*/
				
				//Subject Property - Part 1
				WebElement street_number = driver.findElement(By.id("street_num"));
				street_number.sendKeys("150");
				
				WebElement street_name = driver.findElement(By.id("street"));
				street_name.sendKeys("Wellington");
				
				WebElement unit_number = driver.findElement(By.id("unit_num"));
				unit_number.sendKeys("150");
				
				Select dropdown_streettype = new Select(driver.findElement(By.id("txtbox_Street Type")));
				dropdown_streettype.selectByVisibleText("Street");
				
				Select dropdown_streetdirection = new Select(driver.findElement(By.id("txtbox_Street Direction")));
				dropdown_streetdirection.selectByVisibleText("S");
				
				WebElement postalcode = driver.findElement(By.id("postalorzip"));
				postalcode.sendKeys("N1H 3R2");
//				jse.executeScript("document.getElementById('postalorzip').value='N1H 3R2';");
				
				Select dropdown_province = new Select(driver.findElement(By.id("txtbox_provinceorstate")));
				dropdown_province.selectByVisibleText("ON");
				
				WebElement city = driver.findElement(By.id("city"));
				city.sendKeys("Guelph");
				
				Select dropdown_country = new Select(driver.findElement(By.id("txtbox_country")));
				dropdown_country.selectByVisibleText("Canada");
				
				Select dropdown_propertyoccupancy = new Select(driver.findElement(By.id("txtbox_Occupancy")));
				dropdown_propertyoccupancy.selectByVisibleText("Owner-Occupied");
				
				Select dropdown_propertytype = new Select(driver.findElement(By.id("txtbox_Property Type")));
				dropdown_propertytype.selectByVisibleText("Detached");
				
				Select dropdown_tenure = new Select(driver.findElement(By.id("txtbox_Tenure")));
				dropdown_tenure.selectByVisibleText("FreeHold");
				
				Select dropdown_dwellingstyle = new Select(driver.findElement(By.name("cf_3090")));
				dropdown_dwellingstyle.selectByVisibleText("One storey");
				
				Select dropdown_taxespaidby = new Select(driver.findElement(By.id("txtbox_Taxes Paid by")));
				dropdown_taxespaidby.selectByVisibleText("Borrower");
				
				WebElement propertytaxes = driver.findElement(By.id("cf_3082"));
				propertytaxes.sendKeys("2500.00");
				
				WebElement taxationyear = driver.findElement(By.id("cf_3092"));
				taxationyear.sendKeys("2018");
				
				WebElement lotsize = driver.findElement(By.id("cf_3089"));
				lotsize.sendKeys("1500.00");
				
				WebElement livingspace = driver.findElement(By.id("cf_3087"));
				livingspace.sendKeys("1200.00");
				
				WebElement municipality = driver.findElement(By.id("cf_2957"));
				municipality.sendKeys("MISSISSAUGA");
				
				WebElement purchaseprice = driver.findElement(By.name("purchase_price"));
				purchaseprice.sendKeys("950000.00");
				
				WebElement propertyage = driver.findElement(By.id("property_age"));
				propertyage.sendKeys("15");
				
				WebElement year_built = driver.findElement(By.id("yearbuilt"));
				year_built.sendKeys("2018");
				
				WebElement timeatresidence = driver.findElement(By.id("cf_2934"));
				timeatresidence.sendKeys("12");
				
				//Subject Property - Part 2
				jse.executeScript("document.getElementById('jscal_field_appraisal_date').value='05-08-2018';");
				
				WebElement appraised_value = driver.findElement(By.name("appraisedvalue"));
				appraised_value.sendKeys("12650.00");
				
//				WebElement appraisal_fee = driver.findElement(By.name("appraisal_fee"));
//				appraisal_fee.sendKeys("500.00");
				
				Select dropdown_appraisal_fee_paid_by = new Select(driver.findElement(By.id("txtbox_Appraisal Fee Paid by")));
				dropdown_appraisal_fee_paid_by.selectByVisibleText("Borrower");
				
				WebElement purview_appraisal_value = driver.findElement(By.name("purview_appraisal"));
				purview_appraisal_value.sendKeys("27000.00");
				
				Select dropdown_appraisal_type = new Select(driver.findElement(By.name("cf_3249")));
				dropdown_appraisal_type.selectByValue("Full Report");
				
				WebElement est_property_value = driver.findElement(By.name("cf_3248"));
				est_property_value.sendKeys("13650.00");
				
				//Primary Applicant
				WebElement applicant_fname = driver.findElement(By.name("app4fname"));
				applicant_fname.sendKeys("Rutam");
				
				WebElement applicant_lname = driver.findElement(By.id("app4lname"));
				applicant_lname.sendKeys("Desai");
				
				WebElement applicant_mname_initial = driver.findElement(By.id("app4initial"));
				applicant_mname_initial.sendKeys("R");
				
//				WebElement applicant_bdate = driver.findElement(By.id("jscal_field_app4birthday"));
//				applicant_bdate.sendKeys("08111988");
				jse.executeScript("document.getElementById('jscal_field_app4birthday').value='08-11-1988';");
				
				WebElement applicant_mobile = driver.findElement(By.id("app4mobilephone"));
				applicant_mobile.sendKeys("(989) 898-0420");
//				jse.executeScript("document.getElementById('app4mobilephone').value='(989) 898-0420';");
				
				WebElement applicant_email = driver.findElement(By.id("app4email"));
				applicant_email.sendKeys("rutam.desai@mybrokerbee.com");
				
				WebElement applicant_street_number = driver.findElement(By.id("app4street_num"));
				applicant_street_number.sendKeys("1150");
				
				WebElement applicant_street_name = driver.findElement(By.id("app4street"));
				applicant_street_name.sendKeys("Yarmouth Street");
				
				WebElement applicant_unit_number = driver.findElement(By.id("app4unit_num"));
				applicant_unit_number.sendKeys("Suite 1104");
				
				Select dropdown_applicant_streettype = new Select(driver.findElement(By.id("txtbox_Applicant Street Type")));
				dropdown_applicant_streettype.selectByValue("Road");
				
				Select dropdown_applicant_streetdirection = new Select(driver.findElement(By.id("txtbox_Applicant Direction")));
				dropdown_applicant_streetdirection.selectByValue("SE");
				
				WebElement applicant_city = driver.findElement(By.id("app4city"));
				applicant_city.sendKeys("Guelph");
				
				WebElement applicant_postalcode = driver.findElement(By.id("app4postalcode"));
				applicant_postalcode.sendKeys("N1H 3R2");
//				jse.executeScript("document.getElementById('app4postalcode').value='N1H 3R2';");
				
				Select dropdown_applicant_province = new Select(driver.findElement(By.id("txtbox_app4provinceorstate")));
				dropdown_applicant_province.selectByValue("Ontario");
				
				Select dropdown_applicant_country = new Select(driver.findElement(By.id("txtbox_app4country")));
				dropdown_applicant_country.selectByValue("Canada");
				
				Select dropdown_applicant_address_status = new Select(driver.findElement(By.id("txtbox_Applicant Rent or Own")));
				dropdown_applicant_address_status.selectByValue("Own");
				
				WebElement applicant_months_ataddress = driver.findElement(By.id("app4yearsataddress"));
				applicant_months_ataddress.sendKeys("360");
				
				WebElement applicant_credit_score = driver.findElement(By.id("cf_3243"));
				applicant_credit_score.sendKeys("575");
				
				//Primary Applicant (Optional)
				WebElement applicant_emp_name = driver.findElement(By.id("app4employername"));
				applicant_emp_name.sendKeys("Stranger Inc.");
				
				WebElement applicant_annual_income = driver.findElement(By.name("app4empannualincome"));
				applicant_annual_income.sendKeys("150000.00");
				
				Select dropdown_applicant_occupation_type = new Select(driver.findElement(By.id("txtbox_app4employmenttype")));
				dropdown_applicant_occupation_type.selectByValue("Professional");
				
				Select dropdown_applicant_income_type = new Select(driver.findElement(By.id("txtbox_Applicant Income Type")));
				dropdown_applicant_income_type.selectByValue("Salary");
				
				Select dropdown_applicant_emp_type = new Select(driver.findElement(By.id("txtbox_app4empfulltime")));
				dropdown_applicant_emp_type.selectByValue("Full Time");
				
				WebElement applicant_job_title = driver.findElement(By.id("app4empjobtitle"));
				applicant_job_title.sendKeys("Engineer in QA");
				
				WebElement applicant_emp_months = driver.findElement(By.id("app4emplengthofemployment"));
				applicant_emp_months.sendKeys("48");
				
				WebElement applicant_other_income = driver.findElement(By.name("app4otherincome"));
				applicant_other_income.sendKeys("5000");
				
				WebElement applicant_otherincome_desc = driver.findElement(By.id("app4otherincomedesc"));
				applicant_otherincome_desc.sendKeys("Part Time");
				
//				WebElement applicant_work_phone = driver.findElement(By.id("app4workphone"));
//				applicant_work_phone.sendKeys("5555555555");
				jse.executeScript("document.getElementById('app4workphone').value='(555) 555-5555';");
				
				WebElement applicant_work_ext = driver.findElement(By.id("app4workphone_ext"));
				applicant_work_ext.sendKeys("619");
				
				Select dropdown_applicant_marital_status = new Select(driver.findElement(By.id("txtbox_Applicant Marital Status")));
				dropdown_applicant_marital_status.selectByValue("Single");
				
//				WebElement applicant_home_phone = driver.findElement(By.id("app4homephone"));
//				applicant_home_phone.sendKeys("4444444444");
				jse.executeScript("document.getElementById('app4homephone').value='(444) 444-4444';");
				
				WebElement applicant_dependants = driver.findElement(By.id("cf_2936"));
				applicant_dependants.sendKeys("5");
				
//				WebElement applicant_fax = driver.findElement(By.id("cf_2956"));
//				applicant_fax.sendKeys("0261234350");
				jse.executeScript("document.getElementById('cf_2956').value='(026) 123-4350';");
				
				Select dropdown_applicant_spouseinfo = new Select(driver.findElement(By.id("txtbox_Spouse on as")));
				dropdown_applicant_spouseinfo.selectByValue("--None--");
				
				//Subject Property - Access Information
				Select dropdown_accesscontact = new Select(driver.findElement(By.name("property_access_contact")));
				dropdown_accesscontact.selectByValue("Home Owner");
				
				WebElement contact_fname = driver.findElement(By.name("contact_first_name"));
				contact_fname.sendKeys("RutamContact");
				
				WebElement contact_lname = driver.findElement(By.id("contact_last_name"));
				contact_lname.sendKeys("DesaiContact");
				
				WebElement contact_email = driver.findElement(By.id("contact_email"));
				contact_email.sendKeys("rutam.desai@mybrokerbee.com");
				
				WebElement contact_phn = driver.findElement(By.id("contact_phone"));
				contact_phn.sendKeys("(987) 654-3219");
				
				//Existing Mortgage Information
				WebElement first_org_mrtg_amt = driver.findElement(By.name("exist_mortgage_amt"));
				first_org_mrtg_amt.sendKeys("110000.00");
				
				//Independent Legal Information
				WebElement lawyer_fname = driver.findElement(By.id("lawyerfname"));
				lawyer_fname.sendKeys("LawyerFTest");
				
				WebElement lawyer_lname = driver.findElement(By.id("lawyerlname"));
				lawyer_lname.sendKeys("LawyerLTest");
				
				WebElement lawyer_cmp = driver.findElement(By.id("lawyerconame"));
				lawyer_cmp.sendKeys("LawyerCmp");
				
				WebElement lawyer_email = driver.findElement(By.id("lawyeremail"));
				lawyer_email.sendKeys("rutam.desai@mybrokerbee.com");
				
//				WebElement lawyer_phone = driver.findElement(By.id("lawyerphone"));
//				lawyer_phone.sendKeys("9973451423");
				jse.executeScript("document.getElementById('lawyerphone').value='(973) 451-2349';");
				
//				WebElement lawyer_fax = driver.findElement(By.id("lawyerfax"));
//				lawyer_fax.sendKeys("0261789645");
				jse.executeScript("document.getElementById('lawyerfax').value='(026) 178-9456';");
				
				WebElement lawyer_address = driver.findElement(By.name("cf_3035"));
				lawyer_address.sendKeys("Address1");
				
				driver.findElement(By.className("save")).click();
				

			} else {

				System.out.println("Wrong Page");

			}

		} else {

			System.out.println("Login Unsuccessful");

		}

	}

}