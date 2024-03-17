package github.job;


import github.util.DateUtil;
import github.util.GitHubJobUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.LocalDate;
import java.util.List;


public class GitHubJob {
    private WebDriver driver;

    public GitHubJob(){}

    public void close() throws InterruptedException {
        this.driver.quit();
        this.driver = null;
        GitHubJobUtil.waitDay();
    }

    public GitHubJob init(Class<? extends WebDriver> driverClass) {
        this.driver = GitHubJobUtil.getDriverWithOptions(driverClass);
        return this;
    }

    private LocalDate getTokenExpirationDate() {
        List<WebElement> dates = this.driver.findElements(By.className("text-italic"));
        if (dates.isEmpty()) {
            return LocalDate.now();
        }
        String date = dates.get(0).getText();
        return DateUtil.parse(date);

    }
    public GitHubJob getPage() throws InterruptedException {
        this.driver.get(GitHubJobUtil.TOKEN_URL);
        this.driver.findElement(By.id("login_field")).sendKeys(GitHubJobUtil.EMAIL);
        this.driver.findElement(By.id("password")).sendKeys(GitHubJobUtil.PASSWORD);
        this.driver.findElement(By.className("js-sign-in-button")).click();
        Thread.sleep(3000);
        List<WebElement> btnLinks = this.driver.findElements(By.className("btn-link"));
        if (!btnLinks.isEmpty()) {
            WebElement dontAskBtn = btnLinks.get(1);
            dontAskBtn.click();
        }
        return this;
    }

    public GitHubJob generateTokenPage() {
        this.driver.findElement(By.className("select-menu-button")).click();
        List<WebElement> menuItems = this.driver.findElements(By.className("SelectMenu-item"));
        WebElement classicToken = menuItems.get(1);
        classicToken.click();
        return this;
    }

    public String generateToken() throws InterruptedException {
        Thread.sleep(3000);
        this.driver.findElement(By.id("oauth_access_description"))
                .sendKeys(GitHubJobUtil.generateTokenNote());
        List<WebElement> options = this.driver.findElements(By.tagName("option"));
        WebElement selectedOption = options.get(GitHubJobUtil.EXPIRATION_OPTION - 1);
        selectedOption.click();
        List<WebElement> inputs = this.driver.findElements(By.className("parent-checkbox-scope"));
        WebElement selectedInput = inputs.get(GitHubJobUtil.DEFAULT_SCOPE - 1);
        selectedInput.click();
        WebElement generateTokenButton = this.driver.findElement(By.xpath("//p//button[@class='btn-primary btn']"));
        generateTokenButton.click();
        String token = this.driver.findElement(By.id("new-oauth-token")).getText();
        this.driver.quit();
        return token;
    }

    public boolean tokenExpired() {
        LocalDate expirationDate = getTokenExpirationDate();
        LocalDate currentDate = LocalDate.now();
        return expirationDate.minusDays(1).equals(currentDate) ||
          expirationDate.equals(currentDate) || expirationDate.isBefore(currentDate);
    }

}
