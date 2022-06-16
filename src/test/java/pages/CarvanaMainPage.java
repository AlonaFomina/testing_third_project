package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaMainPage {
    public CarvanaMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper'] svg")
    public WebElement carvanaLogo;

    @FindBy (css = "div[aria-label='How It Works'] a")
    public WebElement howItsWorkDropDown;

    @FindBy(css = "div[data-qa='navigation-wrapper'] div[data-qa='menu-wrapper']")
    public List<WebElement> menuNavigatorBar;

    @FindBy(css = "a[role='button']")
    public WebElement singIn;

    @FindBy(id = "usernameField")
    public WebElement userNameEmailInputBox;

    @FindBy(css = "#passwordField")
    public WebElement userNamePasswordInputBox;

    @FindBy(css = "button[data-cv='sign-in-submit']")
    public WebElement singInButtonInSingInForm;

    @FindBy(css = ".AccountModalstyles__ErrorMessageContainer-sc-94oom3-7")
    public WebElement errorMessage;

    @FindBy(css = ".HeaderMenustyles__HeaderItems-ogb5qa-1.dewPuX > a:nth-of-type(1)")
    public WebElement searchCarsButton;

}
