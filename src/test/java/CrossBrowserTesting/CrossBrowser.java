package CrossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CrossBrowser {

    public WebDriver driver;
    private String username = "sheriftawaptawap";
    private String accessKey = "3Ur8NknrWNBfouiDxX4tkJl5rELKHWaypGjHese5H1wYcdcJA1";
    private String hub = "@hub.lambdatest.com/wd/hub";

    //Locators for first test
    private By dropDownLink = By.linkText("Select Dropdown List");
    private By selectDayList = By.id("select-demo");


    DesiredCapabilities caps = new DesiredCapabilities();

    @Parameters(value = {"Browser", "Version", "Platform"})
    @BeforeMethod
    public void setUp(String browser, String version, String platform) {

        caps.setCapability("build", "2.1");
        caps.setCapability("name", "Cross Browser Testing");
        caps.setCapability("browserName", browser);
        caps.setCapability("version", version);
        caps.setCapability("platform", platform);
        caps.setCapability("network", true);
        caps.setCapability("console", true);
        caps.setCapability("visual", true);

        try {
            driver = new RemoteWebDriver(new URL("https://" +
                    username + ":" + accessKey + hub), caps);
        } catch (MalformedURLException exc) {
            exc.printStackTrace();
        }

        driver.get("https://www.lambdatest.com/selenium-playground/");

    }

    @Test
    public void testDropDown() {
        driver.findElement(dropDownLink).click();
        WebElement findDropDown = driver.findElement(selectDayList);
        Select dayDropDown = new Select(findDropDown);
        dayDropDown.selectByVisibleText("Saturday");

    }

    @Test
    public void TestDragAndDrop() {
        driver.findElement(By.linkText("Drag and Drop")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
