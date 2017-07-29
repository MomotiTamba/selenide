package classwork.selenide.tests;

import static com.codeborne.selenide.CollectionCondition.size;

import classwork.selenide.core.SelenideTestBase;
import classwork.selenide.pages.google.GoogleSearchPage;
import classwork.selenide.pages.google.GoogleSearchResultPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@Features("Google search")
@Stories({"WEB-777"})
public class GoogleTest extends SelenideTestBase {

    private String google = "http://google.com/ncr";
    private String searchText = "selenide";

    @Title("Search for text on Google")
    @Test
    public void searchInGoogleTest() {
        open(google);
        $(By.name("q")).val(searchText).pressEnter();
        $(By.xpath(".//*[@id='rso']/div/div/div[1]/div/div/h3/a")).shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java")
                /*text("Selenide.org")*/);
        $$("#ires .g").shouldHave(size(10));
    }
}
