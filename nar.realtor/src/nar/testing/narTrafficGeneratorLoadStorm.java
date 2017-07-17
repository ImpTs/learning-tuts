package nar.testing;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class narTrafficGeneratorLoadStorm {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://dev-www.realtor.org/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoadStormSelenium() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("logo")).click();
    driver.get(baseUrl + "/");
    driver.get(baseUrl + "/user/login");
    driver.get(baseUrl + "/governance/governing-documents/the-code-of-ethics");
    driver.get(baseUrl + "/code-of-ethics/training");
    driver.get(baseUrl + "/research-and-statistics");
    driver.get(baseUrl + "/topics/trid-tila-respa-integrated-disclosure");
    driver.get(baseUrl + "/programs/realtor-benefits-program");
    driver.get(baseUrl + "/designations-and-certifications");
    driver.get(baseUrl + "/education");
    driver.get(baseUrl + "/member-benefits");
    driver.get(baseUrl + "/user/login?destination=#");
    driver.get(baseUrl + "/topics/existing-home-sales");
    driver.get(baseUrl + "/research-and-statistics/housing-statistics");
    driver.get(baseUrl + "/library/real-estate-business-letter-templates");
    driver.get(baseUrl + "/code-of-ethics");
    driver.get(baseUrl + "/courses");
    driver.get(baseUrl + "/news-and-commentary");
    driver.get(baseUrl + "/field-guides/field-guide-to-quick-real-estate-statistics");
    driver.get(baseUrl + "/research-and-statistics/research-reports");
    driver.get(baseUrl + "/user/login?destination=");
    driver.get(baseUrl + "/reports/highlights-from-the-2015-profile-of-home-buyers-and-sellers");
    driver.get(baseUrl + "/events");
    driver.get(baseUrl + "/articles/urgent-alert-sophisticated-email-scams-targeting-the-real-estate-ind");
    driver.get(baseUrl + "/directories");
    driver.get(baseUrl + "/news-releases");
    driver.get(baseUrl + "/programs/realtor-benefits-program/all-realtor-benefits-program-partners");
    driver.get(baseUrl + "/news-releases/2015/11/breaking-hud-announces-change-to-fha-condo-policies-at-");
    driver.get(baseUrl + "/logos-and-trademark-rules");
    driver.get(baseUrl + "/law-and-ethics");
    driver.get(baseUrl + "/topics/metropolitan-median-area-prices-and-affordability");
    driver.get(baseUrl + "/topics/nar-doj-settlement/multiple-listing-service-mls-what-is-it");
    driver.get(baseUrl + "/field-guides/field-guide-to-1031-exchanges");
    driver.get(baseUrl + "/member-benefits/value-of-membership");
    driver.get(baseUrl + "/association-executives");
    driver.get(baseUrl + "/policy/professional-standards-and-code-of-ethics/a-buyers-and-sellers-guide-t");
    driver.get(baseUrl + "/code-of-ethics/ethics-complaints-arbitration-requests-and-related-information");
    driver.get(baseUrl + "/field-guides/field-guide-to-opening-a-real-estate-brokerage");
    driver.get(baseUrl + "/handbook-on-multiple-listing-policy/key-definitions/section-3-definitions-of-");
    driver.get(baseUrl + "/topics/real-estate-settlement-procedures-act-respa/respa-faq");
    driver.get(baseUrl + "/contact-us");
    driver.get(baseUrl + "/logos-and-trademark-rules/the-realtor-logo");
    driver.get(baseUrl + "/topics/housing-affordability-index");
    driver.get(baseUrl + "/field-guides/field-guide-to-being-a-new-realtor");
    driver.get(baseUrl + "/about-nar");
    driver.get(baseUrl + "/designations-and-certifications/gri-designation");
    driver.get(baseUrl + "/political-advocacy");
    driver.get(baseUrl + "/library");
    driver.get(baseUrl + "/topics/pending-home-sales");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
