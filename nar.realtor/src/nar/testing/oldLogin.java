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

public class oldLogin {
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
	private String login[] = new String[] {
		"testuser_qa",
		"testeditor_qa",
		"testmember_qa",
		"teststaff_qa"
	};
	private String password = "TiQAtua15!";
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
			roLoginMain();
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

	public void roLoginMain() throws Exception {
		for (i = 0; i < 3; i++) {
			driver.get(coreUrl + "/");
			try {
				assertEquals(coreUrl + "/", driver.getCurrentUrl());
				//assertEquals("http://www.realtor.org/", driver.getCurrentUrl());
			} catch (Error e) {
				System.err.println("Dev Page Not Loaded; Attempt: Failed;");
			}
			// Waiting Time
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Editor Logging In
			String userLogIn = login[i];
			System.out.println("Id :" + userLogIn);
			try {
				driver.findElement(By.xpath("//div[@id='block-nar-custom-blocks-nar-custom-home-button']/div/div/div/div/ul/li[3]/a/span[1]")).click();
			} catch (Error e) {
				driver.get(coreUrl + "/user/login");
			}
			try {
				//Login Actions
				WebElement UsernameLocal = driver.findElement(By.xpath("//input[@id='edit-name']"));
				WebElement PasswordLocal = driver.findElement(By.xpath("//input[@id='edit-pass']"));
				WebElement SubmitLocal = driver.findElement(By.xpath("//input[@id='edit-submit']"));
				UsernameLocal.sendKeys(userLogIn);
				TimeUnit.SECONDS.sleep(1);
				PasswordLocal.sendKeys(password);
				TimeUnit.SECONDS.sleep(1);
				SubmitLocal.click();
				try {
					//Check Login
					driver.get(coreUrl + "/user");
					String userResult = driver.findElement(By.xpath("//h1[@id='page-title']")).getText();
					assertEquals(userLogIn, userResult);
					//Login Success
					System.out.println("Username " + userLogIn + " Login Success;");
					logout();
				} catch (Error e) {
					System.err.println("Username Appears Incorrect: " + userLogIn + "; Attempt: Failed;");
				}
			} catch (Error e) {
				i--;
				System.err.println("Login: " + userLogIn + "; Attempt: Failed;");
			}
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

}
