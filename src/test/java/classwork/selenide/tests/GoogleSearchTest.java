package classwork.selenide.tests;

import classwork.selenide.pages.google.GoogleSearchPage;
import classwork.selenide.pages.google.GoogleSearchResultPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.CollectionCondition.size;

public class GoogleSearchTest {

    private String google = "http://google.com/ncr";
    private String searchText = "selenide";

    @Title("Searches fot text on Google")
    @Test
    public void searchInGoogleWithPageObjectTest() {
        open(google);
        GoogleSearchPage googleSearch = new GoogleSearchPage();
        googleSearch.searchFor(searchText);
        GoogleSearchResultPage googleResult = new GoogleSearchResultPage();
        googleResult.getLinkResults()
                .shouldHave(size(10))
                .first()
                .shouldHave(text("Selenide"));
    }
}
