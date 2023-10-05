package qa.guru.owner;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import qa.guru.owner.config.Locale;
import qa.guru.owner.config.WebDriverProvider;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    public void testGithub() {
        String title = driver.getTitle();

       // assertEquals("GitHub: Where the world builds software · GitHub", title);
        assertEquals("Ракета - цифровая платформа для организации командировок и управления расходами", title);
        $$(".t199__holder li").first().hover().shouldHave(text("Карьера")).shouldBe(visible);
        $("[href='/career']").click();
    }

    @Test
    public void testRaketa() {
        WebDriverRunner.setWebDriver(driver);
        //Selenide.open("https://raketa.world");
        //String title = driver.getTitle();
        // assertEquals("GitHub: Where the world builds software · GitHub", title);
        //assertEquals("Ракета - цифровая платформа для организации командировок и управления расходами", title);
        $(".box_lang").hover().find(byText(Locale.EN.getLanguage())).click();
        sleep(5000);
       // $(".box_lang").hover().shouldBe(text("en")).click();
        //$(".box_lang").hover();
        //$$(".t199__holder li").first().hover().shouldHave(text("Карьера")).shouldBe(visible);
        //$("[href='/career']").click();
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

}

