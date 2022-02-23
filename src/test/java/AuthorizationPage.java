import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class AuthorizationPage extends MainTest {

    @FindBy(xpath = "//*[@id='login-form-username']")
    private SelenideElement loginField;

    @FindBy(xpath = "//*[@id='login-form-password']")
    private SelenideElement passwordField;

    @FindBy(xpath = "//*[@id='login-form-submit']")
    private SelenideElement loginButton;

    public AuthorizationPage inputLoginAndPassword() {
        loginField.sendKeys(getLogin());
        loginField.pressTab();
        passwordField.sendKeys(getPassword());
        return page(AuthorizationPage.class);
    }

    public AuthorizationPage clickLoginButton() {
        loginButton.click();
        return page (AuthorizationPage.class);
    }

}
