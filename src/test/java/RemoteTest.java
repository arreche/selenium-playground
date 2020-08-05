import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class RemoteTest {

    private WebDriver driver;

    @Before
    public void setupTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    @After
    public void teardown() {
        if (driver != null)
            driver.quit();
    }

    @Ignore
    @Test
    public void test() {
        driver.get("https://google.com");
        assertTrue(driver.getTitle().equals("Google"));
    }

}
