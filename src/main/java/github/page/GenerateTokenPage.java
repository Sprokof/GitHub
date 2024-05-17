package github.page;

import github.page.element.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenerateTokenPage extends BasePage {
    WebDriver driver = super.getDriver();

    public final InputLine tokenNote = new InputLine(this.driver.findElement(By.id("oauth_access_description")));
    public final Options expiryTerm = new Options(this.driver.findElements(By.tagName("option")));
    public final CheckBox scopes = new CheckBox(this.driver.findElements(By.className("parent-checkbox-scope")));
    public final Button generateButton = new Button(this.driver.findElement(By.xpath("//p//button[@class='btn-primary btn']")));
    public final Paragraph newToken = new Paragraph(this.driver.findElement(By.id("new-oauth-token")));


}
