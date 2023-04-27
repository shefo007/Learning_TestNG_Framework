package Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {


//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sheri\\IdeaProjects\\Complete_TestNG_Framework_Learning\\drivers\\chromedriver_112.0.5615.28.exe");

//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");
//        System.out.println(driver.getCurrentUrl());
//        Thread.sleep(1000);
//        driver.quit();

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com/");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title :"+pageTitle);
        Thread.sleep(1000);
        driver.quit();
    }
}
