package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import automation.pagelocator.LoginPage;
import automation.pagelocator.LogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Logout extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.CRM_URL);
    }

    @Test
    public void logoutSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.loginFunction("admin@gmail.com", "12345678");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Verify đăng nhập thành công - dùng wait thay vì findElement trực tiếp
        WebElement textQuanLyND = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Quản lý người dùng']"))
        );
        assertTrue(textQuanLyND.isDisplayed(), "Đăng nhập thất bại!");

        // Đợi toast notification biến mất (nếu có)
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-title")));
        } catch (Exception e) {
            // Không có toast hoặc đã biến mất
        }

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logoutFunction();

        WebElement loginTitle = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        assertTrue(loginTitle.isDisplayed(), "Đăng xuất thất bại - không quay về trang đăng nhập");
    }
}
