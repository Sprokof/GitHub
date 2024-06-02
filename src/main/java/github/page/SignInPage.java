package github.page;

import github.page.element.Button;
import github.page.element.InputLine;
import github.page.instance.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    WebDriver driver = Driver.getInstance();

    public InputLine email;
    public InputLine password;
    public Button signInBtn;
    public Button dontAskBtn;

    public SignInPage() {
        try {
            this.email = new InputLine(this.driver.findElement(By.id("login_field")));
            this.password = new InputLine(this.driver.findElement(By.id("password")));
            this.signInBtn = new Button(this.driver.findElement(By.className("js-sign-in-button")));
            this.dontAskBtn = new Button(this.driver.findElement(By.xpath("//input[@class='btn-link']")));
        } catch (Exception ignore) {
            dontAskBtn = new Button();
        }
    }

}
