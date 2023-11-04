package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributerToSelenide {

    @Test
    void andreiSolntsevShouldBeTheFrisContributer(){
        Configuration.browserSize="1920x1080";
        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        //подвести мышку к первому аватару из блока Contributers
        $("div.Layout-sidebar").$(byText("Contributors"))
                 .closest("h2").sibling(0).$$("li").first().hover();
        // проверка: во всплывающем окне есть текст Andrei Solntsev
        $(".Popover-message").shouldHave(Condition.text("Andrei Solntsev"));

    }
}
