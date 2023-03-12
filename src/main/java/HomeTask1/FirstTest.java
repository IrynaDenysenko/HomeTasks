package HomeTask1;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.time.Duration;

public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void firstTest(){

        driver.get("https://maportalstg.medavante.net/");

        WebElement userName = driver.findElement(By.id("WebLogin_UserName"));
        userName.sendKeys("v_adm2");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Qwerty2@");
        WebElement login = driver.findElement(By.name("WebLogin$Login"));
        login.click();
        WebElement Logo = driver.findElement(By.id("logo"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
