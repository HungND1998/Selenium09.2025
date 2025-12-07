package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Media_Mart_Iframe extends CommonBase {
    @BeforeMethod
    public void openMediaMartPage() {
        driver = initFirefoxDriver(CT_PageURL.MEDIA_MART_URL);
    }

//    @Test
//    public void chatZalo() {
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////        int sizeIframe = driver.findElements(By.tagName("iframe")).size();
////        System.out.println("Số lượng iframe là: " + sizeIframe);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement iconIframe = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//iframe[contains(@src, 'page.widget.zalo.me') and @width='60']")));
//        driver.switchTo().frame(iconIframe);
//        click(By.xpath("//html/body"));
//        driver.switchTo().defaultContent();
//        wait.until(driver -> driver.findElements(By.xpath("//iframe[contains(@src, 'page.widget.zalo.me')]")).size() > 1);
//        List<WebElement> zaloIframe = driver.findElements(By.xpath("//iframe[contains(@src, 'page.widget.zalo.me')]"));
//        System.out.println("Found zalo iframes: " + zaloIframe.size());
//        driver.switchTo().frame(zaloIframe.get(1));
//        Assert.assertTrue(isDisplay_fluent(By.xpath("//body")), "Màn hình chat zalo chưa hiển thị! ");
//        driver.switchTo().defaultContent();
//
//    }
@Test
public void chatZalo() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    // 1. Đợi icon Zalo đầu tiên xuất hiện
    WebElement iconIframe = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//iframe[contains(@src, 'page.widget.zalo.me') and @width='60']")));
    driver.switchTo().frame(iconIframe);
    // 2. Click vào icon Zalo
    click(By.xpath("//html/body"));
    driver.switchTo().defaultContent();

    // 3. Đợi iframe chat phóng to xuất hiện (iframe to có width >= 300)
    WebElement chatIframe = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//iframe[contains(@src,'page.widget.zalo.me') and @width>=300]")));

    driver.switchTo().frame(chatIframe);

    // 4. Verify body hiển thị
    Assert.assertTrue(
            isDisplay_fluent(By.xpath("//body")),
            "Màn hình chat zalo chưa hiển thị!"
    );

    driver.switchTo().defaultContent();
}

}
