package github.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.LocalDate;

public class GitHubJobUtil {
    public static final String EMAIL_KEY = "github.email";
    public static final String PASSWORD_KEY = "github.password";
    public static final String USERNAME_KEY = "github.username";
    public static final String START_URL = "https://github.com/settings/tokens";
    public static final int EXPIRATION_OPTION_INDEX = 2;
    public static final int DEFAULT_SCOPE_INDEX = 0;
    public static final int CLASSIC_TOKEN_INDEX = 1;
    private static final int DAY_MILLS = 86400000;
    public static final String TOKEN_PREFIX = "token_for_private_purpose";


    public static String generateTokenNote() {
        StringBuilder prefix = new StringBuilder(TOKEN_PREFIX);
        int suffixLength = 5, index = 0;
        while(index != suffixLength){
            int num = (int) (Math.random() * 5);
            prefix.append(num);
            index ++ ;
        }
    return prefix.toString();
    }

    public static void waitDay() throws InterruptedException {
        Thread.sleep(DAY_MILLS);
    }

    public static WebDriver getDriverWithOptions(Class<? extends WebDriver> driverClass) {
        WebDriver driver = null;
        if (driverClass.equals(EdgeDriver.class)) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless", "--remote-allow-origins=*");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);
        } else if (driverClass.equals(ChromeDriver.class)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (driverClass.equals(FirefoxDriver.class)) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless", "--remote-allow-origins=*");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        }
    return driver;
    }

    public static String getAccessLink(String token) {
        return ("https://token@github.com/" + PropertiesUtil.get(USERNAME_KEY)).replaceAll("(token)", token);
    }

    public static boolean tokenExpired(LocalDate expiryDate) {
        LocalDate currentDate = LocalDate.now();
        return expiryDate.minusDays(1).equals(currentDate) ||
                expiryDate.equals(currentDate) || expiryDate.isBefore(currentDate);
    }

}
