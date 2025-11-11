package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day12_Dropdownlist extends CommonBase {

    @Test
    public void selectDropdownlist() {
        driver = initChromeDriver(CT_PageURL.CODESTART_URL);
        Select dropCourse = new Select(driver.findElement(By.id("product_categories_filter")));
        // Kiểm tra size
        int size = dropCourse.getOptions().size();
        System.out.println("Size is " + size);

        //chon aws theo cách 1
        dropCourse.selectByVisibleText("AWS");
        String aws = dropCourse.getFirstSelectedOption().getText();
        System.out.println("Text sau khi chọn AWS: " + aws);

        // chọn lập trình web theo cách 2
        //dropCourse.selectByValue("https://codestar.vn/product-category/lap-trinh-web/");
        dropCourse.selectByIndex(3);
        String laptrinhWeb = dropCourse.getFirstSelectedOption().getText();
        System.err.println("Text sau khi chọn lập trinh web: " + laptrinhWeb);
    }
}
