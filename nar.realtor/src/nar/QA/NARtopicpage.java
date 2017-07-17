package nar.QA;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.*;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.util.List;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class NARtopicpage {
	private WebDriver driver;
	static int e;
	static String search;
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


	//Notes:
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "][contains(@style, 'opacity: 1')]")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "]")));
	assertTrue(isElementPresent(ElementLocal));
	.getCssValue("border-top-style").trim()
	.getAttribute("href");
	Saving a mouse over to home logo for example: Action mouseOverHome = builder.moveToElement(link_Home).build();
	*/

	static String searchTerms[] = new String[] {
		"Test",
		"Now"
	};
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Topics Test Started!");
	}
	@Test
	public void NARtopicpageMain() throws MalformedURLException {
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
	public void tearDown() {
		driver.quit();
	}
	static String topicTitles[] = new String[] {
		"Commercial & Investment Real Estate",
		"Residential Real Estate",
		"Financing & Credit",
		"Taxes"
	};
	static String browseAllLinks[] = new String[] {
		coreUrl + "/commercial-investment-real-estate", coreUrl + "/residential-real-estate", coreUrl + "/financing-credit", coreUrl + "/taxes"
	};
	// Methods
	public void callout() {
		driver.get(coreUrl + "/topics");
		checkPageIsReady();
		for (int column = 0; column < 4; column++) {
			System.out.println("ColumnDefault" + column);
			String topictitleDefault = topicTitles[column];
			System.out.println("Default" + topictitleDefault);
			System.out.println("ColumnDefault" + (column + 1));
			String topicTitles = driver.findElement(By.xpath("//*[@id='main']/div/div/div[4]/div/div/div/div/div/div/div/div[" + (column + 1) + "]/div/div/h3")).getText();
			System.out.println("Pulled" + topicTitles);
			assertEquals(topictitleDefault, topicTitles);
			browserAll(topictitleDefault, column);
		}
	}
	public void browserAll(String z, int b) {
			List < WebElement > topicSubjects = driver.findElements(By.xpath("//*[@id='main']/div/div/div[4]/div/div/div/div/div/div/div/div[" + b + "]/div/div/div/ul/li"));
			int intLinkCount = topicSubjects.size();
			String BrowserAllTextDefault = "Browse all " + z;
			String BrowserAllText = driver.findElement(By.xpath("//*[@id='main']/div/div/div[4]/div/div/div/div/div/div/div/div[" + (b + 1) + "]/div/div/div/ul/li[" + intLinkCount + "]/a")).getText();
			String BrwserrAllLinkDefault = browseAllLinks[b];
			String BrwserrAllLink = driver.findElement(By.xpath("//*[@id='main']/div/div/div[4]/div/div/div/div/div/div/div/div[" + (b + 1) + "]/div/div/div/ul/li[" + intLinkCount + "]/a")).getAttribute("href");
			assertEquals(BrowserAllTextDefault, BrowserAllText);
			assertEquals(BrwserrAllLinkDefault, BrwserrAllLink);
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