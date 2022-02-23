
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MainTest {

    private String login = "sorNikolai";
    private String password = "123qaz!@#QAZ";

    private String dashboardUrl = "https://edujira.ifellow.ru/secure/Dashboard.jspa";

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @BeforeAll
    static void beforeTest() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/Users/sorokin/IdeaProjects/lesson_03/src/test/resources/chromedriver");
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
        Selenide.open("https://edujira.ifellow.ru/login.jsp", AuthorizationPage.class)
                .inputLoginAndPassword()
                .clickLoginButton();
        MainPage
                .isOpened(dashboardUrl)
                .goToProjectPage()
                .compareTasks();
    }

    @Test
    public void Test2() {
        Selenide.open("https://edujira.ifellow.ru/login.jsp", AuthorizationPage.class)
                .inputLoginAndPassword()
                .clickLoginButton();
        MainPage
                .isOpened(dashboardUrl)
                .createAndGoToTask()
                .inProgress()
                .done()
                .statusIsDone();
    }

}
