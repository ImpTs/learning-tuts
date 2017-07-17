package nar.testing;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.junit.*;

public class listOfURLS {
	static FirefoxDriver driver = new FirefoxDriver();
	private static String coreUrl = "https://qa.nar.realtor";

	private static String username = "GAMNAR242";
	private static String userpass = "Password1!";

	private static String sitePagesTesting[] = new String[] {
	"/admin/structure/taxonomy/from",
	"/admin/structure/taxonomy/from?page=1",
	"/admin/structure/taxonomy/from?page=2",
	"/admin/structure/taxonomy/from?page=3",
	"/admin/structure/taxonomy/from?page=4",
	"/admin/structure/taxonomy/from?page=5",
	"/admin/structure/taxonomy/from?page=6",
	"/admin/structure/taxonomy/from?page=7",
	"/admin/structure/taxonomy/from?page=8"
	};

	private static String list1[] = new String[] {
			"/taxonomy/term/28480",
			"/taxonomy/term/28486",
			"/taxonomy/term/28590",
			"/taxonomy/term/28594",
			"/taxonomy/term/28487",
			"/taxonomy/term/28488",
			"/taxonomy/term/28489",
			"/taxonomy/term/28490",
			"/taxonomy/term/28492",
			"/taxonomy/term/28493",
			"/taxonomy/term/28494",
			"/taxonomy/term/28495",
			"/taxonomy/term/28496",
			"/taxonomy/term/28497",
			"/taxonomy/term/28498",
			"/taxonomy/term/28499",
			"/taxonomy/term/28500",
			"/taxonomy/term/28501",
			"/taxonomy/term/28502",
			"/taxonomy/term/28503",
			"/taxonomy/term/28504",
			"/taxonomy/term/28505",
			"/taxonomy/term/28506",
			"/taxonomy/term/28507",
			"/taxonomy/term/28508",
			"/taxonomy/term/28509",
			"/taxonomy/term/28510",
			"/taxonomy/term/28511",
			"/taxonomy/term/28512",
			"/taxonomy/term/28513",
			"/taxonomy/term/28514",
			"/taxonomy/term/28515",
			"/taxonomy/term/28516",
			"/taxonomy/term/28517",
			"/taxonomy/term/28518",
			"/taxonomy/term/28519",
			"/taxonomy/term/28520",
			"/taxonomy/term/28521",
			"/taxonomy/term/28522",
			"/taxonomy/term/28523",
			"/taxonomy/term/28524",
			"/taxonomy/term/28525",
			"/taxonomy/term/28527",
			"/taxonomy/term/28528",
			"/taxonomy/term/28529",
			"/taxonomy/term/28530",
			"/taxonomy/term/28531",
			"/taxonomy/term/28532",
			"/taxonomy/term/28533",
			"/taxonomy/term/28534",
			"/taxonomy/term/28535",
			"/taxonomy/term/28536",
			"/taxonomy/term/28537",
			"/taxonomy/term/28538",
			"/taxonomy/term/28539",
			"/taxonomy/term/28540",
			"/taxonomy/term/28541",
			"/taxonomy/term/28542",
			"/taxonomy/term/28543",
			"/taxonomy/term/28545",
			"/taxonomy/term/28546",
			"/taxonomy/term/28547",
			"/taxonomy/term/28550",
			"/taxonomy/term/28551",
			"/taxonomy/term/28552",
			"/taxonomy/term/28553",
			"/taxonomy/term/28554",
			"/taxonomy/term/28555",
			"/taxonomy/term/28559",
			"/taxonomy/term/28560",
			"/taxonomy/term/28561",
			"/taxonomy/term/28562",
			"/taxonomy/term/28563",
			"/taxonomy/term/28564",
			"/taxonomy/term/28567",
			"/taxonomy/term/28568",
			"/taxonomy/term/28569",
			"/taxonomy/term/28570",
			"/taxonomy/term/28571",
			"/taxonomy/term/28572",
			"/taxonomy/term/28573",
			"/taxonomy/term/28574",
			"/taxonomy/term/28575",
			"/taxonomy/term/28485",
			"/taxonomy/term/28576",
			"/taxonomy/term/28577",
			"/taxonomy/term/28578",
			"/taxonomy/term/28579",
			"/taxonomy/term/28580",
			"/taxonomy/term/28581",
			"/taxonomy/term/28582",
			"/taxonomy/term/28583",
			"/taxonomy/term/28584",
			"/taxonomy/term/28585"
	};
	private static String list2[] = new String[] {
			" ()",
			" (_10)",
			" (_100)",
			" (_101)",
			" (_11)",
			" (_12)",
			" (_13)",
			" (_14)",
			" (_15)",
			" (_16)",
			" (_17)",
			" (_18)",
			" (_19)",
			" (_20)",
			" (_21)",
			" (_22)",
			" (_23)",
			" (_24)",
			" (_25)",
			" (_26)",
			" (_27)",
			" (_28)",
			" (_29)",
			" (_30)",
			" (_31)",
			" (_32)",
			" (_33)",
			" (_34)",
			" (_35)",
			" (_36)",
			" (_37)",
			" (_38)",
			" (_39)",
			" (_40)",
			" (_41)",
			" (_42)",
			" (_43)",
			" (_44)",
			" (_45)",
			" (_46)",
			" (_47)",
			" (_48)",
			" (_49)",
			" (_50)",
			" (_51)",
			" (_52)",
			" (_53)",
			" (_54)",
			" (_55)",
			" (_56)",
			" (_57)",
			" (_58)",
			" (_59)",
			" (_60)",
			" (_61)",
			" (_62)",
			" (_63)",
			" (_64)",
			" (_65)",
			" (_66)",
			" (_67)",
			" (_68)",
			" (_69)",
			" (_70)",
			" (_71)",
			" (_72)",
			" (_73)",
			" (_74)",
			" (_75)",
			" (_76)",
			" (_77)",
			" (_78)",
			" (_79)",
			" (_80)",
			" (_81)",
			" (_82)",
			" (_83)",
			" (_84)",
			" (_85)",
			" (_86)",
			" (_87)",
			" (_88)",
			" (_89)",
			" (_9)",
			" (_90)",
			" (_91)",
			" (_92)",
			" (_93)",
			" (_94)",
			" (_95)",
			" (_96)",
			" (_97)",
			" (_98)",
			" (_99)"
	};

	private static ArrayList<String> termTitle = new ArrayList<String>();
	private static ArrayList<String> termLinks = new ArrayList<String>();

	@Before
    public void setUp()
    {
		System.out.println("Login Test Started!");
    }

	@Test
	public void listOfURLSMain() throws InterruptedException, IOException {
		/*
		driver.get(coreUrl + "/user/login?current=node/28174#!/login");
		checkPageIsReady();
		// Login Variables
		WebElement loginUsernameField = driver.findElement(By.xpath("//*[@id='sign-in']/div[1]/input[1]"));
		WebElement loginPasswordField = driver.findElement(By.xpath("//*[@id='sign-in']/div[1]/input[2]"));
        WebElement loginSubmitButton = driver.findElement(By.xpath("//*[@id='signInModal']/div/div[3]/button"));
        // Login Begin
        loginUsernameField.sendKeys(username);
        TimeUnit.SECONDS.sleep(1);
        loginPasswordField.sendKeys(userpass);
        TimeUnit.SECONDS.sleep(1);
        loginSubmitButton.click();
        TimeUnit.SECONDS.sleep(5);

		for (int x = 0; x < sitePagesTesting.length; x++){
	        driver.get(coreUrl + sitePagesTesting[x]);
			checkPageIsReady();

			int rows = driver.findElements(By.xpath("//*[@id='taxonomy']/tbody/tr")).size();
			for (int y = 1; y < rows; y++){

				String name = driver.findElement(By.xpath("//*[@id='taxonomy']/tbody/tr["+y+"]/td[1]/a[2]")).getText();
				String link = driver.findElement(By.xpath("//*[@id='taxonomy']/tbody/tr["+y+"]/td[1]/a[2]")).getAttribute("href");
				System.out.println("Started: "+name+" URL: " + link);

				if (name.contains("\\([_]?[\\d]?[\\d]?\\)")) {
					System.out.println("Found: " + name);
					link = driver.findElement(By.xpath("//*[@id='taxonomy']/tbody/tr["+y+"]/td[1]/a[2]")).getAttribute("href");
				}
			}
		}
		*/
		driver.get(coreUrl + "/");
		int listNumber = list1.length;
		for (int t = 0; t < listNumber; t++) {
			String address = list1[t];
			driver.get(coreUrl + address);
			if (!(driver.findElements(By.xpath("//*[@id='main']/div/div/div[3]/div/div[2]/div[1]/h2/a")).size() == 0)) {
				System.out.println("Found Item");
				String title = driver.findElement(By.xpath("//*[@id='main']/div/div/div[3]/div/div[2]/div[1]/h2/a")).getText();
				String link = driver.findElement(By.xpath("//*[@id='main']/div/div/div[3]/div/div[2]/div[1]/h2/a")).getAttribute("href");
				termTitle.add(title);
				termLinks.add(link);
			}
			else {
				termTitle.add("null");
				termLinks.add("null");

			}

		}
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(termTitle);
		System.out.println(termLinks);



		/*
		int listNumber = list1.length;
		  for (int t = 0; t < listNumber; t++) {
		  String address = list1[t];
			System.err.println("Http Connect to: " + address);
			URL obj = new URL(address);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String sourceCodeSegment;
			while ((sourceCodeSegment = in.readLine()) != null) {
				String usernameRegex = "(.*)</title>.*";
				if( sourceCodeSegment.matches(usernameRegex) ) {
					break;
				}
			}
			String pageTitle = sourceCodeSegment;
			System.out.println(pageTitle);
			in.close();
			Thread.sleep(1000);
		  }
		  */
	}

	@After
    public void tearDown()
    {
		driver.quit();
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


	/*
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
			System.err.println("Null");
			return false;
		}
	}
	*/
}