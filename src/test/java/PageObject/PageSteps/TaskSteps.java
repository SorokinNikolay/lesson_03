package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static PageObject.PageElements.TaskElem.*;
import static com.codeborne.selenide.Selenide.$x;

public class TaskSteps extends MainSteps {

    @Step("Назначаем задаче статус \"В процессе\"")
    public static void inProgress() {
        $x(inProgressButton).click();
    }

    @Step("Назначаем задаче статус \"Готово\"")
    public static void done() {
        $x(businessProcessButton).click();
        $x(doneButton).click();
    }

    @Step("Проверяем, что статус задачи {stat}")
    public static void statusIs(String stat) {
        $x(status).shouldBe(Condition.text(stat));
    }
}
