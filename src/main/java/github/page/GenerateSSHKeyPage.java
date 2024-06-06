package github.page;

import github.page.element.Button;
import github.page.instance.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GenerateSSHKeyPage extends BasePage {
    WebDriver driver = Driver.getInstance();
    public Button dontAskBtn;

    public GenerateSSHKeyPage() {
        try {
            this.dontAskBtn = new Button(this.driver.findElement(By.xpath("//input[@class='btn-link']")));
        }
        catch (NoSuchElementException e) {
            this.dontAskBtn = new Button();
        }
    }

}
