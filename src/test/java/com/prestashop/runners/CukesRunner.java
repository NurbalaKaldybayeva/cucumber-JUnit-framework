package com.prestashop.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//plugin creates 
		plugin={"pretty", //
				"html:target/default-cucmber-reports", //generates html reports
				"json:target/cucumber.json" //sorts reports json type(Cucumber.json)
		},        //option to create a json report
		tags="@temp",
		features="src/test/resources/com/prestashop/features", 
		glue="com/prestashop/step_definitions"
	//	,dryRun = true
		)
public class CukesRunner {
	
}
