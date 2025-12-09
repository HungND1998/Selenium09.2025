package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import automation.pagelocator.Day17_GuruPopup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Set;

public class Day17_HandleIframe extends CommonBase {
    @BeforeMethod
    @Parameters("browser") //browser là name của parameter trong testNG
    public void openWebPage(@Optional("firefox") String browserSetup) {
//        driver = initFirefoxDriver(CT_PageURL.CRM_URL);
        setupDriver(browserSetup);
        driver.get(CT_PageURL.CODESTART2_URL);
    }

    @Test
    public void dangKyTuVan_NotSuccessfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int sizeIframe = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Số lượng iframe là: " + sizeIframe);
        scrollToElement(By.xpath("//h2[text()='Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp về AWS/Kiểm thử/Lập trình web']"));
        driver.switchTo().frame(0);
        type(By.id("name"), "Test name");
        type(By.id("phone_number"), "0374849498");
        type(By.id("email"), "testEmail@gmail.com");
        Assert.assertTrue(isDisplay_fluent(By.id("name")));
    }

    @Test
    public void followFacebook() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("số lượng iframe là: " + size);
        scrollToElement(By.xpath("//p[text()='Về chúng tôi']"));
        driver.switchTo().frame(3);
        String firstWindow = driver.getWindowHandle();
        click(By.xpath("//a[text()='Theo dõi Trang']"));
        // Mở ra tab window mới, lấy lại currentUrl rồi assert
        Set<String> windows = driver.getWindowHandles();
        for (String childWindow : windows) {
            if (!childWindow.equals(firstWindow)) {
                driver.switchTo().window(childWindow);
                Thread.sleep(5000);
                String actualUrl = driver.getCurrentUrl();
                System.out.println("trang url: " + actualUrl);
                Assert.assertEquals(actualUrl, "https://www.facebook.com/CodeStarAcademy/?ref=embed_page");
                driver.close();
            }
        }
        driver.switchTo().window(firstWindow);
    }

    @AfterMethod
    public void closeDriver() {
        closeDriver();
    }
}
