package cucumber;

import io.cucumber.java.Scenario;
import managers.PageObjectManager;
import managers.WebDriverManager;

/*
 *  Class used by PicoContainer lib to share test state
 *  data between stepDefinition classes.
 */
public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    // we don't need FileManagerReader as it is a Singleton instance
    public ScenarioContext scenarioContext;

    // Begin Getter/Setter section
    // Used to work with run-time Cucumber Scenario object for the Hooks.java class
    public Scenario getScenario() {
        return m_scenario;
    }
    public void setScenario(Scenario scenario) {
        this.m_scenario = scenario;
    }
    private Scenario m_scenario;

    // Used to work with run-time Hooks class
    // Have to declare as Object as Hooks class is under Test Sources folders
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
        scenarioContext = new ScenarioContext();
    }

    // Getters for 'managers' for testContext objects to use, and for
    // ScenarioContext
    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }
    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
    public ScenarioContext getScenarioContext() { return scenarioContext; }
    // End Getter/Setter section

}