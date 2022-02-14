package reusable.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InitiateDriver extends Utility {
    static WebDriver driver;
    @BeforeTest
    public void openUrl() throws InterruptedException, IOException {
        properties = new Properties();
        String propPath = System.getProperty("user.dir") + "//src//test//java//reusable//com//inspect.properties";
        FileInputStream fileInputStream = new FileInputStream(propPath);
        properties.load(fileInputStream);

        Reporter.log("Test Amazon Search functionality started", true);
        String url = properties.getProperty("url_amazon");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
        Reporter.log("Chrome Invoked and navigated to URL: " + url + "<br>", true);
        String actual = driver.getTitle();
        String expected = "Amazon.com. Spend less. Smile more.";
        Assert.assertEquals(actual, expected);
        Reporter.log("Page Navigated." + "<br>", true);
    }

    @Test
   public static void main() throws InterruptedException {
        SearchPage searchPage=new SearchPage();
        searchPage.validate_search_box();
        ProductPage productPage=new ProductPage();
        productPage.elements_list();
    }

    @AfterTest
    public static void close(){
        driver.quit();
    }
}
