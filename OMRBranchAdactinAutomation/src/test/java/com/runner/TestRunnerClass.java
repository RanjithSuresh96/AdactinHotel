package com.runner;


import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * @author Ranjith
 * @see TestRunnerClass
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags=(""),dryRun=false,plugin= {"pretty","json:target\\output.json","rerun:src\\test\\resources\\faild.txt"},monochrome=true,features="src\\test\\resources",glue="com.stepDefinition")
public class TestRunnerClass extends BaseClass {
	
	@AfterClass
	public static void afterClass() throws Throwable, IOException {
		Reporting.generateJVMReports(getProjectPath()+getPropertyFileValue("jsonPath"));
		
	}
}
