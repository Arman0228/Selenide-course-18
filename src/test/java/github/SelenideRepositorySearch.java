package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        //Открыть главную страницу
        open("https://github.com/");
        //ввести в поле поиска selenide и нажать Enter
        $(".header-search-button > .flex-1").click();
        $("#query-builder-test").val("Selenide").pressEnter();
        //кликнуть на первый репозиторий из списка найденных
        $$(".search-title").first().click();
        //проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));
        sleep(5000);



    }
}

