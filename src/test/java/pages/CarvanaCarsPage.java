package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaCarsPage {
    public CarvanaCarsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-test='HeaderFacets'] button")
    public List<WebElement> filterOptions;

    @FindBy(css = ".react-autosuggest__input")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(xpath = "//picture[@class='vehicle-image']")
    public List<WebElement> tileImg;

    @FindBy(css = "div[data-qa='base-favorite-vehicle']")
    public List<WebElement> tileFavorite;

    @FindBy(css = "div[data-qa='base-favorite-vehicle']")
    public List<WebElement> tileBody;

    @FindBy(css = ".inventory-type-variant")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[data-qa='make-model']")
    public List<WebElement> yearMakeModelInfo;

    @FindBy(css = ".trim-mileage")
    public List<WebElement> trimMileage;

    @FindBy(css = ".price")
    public List<WebElement> price;

    @FindBy(css = ".monthly-payment")
    public List<WebElement> monthlyPaymentInfo;

    @FindBy(css = ".down-payment")
    public List<WebElement> downPaymentInfo;

    @FindBy(css = ".base-delivery-chip")
    public List<WebElement> deliveryChip;

    @FindBy(css = ".close svg")
    public WebElement crossClose;
}
