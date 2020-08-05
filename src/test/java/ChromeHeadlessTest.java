import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class ChromeHeadlessTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("window-size=1920,1080"); // Workaround to avoid the failure: element not interactable
        driver = new ChromeDriver(options);
    }

    @After
    public void teardown() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://google.com");
        assertEquals("Google", driver.getTitle());
    }

}
