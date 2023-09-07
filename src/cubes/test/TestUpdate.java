package cubes.test;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cubes.webpages.LoginPage;
import cubes.webpages.tags.TagsUpdate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUpdate {

	private static WebDriver driver;
	private static LoginPage loginPage;
	private static TagsUpdate addTag;
	private static WebDriverWait wait;
	private static String tagName;
	private static String tagName2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver,gecko,driver","‪C:\\Users\\Korisnik\\Desktop\\webdriverCromeFire\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		loginPage = new LoginPage(driver);
		addTag = new TagsUpdate(driver, wait);

		loginPage.loginSuccess();
		addTag.pageAddTag();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tc1test() {

		addTag.AddTag();

		tagName = addTag.AddNewTag();

		String e = tagName;

		assertEquals(tagName, e);

	}

	@Test
	public void tc2test() {

		addTag.updateButton(tagName);

		addTag.emptyEntry();

		WebElement error = addTag.emptyError();

		assertEquals(addTag.emptyError(), error);

	}

	@Test
	public void tc3test() {
		String er = tagName;

		addTag.cancelAdd();

		assertEquals(tagName, er);
	}

	@Test
	public void tc4test() {

		addTag.pageAddTag();

		addTag.updateButton(tagName);

		addTag.saveButton();

	}

	@Test
	public void tc5test() {

		addTag.pageAddTag();

		addTag.updateButton(tagName);

		addTag.AddNewTag2(tagName2);

		String tag2 = tagName2;

		assertEquals(tagName2, tag2);

	}

}
