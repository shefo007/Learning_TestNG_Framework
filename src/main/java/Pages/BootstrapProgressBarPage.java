package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapProgressBarPage extends BasePage {

    private final By startDownloadButton = By.id("dwnBtn");
    private final By progressBarPercentage = By.cssSelector(".counter");
    private final By completeMessage = By.xpath("//p[contains(@class,'success')]");


    public void clickStartDownloadButton() {
        click(startDownloadButton);
    }

    public String getProgressBarPercentage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeMessage));


        return getText(progressBarPercentage);
    }

    public String getCompletedMessage() {

        return getText(completeMessage);
    }

}
