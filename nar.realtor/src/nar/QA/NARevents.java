package nar.QA;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NARevents {
	private WebDriver driver;
	static int e;
	static String events;
	private static String coreUrl = "https://qa.nar.realtor";

	/*
	private static String coreUrl = "https://qa.nar.realtor";
	private static String coreUrl = "https://www.nar.realtor";
	static String BrowserList[] = new String[] {	"Chrome","Chrome","Chrome","Chrome","Chrome","Chrome","Firefox","Firefox","Firefox","Firefox","Firefox","Firefox","Edge","IE","IE","Safari","Safari","Safari"};
	static String BrowserVersionList[] = new String[] {  "52.0","51.0","50.0","52.0","51.0","50.0","47.0","46.0","45.0","47.0","46.0","45.0","13.0","11.0","10.0","9.1","8.0","7.1"};
	static String OsList[] = new String[] {  "Windows","Windows","Windows","OS X","OS X","OS X","Windows","Windows","Windows","OS X","OS X","OS X","Windows","Windows","Windows","OS X","OS X","OS X"};
	static String OsVersionList[] = new String[] {  "10","8.1","7","El Capitan","Yosemite","Mavericks","10","8.1","7","El Capitan","Yosemite","Mavericks","10","8.1","7","El Capitan","Yosemite","Mavericks"};
	public static final String USERNAME = "vahan7";
	public static final String AUTOMATE_KEY = "s69xsvCjzoREfPDWUNWB";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	*/


	static String eventsTerms[] = new String[] {  "Test", "Now"};

	@Before
    public void setUp()
    {
		driver = new FirefoxDriver();
    	driver.manage().window().maximize();
		System.out.println("Events Test Started!");
    }

	@Test
    public void NAReventsMain() throws MalformedURLException
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
		e = eventsTerms.length;

		for (int i = 0; i < e; i++) {
			eventsInput(i);
		}

	}

	public void eventsInput(int a) {
		WebElement eventsBar = driver.findElement(By.xpath("//*[@id='block-nar-events-site-events']/div/global-search/form/input"));
		WebElement eventsConfirm = driver.findElement(By.xpath("//*[@id='block-nar-search-site-search']/div/global-search/form/button"));
			events = eventsTerms[a];
			eventsBar.sendKeys(events);
			eventsConfirm.click();
			checkPageIsReady();

			System.out.println("Term Used Succesfully " + events);
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
