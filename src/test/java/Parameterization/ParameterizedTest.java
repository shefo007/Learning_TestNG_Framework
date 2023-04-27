package Parameterization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterizedTest {

    WebDriver driver;
    By userName_Field = By.xpath("//div//input[@placeholder='Username']");
    By password_Field = By.xpath("//div//input[@placeholder='Password']");
    By loginButton = By.xpath("//div//button[@type='submit']");


    @Parameters({"URL", "browser"})
    @BeforeClass
    public void setUp(String url, String browser) {

        if (browser.equals("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @Test
    @Parameters({"Username", "Password"})
    public void loginTest(String username, String password) {
        find(userName_Field).sendKeys(username);
        find(password_Field).sendKeys(password);
        find(loginButton).click();
    }

    @AfterClass
    public void tearDown() {

    }

    private WebElement find(By locator) {
        return driver.findElement(locator);
    }
}
