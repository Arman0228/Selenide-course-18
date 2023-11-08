package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class HomeTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl = "https://github.com";
        sleep(1000);
    }
    @Test
    void shouldFindJUnit5(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $$("[href=\"/selenide/selenide/wiki/SoftAssertions\"]").first().shouldHave(text("SoftAssertion"));
        $$("[href=\"/selenide/selenide/wiki/SoftAssertions\"]").first().click();
        $$("div.highlight").get(4).shouldHave(text("@ExtendWith({SoftAssertsExtension.class}) " +
                "class Tests { " +
                "  @Test " +
                "  void test() { " +
                "    Configuration.assertionMode = SOFT; " +
                "    open(\"page.html\"); " +
                " " +
                "    $(\"#first\").should(visible).click(); " +
                "    $(\"#second\").should(visible).click(); " +
                "  } " +
                "}"));
    }
}





