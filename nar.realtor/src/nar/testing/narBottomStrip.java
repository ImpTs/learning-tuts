package nar.testing;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class narBottomStrip {
	private static WebDriver driver;
	static int e;
	static String search;
	private static String coreAltUrl = "https://rov3:r0qa@qa.nar.realtor";
	private static String coreUrl = "https://qa.nar.realtor";
	//private static String coreAltUrl = "https://rov3:pr3pr0d@rov3.nar.realtor";
	//private static String coreUrl = "https://rov3.nar.realtor";
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

	X-path relative locater inside WebElement List Iterations
	http://stackoverflow.com/questions/14837735/relative-xpath-from-list-of-webelements
	// Find the outer element.
	WebElement outer = driver.findElement(By.anything("whatever"));
	// This doesn't work, it searches the whole page for the XPath expression.
	WebElement inner = outer.findElement(By.xpath("//some/nasty/xpath"));
	// This works! It takes the outer element as root.
	WebElement inner = outer.findElement(By.xpath(".//some/nasty/xpath"));

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
	static String sitePagesTesting[] = new String[] {
		//"/student-loan-debt",
		//"/links/save-big-with-the-realtor-benefits-program",
		//"/research-and-statistics-new",
		//"/research-and-statistics/research-reports",
		//"/events/ae-institute",
		//"/videos/the-voice-for-real-estate-1-respa-student-debt-net-neutrality",
		"/test-standard-page-bottom-strip-container-variations",
		//"/test-elements/test-page-for-search/test-private-files/test-article-media-embed",
		//"/test-article-without-featured-image",
		//"/test-media-2-image-embed",
		//"/washington-report"
	};

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
	}

	@Test
	public void testLoadStormSelenium() throws Exception {
		driver.get(coreAltUrl);
		checkPageIsReady();
		//driver.manage().window().maximize();
		for (int x = 0; x < sitePagesTesting.length; x++) {
			driver.get(coreUrl + sitePagesTesting[x]);
			checkPageIsReady();
			System.out.println(" ");
			System.out.println("Visiting: " + coreUrl + sitePagesTesting[x]);
			int sectionCount = driver.findElements(By.xpath("//*[@class='secondary-content']/div")).size();
			for (int z = 1; z <= sectionCount; z++) {
				String classNames = driver.findElement(By.xpath("//*[@class='secondary-content']/div[" + z + "]")).getAttribute("class").toString();
				if (classNames.contains("pane--latest-content-panel-pane-1")) {
					//Latest bottom strip option is checked off, causing it to appear at top of bottomstrip.
					//No need to look deeper since this section has fixed layout option.
					WebElement location = driver.findElement(By.xpath("//*[@class='secondary-content']/div[contains(@class, 'pane--latest-content-panel-pane-1')]"));
					System.out.println("Classname: " + classNames + ", Location: " + location);
					bottomStripLatest(classNames, location);
				}
				if (classNames.contains("pane--nodefield-below-paragraph")) {
					//Mid Section, where different types will populate. Either can be a container with multiple types, or outright types stacked.
					List < WebElement > containers = driver.findElements(By.xpath("//*[@class='secondary-content']/div[contains(@class, 'pane--nodefield-below-paragraph')]/div/div/div/div"));
					for (WebElement resultItem: containers) {
						String sectionClass = resultItem.findElement(By.xpath("./div")).getAttribute("class").toString();
						//Container
						if (sectionClass.contains("layout--full")) {
							List < WebElement > fullContainer = resultItem.findElements(By.xpath("./div[contains (@class, 'layout--full')]/div/div"));
							for (WebElement resultContainer: fullContainer) {
								String fullSectionClass = resultContainer.getAttribute("class").toString();
								System.out.println("Classname: " + fullSectionClass + ", Location: " + resultContainer);
								//BrokenDown
								bottomStripGeneral(fullSectionClass, resultContainer);
							}
						}
						//MultiRow
						if (sectionClass.contains("layout-constrain")) {
							List < WebElement > fullContainer = resultItem.findElements(By.xpath("./div[contains (@class, 'layout-constrain')]/div/div"));
							for (WebElement resultContainer: fullContainer) {
								String fullSectionClass = resultContainer.getAttribute("class").toString();
								System.out.println("Classname: " + fullSectionClass + ", Location: " + resultContainer);
								//BrokenDown
								bottomStripGeneral(fullSectionClass, resultContainer);
							}
						}
						//BrokenDown
						else {
							System.out.println("Classname: " + classNames + ", Location: " + resultItem);
							bottomStripGeneral(sectionClass, resultItem);
						}
					}
				}
				if (classNames.contains("pane--parent-bottom-strip")) {
					//Bottom section found standard throughout the website.
					//No need to look deeper since this section has fixed layout option.
					WebElement location = driver.findElement(By.xpath("//*[@class='secondary-content']/div[contains(@class, 'pane--parent-bottom-strip')]"));
					System.out.println("Classname: " + classNames + ", Location: " + location);
					bottomStripLatest(classNames, location);
				}
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	public void bottomStripLatest(String className, WebElement location) {
		try {
			if ((driver.findElement(By.xpath("//*[@class='secondary-content']/div/div/div")).getAttribute("class").toString()).contains("view--latest-content")) {
				System.out.println("KickStart1 - Latest Layout");
				System.out.println("A1");
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}

	public void bottomStripGeneral(String className, WebElement location) {
		try {
			/*
			if (className.contains("layout--fg-3333")) {
				System.out.println("KickStart4 - FG-3333");
				System.out.println("->Classname: " + className + ", Location: " + location);
				int cordnumber = location.findElements(By.xpath("./div")).size();
				assertTrue(cordnumber==4);

			}
			if (className.contains("layout--fg-3-3-6")) {
				System.out.println("KickStart5 - FG-3-3-6");
				System.out.println("->Classname: " + className + ", Location: " + location);

			}
			if (className.contains("layout--fg-3-6-3")) {
				System.out.println("KickStart6 - FG-3-6-3");
				System.out.println("->Classname: " + className + ", Location: " + location);

			}
			if (className.contains("layout--fg-6-3-3")) {
				System.out.println("KickStart7 - FG-6-3-3");
				System.out.println("->Classname: " + className + ", Location: " + location);

			}
			if (className.contains("layout--fg-3-9")) {
				System.out.println("KickStart8 - FG-3-9");
				System.out.println("->Classname: " + className + ", Location: " + location);

			}
			if (className.contains("layout--fg-9-3")) {
				System.out.println("KickStart9 - FG-9-3");
				System.out.println("->Classname: " + className + ", Location: " + location);

			}
			*/
			if (className.contains("carousel")) {
				System.out.println("KickStart2 - Carousel");
				System.out.println("->Classname: " + className + ", Location: " + location);

				try {
					assertTrue(location.isDisplayed());
					//Check Next Button	          	./div[contains (@class, 'carousel')]/div[contains(@class, 'carousel__content')]/div[contains(@class, 'carousel__container')]/div/div/div[contains(@class, 'carousel__item')]/article
					//location.findElements(By.xpath("./div[contains (@class, 'carousel')]/div[contains(@class, 'carousel__content')]/div[contains(@class, 'carousel__button-next')]"));

					//Check Slides
					List < WebElement > carouselContainer = location.findElements(By.xpath("./div[contains (@class, 'carousel')]/div[contains(@class, 'carousel__content')]/div[contains(@class, 'carousel__container')]/div/div/div[contains(@class, 'carousel__item')]/article"));
					for (WebElement resultContainer: carouselContainer) {
						String contentTypeClasses = resultContainer.getAttribute("class").toString();
						decipherContentType(contentTypeClasses, resultContainer);
					}
				}
				catch (Exception e) {
					System.out.print("Error --->" + e);
				}
			}

			/*
			if (className.contains("paragraphs-item--icon-accordion-menu")) {
				System.out.println("KickStart3 - Accordian Icon Menu");
				System.out.println("->Classname: " + className + ", Location: " + location);

				//assertTrue(isElementPresent(By.xpath("")));
				//Check: //*[@class='secondary-content']/div[contains(@class, 'pane--nodefield-below-paragraph')]/div/div/div/div/div[contains(@class, 'layout--full')]/div/div[contains(@class, 'paragraphs-item--icon-accordion-menu')]....
			}
			*/
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}

	public void bottomStripFinal(String className, WebElement location) {


	}

	public void decipherContentType (String contentTypeClasses, WebElement location) {
		String special = "none";
		String tileSize = "none";
		if (contentTypeClasses.contains("has-video")) {
			special = "video";
		}

		if (contentTypeClasses.contains("card-view--tile")) {
			special = "cardViewTile";
		}

		if (contentTypeClasses.contains("node--tile-large")) {
			tileSize = "nodeTileLarge";
		}

		if (contentTypeClasses.contains("node--bottom-tile")) {
			tileSize = "nodeTileBottom";
		}

		if (contentTypeClasses.contains("card-view")) {
			cardView(contentTypeClasses, tileSize, special, location);
		}
		/*
		if (contentTypeClasses.contains("field--body")) {

		}
		if (contentTypeClasses.contains("node--page")) {

		}
		if (contentTypeClasses.contains("node--post")) {

		}
		if (contentTypeClasses.contains("node--event")) {

		}
		if (contentTypeClasses.contains("node--media")) {

		}
		if (contentTypeClasses.contains("node--news-release")) {

		}
		if (contentTypeClasses.contains("node--publications")) {

		}
		*/

	}


	public void cardView (String className, String titletype, String special, WebElement location) {
		List < WebElement > divs = location.findElements(By.xpath("./div"));
		for (WebElement resultDivs: divs) {
			String classSpec = resultDivs.getAttribute("class").toString();
			if (classSpec.contains("card-view__media")) {
				//background
				Boolean isPresent = resultDivs.findElements(By.xpath("./div[contains (@class, 'card-view__body')]/h3[contains (@class, 'card-view__title')]")).size() > 0;
				assertTrue(isElementPresent(By.xpath("./div[contains (@class, 'card-view__bg-image')]")));
			}
			if (classSpec.contains("card-view__body")) {
				//body
				if ((resultDivs.findElement(By.xpath("./div[contains (@class, 'card-view__body')]/h3")).getAttribute("class").toString()).contains("card-view__title")) {
					//title
					resultDivs.findElement(By.xpath("./div[contains (@class, 'card-view__body')]/h3[contains (@class, 'card-view__title')]"));
					assertTrue(isElementPresent(By.xpath("./div[contains (@class, 'card-view__bg-image')]")));
				}
				if ((resultDivs.findElement(By.xpath("./div[contains (@class, 'card-view__body')]/div")).getAttribute("class").toString()).contains("card-view__teaser")) {
					//bodytext
					resultDivs.findElement(By.xpath("./div[contains (@class, 'card-view__body')]/div[contains (@class, 'card-view__teaser')]/a/div/div/div"));
					assertTrue(isElementPresent(By.xpath("./div[contains (@class, 'card-view__bg-image')]")));
				}
			}

			if (classSpec.contains("field--featured-image")) {
				//date
			}
		}



		/*
			// Card1 - BG -
		    assertTrue(isElementPresent(By.xpath("./div[contains (@class, 'card-view__bg-image')]")));
		    assertTrue(isElementPresent(By.xpath("./h3/a/div/div/div")));
		    // Card2 - BG -
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider1']/div/div/div[2]/article/div/div")));
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider1']/div/div/div[2]/article/div[2]/h3/a/div/div/div")));
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider1']/div/div/div[2]/article/div[3]/div")));
		    // Card3 - No BG -
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider1']/div/div/div[3]/article/div/h3/a/div/div/div")));
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider1']/div/div/div[3]/article/div/div/div/div/div")));
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider1']/div/div/div[3]/article/div[2]/div/span")));
		    // Card4 - Video
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider1']/div/div/div[4]/article/div/div[2]/div/div/div/div/div")));
		    assertTrue(isElementPresent(By.xpath("//div[@id='slider1']/div/div/div[4]/article/div[2]/h3/a/div/div/div")));
		 */


		assertTrue(location.findElement(By.xpath("")).isDisplayed());
		assertTrue(location.findElement(By.xpath("")).isDisplayed());


	}

	public void fieldBody (String className, String titletype, WebElement location) {
		//plain HTML Block

	}

	public void nodePage (String className, String titletype, WebElement location) {
	}

	public void nodePost (String className, String titletype, WebElement location) {
	}

	public void nodeEvent(String className, String titletype, WebElement location) {
	}

	public void nodeMedia(String className, String titletype, WebElement location) {
	}

	public void nodeNewsRelease(String className, String titletype, WebElement location) {
	}

	public void nodePublications(String className, String titletype, WebElement location) {
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
			}
			catch (InterruptedException e) {}
			//To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}



	  private boolean isElementPresent(WebElement item) {
	    try {
	      WebElement item;
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
}