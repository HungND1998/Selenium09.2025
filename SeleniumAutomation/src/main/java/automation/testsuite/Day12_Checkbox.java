package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Day12_Checkbox extends CommonBase {
    @BeforeMethod
    @Parameters("browser") //browser là name của parameter trong testNG
    public void openWebPage(@Optional("firefox") String browserSetup) {
//        driver = initFirefoxDriver(CT_PageURL.CRM_URL);
        setupDriver(browserSetup);
        driver.get(CT_PageURL.DEMOQA_URL);
    }
    @Test
    public void checkboxHandle() {
        //Case1: Kiểm tra giá trị mặc định theo yêu cầu requie,
        // vd vào trang web thì các checkbox chưa đc check
//        driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement readCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
        WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3"));
        // Mong đợi cả 3 checkbox đều chưa check theo requie
        boolean checkSport = sportCheckbox.isSelected();
        boolean checkReading = readCheckbox.isSelected();
        boolean checkMusic = musicCheckbox.isSelected();

        assertFalse(checkMusic);
        assertFalse(checkReading);
        assertFalse(checkSport);
    }

    @Test
    public void clickToCheckbox() {
        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement readCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
        WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportCheckbox);
        if (sportCheckbox.isSelected() == false) {
            driver.findElement(By.xpath("//label[text()='Sports']")).click();
//            sportCheckbox.click();
            assertTrue(sportCheckbox.isSelected());
        }
        if (readCheckbox.isSelected() == false) {
            driver.findElement(By.xpath("//label[text()='Reading']")).click();
//            readCheckbox.click();
            assertTrue(readCheckbox.isSelected());
        }
        if (musicCheckbox.isSelected() == false) {
            driver.findElement(By.xpath("//label[text()='Music']")).click();
//            musicCheckbox.click();
            assertTrue(musicCheckbox.isSelected());
        }
    }

    @AfterMethod
    public void closeDriver() {
        closeDriver();
    }
}
