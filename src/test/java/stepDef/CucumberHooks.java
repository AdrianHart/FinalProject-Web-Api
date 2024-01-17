package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BaseTest;

public class CucumberHooks extends BaseTest {
    @Before
    public void beforeTest() {
        getDriver();
    }
    @After
    public void afterclass() {
        quitDriver();
    }
}
