package Pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By bootstrapProgressBarLink = By.linkText("Bootstrap Progress bar");

    public BootstrapProgressBarPage clickBootstrapProgressBar() {
        click(bootstrapProgressBarLink);
        return new BootstrapProgressBarPage();
    }
}
