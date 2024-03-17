package github.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.Properties;

public class GitHubJobUtil {
    public static final String EMAIL = getProperty("email");
    public static final String PASSWORD = getProperty("password");
    public static final String USERNAME = getProperty("username");
    public static final String TOKEN_URL = "https://github.com/settings/tokens";
    public static final int EXPIRATION_OPTION = 3;
    public static final int DEFAULT_SCOPE = 1;
    private static final int DAY_MILLS = 86400000;

    private static Properties getApplicationProperties() throws IOException {
        Properties properties = new Properties();
        try(var inputStream = GitHubJobUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    private static String getProperty(String key) {
        String property = null;
        try {
            property = getApplicationProperties().getProperty(key);
        } catch (IOException e) {
            System.out.println(e.getCause().getMessage());
        }
        return property;
    }

    public static String generateTokenNote() {
        StringBuilder prefix = new StringBuilder("Token");
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
            driver = new EdgeDriver(options);
        } else if (driverClass.equals(ChromeDriver.class)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (driverClass.equals(FirefoxDriver.class)) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless", "--remote-allow-origins=*");
            driver = new FirefoxDriver(options);
        }
    return driver;
    }
    public static String getAccessLink(String token) {
        //return "https://token@github.com/username";
        return ("https://token@github.com/" + USERNAME).replaceAll("(token)", token);
    }
}
