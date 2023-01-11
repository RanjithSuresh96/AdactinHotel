package com.runner;



import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass1;
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
@CucumberOptions(tags=("@Login or @StateId or @CityId or @Address or @SearchProduct or @ProfilePic"),dryRun=false,plugin= {"pretty","json:target\\output.json","rerun:src\\test\\resources\\faild.txt"},monochrome=true,features="src\\test\\resources",glue="com.stepdefinition")
public class TestRunnerClass extends BaseClass1 {
	
	@AfterClass
	public static void afterClass() throws Throwable, IOException {
		Reporting.generateJVMReports(getProjectPath()+getPropertyFileValue("jsonPath"));
		
	}
}
