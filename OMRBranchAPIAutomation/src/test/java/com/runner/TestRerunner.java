package com.runner;

import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * @author Ranjith
 * @see TestRerunner
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="@src\\test\\resources\\faild.txt",glue="com.stepDefinition")
public class TestRerunner {
	
	
}
