package nar.QA;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.ws.WebServiceException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.remote.DesiredCapabilities;


//import org.openqa.selenium.remote.RemoteWebDriver;
public class NARnavigation {
    private static WebDriver driver;
    static int i;
    private static Scanner scanner;
    private static String coreAltUrl = "https://rov3:pr3pr0d@rov3.nar.realtor";
    private static String coreUrl = "https://rov3.nar.realtor";
    //private static String coreUrl = "https://qa.nar.realtor";
    //private static String coreUrl = "https://www.nar.realtor";
    //static String BrowserList[] = new String[] {    "Chrome","Chrome","Chrome","Chrome","Chrome","Chrome","Firefox","Firefox","Firefox","Firefox","Firefox","Firefox","Edge","IE","IE","Safari","Safari","Safari"};
    //static String BrowserVersionList[] = new String[] {  "52.0","51.0","50.0","52.0","51.0","50.0","47.0","46.0","45.0","47.0","46.0","45.0","13.0","11.0","10.0","9.1","8.0","7.1"};
    //static String OsList[] = new String[] {  "Windows","Windows","Windows","OS X","OS X","OS X","Windows","Windows","Windows","OS X","OS X","OS X","Windows","Windows","Windows","OS X","OS X","OS X"};
    //static String OsVersionList[] = new String[] {  "10","8.1","7","El Capitan","Yosemite","Mavericks","10","8.1","7","El Capitan","Yosemite","Mavericks","10","8.1","7","El Capitan","Yosemite","Mavericks"};
    //public static final String USERNAME = "vahan7";
    //public static final String AUTOMATE_KEY = "s69xsvCjzoREfPDWUNWB";
    //public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        System.out.println( "Navigation Test Started!" );
    }
    @Test
    public void NARloginMain() throws Exception {
        callout();
        /* Remote Browser Loop
        for (i = 0; i < 18; i++) {
            System.out.println("A");
            browser(i);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            callout();
            System.out.println("End Main Test");
            driver.quit();
        }
        */
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    static String PrimaryTabText[] = new String[] {
        "Real Estate Topics",
        "Membership",
        "Research & Statistics",
        "Political Advocacy",
        "Education",
        "Events",
        "About NAR",
        "Browse"
    };
    static String PrimaryHref[] = new String[] {
        coreUrl +"/topics",
        coreUrl +"/membership",
        coreUrl +"/research-and-statistics-2017",
        coreUrl +"/political-advocacy-2017",
        coreUrl +"/education-2017",
        coreUrl +"/events-2017",
        coreUrl +"/about-nar-2017",
        coreUrl +"/browse-by-section"
    };
    static String PrimaryTitle[] = new String[] {
    	"Real Estate Topics | realtor.org",
    	"Membership | realtor.org",
    	"Research and Statistics 2017 | realtor.org",
    	"Political Advocacy 2017 | realtor.org",
    	"Education 2017 | realtor.org",
    	"Events 2017 | realtor.org",
    	"About NAR 2017 | realtor.org",
    	"Browse by Section | realtor.org"
    };
    static String SecondaryTabText[] = new String[] {
        "Being a Real Estate Professional",
        "Become a Member",
        "Housing Statistics",
        "Federal",
        "Designations & Certifications",
        "Annual Conference & Expo",
        "History"
    };
    static String SecondaryHref[] = new String[] {
		coreUrl +"/being-a-real-estate-professional",
		coreUrl +"/membership/how-to-join-nar",
		coreUrl +"/research-and-statistics/housing-statistics-2017",
		coreUrl +"/political-advocacy/federal-advocacy",
		coreUrl +"/designations-and-certifications",
		"https://www.nar.realtor/convention.nsf/",
		coreUrl +"/about-nar/mission-vision-and-history"
    };
    static String SecondaryTitle[] = new String[] {
		"Being a Real Estate Professional | realtor.org",
		"How to Join NAR | realtor.org",
		"Housing Statistics | realtor.org",
		"Federal Advocacy | realtor.org",
		"Designations and Certifications | realtor.org",
		"REALTORS® CONFERENCE &amp; EXPO - Real Estate Event",
		"Mission, Vision, and History | realtor.org"
       };
    // Methods
    public void callout() throws Exception {

        driver.get(coreAltUrl);
        checkPageIsReady();
        driver.get(coreUrl);
        try {
            assertEquals("realtor.org", driver.getTitle());
        } catch (Error e) {
              System.out.println("Error --> "+ e);;
        }

        for (int tab = 0; tab < PrimaryTabText.length; tab++) {
            try {
                assertEquals(PrimaryTabText[tab], driver.findElement(By.xpath("//div[@id='block-menu-block-4']/div/ul/li["+(tab+1)+"]/a")).getText());
                assertEquals(PrimaryHref[tab], driver.findElement(By.xpath("//div[@id='block-menu-block-4']/div/ul/li["+(tab+1)+"]/a")).getAttribute("href"));
                internalTitleCheck(PrimaryHref[tab]);
            }catch (Error e) {
                  System.out.println("Error --> "+ e);;
            }
        }

        for (int tab = 0; tab < SecondaryTitle.length; tab++) {
            try {
                mouseMove();
                String output = SecondaryTitle[tab] + " at " + SecondaryHref[tab];
                By hover = By.xpath("html/body/div[2]/div/div/div/div/ul/li["+(tab+1)+"]");
                By click = By.xpath("html/body/div[2]/div/div/div/div/ul/li["+(tab+1)+"]/ul/li[2]/a");
                assertEquals(output, subTab(hover,click));
                internalTitleCheck(SecondaryHref[tab]);

            }catch (Error e) {
                  System.out.println("Error --> "+ e);;
            }
        }
    }

    public static void mouseMove() throws InterruptedException {
        checkPageIsReady();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/header/div/div[1]/a")));
        WebElement mouseHover = driver.findElement(By.xpath("html/body/div[2]/header/div/div[1]/a"));
        builder.moveToElement(mouseHover).perform();
    }

    public static String subTab(By hover, By click) {
        String output = null;
        String repeat = "false";
        while (repeat == "false") {
            try {
                checkPageIsReady();
                //WebDriverWait wait = new WebDriverWait(driver, 2);
                Actions builder = new Actions(driver);
                WebElement tab = driver.findElement(hover);
                builder.moveToElement(tab).perform();
                output = driver.findElement(click).getText() + " at " + driver.findElement(click).getAttribute("href");
                repeat = "true";
            } catch (Error e) {
                repeat = "false";
            }
        }
        System.out.println("Sub Tab ==>" + output);
        return output;
    }

    static String internalTitleCheck(String usernameAddress) throws IOException {
        try {
            URL url = new URL(usernameAddress);
            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("rov3","pr3pr0d".toCharArray());
                }
            });
        }catch (MalformedURLException ex) {
            System.out.println("error");
            //e = new WebServiceException(ex);
        }


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String pageTitle = null;
        // Navigating to the Users Profile Page with all their Images.
        URL objective = new URL(usernameAddress);
        HttpURLConnection connection = (HttpURLConnection) objective.openConnection();

        // optional default is GET
        connection.setRequestMethod("GET");

        BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        while ((line = inputStream.readLine()) != null) {
            String profileRegex = "\\s*<title>(.*)<\\/title>.*";

            if( line.matches(profileRegex) ) {
                pageTitle = converter(profileRegex, line, "$1");
                break;
            }
        }
        inputStream.close();
        return pageTitle;
    }

    public static String converter(String x, String y, String z) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Pattern p1 = Pattern.compile(x);
        Matcher m1 = p1.matcher(y);
        String output = m1.replaceAll(z);
        return output;
    }


    public static void checkPageIsReady() {
        JavascriptExecutor js = ( JavascriptExecutor ) driver;
        //Initially bellow given if condition will check ready state of page.
        if ( js.executeScript( "return document.readyState" ).toString().equals( "complete" ) ) {
            return;
        }
        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for ( int i = 0; i < 25; i++ ) {
            try {
                Thread.sleep( 1000 );
            }
            catch ( InterruptedException e ) {}
            //To check page ready state.
            if ( js.executeScript( "return document.readyState" ).toString().equals( "complete" ) ) {
                break;
            }
        }
    }
}