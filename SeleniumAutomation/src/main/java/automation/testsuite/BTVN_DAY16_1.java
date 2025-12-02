package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BTVN_DAY16_1 extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.CRM_URL);
    }

    @Test
    public void loginSuccessfully() {
        type(By.name("email"), "admin@gmail.com");
        type(By.name("password"), "12345678");
        click(By.name("signin"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(text(),'Quản lý người dùng')]")
                )
        );
        assertTrue(dashboardHeader.isDisplayed(),
                "Login không thành công hoặc không chuyển sang Dashboard!");
    }

    @Test
    public void addKLVSuccessfully() {
        loginSuccessfully();
        click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
        click(By.xpath("//button[normalize-space()='Thêm mới']"));
        type(By.name("work_areas_code"), "KV1");
        type(By.name("name"), "Khuvuc1");
        click(By.xpath("//button[contains(normalize-space(),'Lưu')]"));
        click(By.xpath("//button[contains(normalize-space(),'Thêm')]"));
    }

    @Test
    public void deleteKLVSuccessfully() {
        loginSuccessfully();

        // Điều hướng đến trang Quản lý khu làm việc
        click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
        click(By.xpath("//a[@class='page-link' and normalize-space()='3']"));

        // Lấy tên của item cuối cùng để kiểm tra sau khi xóa
        WebElement lastItem = driver.findElement(By.xpath("(//tr/td[1])[last()]"));
        String deletedItemName = lastItem.getText();

        // Click nút Xóa
        click(By.xpath("(//a[contains(normalize-space(),'Xóa')])[last()]"));
        driver.switchTo().alert().accept();

        // Chờ item biến mất khỏi bảng
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean itemIsDeleted = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//td[normalize-space()='" + deletedItemName + "']")
        ));

        // Kiểm tra kết quả
        assertTrue(itemIsDeleted, "Item đáng lẽ phải bị xóa nhưng vẫn còn trong bảng.");
    }

}
