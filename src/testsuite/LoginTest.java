package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }
    /**
     * userSholdLoginSuccessfullyWithValid
     * Credentials
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “PRODUCTS”
     */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify the text Products
        String expectedOutput = "Products";
        String actualOutput = getTextFromElement(By.xpath("//span[@class='title']"));
        assertEqualsMethod("Error in products display",expectedOutput,actualOutput);

}

    /**
     * verifyThatSixProductsAreDisplayedOnPage
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify that six products are displayed
     * on page
     */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        System.out.println("Total products are : " + productList.size());
}
@After
//closing the browser
    public void setDown(){
        closeBrowser();
}
}

