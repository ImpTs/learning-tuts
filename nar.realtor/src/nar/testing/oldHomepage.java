package nar.testing;
import org.junit.*;
import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class oldHomepage {
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
    public void narHomepageMain() throws Exception
    {
		for (i = 0; i < 18; i++) {
			System.out.println("A");
			browser(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			roHomepageMain();
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

	public void roHomepageMain() throws Exception {
		driver.manage().window().maximize();
		driver.get(coreUrl + "/");
        int x = 0;
        String Element = null;
        // Homepage Layout
        System.out.println("Start Main Test");
        x++;
        try
        {
            By ElementLocal = By.xpath("//header[@id='section-header']");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Header Section: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Header Section: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//section[@id='section-content']");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Content Section: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Content Section: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//footer[@id='section-footer']");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Footer Section: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Footer Section: Not Present; \r\t" + Element);
        }
        // Verify Mainstage Slideshow
        TimeUnit.SECONDS.sleep(1);
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='flexslider-1']/ul[1]/li[1]");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Mainstage Section: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Mainstage Section: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='flexslider-1']/ul/li[1]/a");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Mainstage Previous Arrow: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Mainstage Previous Arrow: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='flexslider-1']/ul/li[2]/a");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Mainstage Next Arrow: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Mainstage Next Arrow: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='flexslider-1']/div/ul/li[2]/div[2]/span/a");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Mainstage Title: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Mainstage Title: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='flexslider-1']/div/ul/li[2]/div[2]/span/div/a/p");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Mainstage Blurb: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Mainstage Blurb: Not Present; \r\t" + Element);
        }
        // Verify Industry News
        x++;
        try
        {
        	By ElementLocal = By.xpath("//div[@id='block-views-nar-industry-news-block']/div/div/div/div/h1");
        	Element = ElementLocal.toString();
            assertEquals("Industry News", driver.findElement(ElementLocal).getText());
            System.out.println("Test" + x + "; Industry News Header: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Industry News Header: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
        	By ElementLocal = By.xpath("//div[@id='block-views-nar-industry-news-block']/div/div/div/div[1]");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Industry News Top Section: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Industry News Top Section: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='block-views-nar-industry-news-block']/div/div/div/div[2]");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Industry News Links: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Industry News Links: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
        	By ElementLocal = By.xpath("//div[@id='block-views-nar-industry-news-block']/div/div/div/div[1]/h2[1]");
            Element = ElementLocal.toString();
            assertEquals("LATEST STATISTICAL RELEASE", driver.findElement(ElementLocal).getText());
            System.out.println("Test" + x + "; Industry News - Today Section: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Industry News - Today Section: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
        	By ElementLocal = By.xpath("//div[@id='block-views-nar-industry-news-block']/div/div/div/div[1]/h2[2]");
            Element = ElementLocal.toString();
            assertEquals("TODAY", driver.findElement(ElementLocal).getText());
            System.out.println("Test" + x + "; Industry News - Today Section: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Industry News - Today Section: Not Present; \r\t" + Element);
        }
        // Verify Three Columns
        x++;
        try
        {
            assertEquals("Popular Links", driver.findElement(By.xpath("//*[@id='block-nar-custom-blocks-nar-custom-homepage-supportlinks']/div/div/div/div[1]/h3")).getText());
            System.out.println("Test" + x + "; 'Popular Links' Column: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; 'Popular Links' Column : Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-homepage-supportlinks']/div/div/div/div[1]/div/ul/li[1]/a");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; 'Popular Links' 1st Link: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.out.println("Test" + x + "; 'Popular Links' 1st Link: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            assertEquals("Associations", driver.findElement(By.xpath("//*[@id='block-nar-custom-blocks-nar-custom-homepage-supportlinks']/div/div/div/div[2]/h3")).getText());
            System.out.println("Test" + x + "; 'Associations' Column: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; 'Associations' Column: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-homepage-supportlinks']/div/div/div/div[2]/div/ul/li[1]/a");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; 'Popular Links' 2nd Link: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.out.println("Test" + x + "; 'Popular Links' 2nd Link: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            assertEquals("NAR Leadership", driver.findElement(By.xpath("//*[@id='block-nar-custom-blocks-nar-custom-homepage-supportlinks']/div/div/div/div[3]/h3")).getText());
            System.out.println("Test" + x + "; 'NAR Leadership' Column: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; 'NAR Leadership' Column: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-homepage-supportlinks']/div/div/div/div[3]/div/ul/li[1]/a");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; 'Popular Links' 3rd Link: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.out.println("Test" + x + "; 'Popular Links' 3rd Link: Not Present; \r\t" + Element);
        }
        // Verify Homepage Support Article Section
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-homepage-sb-left']/div/div/div/div/h3");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Left Support (Article) Title: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Left Support (Article) Title: Not Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-homepage-sb-left']/div/div/div/div");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Left Support (Article) Box: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Left Support (Article) Box: Not Presen;t \r\t" + Element);
        }
        // Verify Homepage Support Video Section
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-homepage-sb-center']/div/div/div/div/h3");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Center Support (Video) Title: Present; \r\t" + Element);
        }
        catch (Error e)
        {
        	System.out.println("Test" + x + "; Center Support (Video) Title: Present; \r\t" + Element);
        }
        x++;
        try
        {
            By ElementLocal = By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-homepage-sb-center']/div/div/div/div");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Center Support (Video) Box: Present; \r\t" + Element);
        }
        catch (Error e)
        {
        	System.out.println("Test" + x + "; Center Support (Video) Box: Present; \r\t" + Element);
        }
        // Checking Ads
        x++;
        try
        {
            By ElementLocal = By.xpath("//*[@id='dfp-ad-box1']/div");
            Element = ElementLocal.toString();
            assertTrue(isElementPresent(ElementLocal));
            System.out.println("Test" + x + "; Right Support (AD) Box: Present; \r\t" + Element);
        }
        catch (Error e)
        {
            System.err.println("Test" + x + "; Right Support (AD) Box: Present; \r\t"  + Element);
        }
	}

	public static void logout() throws InterruptedException {
		try {
			//Log Out
			Actions builder = new Actions(driver);
			WebElement MyAccountLocal = driver.findElement(By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-my-account']/div/div/div/div"));
			builder.moveToElement(MyAccountLocal).perform();
			driver.findElement(By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-my-account']/div/div/div/div/ul/li[3]/a")).click();
			String logOutText = driver.findElement(By.xpath("//*[@id='block-nar-custom-blocks-nar-custom-home-button']/div/div/div/div/ul/li[3]/a")).getText();
			assertEquals("Sign In/Register", logOutText);
		} catch (Error e) {
			driver.get(coreUrl + "/user/logout");
		}
	}

	private boolean isElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

}
