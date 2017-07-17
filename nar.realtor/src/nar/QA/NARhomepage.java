package nar.QA;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;

//Temp
import java.util.regex.Pattern;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//Temp


//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class NARhomepage {
	private static WebDriver driver;
	static int i;
	//static FirefoxDriver driver = new FirefoxDriver();
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
	//Notes:
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "][contains(@style, 'opacity: 1')]")));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "]")));
	//assertTrue(isElementPresent(ElementLocal));
	//.getCssValue("border-top-style").trim()
	//Saving a mouse over to home logo for example: Action mouseOverHome = builder.moveToElement(link_Home).build();
	@Before
	public void setUp() {
		System.out.println("Login Test Started!");
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void narHomepageMain() throws MalformedURLException {
		callout();
		/* Remote Browser Loop
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
	private void callout() {
		driver.get(coreAltUrl);
		checkPageIsReady();

		testSample();

		/*
		String sectionHeader;

		//Main Stage Featured Img/Vid
		sectionHeader = "Mainstage Section";
		isElementPresent(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/ul/li"));
		int size = driver.findElements(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/ul/li")).size();
		for (int x = 0; x < size; x++) {
			int slide = x + 1;
			try {
				mainStage(x, slide, size);
			}
			catch (Exception e) {
				System.err.println("-> Error with slide " + slide);
			}
		}
		//Menu Section Test
		sectionHeader = "Menu Section";
		triColumnMenu(sectionHeader);

		//Daily News Carousel ( Ad on right)
		sectionHeader = "Daily News from REALTOR® Magazine";
		assertEquals(sectionHeader, driver.findElement(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[3]/div/div/div[1]/div/div[1]/div/h3/div/div/div")).getText());
		sectionHeader = "Daily News";
		dailyNewsCarousel(sectionHeader + " (Skipped)");

		//Trending (Trending Multi-Row)
		sectionHeader = "Trending";
		assertEquals(sectionHeader, driver.findElement(By.xpath(".//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/h3")).getText());
		trendingSection(sectionHeader);
		//Bottom Strip (Container 3-6-3)
		if (!(driver.findElements(By.xpath("//*[@id='main']/div/div/div[3]/div/div[2]")).size() == 0)) {
			bottomStrip();
		}
		*/
	}
	private void mainStage(Integer x, Integer slide, Integer size) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//Starts at x == 0
		//Starts at slide == 1
		//System.out.println("  Current: " + slide + ". Till: " + size);
		//mainStage(x, slide);
		WebElement mainStageButton = driver.findElement(By.xpath("//*[@id='slick-slide1" + x + "']/button"));
		mainStageButton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "][contains(@style, 'opacity: 1')]")));
		try {
			WebElement mainStageButtonOutlineLocation = driver.findElement(By.xpath("//*[@id='slick-slide1" + x + "']/button/span"));
			String mainStageButtonOutlineStyle = mainStageButtonOutlineLocation.getCssValue("border-top-style").trim() + " " + mainStageButtonOutlineLocation.getCssValue("border-top-color").trim();
			"solid rgba(98, 152, 190, 1)".equals(mainStageButtonOutlineStyle);
		}
		catch (Exception e) {
			System.err.println("  MainStage Slick Nav Link: Faulty");
		}
		///System.out.println("  MainStageSlide Test");
		String classes = driver.findElement(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "]")).getAttribute("class").trim();
		//System.out.println("  Classes: " + classes);
		try {
			if (!classes.contains("slide--video")) {
				//System.out.println("  MainStage is Image");
				elementCheck(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "]/div/h3/a"), "Slide" + slide + ", Short Title");
				elementCheck(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "]/div/div"), "Slide" + slide + ", Short Summary");
			}
			if (classes.contains("slide--video")) {
				//System.out.println("  MainStage is Video");
				elementCheck(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[" + slide + "]/div[1]/button"), "Slide" + slide + ", Play Button");
			}
		}
		catch (Exception e) {
			System.out.println("  Mainstage Issues with slide " + slide);
		}
	}
	private void triColumnMenu(String sectionHeader) {
		System.out.println(sectionHeader);
		String defaultFontColor = "rgba(79, 118, 144, 1)";
		String hoverFontColor = "rgba(53, 160, 234, 1)";
		fontCheck(sectionHeader, By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/ul/li/ul/li[1]/a"), defaultFontColor, hoverFontColor);
		int size = driver.findElements(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div")).size();
		String triColumnMenuTitles[] = new String[] {
			"Agents & Brokers",
			"Associations",
			"NAR Leadership"
		};
		for (int y = 1; y <= size; y++) {
			//System.out.println("  " +driver.findElement(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[" + y + "]/ul/li/a")).getText());
			assertEquals(triColumnMenuTitles[y - 1], driver.findElement(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[" + y + "]/ul/li/a")).getText());
			isElementPresent(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[" + y + "]/ul/li/a/img"));
			isElementPresent(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[" + y + "]/ul/li/ul/li[1]"));
		}
	}
	private void dailyNewsCarousel(String sectionHeader) {
		System.out.println(sectionHeader);
		//System.out.println("  Please Replace once " + sectionHeader + " is working");
	}
	private void trendingSection(String sectionHeader) {
		System.out.println(sectionHeader);
		//Left Top Main Section
		String defaultFontColor = "rgba(35, 27, 24, 1)";
		String hoverFontColor = "rgba(53, 160, 234, 1)";
		List < WebElement > trendingSides = driver.findElements(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div"));
		for (WebElement resultItem1: trendingSides) {
			// .//*[@id='prev-button0']
			// .//*[@id='next-button0']
			// Carousel Checked for different cards
			// .//*[@id='slider0']/div/div/div[1]/article
			defaultFontColor = "rgba(35, 27, 24, 1)";
			hoverFontColor = "rgba(53, 160, 234, 1)";
			// Checks the LEFT side of the Trending Section
			if (resultItem1.getAttribute("class").trim().contains("flex-main")) {
				sectionHeader = "Trending - Left";
				try {
					// Add back in once an image is added to this homepage section.
					//driver.findElement(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div[contains(@class, 'flex-main')]/article/div[1]/div/div/div/figure/img")).isDisplayed();
					driver.findElement(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div[contains(@class, 'flex-main')]/article/div/h3/a/div/div/div")).isDisplayed();
					driver.findElement(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div[contains(@class, 'flex-main')]/article/div/div/div/div/div")).isDisplayed();
					By by = By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div[contains(@class, 'flex-main')]/article/div/h3/a");
					fontCheck(sectionHeader, by, defaultFontColor, hoverFontColor);
					System.err.println("Trending - Left -> Working");
				}
				catch (Exception e) {
					System.err.println("Error-------> Trending Left Element(s) missing.");
					System.err.println(e);
				}
			}
			// Checks the RIGHT side of the Trending Section
			if (resultItem1.getAttribute("class").trim().contains("flex-aside")) {
				sectionHeader = "Trending - Right Card-view Multimedia";
				List < WebElement > trendingRightSides = driver.findElements(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div[contains(@class, 'flex-aside')]/div"));
				for (WebElement resultItemRight: trendingRightSides) {
					if (resultItemRight.getAttribute("class").trim().contains("flex-aside--top")) {
						sectionHeader = "Trending - Right Top";
						try {
							resultItemRight.findElement(By.xpath("./article/div/h3/a/div/div/div")).isDisplayed();
							resultItemRight.findElement(By.xpath("./article/div/div/div/div/div/p")).isDisplayed();
							By by = By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div[contains(@class, 'flex-aside')]/div/article/div/h3/a/div/div/div");
							fontCheck(sectionHeader, by, defaultFontColor, hoverFontColor);
							System.err.println("Trending - Right Top -> Working");
						}
						catch (Exception e) {
							System.err.println(e);
							System.err.println("Error ---> Trending Right Top ---> " + e);
						}
					}
					if (resultItemRight.getAttribute("class").trim().contains("flex-aside--bottom")) {
						List < WebElement > trendingRightBottom = driver.findElements(By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div[contains(@class, 'flex-aside')]/div[contains(@class, 'flex-aside--bottom')]/div[contains(@class, 'flex-column')]"));
						for (WebElement resultItemRightBottom: trendingRightBottom) {
							if (resultItemRightBottom.getAttribute("class").trim().contains("node--post")) {
								sectionHeader = "Trending - Right Bottom L";
								try {
									resultItemRightBottom.findElement(By.xpath("./article[contains(@class, 'node--event')]/div[contains(@class, 'card-view__body')]/h3/a/div/div/div")).isDisplayed();
									resultItemRightBottom.findElement(By.xpath("./article[contains(@class, 'node--event')]/div[contains(@class, 'card-view__body')]/div/div/div/div/p")).isDisplayed();
									resultItemRightBottom.findElement(By.xpath("./article[contains(@class, 'node--event')]/div[contains(@class, 'card-view__footer')]/div/span")).isDisplayed();
									By by = By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div[contains(@class, 'flex-aside')]/div[contains(@class, 'flex-aside--bottom')]/div[contains(@class, 'flex-column')]/article[contains(@class, 'node--event')]/div/h3/a/div/div/div");
									fontCheck(sectionHeader, by, defaultFontColor, hoverFontColor);
									System.err.println("Trending - Right Bottom L -> Working");
								}
								catch (Exception e) {
									System.err.println("Error-------> Trending Right Bottom Post Element(s) missing.");
									System.err.println(e);
								}
							}
							if (resultItemRightBottom.getAttribute("class").trim().contains("node--event")) {
								sectionHeader = "Trending - Right Bottom R";
								try {
									resultItemRightBottom.findElement(By.xpath("./article[contains(@class, 'node--post')]/div/h3")).isDisplayed();
									resultItemRightBottom.findElement(By.xpath("./article[contains(@class, 'node--post')]/div/div")).isDisplayed();
									By by = By.xpath("//*[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/div/div/div[contains(@class, 'flex-aside')]/div[contains(@class, 'flex-aside--bottom')]/div[contains(@class, 'flex-column')]/article[contains(@class, 'node--post')]/div/h3/a/div/div/div");
									fontCheck(sectionHeader, by, defaultFontColor, hoverFontColor);
									System.err.println("Trending - Right Bottom R -> Working");
								}
								catch (Exception e) {
									System.err.println(e);
									System.err.println("Error-------> Trending Right Bottom Event Element(s) missing.");
								}
							}
						}
					}
				}
			}
		}
	}
	private static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	private boolean elementCheck(By by, String Name) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (NoSuchElementException e) {
			System.err.println(Name + " failed.");
			return false;
		}
	}
	private static boolean fontCheck(String test, By by, String defaultFontColor, String hoverFontColor) {
			try {
				Actions builder = new Actions(driver);
				isElementPresent(by);
				String returnedColor = driver.findElement(by).getCssValue("color").trim();
				//System.err.println("Default Font Expected: " + defaultFontColor);
				//System.err.println("Default Font Found: " + returnedColor);
				assertEquals(defaultFontColor, returnedColor);
				builder.moveToElement(driver.findElement(by)).build().perform();
				returnedColor = driver.findElement(by).getCssValue("color").trim();
				//System.err.println("Hover Font Expected: " + hoverFontColor);
				//System.err.println("Hover Font Found: " + returnedColor);
				assertEquals(hoverFontColor, returnedColor);
				return true;
			}
			catch (Exception e) {
				System.err.println("Font Issues -----> found in " + test);
				System.err.println(e);
				return false;
			}
		}
		/*
		public void browser(int number) throws MalformedURLException {
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
		*/
	public static void checkPageIsReady() {
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
			}
			catch (InterruptedException e) {}
			//To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public static void testSample() {
		try {
		    // Icon Accordian Menu
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[2]/div/div/div/div/div")));
		    try {
		    assertEquals("Agents & Brokers", driver.findElement(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[2]/div/div/div/div/div/ul/li/a")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[2]/div/div/div/div/div[2]/ul")));
		    try {
		    assertEquals("Associations", driver.findElement(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[2]/div/div/div/div/div[2]/ul/li/a")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[2]/div/div/div/div/div[3]/ul")));
		    try {
		      assertEquals("NAR Leadership", driver.findElement(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[2]/div/div/div/div/div[3]/ul/li/a")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		    // Daily News
		    try {
		      assertEquals("Daily News from REALTOR® Magazine", driver.findElement(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[3]/div/div/div/div/div/div/h3/div/div/div")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider0']/div/div/article/div")));
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider0']/div/div/article[2]")));
		    assertTrue(isElementPresent(By.xpath("//div[@id='block-views-daily-news-block']/div/div/div/div[2]")));
		    // Add Space
		    assertTrue(isElementPresent(By.xpath("//div[@id='block-block-9']/div/p[2]/a/img")));
		    // Trending
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[4]/div/div/div/div/div/article/div")));
		    try {
		      assertEquals("Trending", driver.findElement(By.xpath("//main[@id='main']/div/div/div[3]/div/div[1]/div/div[2]/div/div[4]/div/div/h3")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		    // Needs Fixing Up
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[4]/div/div/div/div/div[2]/div/article/div/div")));
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[4]/div/div/div/div/div[2]/div[2]/div/article/div")));
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div/div/div[2]/div/div[4]/div/div/div/div/div[2]/div[2]/div[2]/article/div")));
		    // Bottom Bar
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div[2]/div/div/div/div/div/div/div/article")));
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/article")));
		    assertTrue(isElementPresent(By.xpath("//main[@id='main']/div/div/div[3]/div/div[2]/div/div/div/div/div/div/div[3]/article")));

		    // Main Links
		    assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'Home')])[13]")));
		    try {
		      assertEquals("Newsroom", driver.findElement(By.xpath("//div[@id='block-menu-block-5']/div/ul/li[2]/a")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		    assertTrue(isElementPresent(By.xpath("//div[@id='block-menu-block-5']/div/ul/li[2]/a")));
		    try {
		      assertEquals("Advertise", driver.findElement(By.xpath("//div[@id='block-menu-block-5']/div/ul/li[3]/a")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		    assertTrue(isElementPresent(By.xpath("//div[@id='block-menu-block-5']/div/ul/li[3]/a")));
		    try {
		      assertEquals("Careers", driver.findElement(By.xpath("//div[@id='block-menu-block-5']/div/ul/li[4]/a")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		    assertTrue(isElementPresent(By.xpath("//div[@id='block-menu-block-5']/div/ul/li[4]/a")));
		    try {
		      assertEquals("Contact", driver.findElement(By.xpath("//div[@id='block-menu-block-5']/div/ul/li[5]/a")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		    assertTrue(isElementPresent(By.xpath("//div[@id='block-nar-settings-live-chat']/div/a")));
		    try {
		      assertEquals("Live Chat", driver.findElement(By.xpath("//div[@id='block-nar-settings-live-chat']/div/a")).getText());
		    } catch (Error e) {
			      System.out.print("Error -->" + e);
		    }
		}catch (Error e) {
		      System.out.print("Error -->" + e);
	    }
	}
}