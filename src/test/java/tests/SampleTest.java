package tests;

import com.codeborne.selenide.*;
import config.AllureListener;
import config.ConfigLoader;
import config.RetryAnalyzer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Listeners(AllureListener.class)
public class SampleTest {

    @BeforeClass
    public void setup() {
        Configuration.browser = ConfigLoader.getConfig().browser;
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void googleTest() {
        open("https://www.google.com");
        $("[name='q']").setValue("Selenide").pressEnter();
        $$("#search .g").first().shouldBe(visible);
    }
}
