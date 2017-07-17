package nar.testing;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class narSampleHTTP {
	private WebDriver driver;
	static int i;
	private static String coreUrl = "https://qa.nar.realtor";
	private static Scanner scanner;
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		System.out.println("Login Test Started!");
	}
	@Test
	public void NAReventsMain() throws MalformedURLException {
		getTitle();
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
	
	static void getTitle() {
		InputStream response = null;
		try {
			String url = coreUrl;
			response = new URL(url).openStream();
			scanner = new Scanner(response);
			String responseBody = scanner.useDelimiter("\\A").next();
			System.out.println(responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>")));
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		
		finally {
			try {
				response.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}