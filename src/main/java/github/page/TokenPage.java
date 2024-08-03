package github.page;

import github.page.element.Button;
import github.page.element.Options;
import github.page.element.Paragraph;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TokenPage extends BasePage {
    WebDriver driver = super.getDriver();
    private static boolean tokenGenerated;
    public final Button selectTokenBtn = new Button(this.driver.findElement(By.className("select-menu-button")));
    public final Options tokenVariants = new Options( this.driver.findElements(By.className("SelectMenu-item")));
    public final Paragraph tokenDescription = new Paragraph(this.driver.findElement(By.xpath("//span[@class='token-description'][1]")));
    public final Paragraph tokenExpiry = new Paragraph(this.driver.findElement(By.xpath("//span[@class='text-semibold text-italic'][1]")));
    public Paragraph newToken;

    public TokenPage() {
        if(tokenGenerated) {
           this.newToken = new Paragraph(this.driver.findElement(By.id("new-oauth-token")));
        }
    }

    public TokenPage generated() {
        tokenGenerated = true;
        return new TokenPage();
    }
}
