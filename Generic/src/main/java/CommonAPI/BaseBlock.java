package CommonAPI;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JHANGIR on 1/5/2017.
 */
public class BaseBlock {
    public WebDriver driver = null;

    // public static  Logger logger = LogManager.getLogger(Base.class);
    @Parameters({"useCloudEnv", "userName", "accessKey", "os", "browserName", "browserVersion", "url", "ScreenCastValue"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("mdhossain") String userName, @Optional("")
            String accessKey, @Optional("Windows 8") String os, @Optional("firefox") String browserName, @Optional("34")
                              String browseVersion, @Optional("http://www.google.com") String url, @Optional("false") boolean screenCastValue) throws IOException, NullPointerException {
        BasicConfigurator.configure();
        if (useCloudEnv == true) {
            // run in cloud
            getCloudDriver(userName, accessKey, os, browserName, browseVersion);
        } else {
            // run in local
            getLocalDriver(os, browserName);
            //  logger.info("Test is running on Local");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(String os, String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\JHANGIR\\IdeaProjects\\dhakaMetropolitan\\Generic\\drivers\\chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", "../Generic/selenium-browser-driver/chromedriver");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "..\\Generic\\selenium-browser-driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("htmlunit")) {
            driver = new HtmlUnitDriver();
        } else if (browserName.equalsIgnoreCase("phantomJS")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("phantomjs.binary.path", "..\\Generic\\selenium-browser-driver\\phantomjs.exe");
            } else {
                System.setProperty("phantomjs.binary.path", "../Generic/selenium-browser-driver/phantomjs.exe");
            }
            driver = new PhantomJSDriver();
        }
        return driver;
    }

    public WebDriver getCloudDriver(String userName, String accessKey, String os, String browserName,
                                    String browserVersion) throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName((browserName));
        cap.setCapability("version", browserVersion);
        driver = new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey +
                "@ondemand.saucelabs.com:80/wd/hub"), cap);
        return driver;
    }

    @AfterMethod
    public void cleanUp() {
        try {
            driver.quit();
            // Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
        } catch (Exception anException) {
            anException.printStackTrace();
        }
        //driver.close();
        //driver.quit();
    }

    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;

    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public List<String> getTextFromWebElements(String locator) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.xpath(locator));
        for (WebElement web : element) {
            text.add(web.getText());
        }
        return text;
    }

    public List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }

    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }

    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }

    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }

    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public void mouseHoverByCss(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
            // Action hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, this is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }

    }

    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
            //Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, this is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }

    // scrolling down
    public void scrollPageDown() {
        ((JavascriptExecutor) driver).executeScript("scroll(0, 400)");
    }

    public void scrollToElementById(String locator) {
        WebElement element = driver.findElement(By.cssSelector(locator));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0]. scrollIntoView(true)", element);
    }

    // Handling alert
    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // taking  screen shoots on testoutputData/Screenshots directory
    public void takeScreenShot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yy-mm-dd HH-mm-ss");
        Date date = new Date();
        FileUtils.copyFile(scrFile, new File("TestoutputData/Screenshot/" + fileName + "_" + dateFormat.format(date) + ".png"));
    }

    // synchronization
    public void waitUnitlClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilPresenceLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilVisibleAndClick(By locator) {
        waitUntilVisible(locator);
        driver.findElement(locator).click();
    }

    public void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public void upLoadFile(String locator, String path) {
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
        path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }

    public void getAllLinks(String url) throws IOException {
        navigateTo(url);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (int i = 1; i <= links.size() - 1; i = i + 1) {
            String output = links.get(i).getText();
            System.out.println(output);
        }
    }
//    public void printVisibleLinks (String ExcelFile) throws InterruptedException {
//       try {
//           List<WebElement> links = driver.findElements(By.tagName("a"));
//           int noOflinks = links.size();
//           int i =1;
//           //System.out.println(noOflinks);
//           DataRead data = new DataRead(ExcelFile);
//           for(WebElement pagelink: links ) {
//               int j= i++;
//               String linktext = pagelink.getText();
//               String link =pagelink.getAttribute("href");
//               if(linktext.length() !=0) {
//                   data.setCellData("search", "Text", j, linktext);
//                   data.setCellData("Search", "Link", j, link);
//               }
//           }
//       }catch (Exception e){
//           System.out.println("error " + e);
//       }
//    }
    public void clearInput(String locator) {driver.findElement(By.cssSelector(locator)).clear();}
    public void keysInput(String locator) {driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER); }
}


