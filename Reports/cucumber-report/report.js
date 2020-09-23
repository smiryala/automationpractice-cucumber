$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AnonymousUser.feature");
formatter.feature({
  "line": 1,
  "name": "Anonymous User Functionality",
  "description": "",
  "id": "anonymous-user-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 7709913500,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Navigate to BGS Application",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonSteps.i_navigate_to_aviall()"
});
formatter.result({
  "duration": 5757762300,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "TC-11_Verify PDP is visible properly",
  "description": "",
  "id": "anonymous-user-functionality;tc-11-verify-pdp-is-visible-properly",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 43,
      "name": "@Regression"
    },
    {
      "line": 43,
      "name": "@Smoke"
    },
    {
      "line": 43,
      "name": "@Tester"
    }
  ]
});
formatter.step({
  "line": 46,
  "name": "I Search for the Product:",
  "rows": [
    {
      "cells": [
        "searchProduct",
        "@testdata.search.simpleProduct.hardgoodProduct"
      ],
      "line": 47
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 48,
  "name": "\u0027PLP\u0027 Page is Opened",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "I Click on First Product in PLP",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "\u0027PDP\u0027 Page is Opened",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "Verify PDP Page for NonConfigurable Products",
  "keyword": "Then "
});
formatter.step({
  "line": 52,
  "name": "I Search for the Product:",
  "rows": [
    {
      "cells": [
        "searchProduct",
        "@testdata.search.configProduct.searchProduct1"
      ],
      "line": 53
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 54,
  "name": "\u0027PLP\u0027 Page is Opened",
  "keyword": "Then "
});
formatter.step({
  "line": 55,
  "name": "I Click on First Product in PLP",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "\u0027PDP\u0027 Page is Opened",
  "keyword": "Then "
});
formatter.step({
  "line": 57,
  "name": "Verify PDP Page for Configurable Products",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeSteps.search_functionality(DataTable)"
});
formatter.result({
  "duration": 8037803400,
  "error_message": "java.lang.AssertionError: Not able to click on  search\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat com.framework.utility.CommonFunctions.click(CommonFunctions.java:462)\r\n\tat com.bgs.stepDefs.HomeSteps.search_functionality(HomeSteps.java:94)\r\n\tat ✽.When I Search for the Product:(AnonymousUser.feature:46)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u0027PLP\u0027",
      "offset": 0
    }
  ],
  "location": "CommonSteps.page_is_opened(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PLPSteps.i_click_on_first_product_in_PLP()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "\u0027PDP\u0027",
      "offset": 0
    }
  ],
  "location": "CommonSteps.page_is_opened(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PDPSteps.verify_PDP_page_for_non_configurable_products()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomeSteps.search_functionality(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "\u0027PLP\u0027",
      "offset": 0
    }
  ],
  "location": "CommonSteps.page_is_opened(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PLPSteps.i_click_on_first_product_in_PLP()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "\u0027PDP\u0027",
      "offset": 0
    }
  ],
  "location": "CommonSteps.page_is_opened(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PDPSteps.verify_PDP_page_for_configurable_products()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 5785700,
  "error_message": "org.assertj.core.api.SoftAssertionError: \r\nThe following assertion failed:\r\n1) Fail to Enter 10001455 in search\r\nat CommonFunctions.input(CommonFunctions.java:250)\r\n\r\n\tat org.assertj.core.api.AbstractSoftAssertions.throwsBestMultipleAssertionsError(AbstractSoftAssertions.java:198)\r\n\tat org.assertj.core.api.SoftAssertions.assertAll(SoftAssertions.java:131)\r\n\tat com.framework.library.Hooks.afterScenario(Hooks.java:117)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:206)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 560922700,
  "status": "passed"
});
});