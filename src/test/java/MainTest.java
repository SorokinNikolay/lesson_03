
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static PageObject.PageSteps.AuthorizationSteps.*;
import static PageObject.PageSteps.MainSteps.*;
import static PageObject.PageSteps.TaskSteps.*;
import static Utils.Configuration.getFromProperties;

public class MainTest {

    @Test
    @Tag("Работа с Jira")
    @DisplayName("Проверка количества задач")
    public void Test1() {
        openUrl(getFromProperties("jiraAuthPage"));
        autorisation(getFromProperties("login"));
        isOpened();
        goToProjectPage();
        compareTasks();
    }

    @Test
    @Tag("Работа с Jira")
    @DisplayName("Проверка создания задачи и изменения её статусов")
    public void Test2() {
        openUrl(getFromProperties("jiraAuthPage"));
        autorisation(getFromProperties("login"));
        isOpened();
        createAndGoToTask();
        inProgress();
        done();
        statusIs("ГОТОВО");
    }

}
