import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static PageObject.PageSteps.AuthorizationSteps.*;
import static PageObject.PageSteps.MainSteps.*;
import static PageObject.PageSteps.TaskSteps.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MainTest {

    private String dashboardUrl = "https://edujira.ifellow.ru/secure/Dashboard.jspa";


    @BeforeAll
    static void beforeTest() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/Users/sorokin/IdeaProjects/lesson_03/src/test/resources/chromedriver2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterAll
    static void afterTest() {
        closeWebDriver();
    }

    @Test
    public void Test1() {
        openUrl("https://edujira.ifellow.ru/login.jsp");
        autorisation("sorNikolai");
        isOpened();
        goToProjectPage();
        compareTasks();
    }

    @Test
    public void Test2() {
        openUrl("https://edujira.ifellow.ru/login.jsp");
        autorisation("sorNikolai");
        isOpened();
        createAndGoToTask();
        inProgress();
        done();
        statusIs("ГОТОВО");
    }

}
