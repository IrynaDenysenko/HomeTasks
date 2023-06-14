package HomeTask1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.rmi.server.ExportException;
import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

import static org.openqa.selenium.JavascriptExecutor.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FillInResume {
    private WebDriver driver;
    private WebDriverWait wait;
//    @BeforeSuite
//    @BeforeGroups
//    @BeforeClass
//    @BeforeMethod
    @BeforeTest (groups = "smokeTest")
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(150));
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Set the path to the geckodriver executable
            FirefoxOptions options = new FirefoxOptions();
            options.setAcceptInsecureCerts(true);
            driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(150));
        }
    }
    @Test
    public void fillInResume() throws InterruptedException {
        driver.navigate().to("https://novaposhta.ua/");
        WebElement popUp = driver.findElement(By.xpath("//img[@class='popup_info_img']"));
        if (popUp.isDisplayed()){
            WebElement popUpClose = driver.findElement(By.xpath("//div[@id='popup_info']//i"));
            popUpClose.click();
        }
        else {};
        By vacances = By.xpath("//a[@href='https://novaposhta.ua/all_jobs']");
        wait.until(visibilityOfElementLocated(vacances));
        WebElement vacancyMenu = driver.findElement(vacances);
        vacancyMenu.click();
        wait.until(titleIs("Вакансії – «Нова Пошта»| Доставка майбутнього"));
        driver.switchTo().frame(0);
        By byRegion = By.xpath("//select[@name='ddlCity']");
        wait.until(visibilityOfElementLocated(byRegion));
        WebElement region = driver.findElement(byRegion);
        Select selectRegion = new Select(region);
        selectRegion.selectByVisibleText("Біла Церква");
        WebElement firstvacancy = driver.findElement(By.xpath("//table[@class='vacancies_table']//a[1]"));
        firstvacancy.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement sendResume = driver.findElement(By.xpath("//a[@class='vac_links_apply']"));
        sendResume.click();
        driver.switchTo().defaultContent();
        Thread.sleep(500);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        String pageurl = driver.getCurrentUrl();
        assert(pageurl).contains("https://rabota.ua/ua/company477532");
    }
    @Test (groups = "smokeTest")//timeOut = 30000
    public void fillInRes() throws InterruptedException {
        driver.navigate().to("https://novaposhta.ua/");
        WebElement popUp = driver.findElement(By.xpath("//img[@class='popup_info_img']"));
        if (popUp.isDisplayed()){
            WebElement popUpClose = driver.findElement(By.xpath("//div[@id='popup_info']//i"));
            popUpClose.click();
        }
        else {};
        By vacances = By.xpath("//a[@href='https://novaposhta.ua/all_jobs']");
        wait.until(visibilityOfElementLocated(vacances));
        WebElement vacancyMenu = driver.findElement(vacances);
        vacancyMenu.click();
        wait.until(titleIs("Вакансії – «Нова Пошта»| Доставка майбутнього"));
        driver.switchTo().frame(0);
        By byRegion = By.xpath("//select[@name='ddlCity']");
        wait.until(visibilityOfElementLocated(byRegion));
        WebElement region = driver.findElement(byRegion);
        Select selectRegion = new Select(region);
        selectRegion.selectByVisibleText("Біла Церква");
        WebElement firstvacancy = driver.findElement(By.xpath("//table[@class='vacancies_table']//a[1]"));
        firstvacancy.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement sendResume = driver.findElement(By.xpath("//a[@class='vac_links_apply']"));
        sendResume.click();
        driver.switchTo().defaultContent();
        Thread.sleep(500);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        String pageurl = driver.getCurrentUrl();
        assert(pageurl).contains("https://rabota.ua/ua/company477532");
    }
    @Test (expectedExceptions = NoSuchElementException.class)
    public void exp() throws InterruptedException {
        driver.navigate().to("https://novaposhta.ua/");
        WebElement popUp = driver.findElement(By.xpath("//img[@class='popup_info_img']"));
        if (popUp.isDisplayed()){
            WebElement popUpClose = driver.findElement(By.xpath("//div[@id='popup_info']//i"));
            popUpClose.click();
        }
        else {};
        By vacances = By.xpath("//a[@href='https://novaposhta.ua/all_jobs']");
        wait.until(visibilityOfElementLocated(vacances));
        WebElement vacancyMenu = driver.findElement(vacances);
        vacancyMenu.click();
        wait.until(titleIs("Вакансії – «Нова Пошта»| Доставка майбутнього"));
        driver.switchTo().frame(0);
        By byRegion = By.xpath("//select[@name='ddlCity']");
        wait.until(visibilityOfElementLocated(byRegion));
        WebElement region = driver.findElement(byRegion);
        Select selectRegion = new Select(region);
        selectRegion.selectByVisibleText("Біла Церква");
        WebElement firstvacancy = driver.findElement(By.xpath("//table[@class='vacancies_table']//a[1]"));
        firstvacancy.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement sendResume = driver.findElement(By.xpath("//a[@class='vac_links_applyhh']"));
        sendResume.click();

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}