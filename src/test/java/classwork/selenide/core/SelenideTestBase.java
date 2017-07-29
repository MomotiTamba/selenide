package classwork.selenide.core;


import classwork.selenium.core.TestListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import static classwork.selenide.util.PropertiesCache.getProperty;

@Listeners({classwork.selenide.core.TestListener.class})
public class SelenideTestBase {

    private String browser = System.getProperty("browser", "chrome");

    @BeforeClass
    public void setUp() {
        switch (browser) {
            case WebDriverRunner.CHROME:
                ChromeDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.OPERA:
                OperaDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.INTERNET_EXPLORER:
                InternetExplorerDriverManager.getInstance().setup();
                break;
        }
        Configuration.browser = browser;
        Configuration.reportsFolder = getProperty("screenshot.folder");
    }
}
