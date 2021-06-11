package cucumber;

import io.cucumber.java.Scenario;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    // Used to work with Cucumber Scenario object
    public Scenario getScenario() {
        return m_scenario;
    }

    public void setScenario(Scenario scenario) {
        this.m_scenario = scenario;
    }

    private Scenario m_scenario;

    public Object getHooks() {
        return m_hooks;
    }

    public void setHooks(Object m_hooks) {
        this.m_hooks = m_hooks;
    }

    private Object m_hooks;

    //CStor
    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}