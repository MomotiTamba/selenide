package classwork.selenide.advanceinteractions;


import com.codeborne.selenide.SelenideElement;
import classwork.selenide.core.SelenideTestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class DropDownAndIFrameTest extends SelenideTestBase {

    private String dropDownPage = "http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select";

    @Test
    public void testDropDownAndIFrame() {
        open(dropDownPage);
        String volvo = "Volvo";
        switchTo().frame("iframeResult");
        SelenideElement cars = $(By.xpath("html/body/select"));
        cars.selectOption(volvo);
        cars.getSelectedOption().shouldHave(text(volvo));
    }
}
