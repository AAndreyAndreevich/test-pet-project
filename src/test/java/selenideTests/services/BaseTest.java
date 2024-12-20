package selenideTests.services;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract public class BaseTest {

    private static final WebDriverManager driver = WebDriverManager.chromedriver();

    public void setUp() {
        driver.setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1400x1000";
        Configuration.headless = false;
    }

    @BeforeEach
    public void init() {
        setUp();
    }
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}