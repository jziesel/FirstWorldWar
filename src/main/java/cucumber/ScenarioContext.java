package cucumber;

import enums.Context;

import java.util.HashMap;
import java.util.Map;

/*
  NOTE: 'ScenarioContext' is different from io.cucumber.java.Scenario class
  This class is for sharing data between TestSteps, the other class is for
  Hooks with Cucumber annotation tags ( @ ) - see Hooks.java for an example
*/
public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }

}
