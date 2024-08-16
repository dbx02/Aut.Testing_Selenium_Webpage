package Test;

import Base.BaseTest;
import Help.HelpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList_AddProduct extends BaseTest {
    public HelpMethod helpMethod;

    @Test
    public void addProductToShoppingList(){
        helpMethod = new HelpMethod(driver);
        String expectedResult = "Modă, casă & beauty | Primark";
        helpMethod.validareHomepage(expectedResult);

        helpMethod.handleCookie();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement searchBar = driver.findElement(By.xpath("//div[@class='SearchPanelDesktop-toolbar MuiBox-root css-0']/div[2]"));
        searchBar.click();

        //Search for the product and add it to the list
        WebElement fillinSearchBar = driver.findElement(By.id("search-field"));
        fillinSearchBar.sendKeys("bluza");
        fillinSearchBar.sendKeys(Keys.ENTER);

        helpMethod.handlePopup();
        helpMethod.scrollIntoViewAddList();


       List<WebElement> addtoListElement = driver.findElements(By.xpath("//div[@id='products-grid']//div"));
       addtoListElement.get(1).click();
       WebElement addtoList = driver.findElement(By.xpath("//div[@id='sales-panel-wrapper-header']/div/button"));
       addtoList.click();

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Verify if the product was added to shoppingList
       helpMethod.assertAddProduct();


    }


}
