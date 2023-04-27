package DataProviders;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTest {

    WebDriver driver;
    By nameField = By.id("title");
    By commentField = By.id("description");
    By submitButton = By.id("btn-submit");

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] ajaxData() {
        Object[][] data = new Object[2][2];

        data[0][0] = "Sherif Abdallah";
        data[0][1] = "Test Automation Engineer";

        data[1][0] = "Ali Ahmed";
        data[1][1] = "Web Developer";

        return data;
    }

//    @Test(dataProvider = "ajaxData")
//    public void testAjaxForm(String name, String comment) {
//        System.out.println("Name: " + name);
//        System.out.println("Comment: " + comment);
////        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
//        driver.findElement(nameField).sendKeys(name);
//        driver.findElement(commentField).sendKeys(comment);
//        driver.findElement(submitButton).click();
//
//    }

    @Test(dataProviderClass = DataProviderOnly.class, dataProvider = "input-provider")
    public void testAjaxForm(String name, String comment, int salary) {
        System.out.println("Name: "    + name);
        System.out.println("Comment: " + comment);
        System.out.println("Salary: "  + salary);

        driver.findElement(nameField).sendKeys(name + " " + salary);
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(submitButton).click();

    }
}
