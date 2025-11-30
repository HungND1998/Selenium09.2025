package automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CommonBase {
    public static WebDriver driver;
    public WebDriver initChromeDriver(String URL) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();

        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false); // Disables the "save password" prompt
        chromePrefs.put("profile.password_manager_enabled", false); // Disables the password manager
        chromePrefs.put("profile.password_manager_leak_detection", false); // Disables the password leak detection warning
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get(URL);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver initFirefoxDriver(String URL) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        return driver;
    }

    public void closeDriver() {
        if (driver != null)
            driver.close();
    }
}
