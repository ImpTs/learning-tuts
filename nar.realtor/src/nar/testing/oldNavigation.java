package nar.testing;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class oldNavigation {
	private static WebDriver driver;
	static int i;
	//static String coreUrl = "https://www.nar.realtor";
	//String homepageTitle = "nar.realtor";
	static String coreUrl = "https://dev.nar.realtor";
	String homepageTitle = "www.nar.realtor";

	static String mainNavURLList[] = new String[] {
			coreUrl + "/news-and-commentary",
			coreUrl + "/research-and-statistics",
			coreUrl + "/member-benefits",
			coreUrl + "/education",
			coreUrl + "/events",
			coreUrl + "/political-advocacy",
			coreUrl + "/law-and-ethics",
			coreUrl + "/business-specialties",
			coreUrl + "/about-nar"
	};

	static String mainNavTitlesList[] = new String[] {
			"Real Estate News &amp; Commentary | nar.realtor",
			"Real Estate Research & Statistics | nar.realtor",
			"REALTOR® Member Benefits | nar.realtor",
			"REALTOR® Education | nar.realtor",
			"Real Estate Events | nar.realtor",
			"Real Estate Politics &amp; Advocacy | nar.realtor",
			"REALTOR® Law &amp; Ethics  | nar.realtor",
			"Real Estate Specialties | nar.realtor",
			"About NAR | nar.realtor"
	};

	static String subNavOneURLList[] = new String[] {
			coreUrl + "/news-releases",
			coreUrl + "/research-and-statistics/research-reports",
			coreUrl + "/member-benefits/value-of-membership",
			coreUrl + "/courses",
			coreUrl + "/convention.nsf/",
			coreUrl + "/political-advocacy/federal-political-advocacy",
			coreUrl + "/law-and-ethics/nar-legal-compliance-articles",
			coreUrl + "/commercial",
			coreUrl + "/about-nar/nar-at-a-glance"
	};

	static String subNavOneTitlesList[] = new String[] {
			"News Releases | dev.nar.realtor",
			"NAR Research Reports:  Real Estate Research & Statistics | nar.realtor",
			"Value of Membership: Benefits at a Glance | nar.realtor",
			"NAR Courses | nar.realtor",
			"REALTORS® CONFERENCE &amp; EXPO - Real Estate Event",
			"Federal Political Advocacy - National Association of REALTORS® | nar.realtor",
			"NAR Legal Compliance Articles | nar.realtor",
			"Commercial Real Estate | nar.realtor",
			"NAR At a Glance | nar.realtor"
	};

	static String subNavTwoURLList[] = new String[] {
			"http://blogs.realtor.org/",
			coreUrl + "/research-and-statistics/housing-statistics",
			coreUrl + "/programs/realtor-benefits-program",
			"http://www.realtoru.edu/",
			coreUrl + "/midyear.nsf/",
			coreUrl + "/political-advocacy/all-advocacy-issues",
			coreUrl + "/legal-case-summaries",
			coreUrl + "/global",
			coreUrl + "/narfininfo.nsf/pages/DuesTransmittalInfo"
	};

	static String subNavTwoTitlesList[] = new String[] {
			"REALTOR.org Blogs",
			"Housing Statistics | Real Estate Research & Statistics | nar.realtor",
			"REALTOR Benefits® Program | nar.realtor",
			"Welcome to REALTOR® University",
			"REALTOR® Party Convention &amp; Trade Expo  - The National Association of REALTORS®",
			"All Issues | Real Estate Politics &amp; Advocacy      | nar.realtor",
			"Legal Case Summaries | nar.realtor",
			"Global Real Estate Markets | Real Estate Specialties  | nar.realtor",
			"2004 and 2005 National Dues, Nondeductible Dues, Nondeductible Dues"
	};

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
    public void narNavigationMain() throws Exception
    {
		for (i = 0; i < 18; i++) {
			browser(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			roNavigationMain();
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
		caps.setCapability("browserstack.video", "false");
		driver = new RemoteWebDriver(new URL(URL), caps);
		new WebDriverWait(driver, 5);
		System.out.println("Test Info Browser: " + BrowserList[number] + " " + BrowserVersionList[number] + ". OS: " + OsList[number] + " " + OsVersionList[number]);
	}

	public void roNavigationMain() throws Exception {
		driver.get(coreUrl + "/");
		assertEquals(homepageTitle, driver.getTitle());
		assertEquals(coreUrl + "/", driver.getCurrentUrl());
		// Navigation Tabs
		System.out.println("Navigation Tab Check");

		for (int t = 0; t < 10; t++) {
			String TabName = driver.findElement(By.xpath("//*[@id='nice-menu-1']/li[1]/a")).getText();
			int tallyMark = 0;
			int tabNum = t+1;
			System.out.print("Tab" + tabNum + ": " + TabName);
			try {
				driver.findElement(By.xpath("//*[@id='nice-menu-1']/li[" + tabNum + "]")).click();
				checkPageIsReady();
				mouseMove();
				assertEquals(mainNavURLList[t], driver.getCurrentUrl());
				tallyMark++;
				System.out.println(tallyMark);
			}	catch (Error e) {
				System.err.println("Main Tab Failed");
			}
			try {
				mouseMove();
				assertEquals(subNavOneTitlesList[t], subTab(t, tabNum));
				//assertEquals(subNavOneURLList[t], driver.getCurrentUrl());
				tallyMark++;
				System.out.println(tallyMark);
			} catch (Error e) {
			}
			try {
				mouseMove();
				assertEquals(subNavTwoTitlesList[t], subTabAlt(t, tabNum));
				//assertEquals(subNavTwoURLList[t], driver.getCurrentUrl());
				tallyMark++;
				System.out.println(tallyMark);
			} catch (Error e) {
			}
			if (tallyMark == 3) {

			}
			else {
				System.err.println("Error with tabs");
			}
			returnHome();
		}

		System.out.println("");
		System.out.println("End Main Test");
	}

	public static void returnHome() throws InterruptedException {
		checkPageIsReady();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='logo']")));
		WebElement homeButton = driver.findElement(By.xpath("//*[@id='logo']"));
		builder.moveToElement(homeButton).click().build().perform();
	}


	public static void mouseMove() throws InterruptedException {
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='logo']")));
		WebElement mouseHover = driver.findElement(By.xpath("//*[@id='logo']"));
		builder.moveToElement(mouseHover).perform();
	}

	public static String subTab(int t, int i) throws InterruptedException {
		checkPageIsReady();
		String title = null;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='nice-menu-1']/li[" + i + "]")));
		WebElement tab = driver.findElement(By.xpath("//ul[@id='nice-menu-1']/li[" + i + "]"));
		builder.moveToElement(tab).perform();
		String subTabURL = driver.findElement(By.xpath("//ul[@id='nice-menu-1']/li[" + i + "]/ul/li[1]/a")).getAttribute("href");
		try {
			assertEquals(subNavOneURLList[t], subTabURL);
			title = titleURlCheck(subTabURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}

	public static String subTabAlt(int t, int i) throws InterruptedException {
		checkPageIsReady();
		String title = null;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='nice-menu-1']/li[" + i + "]")));
		WebElement tab = driver.findElement(By.xpath("//ul[@id='nice-menu-1']/li[" + i + "]"));
		builder.moveToElement(tab).perform();
		String subTabURL = driver.findElement(By.xpath("//ul[@id='nice-menu-1']/li[" + i + "]/ul/li[2]/a")).getAttribute("href");
		try {
			assertEquals(subNavTwoURLList[t], subTabURL);
			title = titleURlCheck(subTabURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}

	// Converter for Regex Replacements (X = Regex that matches the string, Y = The Actual String, Z = The output format)
	public static String converter(String x, String y, String z) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Pattern p1 = Pattern.compile(x);
		Matcher m1 = p1.matcher(y);
		String output = m1.replaceAll(z);
		return output;
	}

	static String titleURlCheck(String url) throws Exception {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Navigating to the Users Image Page with single Image.
		String address = url;
		URL obj = new URL(address);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String sourceCodeSegment;
		while ((sourceCodeSegment = in.readLine()) != null) {
			String usernameRegex = "\\s*<title>.*(.*).*</title>";
			if( sourceCodeSegment.matches(usernameRegex) ) {
				sourceCodeSegment = converter(usernameRegex, sourceCodeSegment, "$1");
				break;
			}
		}
		String pageTitle = sourceCodeSegment;
		in.close();
		return pageTitle;
	}

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
			} catch (InterruptedException e) {}
			//To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}
}
