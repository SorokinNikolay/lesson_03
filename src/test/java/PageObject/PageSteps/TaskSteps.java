package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static PageObject.PageElements.TaskElem.*;
import static Settings.WebSettings.getScreenshoot;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.screenshot;

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

        screenshot("result.png");
        try {
            getScreenshoot("result.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
