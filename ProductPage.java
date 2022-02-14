package reusable.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.*;

public class ProductPage extends  InitiateDriver {
    public static void elements_list(){
        List<WebElement> list_of_products = driver.findElements(By.xpath(properties.getProperty("xpath_for_product")));
        List<WebElement> list_of_products_price = driver.findElements(By.xpath(properties.getProperty("xpath_for_price")));
        for(WebElement element:list_of_products){
            System.out.println("Product name:-"+element.getText());
        }
        for(WebElement element:list_of_products_price){
            System.out.println("Product price:-"+element.getText());
        }

        String product_name;
        String product_price;
        int amazon_product_price;
        HashMap<Integer, String> map_final_products = new HashMap<>();
        for(int i=0;i<list_of_products.size();i++) {
            product_name = list_of_products.get(i).getText();
            product_price = list_of_products_price.get(i).getText();
            product_price = product_price.replaceAll("[^0-9]", "");
            amazon_product_price = Integer.parseInt(product_price);
            map_final_products.put(amazon_product_price,product_name);
        }
        Reporter.log("Product Name and price fetched from UI and saved in HashMap as:" + map_final_products.toString()+ "<br>",true);
        Set<Integer> allkeys = map_final_products.keySet();
        ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
        Collections.sort(array_list_values_product_prices);
        int low_price = array_list_values_product_prices.get(0);
        Reporter.log("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price),true);
    }
}
