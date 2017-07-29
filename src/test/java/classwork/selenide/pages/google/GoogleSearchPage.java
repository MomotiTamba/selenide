package classwork.selenide.pages.google;


import com.codeborne.selenide.SelenideElement;
import classwork.selenide.core.AbstractPage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchPage extends AbstractPage {

    private SelenideElement search = $(By.name("q"));
    private String googleSearchBtn = "_fZl";

    @Step("Search for {0} text")
    public GoogleSearchPage searchFor(String searchText){
        search.val(searchText);
        jsClick(googleSearchBtn, "id");
        return this;
    }
}
