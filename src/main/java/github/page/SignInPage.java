package github.page;

import github.page.element.Button;
import github.page.element.InputLine;
import github.page.instance.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    WebDriver driver = Driver.getInstance();

    public InputLine email = new InputLine(this.driver.findElement(By.id("login_field")));;
    public InputLine password = new InputLine(this.driver.findElement(By.id("password")));;
    public Button signInBtn = new Button(this.driver.findElement(By.className("js-sign-in-button")));;

}
