package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillAvaform {

	private WebDriver driver = null;
	public WebDriverWait wait = null;

	/***************** WebElements *****************/

	private static final String namexpath = "//*[@id='avaform-name']";
	private static final String emailxpath = "//*[@id='avaform-email']";
	private static final String companyxpath = "//*[@id='avaform-company']";
	private static final String phonexpath = "//*[@id='avaform-phone']";
	private static final String submitbtnxpath = "//*[@id='avaform-submit']";

	/***************** End of WebElements *****************/


	/***************Filling the Form Fields**********************/	
	// Filling Name
	public void fillName(WebDriver driver) {
		WebElement name = driver.findElement(By.xpath(namexpath));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(name));

		clearName(name);

		name.sendKeys("Chetan P");

		System.out.println("Name entered");

	}

	// Filling Email
	public void fillEmail(WebDriver driver) {
		WebElement email = driver.findElement(By.xpath(emailxpath));
		wait.until(ExpectedConditions.visibilityOf(email));

		clearEmail(email);

		email.sendKeys("cp@avlr.net");

		System.out.println("Email entered");
	}

	// Filling Company name.
	public void fillCompany(WebDriver driver) {
		WebElement company = driver.findElement(By.xpath(companyxpath));
		wait.until(ExpectedConditions.visibilityOf(company));

		clearCompany(company);

		company.sendKeys("avlr");

		System.out.println("Company entered");
	}

	// Filling phone number.
	public void fillPhone(WebDriver driver) {
		WebElement phone = driver.findElement(By.xpath(phonexpath));
		wait.until(ExpectedConditions.visibilityOf(phone));

		clearPhone(phone);

		phone.sendKeys("9090909099");

		System.out.println("Phone entered");
	}

	// Submitting the Form.
	public void submitAvaform(WebDriver driver) {
		WebElement submitBtn = driver.findElement(By.xpath(submitbtnxpath));
		wait.until(ExpectedConditions.visibilityOf(submitBtn));
		submitBtn.click();
		System.out.println("Form submitted");
	}

	
/***************Clearing the Form Fields**********************/	
	private void clearName(WebElement name) {
		name.clear();

		System.out.println("Name field got cleared");

	}

	private void clearEmail(WebElement email) {
		// TODO Auto-generated method stub
		email.clear();

		System.out.println("Email field got cleared");
	}

	private void clearCompany(WebElement company) {
		// TODO Auto-generated method stub
		company.clear();

		System.out.println("Company field got cleared");
	}

	private void clearPhone(WebElement phone) {
		// TODO Auto-generated method stub
		phone.clear();

		System.out.println("Phone field got cleared");

	}

}
