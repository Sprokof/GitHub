package github.page;

import github.page.element.Button;
import github.page.element.InputLine;
import github.page.instance.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    WebDriver driver = Driver.getInstance();

    public final InputLine email = new InputLine(this.driver.findElement(By.id("login_field")));
    public final InputLine password = new InputLine(this.driver.findElement(By.id("password")));
    public final Button signInBtn = new Button(this.driver.findElement(By.className("js-sign-in-button")));
    public Button dontAskBtn;

    public SignInPage() {
        try {
            this.dontAskBtn = new Button(this.driver.findElement(By.xpath("//input[@class='btn-link']")));
        }
        catch (Exception ignore) {
            this.dontAskBtn = new Button();
        }

    }

}
