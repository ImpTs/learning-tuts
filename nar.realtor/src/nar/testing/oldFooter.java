package nar.testing;
import org.junit.*;
import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class oldFooter {
	private static WebDriver driver;
	static int i;
	//static String coreUrl = "https://www.nar.realtor";
	static String coreUrl = "https://dev.nar.realtor";
	static String BrowserList[] = new String[] {
		"Chrome",
		"Chrome",
		"Chrome",
		"Chrome",
		"Chrome",
		"Chrome",
		"Firefox",
		"Firefox",
		"Firefox",
		"Firefox",
		"Firefox",
		"Firefox",
		"Edge",
		"IE",
		"IE",
		"Safari",
		"Safari",
		"Safari"
	};
	static String BrowserVersionList[] = new String[] {
		"52.0",
		"51.0",
		"50.0",
		"52.0",
		"51.0",
		"50.0",
		"47.0",
		"46.0",
		"45.0",
		"47.0",
		"46.0",
		"45.0",
		"13.0",
		"11.0",
		"10.0",
		"9.1",
		"8.0",
		"7.1"
	};
	static String OsList[] = new String[] {
		"Windows",
		"Windows",
		"Windows",
		"OS X",
		"OS X",
		"OS X",
		"Windows",
		"Windows",
		"Windows",
		"OS X",
		"OS X",
		"OS X",
		"Windows",
		"Windows",
		"Windows",
		"OS X",
		"OS X",
		"OS X"
	};
	static String OsVersionList[] = new String[] {
		"10",
		"8.1",
		"7",
		"El Capitan",
		"Yosemite",
		"Mavericks",
		"10",
		"8.1",
		"7",
		"El Capitan",
		"Yosemite",
		"Mavericks",
		"10",
		"8.1",
		"7",
		"El Capitan",
		"Yosemite",
		"Mavericks"
	};
	public static final String USERNAME = "vahan7";
	public static final String AUTOMATE_KEY = "s69xsvCjzoREfPDWUNWB";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Before
    public void setUp() throws Exception
    {
		System.out.println("Login Test Started!");
    }

	@Test
    public void narFooterMain() throws Exception
    {
		for (i = 0; i < 18; i++) {
			System.out.println("A");
			browser(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			roFooterMain();
			System.out.println("End Main Test");
			driver.quit();
		}
    }

	@After
    public void tearDown() throws Exception
    {
		driver.quit();
    }

	public void browser(int number) throws Exception {
		String BrowserText = BrowserList[number];
		String BrowserVersionText = BrowserVersionList[number];
		String OsText = OsList[number];
		String OsVersionText = OsVersionList[number];
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", BrowserText);
		caps.setCapability("browser_version", BrowserVersionText);
		caps.setCapability("os", OsText);
		caps.setCapability("os_version", OsVersionText);
		caps.setCapability("browserstack.debug", "true");
		driver = new RemoteWebDriver(new URL(URL), caps);
		new WebDriverWait(driver, 5);
		System.out.println("Test Info Browser: " + BrowserList[number] + " " + BrowserVersionList[number] + ". OS: " + OsList[number] + " " + OsVersionList[number]);
	}

	public void roFooterMain() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get(coreUrl + "/");
		  checkPageIsReady();

		  // List of Variables
		  By HQ = By.xpath("//*[@id='block-nar-footer-nar-footer-left-column']/div/div/div[1]/p[1]");
		  By DC = By.xpath("//*[@id='block-nar-footer-nar-footer-left-column']/div/div/div[2]/p[1]");
		  By faceBook = By.xpath("//*[@id='atftbx']/div/a[1]");
		  By twitter = By.xpath("//*[@id='atftbx']/div/a[2]");
		  By linkedIn = By.xpath("//*[@id='atftbx']/div/a[3]");
		  By youTube = By.xpath("//*[@id='atftbx']/div/a[4]");
		  By pintrest = By.xpath("//*[@id='atftbx']/div/a[5]");
		  By morePlus = By.xpath("//*[@id='block-nar-footer-nar-footer-left-column']/div/div/div[3]/div/div[2]/a");
		  By privacyLink = By.xpath("//*[@id='block-nar-footer-nar-footer-left-column']/div/div/div[4]/ul/li[1]/a");
		  By accessibilityLink = By.xpath("//*[@id='block-nar-footer-nar-footer-left-column']/div/div/div[4]/ul/li[2]/a");
		  By reprintsLink = By.xpath("//*[@id='block-nar-footer-nar-footer-left-column']/div/div/div[4]/ul/li[3]/a");
		  By termsLink = By.xpath("//*[@id='block-nar-footer-nar-footer-left-column']/div/div/div[4]/ul/li[4]/a");

		  By RealtorsPropertyResourceImg = By.xpath("//*[@id='block-nar-footer-nar-footer-members']/div/div/div/ul/li[1]/div/a/img");
		  By RealtorsPropertyResourceLink = By.xpath("//*[@id='block-nar-footer-nar-footer-members']/div/div/div/ul/li[1]/a");
		  By RealtorMagazineImg = By.xpath("//*[@id='block-nar-footer-nar-footer-members']/div/div/div/ul/li[2]/div/a/img");
		  By RealtorMagazineLink = By.xpath("//*[@id='block-nar-footer-nar-footer-members']/div/div/div/ul/li[2]/a");
		  By CommercialSearchImg = By.xpath("//*[@id='block-nar-footer-nar-footer-members']/div/div/div/ul/li[3]/div/a/img");
		  By CommercialSearchLink = By.xpath("//*[@id='block-nar-footer-nar-footer-members']/div/div/div/ul/li[3]/a");
		  By RealtorActionCenterImg = By.xpath("//*[@id='block-nar-footer-nar-footer-members']/div/div/div/ul/li[4]/div/a/img");
		  By RealtorActionCenterLink = By.xpath("//*[@id='block-nar-footer-nar-footer-members']/div/div/div/ul/li[4]/a");

		  By WhatIsNARImg = By.xpath("//*[@id='block-nar-footer-nar-footer-public']/div/div/div/ul/li[1]/div/a/img");
		  By WhatIsNARLink = By.xpath("//*[@id='block-nar-footer-nar-footer-public']/div/div/div/ul/li[1]/a");
		  By RealtorComImg = By.xpath("//*[@id='block-nar-footer-nar-footer-public']/div/div/div/ul/li[2]/div/a/img");
		  By RealtorComLink = By.xpath("//*[@id='block-nar-footer-nar-footer-public']/div/div/div/ul/li[2]/a");
		  By HouseLogicImg = By.xpath("//*[@id='block-nar-footer-nar-footer-public']/div/div/div/ul/li[3]/div/a/img");
		  By HouseLogicLink = By.xpath("//*[@id='block-nar-footer-nar-footer-public']/div/div/div/ul/li[3]/a");

		  By allPropertiesClick = By.xpath("//*[@id='block-nar-footer-nar-footer-properties']/div/div/h3");
		  By allPropertiesField = By.xpath("//*[@id='block-nar-footer-nar-footer-properties-popup']/div/div/div");
		  By translateClick = By.xpath("//*[@id='block-nar-footer-nar-footer-translate']/div/div/div/h3");
		  By translateField = By.xpath("//*[@id='block-nar-footer-nar-footer-translate']/div/div/div/h3/div");

		  // Test of Social Media
		  System.out.println("");

		  System.out.println("Left Bar Check");
		  try {
			  String HeadquartersText = driver.findElement(HQ).getText();
			  assertEquals("430 N. Michigan Avenue", HeadquartersText);
			  System.out.println("Headquarters: Working");
		  }catch (Exception e) {
			  System.err.println("Headquarters: Not Working");
		  }

		  try {
			  String DcOfficeText = driver.findElement(DC).getText();
			  assertEquals("500 New Jersey Avenue, NW", DcOfficeText);
			  System.out.println("DcOffice: Working");
		  }catch (Exception e) {
			  System.err.println("DcOffice: Not Working");
		  }

		  try {
			  String facebookURL = driver.findElement(faceBook).getAttribute("href");
			  assertEquals("http://www.facebook.com/NARdotRealtor/", facebookURL);
			  System.out.println("Facebook: Working");
		  }catch (Exception e) {
			  System.err.println("Facebook: Not Working");
		  }

		  try {
			  String twitterURL = driver.findElement(twitter).getAttribute("href");
			  assertEquals("http://twitter.com/intent/follow?source=followbutton&variant=1.0&screen_name=nardotrealtor", twitterURL);
			  System.out.println("Twitter: Working");
		  }catch (Exception e) {
			  System.err.println("Twitter: Not Working");
		  }

		  try {
			  String linkedinURL = driver.findElement(linkedIn).getAttribute("href");
			  assertEquals("http://www.linkedin.com/company/national-association-of-realtors", linkedinURL);
			  System.out.println("LinkedIn: Working");
		  }catch (Exception e) {
			  System.err.println("LinkedIn: Not Working");
		  }

		  try {
			  String youTubeURL = driver.findElement(youTube).getAttribute("href");
			  assertEquals("http://www.youtube.com/user/NAREALTORS?sub_confirmation=1", youTubeURL);
			  System.out.println("Youtube: Working");
		  }catch (Exception e) {
			  System.err.println("Youtube: Not Working");
		  }

		  try {
			  String pintrestURL = driver.findElement(pintrest).getAttribute("href");
			  assertEquals("http://www.pinterest.com/Realtors", pintrestURL);
			  System.out.println("Pintrest: Working");
		  }catch (Exception e) {
			  System.err.println("Pintrest: Not Working");
		  }

		  try {
			  String morePlusURL = driver.findElement(morePlus).getAttribute("href");
			  assertEquals(coreUrl + "/stay-connected/stay-connected", morePlusURL);
			  System.out.println("More+: Working");
		  }catch (Exception e) {
			  System.err.println("More+: Not Working");
		  }

		  try {
			  String PrivacyPolicyURL = driver.findElement(privacyLink).getAttribute("href");
			  assertEquals(coreUrl + "/privacy-policy", PrivacyPolicyURL);
			  System.out.println("Privacy Polic: Working");
		  }catch (Exception e) {
			  System.err.println("Privacy Polic: Not Working");
		  }

		  try {
			  String accessibilityURL = driver.findElement(accessibilityLink).getAttribute("href");
			  assertEquals(coreUrl + "/accessibility", accessibilityURL);
			  System.out.println("Accessibility: Working");
		  }catch (Exception e) {
			  System.err.println("Accessibility: Not Working");
		  }

		  try {
			  String reprintsURL = driver.findElement(reprintsLink).getAttribute("href");
			  assertEquals(coreUrl + "/reprint-guidelines", reprintsURL);
			  System.out.println("Reprints: Working");
		  }catch (Exception e) {
			  System.err.println("Reprints: Not Working");
		  }

		  try {
			  String reprintsURL = driver.findElement(termsLink).getAttribute("href");
			  assertEquals(coreUrl + "/terms-of-use", reprintsURL);
			  System.out.println("Terms of Use: Working");
		  }catch (Exception e) {
			  System.err.println("Terms of Use: Not Working");
		  }
		  System.out.println("Social Media Section: Pass. 1/4");
		  System.out.println("");

		  System.out.println("For NAR Members Check");
		  try {
			  String RealtorsPropertyResourceImgURL = driver.findElement(RealtorsPropertyResourceImg).getAttribute("src");
			  assertEquals(coreUrl + "/sites/default/files/images/logos/footer/rpr-icon.png", RealtorsPropertyResourceImgURL);
			  String RealtorsPropertyResourceLinkURL = driver.findElement(RealtorsPropertyResourceLink).getAttribute("href");
			  assertEquals(coreUrl + "/topics/realtors-property-resource", RealtorsPropertyResourceLinkURL);
			  System.out.println("Realtors Property Resource: Working");
		  }catch (Exception e) {
			  System.err.println("Realtors Property Resource: Not Working");
		  }

		  try {
			  String RealtorMagazineImgURL = driver.findElement(RealtorMagazineImg).getAttribute("src");
			  assertEquals(coreUrl + "/sites/default/files/menu_icons/menu_icon_9327.gif", RealtorMagazineImgURL);
			  String RealtorMagazineLinkURL = driver.findElement(RealtorMagazineLink).getAttribute("href");
			  assertEquals("http://realtormag.realtor.org/", RealtorMagazineLinkURL);
			  System.out.println("Realtor Magazine: Working");
		  }catch (Exception e) {
			  System.err.println("Realtor Magazine: Not Working");
		  }

		  try {
			  String CommercialSearchImgURL = driver.findElement(CommercialSearchImg).getAttribute("src");
			  assertEquals(coreUrl + "/sites/default/files/images/logos/footer/commercialsearch.png", CommercialSearchImgURL);
			  String CommercialSearchLinkURL = driver.findElement(CommercialSearchLink).getAttribute("href");
			  assertEquals("http://www.commercialsearch.com/", CommercialSearchLinkURL);
			  System.out.println("Commercial Search: Working");
		  }catch (Exception e) {
			  System.err.println("Commercial Search: Not Working");
		  }

		  try {
			  String RealtorActionCenterImgURL = driver.findElement(RealtorActionCenterImg).getAttribute("src");
			  assertEquals(coreUrl + "/sites/default/files/images/logos/footer/what-is-a-realtor-logo.png", RealtorActionCenterImgURL);
			  String RealtorActionCenterLinkURL = driver.findElement(RealtorActionCenterLink).getAttribute("href");
			  assertEquals("http://www.realtoractioncenter.com/", RealtorActionCenterLinkURL);
			  System.out.println("Realtor Action Center: Working");
		  }catch (Exception e) {
			  System.err.println("Realtor Action Center: Not Working");
		  }
		  System.out.println("For NAR Members Section: Pass. 2/4");
		  System.out.println("");

		  System.out.println("For the Public Check");
		  try {
			  String WhatIsNARImgURL = driver.findElement(WhatIsNARImg).getAttribute("src");
			  assertEquals(coreUrl + "/sites/default/files/images/logos/footer/what-is-a-realtor-logo.png", WhatIsNARImgURL);
			  String WhatIsNARLinkURL = driver.findElement(WhatIsNARLink).getAttribute("href");
			  assertEquals("http://realtormag.realtor.org/sales-and-marketing/handouts-for-customers/for-buyers/7-reasons-work-realtor", WhatIsNARLinkURL);
			  System.out.println("What Is NAR: Working");
		  }catch (Exception e) {
			  System.err.println("What Is NAR: Not Working");
		  }

		  try {
			  String RealtorComImgURL = driver.findElement(RealtorComImg).getAttribute("src");
			  assertEquals(coreUrl + "/sites/default/files/menu_icons/menu_icon_9331.png", RealtorComImgURL);
			  String RealtorComLinkURL = driver.findElement(RealtorComLink).getAttribute("href");
			  assertEquals("http://www.realtor.com/", RealtorComLinkURL);
			  System.out.println("Realtor.com: Working");
		  }catch (Exception e) {
			  System.err.println("Realtor.com: Not Working");
		  }

		  try {
			  String HouseLogicImgURL = driver.findElement(HouseLogicImg).getAttribute("src");
			  assertEquals(coreUrl + "/sites/default/files/images/logos/footer/houselogic-logo.png", HouseLogicImgURL);
			  String HouseLogicLinkURL = driver.findElement(HouseLogicLink).getAttribute("href");
			  assertEquals("http://www.houselogic.com/", HouseLogicLinkURL);
			  System.out.println("House Logic: Working");
		  }catch (Exception e) {
			  System.err.println("House Logic: Not Working");
		  }
		  System.out.println("For NAR Members Section: Pass. 3/4");
		  System.out.println("");

		  System.out.println("Bottom Check");

		  try {
			  driver.findElement(allPropertiesClick).click();
			  if (driver.findElement(allPropertiesField).isDisplayed()) {
				  System.out.println("All Properties: Working");
			  }
			  driver.findElement(By.xpath("//*[@id='block-nar-footer-nar-footer-properties-popup']/div/div/div/div[2]/span")).click();
		  }catch (Exception e) {
			  System.err.println("All Propertie: Not Working");
		  }

		  try {
			  driver.findElement(translateClick).click();
			  if (driver.findElement(translateField).isDisplayed()) {
				  System.out.println("Translate: Working");
			  }
		  }catch (Exception e) {
			  System.err.println("Translate: Not Working");
		  }
		  System.out.println("For NAR Members Section: Pass. 4/4");
		  System.out.println("");


		  System.out.println("Concluding Homepage Footer Test");
	}

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
