package Waits;

import com.google.common.base.Function;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicWaits {

    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        // To run other waits only use this code
//        driver.manage().window().maximize();
//        driver.get("https://www.lambdatest.com/selenium-playground/");


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testExplicitWait() {
        driver.findElement(By.linkText("Dynamic Data Loading")).click();
        driver.findElement(By.id("save")).click();

        By image = By.xpath("//div[@id='loading']//img");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));

        boolean isImageVisible = driver.findElement(image).isDisplayed();

        Assert.assertTrue(isImageVisible, "\n Image is not displayed");
    }

    @Test
    public void testFluentWait() {
         driver.findElement(By.linkText("JQuery Download Progress bars")).click();
         driver.findElement(By.id("downloadButton")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement progress = driver.findElement(By.xpath("//div[@class=\"progress-label\"]"));
                String progressLabel = progress.getText();

                if (progressLabel.equals("Complete!")) {
                    System.out.println("Progress is complete!");
                    return progress;
                } else {
                    System.out.println(progress.getText());
                    return null;
                }
            }
        });
    }

    @Test
    public void testImplicitWait() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        By helloWorld = By.xpath("//div[@id='finish']//h4");
        String actualText = driver.findElement(helloWorld).getText();

        Assert.assertEquals(actualText, "Hello World!");

    }
}
