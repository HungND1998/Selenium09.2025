package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BTVN12_DropdownList extends CommonBase {

    @Test
    public void BTVN12_DropdownList() {
        driver = initChromeDriver(CT_PageURL.GLOBALSQ_URL);
        Select dropCourse = new Select(driver.findElement(By.tagName("select")));
        int size = dropCourse.getOptions().size();
        System.out.println("Size is " + size);

        dropCourse.selectByVisibleText("Viet Nam");
        String vietNam = dropCourse.getFirstSelectedOption().getText();
        System.out.println("Text sau khi chọn Viet Nam: " + vietNam);
    }

    @Test
    public void Single_Dropdown_Auto() {
        driver = initChromeDriver(CT_PageURL.GITHUB_URL);
        Select select = new Select(driver.findElement(By.id("job1")));

        select.selectByVisibleText("Automation Testing");
    }

    @Test
    public void Single_Dropdown_Manual() {
        driver = initChromeDriver(CT_PageURL.GITHUB_URL);
        Select select = new Select(driver.findElement(By.id("job1")));

        select.selectByVisibleText("Manual Testing");
    }
}
