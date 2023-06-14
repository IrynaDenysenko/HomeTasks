package HomeTask1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;



public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(300));
    }

    @Test
    public void firstTest(){
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


        //assertThat(text).contains("отримана");

        //String text = driver.findElement(By.className("Посилка отримана ").isDisplayed();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
