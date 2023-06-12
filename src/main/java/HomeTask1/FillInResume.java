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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.function.Function;

import static org.openqa.selenium.JavascriptExecutor.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FillInResume {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeTest
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
        wait(500);
        String pageurl = driver.getCurrentUrl();
        //Assert.(urlContains("https://rabota.ua/ua/company"));

        assert(pageurl).contains("https://rabota.ua/ua/company");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}