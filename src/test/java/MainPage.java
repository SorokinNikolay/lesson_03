import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends MainTest {

    @FindBy(xpath = "//*[@id='browse_link']")
    private SelenideElement projectButton;

    @FindBy(xpath = "//*[@id='admin_main_proj_link_lnk']")
    private SelenideElement testProjectButton;

    @FindBy(xpath = "//*[@id='ghx-content-group']//div[@class='ghx-issue-count']")
    private SelenideElement problemValue;

    @FindBy(xpath = "//*[@id='content']//a[@class='aui-nav-item ']")
    private SelenideElement tasks;

    @FindBy(xpath = "//*[@id='create_link']")
    private SelenideElement createButton;

    @FindBy(xpath = "//*[@id='summary']")
    private SelenideElement topic;

    @FindBy(xpath = "//*[@id='description']")
    private SelenideElement description;

    @FindBy(xpath = "//*[@id='create-issue-submit']")
    private SelenideElement createTaskButton;


    public static MainPage isOpened(String url) {
        Assert.assertEquals(WebDriverRunner.url(), url);
        return page(MainPage.class);
    }

    public MainPage goToProjectPage() {
        projectButton.click();
        testProjectButton.click();
        tasks.shouldHave(Condition.text("Список задач")).click();

        return page(MainPage.class);
    }

    public MainPage compareTasks() {

        int pval = Integer.parseInt(problemValue.text().split(" ")[0]);
        System.out.println("Количество задач в шапке проекта = " + pval);

        int xval = $$(By.xpath("//div[@class='ghx-issue-content']")).size();
        System.out.println("Количество заведённых задач = " + xval);

        Assert.assertEquals(pval, xval);
        return page(MainPage.class);
    }

    public TaskPage createAndGoToTask() {
        createButton.click();
        topic.setValue("Сорокин Николай");
        $(By.xpath("//*[@id='aui-uid-1']")).click();
        description.setValue("Тестовое описание");
        createTaskButton.click();

        $(By.xpath("//*[@id='aui-flag-container']//a")).click();
        return page(TaskPage.class);
    }

}
