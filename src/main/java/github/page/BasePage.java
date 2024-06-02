package github.page;

import github.page.instance.Driver;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    private final WebDriver driver = Driver.getInstance();

    public WebDriver getDriver() {
        return driver;
    }
}
