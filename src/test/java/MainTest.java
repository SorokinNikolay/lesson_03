
import org.junit.jupiter.api.Test;

import static PageObject.PageSteps.AuthorizationSteps.*;
import static PageObject.PageSteps.MainSteps.*;
import static PageObject.PageSteps.TaskSteps.*;

public class MainTest {

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
