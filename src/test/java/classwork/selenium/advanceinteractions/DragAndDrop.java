package classwork.selenium.advanceinteractions;

import classwork.selenium.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop extends WebDriverTestBase {

    @Test
    public void testDragDrop() throws InterruptedException {
        webDriver.get("https://gojs.net/latest/samples/htmlDragDrop.html?gclid=CLjWnLeG5tQCFUeVGwodCowEcA");
        WebElement from = webDriver.findElement(By.xpath(".//*[@id='sample']/div[1]/span[1]/div/div[1]"));
        WebElement to = webDriver.findElement(By.xpath(".//*[@id='myDiagramDiv']/canvas"));
        Actions builder = new Actions(webDriver);
        builder.dragAndDrop(from, to).build().perform();
        from.getAttribute("src").equals("img_logo.gif");
    }
}
