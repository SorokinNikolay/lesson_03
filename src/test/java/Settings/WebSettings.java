package Settings;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WebSettings {

    @BeforeAll
    static void setDriver() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/src/test/resources/chromedriver2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @BeforeAll
    static void setAllure() {
        new AllureSelenide()
                .screenshots(true)
                .savePageSource(false);
    }

    @AfterAll
    static void closeDriver() {
        closeWebDriver();
    }

}
