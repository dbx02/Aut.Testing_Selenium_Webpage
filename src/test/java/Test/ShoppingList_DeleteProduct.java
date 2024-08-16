package Test;

import Base.BaseTest;
import Help.HelpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.HasExtensions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ShoppingList_DeleteProduct extends BaseTest {
    public HelpMethod helpMethod;

    @Test
    public void deleteProduct(){
        helpMethod = new HelpMethod(driver);
        String expectedResult = "Modă, casă & beauty | Primark";
        helpMethod.validareHomepage(expectedResult);

        helpMethod.handleCookie();
        //First we add a product in shopping list
        WebElement searchBar = driver.findElement(By.xpath("//div[@class='SearchPanelDesktop-toolbar MuiBox-root css-0']/div[2]"));
        searchBar.click();

        WebElement fillinSearchBar = driver.findElement(By.id("search-field"));
        fillinSearchBar.sendKeys("bluza");
        fillinSearchBar.sendKeys(Keys.ENTER);

        helpMethod.handlePopup();
        helpMethod.scrollIntoViewAddList();

        List<WebElement> addtoListElement = driver.findElements(By.xpath("//div[@id='products-grid']//div"));
        addtoListElement.get(1).click();
        WebElement addtoList = driver.findElement(By.xpath("//div[@id='sales-panel-wrapper-header']/div/button"));
        addtoList.click();

        helpMethod.handlePopup();

         //then we open the  shopping list
        WebElement openShoppingList = driver.findElement(By.xpath("//div[@id='account-toolbar']/a[1]"));
        openShoppingList.click();

        helpMethod.handlePopup();
        helpMethod.scrollDown();

        //we delete the added item
        WebElement deleteButton = driver.findElement(By.xpath("//div[@class='ProductCard-description MuiBox-root css-0']/button"));
        deleteButton.click();

        helpMethod.assertDeleteItem();


    }



}
