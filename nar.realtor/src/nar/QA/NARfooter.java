package nar.QA;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import java.net.URL;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NARfooter {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private static String coreAltUrl = "https://rov3:pr3pr0d@rov3.nar.realtor";
	private static String coreUrl = "https://rov3.nar.realtor";
	//private static String coreUrl = "https://qa.nar.realtor";
	//private static String coreUrl = "https://www.nar.realtor";
	//static String BrowserList[] = new String[] {	"Chrome","Chrome","Chrome","Chrome","Chrome","Chrome","Firefox","Firefox","Firefox","Firefox","Firefox","Firefox","Edge","IE","IE","Safari","Safari","Safari"};
	//static String BrowserVersionList[] = new String[] {  "52.0","51.0","50.0","52.0","51.0","50.0","47.0","46.0","45.0","47.0","46.0","45.0","13.0","11.0","10.0","9.1","8.0","7.1"};
	//static String OsList[] = new String[] {  "Windows","Windows","Windows","OS X","OS X","OS X","Windows","Windows","Windows","OS X","OS X","OS X","Windows","Windows","Windows","OS X","OS X","OS X"};
	//static String OsVersionList[] = new String[] {  "10","8.1","7","El Capitan","Yosemite","Mavericks","10","8.1","7","El Capitan","Yosemite","Mavericks","10","8.1","7","El Capitan","Yosemite","Mavericks"};
	//public static final String USERNAME = "vahan7";
	//public static final String AUTOMATE_KEY = "s69xsvCjzoREfPDWUNWB";
	//public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	@Before
	public void setUp() throws Exception {
		System.out.println("Before Stage Concluded");
		// Alex added this.
		//DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("browser", "IE");
		//caps.setCapability("browser_version", "9.0");
		//caps.setCapability("os", "Windows");
		//caps.setCapability("os_version", "7");
		//caps.setCapability("browserstack.debug", "true");
		//caps.setCapability("browserstack.local", "true");
		//caps.setCapability("build", "Homepage Footer Check");
		//caps.setCapability("project", "Homepage Footer Check");
		// Original String -> driver = new RemoteWebDriver(new URL(URL), caps);
		driver = new FirefoxDriver();
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void roFooterMain() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(coreAltUrl);
			checkPageIsReady();
			driver.get(coreUrl);
			checkPageIsReady();
			String whatis;
			String expectedValue;
			// List of Variables
			By HQ = By.xpath("//*[@id='block-nar-settings-addresses']/div/div[1]/div");
			By DC = By.xpath("//*[@id='block-nar-settings-addresses']/div/div[2]/div");
			By faceBook = By.xpath("//*[@id='block-menu-block-7']/div/ul/li[1]/a");
			By twitter = By.xpath("//*[@id='block-menu-block-7']/div/ul/li[3]/a");
			By linkedIn = By.xpath("//*[@id='block-menu-block-7']/div/ul/li[2]/a");
			By youTube = By.xpath("//*[@id='block-menu-block-7']/div/ul/li[4]/a");
			//By pintrest = By.xpath("//*[@id='atftbx']/div/a[5]");
			//By morePlus = By.xpath("//*[@id='block-nar-footer-nar-footer-left-column']/div/div/div[3]/div/div[2]/a");
			By privacyLink = By.xpath("//*[@id='block-menu-block-8']/div/ul/li[1]/a");
			By accessibilityLink = By.xpath("//*[@id='block-menu-block-8']/div/ul/li[2]/a");
			By reprintsLink = By.xpath("//*[@id='block-menu-block-8']/div/ul/li[3]/a");
			By termsLink = By.xpath("//*[@id='block-menu-block-8']/div/ul/li[4]/a");
			By RealtorsPropertyResourceImg = By.xpath("//*[@id='block-menu-block-9']/div/ul/li[1]/a/img");
			By RealtorsPropertyResourceLink = By.xpath("//*[@id='block-menu-block-9']/div/ul/li[1]/a");
			By RealtorMagazineImg = By.xpath("//*[@id='block-menu-block-9']/div/ul/li[2]/a/img");
			By RealtorMagazineLink = By.xpath("//*[@id='block-menu-block-9']/div/ul/li[2]/a");
			By CommercialSearchImg = By.xpath("//*[@id='block-menu-block-9']/div/ul/li[3]/a/img");
			By CommercialSearchLink = By.xpath("//*[@id='block-menu-block-9']/div/ul/li[3]/a");
			By RealtorActionCenterImg = By.xpath("//*[@id='block-menu-block-9']/div/ul/li[4]/a/img");
			By RealtorActionCenterLink = By.xpath("//*[@id='block-menu-block-9']/div/ul/li[4]/a");
			By WhatIsNARImg = By.xpath("//*[@id='block-menu-block-10']/div/ul/li[1]/a/img");
			By WhatIsNARLink = By.xpath("//*[@id='block-menu-block-10']/div/ul/li[1]/a");
			By RealtorComImg = By.xpath("//*[@id='block-menu-block-10']/div/ul/li[2]/a/img");
			By RealtorComLink = By.xpath("//*[@id='block-menu-block-10']/div/ul/li[2]/a");
			By HouseLogicImg = By.xpath("//*[@id='block-menu-block-10']/div/ul/li[3]/a/img");
			By HouseLogicLink = By.xpath("//*[@id='block-menu-block-10']/div/ul/li[3]/a");
			By HomeOwnershipMattersImg = By.xpath("//*[@id='block-menu-block-10']/div/ul/li[4]/a/img");
			By HomeOwnershipMattersLink = By.xpath("//*[@id='block-menu-block-10']/div/ul/li[4]/a");
			By allPropertiesClick = By.xpath("//*[@id='block-nar-settings-nar-properties-toggle']/div/a");
			By allPropertiesField = By.xpath("html/body/footer/div/div[4]/div/div[5]/div[1]/div/div");
			By translateClick = By.xpath("//*[@id='block-nar-settings-translate']/div/a");
			By translateField = By.xpath("//*[@id='block-nar-settings-translate']/div/div");
			// Test of Social Media
			System.out.println("");
			System.out.println("Left Bar Check");
			//textPresent(); linkPresent(by, value); imagePresent(by, value);
			whatis = "Headquarters";
			expectedValue = "430 N. Michigan Ave" + "\n" + "Chicago, IL 60611-4087";
			textPresent(whatis, HQ, expectedValue);
			whatis = "DcOffice";
			expectedValue = "500 New Jersey Avenue, NW" + "\n" + "Washington DC 20001-2020";
			textPresent(whatis, DC, expectedValue);
			whatis = "Facebook";
			expectedValue = "http://www.facebook.com/NARdotRealtor/";
			linkPresent(whatis, faceBook, expectedValue);
			whatis = "Twitter";
			expectedValue = "http://twitter.com/intent/follow?source=followbutton&variant=1.0&screen_name=nardotrealtor";
			linkPresent(whatis, twitter, expectedValue);
			whatis = "LinkedIn";
			expectedValue = "http://www.linkedin.com/company/national-association-of-realtors";
			linkPresent(whatis, linkedIn, expectedValue);
			whatis = "Youtube";
			expectedValue = "https://www.youtube.com/user/NAREALTORS";
			linkPresent(whatis, youTube, expectedValue);
			whatis = "Privacy Policy";
			expectedValue = coreUrl + "/privacy-policy";
			linkPresent(whatis, privacyLink, expectedValue);
			whatis = "Accessibility";
			expectedValue = coreUrl + "/accessibility";
			linkPresent(whatis, accessibilityLink, expectedValue);
			whatis = "Reprints";
			expectedValue = coreUrl + "/reprint-guidelines";
			linkPresent(whatis, reprintsLink, expectedValue);
			whatis = "Terms of Use";
			expectedValue = coreUrl + "/terms-of-use";
			linkPresent(whatis, termsLink, expectedValue);
			//System.out.println("Social Media Section: Pass. 1/4");
			//System.out.println("");
			//System.out.println("For NAR Members Check");

			whatis = "Realtors Property Resource";
			expectedValue = coreUrl + "/sites/default/files/styles/logo_autox35/public/menuimage/rpr-icon-35_0.png?itok=xqj1hi-k";
			imagePresent(whatis, RealtorsPropertyResourceImg, expectedValue);
			expectedValue = "https://www.narrpr.com/";
			linkPresent(whatis, RealtorsPropertyResourceLink, expectedValue);
			whatis = "Realtor Magazine";
			expectedValue = coreUrl + "/sites/default/files/styles/logo_autox35/public/menuimage/rmo-35_0.gif?itok=BW2Oait3";
			imagePresent(whatis, RealtorMagazineImg, expectedValue);
			expectedValue = "http://realtormag.realtor.org/";
			linkPresent(whatis, RealtorMagazineLink, expectedValue);
			whatis = "Commercial Search";
			expectedValue = coreUrl + "/sites/default/files/styles/logo_autox35/public/menuimage/commercialsearch-35_0.png?itok=79lJpYWS";
			imagePresent(whatis, CommercialSearchImg, expectedValue);
			expectedValue = "http://www.commercialsearch.com/";
			linkPresent(whatis, CommercialSearchLink, expectedValue);
			whatis = "Realtor Action Center";
			expectedValue = coreUrl + "/sites/default/files/styles/logo_autox35/public/menuimage/what-is-a-realtor-logo-35_1.png?itok=UnCezRZX";
			imagePresent(whatis, RealtorActionCenterImg, expectedValue);
			expectedValue = "http://www.realtoractioncenter.com/";
			linkPresent(whatis, RealtorActionCenterLink, expectedValue);
			//System.out.println("For NAR Members Section: Pass. 2/4");
			//System.out.println("");

			System.out.println("For the Public Check");
			whatis = "What Is NAR";
			expectedValue = coreUrl + "/sites/default/files/styles/logo_autox35/public/menuimage/what-is-a-realtor-logo-35_0.png?itok=Ovmnl7YD";
			imagePresent(whatis, WhatIsNARImg, expectedValue);
			expectedValue = "http://realtormag.realtor.org/sales-and-marketing/handouts-for-customers/for-buyers/7-reasons-work-realtor";
			linkPresent(whatis, WhatIsNARLink, expectedValue);

			whatis = "Realtor.com";
			expectedValue = coreUrl + "/sites/default/files/styles/logo_autox35/public/menuimage/realtor-com-35_0.png?itok=JxenTVFb";
			imagePresent(whatis, RealtorComImg, expectedValue);
			expectedValue = "http://www.realtor.com/";
			linkPresent(whatis, RealtorComLink, expectedValue);

			whatis = "House Logic";
			expectedValue = coreUrl + "/sites/default/files/styles/logo_autox35/public/menuimage/houselogic-logo-35_0.png?itok=i60G63R0";
			imagePresent(whatis, HouseLogicImg, expectedValue);
			expectedValue = "http://www.houselogic.com/";
			linkPresent(whatis, HouseLogicLink, expectedValue);

			whatis = "Home Ownership Matters";
			expectedValue = coreUrl + "/sites/default/files/styles/logo_autox35/public/menuimage/homeownershipmattersicon.png?itok=_rUfD6Gt";
			imagePresent(whatis, HomeOwnershipMattersImg, expectedValue);
			expectedValue = "http://homeownershipmatters.realtor/";
			linkPresent(whatis, HomeOwnershipMattersLink, expectedValue);



			//System.out.println("For NAR Members Section: Pass. 3/4");
			//System.out.println("");
			System.out.println("Bottom Check");

			whatis = "All Properties";
			elementPresent(whatis, allPropertiesClick, allPropertiesField);

			whatis = "Translate";
			elementPresent(whatis, translateClick, translateField);

			//System.out.println("For NAR Members Section: Pass. 4/4");
			//System.out.println("");
			System.out.println("Concluding Homepage Footer Test");
		} catch (Exception e) {
			System.out.println("Error >>----------> " + e);
		}
	}
	@After
	public void tearDown() throws Exception {
			driver.quit();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
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
	private boolean textPresent(String whatIs, By location, String result) {
		try {
			String text = driver.findElement(location).getText();
			assertEquals(text, result);
			//System.out.println("Headquarters: Working");
			return true;
		} catch (Exception e) {
			System.err.println(whatIs + ": Not Working");
			return false;
		}
	}
	private boolean linkPresent(String whatIs, By location, String result) {
		try {
			String link = driver.findElement(location).getAttribute("href");
			assertEquals(link, result);
			//System.out.println("Headquarters: Working");
			return true;
		} catch (Exception e) {
			System.err.println(whatIs + ": Not Working");
			return false;
		}
	}
	private boolean imagePresent(String whatIs, By location, String result) {
		try {
			String local = driver.findElement(location).getAttribute("src");
			assertEquals(local, result);
			//System.out.println("Headquarters: Working");
			return true;
		} catch (Exception e) {
			System.err.println(whatIs + ": Not Working");
			return false;
		}
	}
	private boolean elementPresent(String whatIs, By location, By field) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			driver.findElement(location).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(field));

			if (driver.findElement(field).isDisplayed()) {
				//System.out.println(whatIs + "s: Working");
				driver.findElement(location).click();
			}
			return true;
		} catch (Exception e) {
			System.err.println(whatIs + ": Not Working");
			return false;
		}
	}
}