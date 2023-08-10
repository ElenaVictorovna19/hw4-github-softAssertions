package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void softAssertionTest() {
        //Открыть страницу Selenide в Github
        open("/selenide/selenide");
        //Перейти в раздел Wiki
        $("#wiki-tab").click();
        //Проверка, что в списке Pages есть страница SoftAssertions
        $(".wiki-more-pages-link").$("[type=button]").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        //Открыть SoftAssertions
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        //Проверить, что на странице есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
