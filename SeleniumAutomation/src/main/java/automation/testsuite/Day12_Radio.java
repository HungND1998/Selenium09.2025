package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Day12_Radio extends CommonBase {
    @Test
    public void clickToRadio() {
        driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
        // kiểm tra giá trị mặc định isSelected là false
        WebElement maleRadio = driver.findElement(By.id("gender-radio-1"));
        WebElement feMaleRadio = driver.findElement(By.id("gender-radio-2"));
        WebElement otherRadio = driver.findElement(By.id("gender-radio-3"));

        boolean male = maleRadio.isSelected();
        // Mong đợi, xác nhận rằng male chưa được bấm = false
        assertFalse(male);
        // Mong đợi, xác nhận rằng female chưa được bấm = false
        assertFalse(feMaleRadio.isSelected());
        // Mong đợi, xác nhận rằng other chưa được bấm = false
        assertFalse(otherRadio.isSelected());
        WebElement femaleLabel = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", femaleLabel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", femaleLabel);



        //click Female
        feMaleRadio.click();
        assertTrue(feMaleRadio.isSelected());
    }
}
