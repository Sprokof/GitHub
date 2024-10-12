package github.page;

import github.page.element.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenerateTokenPage extends BasePage {
    WebDriver driver = super.getDriver();
    public final InputLine tokenNote = new InputLine(this.driver.findElement(By.xpath("//input[@class='form-control wide']")));
    public final Button openExpiryTermButton = new Button(this.driver.findElement(By.xpath("//button[@class='Button--secondary Button--medium Button']")));
    public final ListItem expiryTerm = new ListItem(this.driver.findElements(By.xpath("//li[@class='js-new-default-token-expiration-item ActionListItem']")));
    public final CheckBox scopes = new CheckBox(this.driver.findElements(By.xpath("//input[@class='js-checkbox-scope parent-checkbox-scope']")));
    public final Button generateButton = new Button(this.driver.findElement(By.xpath("//p//button[@type='submit']")));;

}
