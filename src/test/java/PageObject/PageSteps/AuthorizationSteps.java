package PageObject.PageSteps;


import io.qameta.allure.Step;

import static Utils.Configuration.getFromProperties;
import static PageObject.PageElements.AuthorizationElem.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationSteps {

    @Step("Открываем страницу по ссылке {url}")
    public static void openUrl(String url) {
        open(url);
    }

    @Step("Пробуем авторизоваться под логином {login}")
    public static void autorisation(String login) {
        $x(loginField).sendKeys(login);
        $x(loginField).pressTab();
        $x(passwordField).sendKeys(getFromProperties("jiraPassword"));
        $x(loginButton).click();
    }

}
