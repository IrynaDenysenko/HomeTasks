package HomeTask1;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
       /* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));*/
    }

    @Test
    public void firstTest(){
        driver.get("https://google.com");
        /*WebElement userName = driver.findElement(By.name("WebLogin$UserName"));
        //wait.until(titleIs("MedAvante-ProPhase. A WIRB-Copernicus Group Company" ));
        userName.sendKeys("v_adm2@dev-ad.test");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Qwerty2@#");
        WebElement passwSwitcher = driver.findElement(By.id("passwSwitcher"));
        passwSwitcher.click();
        WebElement login = driver.findElement(By.name("WebLogin$Login"));
        login.click();
        boolean Logo = driver.findElement(By.id("logo")).isDisplayed();
         */
    }

    // private static ExpectedConditions getExpectedConditions() {
    //    return ExpectedConditions;
    //}

   // @Test
   // public void addUser(){
    //    driver.get("https://maportalqa3.medavante.net/");
     //   WebElement userName = driver.findElement(By.id("WebLogin_UserName"));
    //  userName.sendKeys("v_adm1@dev-ad.test");
    //    WebElement password = driver.findElement(By.id("Password"));
    //    password.sendKeys("Qwerty1!");
    //    WebElement passwSwitcher = driver.findElement(By.id("passwSwitcher"));
     //   passwSwitcher.click();
     //   driver.navigate().to("https://maportalqa3.medavante.net/raters/on-boarding");
    //    WebElement addButton = driver.findElement(By.xpath("//div[@title='Add Site Staff'']"));
     //   addButton.click();
    //    wait.until(titleIs("Add Site Staff"));
        //WebElement email = driver.findElement(By.cssSelector("input[type="email"]"));


   // }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
