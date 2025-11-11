package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BTVN12_Radio extends CommonBase {

    @Test
    public void BTVN_Radio() {
        driver = initChromeDriver(CT_PageURL.RADIO_URL);

        WebElement underRadio = driver.findElement(By.id("under_18"));
        WebElement olderRadio = driver.findElement(By.id("over_18"));
        WebElement disableRadio = driver.findElement(By.id("radio-disabled"));

        underRadio.click();
        Assert.assertTrue(underRadio.isSelected());
        olderRadio.click();
        Assert.assertTrue(olderRadio.isSelected());
        Assert.assertFalse(disableRadio.isEnabled());
    }
}
