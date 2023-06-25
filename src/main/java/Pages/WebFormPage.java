package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.PropertiesFactory.getProperty;


public class WebFormPage extends BasePage {
    public WebFormPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Open Start Url
     */
    public void openUrlPage() {
        driver.get(getProperty("web_form_url"));
    }

    /**
     * Find element LOGO in the page
     */
    @FindBy(xpath = "//header/div[2]/a[1]/img[1]")
    private WebElement logoButton;

    public WebElement getLogoButton() {
        return logoButton;
    }

    /***
     *Find element cataloger Sale
     */
    @FindBy(css = "#ui-id-8")
    private WebElement sale;

    public WebElement getSale() {
        return sale;
    }

    /***
     *Adding a product to the cart
     */
    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    public WebElement getAddToCart() {
        return addToCart;
    }

    /***
     *Search shoppingCart
     */
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    private WebElement shoppingCart;

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    /***
     *Removing all items from the cart
     */
    @FindBy(xpath = "//a[@class='action action-delete']")
    private WebElement removeCart;

    public WebElement getRemoveCart() {
        return removeCart;
    }


    /***
     *Find element Create an Account
     */
    @FindBy(xpath = "(//a[text()='Create an Account'])[1]")
    private WebElement createAnAccount;

    public WebElement getCreateAnAccount() {
        return createAnAccount;
    }


}
