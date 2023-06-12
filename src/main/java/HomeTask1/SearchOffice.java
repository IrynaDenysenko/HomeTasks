package HomeTask1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.JavascriptExecutor.*;
public class SearchOffice {

    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {
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
    public void searchOffice() throws InterruptedException {
        driver.navigate().to("https://novaposhta.ua/");
        By officesLocator = By.partialLinkText("Відділення");
        wait.until(visibilityOfElementLocated(officesLocator));
        WebElement office = driver.findElement(officesLocator);
        Actions action = new Actions(driver);
        action.moveToElement(office).moveByOffset(1, 1).perform();
        By officeListLocator = By.xpath("//li/a[@href='/office/list']");
        wait.until(visibilityOfElementLocated(officeListLocator));
        WebElement typoAdress = driver.findElement(officeListLocator);
        typoAdress.click();
        WebElement searchadress = driver.findElement(By.id("oCityArrow"));
        searchadress.click();
        WebElement selectadress= driver.findElement(By.id("lidb5c88e0-391c-11dd-90d9-001a92567626"));
        selectadress.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("top_block")));

        WebElement number = driver.findElement(By.xpath("//input[@id='oWarehouseFilter']"));
        number.click();
        wait.until(visibilityOfElementLocated(By.xpath("//input[@id='oWarehouseFilter']/../div[@class='scroll-element jspScrollable initialized']")));
        number.sendKeys("8");
        Thread.sleep(300);
        number.sendKeys("6");
        Thread.sleep(300);
        WebElement selectNumber = driver.findElement(By.xpath("//li[@data-warehouse-ref='9f328a2f-cbd1-11e4-a77a-005056887b8d']/span"));
        selectNumber.click();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        By officeSelector = By.xpath("//a[@href='/office/view/id/86/city/Харків']");
        WebElement officeNumber = driver.findElement(officeSelector);
        officeNumber.click();
        wait.until(titleIs("Харків | Відділення №86 | «Нова пошта»"));
        String text = driver.findElement(By.xpath("//h2[@class='officePageTitle']/../p[1]")).getText();
        assert(text).contains("вул. Гвардійців-Широнінців, 62");


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
