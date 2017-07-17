package nar.testing;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.junit.*;

public class narSampleNotes {
	static FirefoxDriver driver = new FirefoxDriver();
	private static String coreUrl = "https://qa.nar.realtor";

	/*
	//Notes:
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(location).getText());
	driver.getTitle());
	driver.getCurrentUrl());

	By.xpath("//div[@id='gsa-content']/table")
	By.cssSelector("h1")
	By.linkText("Sales & Marketing")

	TimeUnit.SECONDS.sleep(1);

	Array Creation: String login[] = new String[] {
	Array Singling out one element: String userLogIn = login[i];
	Wait until CSS style is detected on this element: wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "][contains(@style, 'opacity: 1')]")));
	Wait until element becomes visible: wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "]")));

	Is this statement true: assertTrue(isElementPresent(driver.findElement(By.xpath("//*[@id='nice-menu-1']/li[5]/ul/li[5]/a"))));
	Do these items match: assertEquals("https://reg.realtor.org/roreg.nsf/pages/MyAccount?OpenDocument&Login", driver.getCurrentUrl());
		Assert.assertEquals("Search results for code of ethics training", driver.findElement(By.xpath("//div[@id='gsa-content']/table[2]/tbody/tr/td/h1")).getText());

	.getCssValue("border-top-style").trim()
	.click();
	.sendKeys(userLogIn);

	if (!"".equals("Text Here")) {
	if (!(driver.findElements(By.xpath("//*[@id='main']/div/div/div[3]/div/div[2]")).size() == 0)) {
	if (d1.equals("HOME & DESIGN SOLUTIONS") && d2.equals("ARCHITECTURE COACH") && d3.equals("ARCHITECTURE GUIDE"))
	for (int i = 0; i < 25; i++) {

	private StringBuffer verificationErrors = new StringBuffer();
	String verificationErrorString = verificationErrors.toString();
	verificationErrors.append(e.toString());

	Actions builder = new Actions(driver);
  	builder.moveToElement(menuEvent).moveToElement(menuAllEvents).click().build().perform();
	Repetitive action one call way: Action mouseOverHome = builder.moveToElement(link_Home).build();

	System.err.println
	System.out.print
	*/


	@Before
    public void setUp()
    {
		System.out.println("Login Test Started!");
    }

	@Test
	private void narHomepageMain() {
		driver.manage().window().maximize();
		driver.get(coreUrl + "/");

		String elementName = "Test Element";
		By elementLocation = By.xpath("//location");

		elementCheck(elementLocation, elementName);

	}

	@After
    public void tearDown()
    {
		driver.quit();
    }

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	private boolean elementCheck(By by, String Name) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(Name + " failed.");
			return false;
		}
	}
	private boolean fontCheck(String test, By by, String defaultFontColor, String hoverFontColor) {
		try {
			Actions builder = new Actions(driver);
			isElementPresent(by);
			String returnedColor = driver.findElement(by).getCssValue("color").trim();
				//System.err.println("Default Font Expected: " + defaultFontColor);
				//System.err.println("Default Font Found: " + returnedColor);
			assertEquals(defaultFontColor ,returnedColor);
			builder.moveToElement(driver.findElement(by)).build().perform();
			returnedColor = driver.findElement(by).getCssValue("color").trim();
				//System.err.println("Hover Font Expected: " + hoverFontColor);
				//System.err.println("Hover Font Found: " + returnedColor);
			assertEquals(hoverFontColor ,returnedColor);
			return true;
		} catch (Exception e) {
			System.err.println("Font Issues found in " + test);
			return false;
		}
	}
}