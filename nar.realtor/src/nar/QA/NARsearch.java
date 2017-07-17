package nar.QA;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class NARsearch {
	private WebDriver driver;
	static int e;
	static String search;
	private static String coreUrl = "https://qa.nar.realtor";


	static String searchTerms[] = new String[] {  "Test", "Now"};

	@Before
    public void setUp()
    {
		driver = new FirefoxDriver();
    	driver.manage().window().maximize();
		System.out.println("Search Test Started!");
    }

	@Test
    public void NARsearchMain() throws MalformedURLException
    {
		callout();

		/*
		Remote Browser Loop
		for (i = 0; i < 18; i++) {
			System.out.println("A");
			browser(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			NARloginMain();
			System.out.println("End Main Test");
			driver.quit();
		}
		*/

    }

	@After
    public void tearDown()
    {
		driver.quit();
    }

	static String tabLevels[] = new String[] {
			"3", "2", "2", "1", "2", "2", "1"
	};

	// Methods

	public void callout() {
		driver.get(coreUrl + "/");
		checkPageIsReady();
		e = searchTerms.length;

		for (int i = 0; i < e; i++) {
			searchInput(i);
		}

	}

	public void searchInput(int a) {
		WebElement searchBar = driver.findElement(By.xpath("//*[@id='block-nar-search-site-search']/div/global-search/form/input"));
		WebElement searchConfirm = driver.findElement(By.xpath("//*[@id='block-nar-search-site-search']/div/global-search/form/button"));
			search = searchTerms[a];
			searchBar.sendKeys(search);
			searchConfirm.click();
			checkPageIsReady();

			System.out.println("Term Used Succesfully " + search);
	}


	//Check Page is loaded
	public void checkPageIsReady() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//Initially bellow given if condition will check ready state of page.
	if (js.executeScript("return document.readyState").toString().equals("complete")) {
		return;
	}
	//This loop will rotate for 25 times to check If page Is ready after every 1 second.
	//You can replace your value with 25 If you wants to Increase or decrease wait time.
	for (int i = 0; i < 25; i++) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		//To check page ready state.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			break;
		}
	}
}
}
