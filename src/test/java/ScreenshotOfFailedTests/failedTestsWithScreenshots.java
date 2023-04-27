package ScreenshotOfFailedTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class failedTestsWithScreenshots {

    WebDriver driver;
    By simpleForm_link = By.linkText("Simple Form Demo");
    By messageField = By.xpath("//p[text()='Enter Message']//following-sibling::input");
    By getCheckedValueButton = By.id("showInput");
    By showMessageField = By.id("message");

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");

    }

    @Test
    public void testSimpleFormDemo() {
        driver.findElement(simpleForm_link).click();
        driver.findElement(messageField).sendKeys("Test Automation is Great!");
        driver.findElement(getCheckedValueButton).click();

        String actualMessage = driver.findElement(showMessageField).getText();

        Assert.assertEquals(actualMessage, "Test Automation is Great!!!"
                        , "Message is not correct");

    }


    @AfterMethod
    public void takeScreenshotForFailures(ITestResult testResult) {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshot/" + testResult.getName() + ".png");

            try {
                FileHandler.copy(source,destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
