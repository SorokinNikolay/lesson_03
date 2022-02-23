import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class TaskPage extends MainPage {

    @FindBy(xpath = "//*[@id='action_id_21']/span")
    private SelenideElement inProgressButton;

    @FindBy(xpath = "//*[@id='opsbar-transitions_more']/span")
    private SelenideElement businessProcessButton;

    @FindBy(xpath = "//*[@id='action_id_31']/span")
    private SelenideElement doneButton;

    @FindBy(xpath = "//*[@id='status-val']/span")
    private SelenideElement status;


    public TaskPage inProgress() {
        inProgressButton.click();
        return page(TaskPage.class);
    }

    public TaskPage done() {
        businessProcessButton.click();
        doneButton.click();
        return page(TaskPage.class);
    }

    public TaskPage statusIsDone() {
        status.shouldBe(Condition.text("ГОТОВО"));
        return page(TaskPage.class);
    }

}
