package github.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class GitHubJobUtil {
    public static final String EMAIL = getProperty("email");
    public static final String PASSWORD = getProperty("password");
    public static final String TOKEN_URL = "https://github.com/settings/tokens";
    public static final int EXPIRATION_OPTION = 3;
    public static final int DEFAULT_SCOPE = 1;
    private static final int DAY_MILLS = 86400000;

    private static Properties getApplicationProperties() throws IOException {
        String rootPath = Objects.requireNonNull(Thread.currentThread()
                .getContextClassLoader().getResource("")).getPath();
        String appConfigPath = rootPath + "application.properties";

        Properties properties = new Properties();
        properties.load(new FileInputStream(appConfigPath));
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
            options.addArguments("--headless");
            driver = new EdgeDriver(options);
        } else if (driverClass.equals(ChromeDriver.class)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (driverClass.equals(FirefoxDriver.class)) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }
    return driver;
    }
}
