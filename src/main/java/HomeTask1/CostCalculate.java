package HomeTask1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
   @DataProvider(name="provideParamarsForCalculate")
   public Object[][]createSomeData(){
           return new Object[][]{
                   {100,5,100,20,15,"Разом: 100.00 ... 170.00грн"},
                   {1099,10,60,40,10,"Разом: 106.00 ... 176.00грн"},
                   {1999,7,40,60,5,"Разом: 110.00 ... 180.00грн"},
           };
    }
    @Test (dataProvider = "provideParamarsForCalculate")
    public void costCalculate(int p, int w,int l,int he,int we, String result) throws InterruptedException {
        driver.navigate().to("https://novaposhta.ua/");
        WebElement popUp = driver.findElement(By.xpath("//img[@class='popup_info_img']"));
        if (popUp.isDisplayed()){
            WebElement popUpClose = driver.findElement(By.xpath("//div[@id='popup_info']//i"));
            popUpClose.click();
        }
        else {}
        By calculate = By.xpath("//li/a[@href='/delivery']");
        wait.until(visibilityOfElementLocated(calculate));
        WebElement calculatePage = driver.findElement(calculate);
        calculatePage.click();
        wait.until(titleIs("Вартість доставки - «Нова Пошта»| Доставка майбутнього"));
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
        priceValue.sendKeys(String.valueOf(p));
        WebElement weight = driver.findElement(By.xpath("//input[@name='DeliveryForm[optionsSeat][1][weight]']"));
        weight.sendKeys(String.valueOf(w));
        WebElement lenght = driver.findElement(By.xpath("//input[@name='DeliveryForm[optionsSeat][1][volumetricLength]']"));
        lenght.sendKeys(String.valueOf(l));
        WebElement width = driver.findElement(By.xpath("//input[@name='DeliveryForm[optionsSeat][1][volumetricWidth]']"));
        width.sendKeys(String.valueOf(he));
        WebElement height = driver.findElement(By.xpath("//input[@name='DeliveryForm[optionsSeat][1][volumetricHeight]']"));
        height.sendKeys(String.valueOf(we));
        WebElement sendButton = driver.findElement(By.xpath("//input[@value='Розрахувати вартість']"));
        sendButton.click();
        sendButton.click();
        wait.until(titleIs("Вартість доставки - «Нова Пошта»| Доставка майбутнього"));
        WebElement totalCost = driver.findElement(By.xpath("//h3[@class='final'][1]"));

        String text = totalCost.getText();
        assert text.contains(result);


    }
    @Test
    public void costExcluded() throws InterruptedException {
        driver.navigate().to("https://novaposhta.ua/");
        //wait.until(titleIs("Термінова і експрес доставка: транспортно-логістичні послуги в Києві та по всій Україні - служба доставки №1 «Нова пошта»"));
        WebElement popUp = driver.findElement(By.xpath("//img[@class='popup_info_img']"));
        if (popUp.isDisplayed()){
            WebElement popUpClose = driver.findElement(By.xpath("//div[@id='popup_info']//i"));
            popUpClose.click();
        }
        else {}
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