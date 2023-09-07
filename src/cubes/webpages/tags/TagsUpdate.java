package cubes.webpages.tags;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagsUpdate {

	private WebDriver driver;
	private WebDriverWait wait;
	private static final String PAGE_ADDTAG = "https://testblog.kurs-qa.cubes.edu.rs/admin/tags";

	// WebElements
	@FindBy(xpath = "//i[@class= 'fas fa-plus-square']")
	WebElement addButton;
	@FindBy(xpath = "//input[@name='name']")
	WebElement inputButton;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath="//a[text()='Cancel']")
	WebElement cancelButton;

	public TagsUpdate(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;
		this.driver.get(PAGE_ADDTAG);
		PageFactory.initElements(driver, this);

	}

	public void pageAddTag() {
		driver.get(PAGE_ADDTAG);
	}

	public String AddNewTag() {

		Random radnom = new Random();
		String tagName = "TagNN " + radnom.nextInt(1000);
		inputButton.sendKeys(tagName);
		saveButton.click();

		return tagName;
	}

	public void AddTag() {

		addButton.click();
	}

	public void updateButton(String tagName) {

		WebElement updateButton = driver
				.findElement(By.xpath("//strong[text()='" + tagName + "']//ancestor::tr//td[5]//div//a[2]//i"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", updateButton);
	}

	public void emptyEntry() {
		wait.until(ExpectedConditions.visibilityOf(inputButton));
		inputButton.clear();

		inputButton.sendKeys("");
		saveButton.click();
	}
	

	public void cancelAdd() {
		cancelButton.click();
		
		//WebElement cancel = driver.findElement(By.xpath("//a[text()='Cancel']"));
		//cancel.click();
		
	}
	
	public void saveButton() {
		wait.until(ExpectedConditions.visibilityOf(saveButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
	}
	
	public WebElement emptyError() {
		
		WebElement we = driver.findElement(By.xpath("//span[@class='error text-danger']"));
		
		return  we;
	}
	public String AddNewTag2(String tagName2) {

		Random radnom = new Random();
		tagName2 = "TagNN " + radnom.nextInt(1000);
		wait.until(ExpectedConditions.visibilityOf(inputButton));
		inputButton.sendKeys(tagName2);
		wait.until(ExpectedConditions.visibilityOf(saveButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);

		return tagName2;
	}


}
