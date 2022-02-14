package reusable.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchPage extends InitiateDriver {

    public static void validate_search_box() throws InterruptedException {
        WebElement searchbx = driver.findElement(By.xpath(properties.getProperty("search")));
        Assert.assertEquals(searchbx.isDisplayed(), true);
        Reporter.log("Search Box is displayed." + "<br>", true);
        Thread.sleep(2000);
        searchbx.sendKeys(properties.getProperty("s_search_string"));
        driver.findElement(By.xpath(properties.getProperty("clickButton"))).click();
        Reporter.log("Search Box set with value :" + properties.getProperty("s_search_string") + " and search results displayed" + "<br>", true);

    }
}
