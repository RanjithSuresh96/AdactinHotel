package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass1;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Ranjith
 * @see Reporting
 *
 */
public class Reporting extends BaseClass1 {
	
	/**
	 * 
	 * @param jsonFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see generateJVMReports
	 */
	public static void generateJVMReports(String jsonFile) throws FileNotFoundException, IOException {
		
		File file = new File(getProjectPath()+getPropertyFileValue("jvmPath"));
		
		Configuration config = new Configuration(file, "OMRBranchAdactinAutomation");
		
		config.addClassifications("Browser Name", "Chrome");
		config.addClassifications("Browser Version", "107");
		config.addClassifications("Os Name", "win 7");
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, config);
		builder.generateReports();
	}
	

}
