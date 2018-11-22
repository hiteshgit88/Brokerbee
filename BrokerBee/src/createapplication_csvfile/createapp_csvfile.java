package createapplication_csvfile;

import org.testng.annotations.Test;

import RegisterAgentFromCsv.ReadAgentCsvFiles;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import java.util.UUID;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class createapp_csvfile {
	
	@Test
	public void test() throws Exception{
		
		// This will load csv file
        CSVReader reader1 = new CSVReader(new FileReader("C:\\Applications.csv"));
        
     // this will load content into list
        List<String[]> li = reader1.readAll();
        System.out.println("Total rows which we have is " + li.size());
        
        for (Object[] str : li) {
            System.out.print(" Values are ");
            System.out.println(Arrays.toString(str));
            createapp_csvfile obj = new createapp_csvfile();
            obj.submitData((String[])str);
            
        }
		
	}
	
	public void submitData(String[] str) throws InterruptedException {
        
    	System.setProperty("webdriver.chrome.driver", "E:\\eclipse\\bin\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
        driver.get("https://stag-app.mybrokerbee.com/app/Login.php");
        driver.manage().window().maximize();
        
        WebElement UserName = driver.findElement(By.name("user_name"));
		UserName.sendKeys("vc_agent");

		WebElement Password = driver.findElement(By.name("user_password"));
		Password.sendKeys("vcagent");

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		String Title = "myBrokerbee | Dashboard";
		String GetTitle = driver.getTitle();
		AssertJUnit.assertEquals(Title, GetTitle);
		
		if ("myBrokerbee | Dashboard".equals(Title)) {
			
			driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div[1]/ul/li[1]/a/span[2]/div")).click();
			
			driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div[1]/ul/li[1]/div/div/div/ul/li[1]/a/span/span/span")).click();

			String Title1 = "vc agent - Applications - myBrokerBee";
			String GetTitle1 = driver.getTitle();
			AssertJUnit.assertEquals(Title1, GetTitle1);
			
			if ("vc agent - Applications - myBrokerBee".equals(Title1)) {
				
				Select dropdown_loanoption = new Select(driver.findElement(By.name("cf_3135")));
				dropdown_loanoption.selectByValue(str[0]);
				
				Select dropdown_apppurpose = new Select(driver.findElement(By.id("txtbox_Application Purpose")));
				dropdown_apppurpose.selectByVisibleText(str[1]);
				
				WebElement broker_fee = driver.findElement(By.name("cf_2937"));
				broker_fee.sendKeys(str[2]);

				WebElement shrt_prps_dscrptn = driver.findElement(By.id("cf_3037"));
				shrt_prps_dscrptn.sendKeys(str[3]);

//				WebElement acted_for_lenders = driver.findElement(By.id("acted_for"));
//				acted_for_lenders.sendKeys(str[4]);

				WebElement referral_fee = driver.findElement(By.name("referral_fee"));
				referral_fee.sendKeys(str[5]);

				// New Requested Mortgage Loan
				//WebElement loanclosingdate = driver.findElement(By.id("jscal_field_closingdate"));
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("document.getElementById('jscal_field_closingdate').value='"+str[7]+"';");
				//jse.executeScript("arguments[0].value='12-15-2022';", wb); OR
			    
				WebElement loan_amt_requested = driver.findElement(By.name("mortgageamount"));
				loan_amt_requested.sendKeys(str[8]);
				
				Select dropdown_loantype = new Select(driver.findElement(By.id("txtbox_Loan Type")));
				dropdown_loantype.selectByVisibleText(str[9]);
				
				Select dropdown_mortgagetype = new Select(driver.findElement(By.id("txtbox_Mortgage Type")));
				dropdown_mortgagetype.selectByVisibleText(str[10]);
				
				Select dropdown_termtype = new Select(driver.findElement(By.id("txtbox_Term Type")));
				dropdown_termtype.selectByVisibleText(str[11]);
				
				Select dropdown_termmonth = new Select(driver.findElement(By.id("txtbox_Term (Months)")));
				dropdown_termmonth.selectByVisibleText(str[12]);
				
				Select dropdown_ratetype = new Select(driver.findElement(By.id("txtbox_Rate Type")));
				dropdown_ratetype.selectByVisibleText(str[13]);
				
				Select dropdown_paymentfreq = new Select(driver.findElement(By.id("txtbox_Payment Frequency")));
				dropdown_paymentfreq.selectByVisibleText(str[15]);
				
//				WebElement amortization_months = driver.findElement(By.id("mortgageamortization"));
//				amortization_months.sendKeys(str[16]);
				
				Select dropdown_repaymenttype = new Select(driver.findElement(By.name("cf_3094")));
				dropdown_repaymenttype.selectByVisibleText(str[18]);
				
				//Lender
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
				
				//Subject Property - Part 1
				WebElement street_number = driver.findElement(By.id("street_num"));
				street_number.sendKeys(str[26]);
				
				WebElement street_name = driver.findElement(By.id("street"));
				street_name.sendKeys(str[27]);
				
				WebElement unit_number = driver.findElement(By.id("unit_num"));
				unit_number.sendKeys(str[28]);
				
				Select dropdown_streettype = new Select(driver.findElement(By.id("txtbox_Street Type")));
				dropdown_streettype.selectByVisibleText(str[29]);
				
				Select dropdown_streetdirection = new Select(driver.findElement(By.id("txtbox_Street Direction")));
				dropdown_streetdirection.selectByVisibleText(str[30]);
				
				WebElement postalcode = driver.findElement(By.id("postalorzip"));
				postalcode.sendKeys(str[31]);
//				jse.executeScript("document.getElementById('postalorzip').value='N1H 3R2';");
				
				Select dropdown_province = new Select(driver.findElement(By.id("txtbox_provinceorstate")));
				dropdown_province.selectByVisibleText(str[32]);
				
				WebElement city = driver.findElement(By.id("city"));
				city.sendKeys(str[33]);
				
				Select dropdown_country = new Select(driver.findElement(By.id("txtbox_country")));
				dropdown_country.selectByVisibleText(str[34]);
				
				Select dropdown_propertyoccupancy = new Select(driver.findElement(By.id("txtbox_Occupancy")));
				dropdown_propertyoccupancy.selectByVisibleText(str[35]);
				
				Select dropdown_propertytype = new Select(driver.findElement(By.id("txtbox_Property Type")));
				dropdown_propertytype.selectByVisibleText(str[36]);
				
				Select dropdown_tenure = new Select(driver.findElement(By.id("txtbox_Tenure")));
				dropdown_tenure.selectByVisibleText(str[37]);
				
				Select dropdown_dwellingstyle = new Select(driver.findElement(By.name("cf_3090")));
				dropdown_dwellingstyle.selectByVisibleText(str[38]);
				
				Select dropdown_taxespaidby = new Select(driver.findElement(By.id("txtbox_Taxes Paid by")));
				dropdown_taxespaidby.selectByVisibleText(str[39]);
				
				WebElement propertytaxes = driver.findElement(By.id("cf_3082"));
				propertytaxes.sendKeys(str[40]);
				
				WebElement taxationyear = driver.findElement(By.id("cf_3092"));
				taxationyear.sendKeys(str[41]);
				
				WebElement lotsize = driver.findElement(By.id("cf_3089"));
				lotsize.sendKeys(str[42]);
				
				WebElement livingspace = driver.findElement(By.id("cf_3087"));
				livingspace.sendKeys(str[43]);
				
				WebElement municipality = driver.findElement(By.id("cf_2957"));
				municipality.sendKeys(str[44]);
				
				WebElement purchaseprice = driver.findElement(By.name("purchase_price"));
				purchaseprice.sendKeys(str[45]);
				
				WebElement propertyage = driver.findElement(By.id("property_age"));
				propertyage.sendKeys(str[46]);
				
				WebElement year_built = driver.findElement(By.id("yearbuilt"));
				year_built.sendKeys(str[47]);
				
				WebElement timeatresidence = driver.findElement(By.id("cf_2934"));
				timeatresidence.sendKeys(str[48]);
				
				//Subject Property - Part 2
				jse.executeScript("document.getElementById('jscal_field_appraisal_date').value='05-08-2018';");
				
				WebElement appraised_value = driver.findElement(By.name("appraisedvalue"));
				appraised_value.sendKeys("11110.00");
				
//				WebElement appraisal_fee = driver.findElement(By.name("appraisal_fee"));
//				appraisal_fee.sendKeys("500.00");
				
				Select dropdown_appraisal_fee_paid_by = new Select(driver.findElement(By.id("txtbox_Appraisal Fee Paid by")));
				dropdown_appraisal_fee_paid_by.selectByVisibleText("50-50 (Borrower - Broker)");
				
				WebElement purview_appraisal_value = driver.findElement(By.name("purview_appraisal"));
				purview_appraisal_value.sendKeys("27000.00");
				
				Select dropdown_appraisal_type = new Select(driver.findElement(By.name("cf_3249")));
				dropdown_appraisal_type.selectByValue("Full Report");
				
				WebElement est_property_value = driver.findElement(By.name("cf_3248"));
				est_property_value.sendKeys("450000.00");
				
				//Primary Applicant
				WebElement applicant_fname = driver.findElement(By.name("app4fname"));
				applicant_fname.sendKeys(str[101]);
				
				WebElement applicant_lname = driver.findElement(By.id("app4lname"));
				applicant_lname.sendKeys(str[102]);
				
				WebElement applicant_mname_initial = driver.findElement(By.id("app4initial"));
				applicant_mname_initial.sendKeys(str[103]);
				
//				WebElement applicant_bdate = driver.findElement(By.id("jscal_field_app4birthday"));
//				applicant_bdate.sendKeys("08111988");
				jse.executeScript("document.getElementById('jscal_field_app4birthday').value='"+str[104]+"';");
				
				WebElement applicant_mobile = driver.findElement(By.id("app4mobilephone"));
				applicant_mobile.sendKeys(str[105]);
//				jse.executeScript("document.getElementById('app4mobilephone').value='(989) 898-0420';");
				
				WebElement applicant_email = driver.findElement(By.id("app4email"));
				applicant_email.sendKeys(str[106]);
				
				WebElement applicant_street_number = driver.findElement(By.id("app4street_num"));
				applicant_street_number.sendKeys(str[107]);
				
				WebElement applicant_street_name = driver.findElement(By.id("app4street"));
				applicant_street_name.sendKeys(str[108]);
				
				WebElement applicant_unit_number = driver.findElement(By.id("app4unit_num"));
				applicant_unit_number.sendKeys(str[109]);
				
				Select dropdown_applicant_streettype = new Select(driver.findElement(By.id("txtbox_Applicant Street Type")));
				dropdown_applicant_streettype.selectByValue(str[110]);
				
				Select dropdown_applicant_streetdirection = new Select(driver.findElement(By.id("txtbox_Applicant Direction")));
				dropdown_applicant_streetdirection.selectByValue(str[111]);
				
				WebElement applicant_city = driver.findElement(By.id("app4city"));
				applicant_city.sendKeys(str[113]);
				
				WebElement applicant_postalcode = driver.findElement(By.id("app4postalcode"));
				applicant_postalcode.sendKeys(str[112]);
//				jse.executeScript("document.getElementById('app4postalcode').value='N1H 3R2';");
				
				Select dropdown_applicant_province = new Select(driver.findElement(By.id("txtbox_app4provinceorstate")));
				dropdown_applicant_province.selectByValue(str[114]);
				
				Select dropdown_applicant_country = new Select(driver.findElement(By.id("txtbox_app4country")));
				dropdown_applicant_country.selectByValue(str[115]);
				
				Select dropdown_applicant_address_status = new Select(driver.findElement(By.id("txtbox_Applicant Rent or Own")));
				dropdown_applicant_address_status.selectByValue(str[116]);
				
				WebElement applicant_months_ataddress = driver.findElement(By.id("app4yearsataddress"));
				applicant_months_ataddress.sendKeys(str[117]);
				
				WebElement applicant_credit_score = driver.findElement(By.id("cf_3243"));
				applicant_credit_score.sendKeys(str[118]);
				
				//Primary Applicant (Optional)
				WebElement applicant_emp_name = driver.findElement(By.id("app4employername"));
				applicant_emp_name.sendKeys(str[191]);
				
				WebElement applicant_annual_income = driver.findElement(By.name("app4empannualincome"));
				applicant_annual_income.sendKeys(str[192]);
				
				Select dropdown_applicant_occupation_type = new Select(driver.findElement(By.id("txtbox_app4employmenttype")));
				dropdown_applicant_occupation_type.selectByValue(str[193]);
				
				Select dropdown_applicant_income_type = new Select(driver.findElement(By.id("txtbox_Applicant Income Type")));
				dropdown_applicant_income_type.selectByValue(str[194]);
				
				Select dropdown_applicant_emp_type = new Select(driver.findElement(By.id("txtbox_app4empfulltime")));
				dropdown_applicant_emp_type.selectByValue(str[195]);
				
				WebElement applicant_job_title = driver.findElement(By.id("app4empjobtitle"));
				applicant_job_title.sendKeys(str[196]);
				
				WebElement applicant_emp_months = driver.findElement(By.id("app4emplengthofemployment"));
				applicant_emp_months.sendKeys(str[197]);
				
				WebElement applicant_other_income = driver.findElement(By.name("app4otherincome"));
				applicant_other_income.sendKeys(str[198]);
				
				WebElement applicant_otherincome_desc = driver.findElement(By.id("app4otherincomedesc"));
				applicant_otherincome_desc.sendKeys(str[199]);
				
//				WebElement applicant_work_phone = driver.findElement(By.id("app4workphone"));
//				applicant_work_phone.sendKeys("5555555555");
				jse.executeScript("document.getElementById('app4workphone').value='"+str[200]+"';");
				
				WebElement applicant_work_ext = driver.findElement(By.id("app4workphone_ext"));
				applicant_work_ext.sendKeys(str[201]);
				
				Select dropdown_applicant_marital_status = new Select(driver.findElement(By.id("txtbox_Applicant Marital Status")));
				dropdown_applicant_marital_status.selectByValue(str[202]);
				
//				WebElement applicant_home_phone = driver.findElement(By.id("app4homephone"));
//				applicant_home_phone.sendKeys("4444444444");
				jse.executeScript("document.getElementById('app4homephone').value='"+str[203]+"';");
				
				WebElement applicant_dependants = driver.findElement(By.id("cf_2936"));
				applicant_dependants.sendKeys(str[204]);
				
//				WebElement applicant_fax = driver.findElement(By.id("cf_2956"));
//				applicant_fax.sendKeys("0261234350");
				jse.executeScript("document.getElementById('cf_2956').value='"+str[205]+"';");
				
				Select dropdown_applicant_spouseinfo = new Select(driver.findElement(By.id("txtbox_Spouse on as")));
				dropdown_applicant_spouseinfo.selectByValue(str[206]);
				
				//Subject Property - Access Information
				Select dropdown_accesscontact = new Select(driver.findElement(By.name("property_access_contact")));
				dropdown_accesscontact.selectByValue(str[285]);
				
				WebElement contact_fname = driver.findElement(By.name("contact_first_name"));
				contact_fname.sendKeys(str[286]);
				
				WebElement contact_lname = driver.findElement(By.id("contact_last_name"));
				contact_lname.sendKeys(str[287]);
				
				WebElement contact_email = driver.findElement(By.id("contact_email"));
				contact_email.sendKeys(str[288]);
				
				WebElement contact_phn = driver.findElement(By.id("contact_phone"));
				contact_phn.sendKeys(str[289]);
				
				//Existing Mortgage Information
				WebElement first_org_mrtg_amt = driver.findElement(By.name("exist_mortgage_amt"));
				first_org_mrtg_amt.sendKeys(str[152]);
				
				//Independent Legal Information
				WebElement lawyer_fname = driver.findElement(By.id("lawyerfname"));
				lawyer_fname.sendKeys(str[49]);
				
				WebElement lawyer_lname = driver.findElement(By.id("lawyerlname"));
				lawyer_lname.sendKeys(str[50]);
				
				WebElement lawyer_cmp = driver.findElement(By.id("lawyerconame"));
				lawyer_cmp.sendKeys(str[51]);
				
				WebElement lawyer_email = driver.findElement(By.id("lawyeremail"));
				lawyer_email.sendKeys(str[52]);
				
//				WebElement lawyer_phone = driver.findElement(By.id("lawyerphone"));
//				lawyer_phone.sendKeys("9973451423");
				jse.executeScript("document.getElementById('lawyerphone').value='"+str[53]+"';");
				
//				WebElement lawyer_fax = driver.findElement(By.id("lawyerfax"));
//				lawyer_fax.sendKeys("0261789645");
				jse.executeScript("document.getElementById('lawyerfax').value='"+str[54]+"';");
				
				WebElement lawyer_address = driver.findElement(By.name("cf_3035"));
				lawyer_address.sendKeys(str[55]);
				
				driver.findElement(By.className("save")).click();
				
				}

			Thread.sleep(5000);			
			driver.findElement(By.id("ltv_options")).click();
//			WebDriverWait wait1 = new WebDriverWait(driver,20);
//			wait1.until(ExpectedConditions.elementToBeClickable(By.id("ltv_options"))).click();

			WebDriverWait wait2 = new WebDriverWait(driver,30);
			wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.slct_lender:nth-child(1)"))).click();
		
			WebDriverWait wait3 = new WebDriverWait(driver,40);
			wait3.until(ExpectedConditions.elementToBeClickable(By.id("alert_close"))).click();
			
			WebDriverWait wait4 = new WebDriverWait(driver,40);
			wait4.until(ExpectedConditions.elementToBeClickable(By.id("send-docusign"))).click();
			
			Thread.sleep(5000);
			WebDriverWait wait5 = new WebDriverWait(driver,40);
			wait5.until(ExpectedConditions.elementToBeClickable(By.id("procced-send-document"))).click();
			
			Thread.sleep(20000);
			WebDriverWait wait6 = new WebDriverWait(driver,10);
			wait6.until(ExpectedConditions.elementToBeClickable(By.className("btn_order_apprasial"))).click();
			
			WebDriverWait wait7 = new WebDriverWait(driver,10);
			wait7.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='button']"))).click();
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[33]/div[3]/div/button[1]")).click();
			
			Thread.sleep(4000);
			driver.findElement(By.xpath("/html/body/div[24]/div/div[3]/button")).click();
			
		}		
    }

  }   