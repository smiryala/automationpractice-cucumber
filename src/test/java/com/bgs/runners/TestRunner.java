package com.bgs.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions( strict = true
				 ,features = {"src/test/java/features"}
				 ,plugin = {"html:Reports/cucumber-report",
						 	"json:Reports/cucumber-json/cucumber.json",
						    "com.cucumber.listener.ExtentCucumberFormatter:Reports/extentReport.html"
						    }
				 ,tags = {"@Tester"} //~@Ignore
				 ,monochrome = true
			     ,glue = {"com.bgs.stepDefs","com.framework.library"}

				)

public class TestRunner {

	 @AfterClass
	    public static void reportSetup() 
	 	{
	        Reporter.loadXMLConfig(new File("src/main/java/com/framework/library/extent-config.xml"));
	        
	        Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
	        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	        Reporter.setSystemInfo("64 Bit", 	"Windows 10");
	        Reporter.setSystemInfo("3.10.0", "Selenium");
	        Reporter.setSystemInfo("3.3.9", "Maven");
	        Reporter.setSystemInfo("1.8.0_66", "Java Version");
	        Reporter.setTestRunnerOutput("BGS Test Automation");
	 	}
	 
}