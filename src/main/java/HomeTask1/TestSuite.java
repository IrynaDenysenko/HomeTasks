package HomeTask1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class TestSuite {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeSuite
    public void beforeSuite() throws  InterruptedException{
        System.out.print("1  before Suite");
    }
    @BeforeGroups
    public void beforeGroups() throws  InterruptedException{
        System.out.print("2  before Group");
    }
    @BeforeClass
    public void beforeClass() throws  InterruptedException{
        System.out.print("3  before Class");
    }

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(300));
    }
    @BeforeMethod
    public void beforeGroup() throws  InterruptedException{
        System.out.print("5  before Method");
    }
    @Test
    public void searchParcel(){
        driver.navigate().to("https://novaposhta.ua/");
        WebElement number = driver.findElement(By.id("cargo_number"));
        WebElement popUp = driver.findElement(By.xpath("//img[@class='popup_info_img']"));
        if (popUp.isDisplayed()){
            WebElement popUpClose = driver.findElement(By.xpath("//div[@id='popup_info']//i"));
            popUpClose.click();
        }
        else {};
        number.sendKeys("20400304107084");
        WebElement submit = driver.findElement(By.xpath("//form[@action='/tracking/']/input[@type='submit']"));
        submit.click();
        wait.until(titleIs("Керуйте доставкою посилок Нової пошти"));
        String text = driver.findElement(By.className("header__status-text")).getText();
        assert(text).contains("отримана");
    }

    @Test
    public void costCalculate() throws InterruptedException {
        driver.navigate().to("https://novaposhta.ua/");
        WebElement popUp = driver.findElement(By.xpath("//img[@class='popup_info_img']"));
        if (popUp.isDisplayed()){
            WebElement popUpClose = driver.findElement(By.xpath("//div[@id='popup_info']//i"));
            popUpClose.click();
        }
        else {};
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
    @Test
    public void searchOffice() throws InterruptedException {
        driver.navigate().to("https://novaposhta.ua/");
        WebElement popUp = driver.findElement(By.xpath("//img[@class='popup_info_img']"));
        if (popUp.isDisplayed()){
            WebElement popUpClose = driver.findElement(By.xpath("//div[@id='popup_info']//i"));
            popUpClose.click();
        }
        else {};
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
        By officeSelector = By.xpath("//a[@href='/office/view/id/86/city/Харків']");
        WebElement officeNumber = driver.findElement(officeSelector);
        officeNumber.click();
        wait.until(titleIs("Харків | Відділення №86 | «Нова пошта»"));
        String text = driver.findElement(By.xpath("//h2[@class='officePageTitle']/../p[1]")).getText();
        assert(text).contains("вул. Гвардійців-Широнінців, 62");


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

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
