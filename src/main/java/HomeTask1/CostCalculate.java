package HomeTask1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CostCalculate {

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
    public void CostCalculate() throws InterruptedException {
        driver.navigate().to("https://novaposhta.ua/");
        //wait.until(titleIs("Термінова і експрес доставка: транспортно-логістичні послуги в Києві та по всій Україні - служба доставки №1 «Нова пошта»"));
        By calculate = By.xpath("//li/a[@href='/delivery']");
        wait.until(visibilityOfElementLocated(calculate));
        WebElement calculatePage = driver.findElement(calculate);
        calculatePage.click();
        wait.until(titleIs("Вартість доставки - «Нова Пошта»| Доставка майбутнього"));
        //Thread.sleep(300);
        WebElement fromPlace = driver.findElement(By.id("DeliveryForm_senderCity"));
        fromPlace.click();
        fromPlace.sendKeys("Х");
        WebElement fromCity = driver.findElement(By.xpath("//input[@id='DeliveryForm_senderCity']/following-sibling::div/ul/li[@data-value='db5c88e0-391c-11dd-90d9-001a92567626']"));
        fromCity.click();
        WebElement toPlace= driver.findElement(By.xpath("//input[@id='DeliveryForm_recipientCity']"));
        toPlace.click();
        toPlace.sendKeys("Л");
        WebElement toCity = driver.findElement(By.xpath("//input[@id='DeliveryForm_recipientCity']/following-sibling::div/ul/li[@data-value='db5c88f5-391c-11dd-90d9-001a92567626']"));
        toCity.click();
        WebElement parcelListType = driver.findElement(By.xpath("//div[@class='select cargo_type']"));
        parcelListType.click();
        WebElement parcelType = driver.findElement(By.xpath("//div[@class='select cargo_type open']/div/ul/li[@data-value='Cargo']"));
        parcelType.click();
        WebElement priceValue = driver.findElement(By.xpath("//input[@name='DeliveryForm[optionsSeat][1][cost]']"));
        priceValue.sendKeys("1000");
        WebElement weight = driver.findElement(By.xpath("//input[@name='DeliveryForm[optionsSeat][1][weight]']"));
        weight.sendKeys("5");
        WebElement lenght = driver.findElement(By.xpath("//input[@name='DeliveryForm[optionsSeat][1][volumetricLength]']"));
        lenght.sendKeys("100");
        WebElement width = driver.findElement(By.xpath("//input[@name='DeliveryForm[optionsSeat][1][volumetricWidth]']"));
        width.sendKeys("20");
        WebElement height = driver.findElement(By.xpath("//input[@name='DeliveryForm[optionsSeat][1][volumetricHeight]']"));
        height.sendKeys("15");
        WebElement sendButton = driver.findElement(By.xpath("//input[@value='Розрахувати вартість']"));
        sendButton.click();
        sendButton.click();
        wait.until(titleIs("Вартість доставки - «Нова Пошта»| Доставка майбутнього"));
        WebElement totalCost = driver.findElement(By.xpath("//h3[@class='final'][1]"));

        String text = totalCost.getText();
        assert text.contains("Разом: 105.00 ... 175.00грн");


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}