package com.base;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Ranjith
 * @Date 07-12-2022
 * @see To Maintain Reusable Methods
 *
 */
public class BaseClass1 {
	
	public static WebDriver driver;
	
	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws IOException
	 * @return void
	 * @see createCellInExcel
	 */
	public static void createCellInExcel(String sheetName, int rownum, int cellnum ,String data) throws IOException {
		
		
		File file = new File("C:\\Users\\AVLES\\eclipse-workspace\\Adactinhotel\\Excels\\test.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
	    Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		
	FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 * @return void
	 * @see updateCellData
	 */
	
	
	public static void updateCellData(String sheetName, int rownum, int cellnum, String oldData,String newData) throws IOException {
		
		File file = new File("C:\\Users\\AVLES\\eclipse-workspace\\Adactinhotel\\Excels\\test.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		if(value.equals(oldData)) {
			cell.setCellValue(newData);	
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	
	/**
	 * @param sheetName
	 * @throws IOException
	 * @return Object[][]
	 * @see readDataFromExcelUsingObject
	 */
	public static Object[][] readDataFromExcelUsingObject(String sheetName) throws IOException {
	
		String res="";
		
		File file = new File("C:\\Users\\AVLES\\eclipse-workspace\\Adactinhotel\\Excels\\test.xlsx");
	FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
			
				Cell cell = sheet.getRow(i).getCell(j);
				System.out.println(cell);
			CellType type=sheet.getRow(i).getCell(j).getCellType();
				switch(type) {
				case STRING:
					res= cell.getStringCellValue();
					break;
				
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
					  Date date = cell.getDateCellValue();	
					  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					  res = dateFormat.format(date);
					}
					else {
						double numericCellValue = cell.getNumericCellValue();
					
						long check = Math.round(numericCellValue);
						if(check==numericCellValue) {
							res = String.valueOf(check);
						}
						else {
						res = String.valueOf(numericCellValue);
						}
						
					}
					break;
					
					default:
						break;
				}
				data[i-1][j]=res;
			}
			
	}
		
		return data;
	}

	/**
	 * 
	 * @param sheetName
	 * @param rollnum
	 * @param cellnum
	 * @return String
	 * @throws IOException
	 * @see readDataFromExcel
	 */
	public static String readDataFromExcel(String sheetName,int rollnum,int cellnum) throws IOException {
		
		String res="";
		
		File file = new File("C:\\Users\\AVLES\\eclipse-workspace\\Adactinhotel\\Excels\\test.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rollnum);
	Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
				switch(type) {
				case STRING:
					res= cell.getStringCellValue();
					break;
				
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
					  Date date = cell.getDateCellValue();	
					  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					  res = dateFormat.format(date);
					}
					else {
						double numericCellValue = cell.getNumericCellValue();
						long check = Math.round(numericCellValue);
						if(check==numericCellValue) {
							res = String.valueOf(check);
						}
						else {
							res = String.valueOf(numericCellValue);
						}
						
					}
					break;
					
					default:
						break;
				}
		
		
		return res;
	}
	
	/**
	 * 
	 * @return String
	 * @see getProjectPath
	 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	
	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see getPropertyFileValue
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(getProjectPath()+"\\src\\test\\resources\\Config\\Config.properties"));
		Object object = p.get(key);
		String value = (String)object;
		return value;
	}
	
	/**
	 * 
	 * @param browser
	 * @see getDriver
	 */
	public static void getDriver(String browser) {
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			break;

		default:
			break;
		}
		
	}
	
	/**
	 * 
	 * @param url
	 * @see getPropertyFileValue
	 */
	public static void enterApplicationUrl(String url) {
		driver.get(url);
	}
	
	/**
	 * @see getPropertyFileValue
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 * @see setWindowSize
	 */
	public static void setWindowSize(int width , int height) {
		Dimension d = new Dimension(width, height);
		driver.manage().window().setSize(d);
	}
	
	/**
	 * 
	 * @param url
	 * @see oneToAnotherUrl
	 */
	public void oneToAnotherUrl(String url) {
		driver.navigate().to(url);
	}
	
	/**
	 * @see oneToAnotherUrl
	 */
	public void previousUrl() {
		driver.navigate().back();
	}
	
	/**
	 * @see forwardUrl
	 */
	public void forwardUrl() {
		driver.navigate().forward();
	}
	
	/**
	 * @see refresh
	 */
	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	/**
	 * 
	 * @param element
	 * @param data
	 * @see elementSendKeys
	 */
	public static void elementSendKeys(WebElement element , String data) {
		element.sendKeys(data);
	}
	
	/**
	 * 
	 * @param element
	 * @param data
	 * @param enter
	 * @see elementSendKeysUsingKeys
	 */
	public static void elementSendKeysUsingKeys(WebElement element , String data, Keys enter) {
		element.sendKeys(data,enter);
	}
	
	/**
	 * 
	 * @param element
	 * @param data
	 * @see elementSendKeysJs
	 */
	public void elementSendKeysJs(WebElement element , String data) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+ data +"')", element);
	}
	
	/**
	 * 
	 * @param element
	 * @see scrollDownJs
	 */
	public void scrollDownJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see verifyIsDisplayed
	 */
	public boolean verifyIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;

	}
	
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see verifyIsEnabled
	 */
	public boolean verifyIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see verifyIsSelected
	 */
	public boolean verifyIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
		
	}
	
	/**
	 * 
	 * @param element
	 * @see verifyIsSelected
	 */
	public void scrollUpJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	/**
	 * 
	 * @param element
	 * @see elementClickJs
	 */
	public void elementClickJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * 
	 * @return File
	 * @see takesScreenshot
	 */
	public File takesScreenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	
	/**
	 * 
	 * @return byte[][]
	 * @see screenshot
	 */
	public byte[] screenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}
	
	/**
	 * 
	 * @param element
	 * @param path
	 * @throws IOException
	 * @see takesScreenshotToElement
	 */
	public void takesScreenshotToElement(WebElement element, String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);
		
	}
	
	/**
	 * 
	 * @param element
	 * @see elementClick
	 */
	
	public static void elementClick(WebElement element) {
		element.click();	
	}
	
	/**
	 * 
	 * @param element
	 * @see elementClick
	 */
	public void elementClear(WebElement element) {
		element.clear();
	}
	
	/**
	 * 
	 * @return String
	 * @see getApplicationTitle
	 */
	public String getApplicationTitle() {
		 String title = driver.getTitle();
		return title;
	}
	
	/**
	 * 
	 * @param attributeValue
	 * @return WebElement
	 * @see findElementById
	 */
	public static WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	
	public static List<WebElement> findElementsMethod(String expressions ){
		List<WebElement> element = driver.findElements(By.xpath(expressions));
		return element;
	}
	
	/**
	 * 
	 * @param attributeValue
	 * @return WebElement
	 * @see findElementByName
	 */
	public static WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}
	
	/**
	 * 
	 * @param attributeValue
	 * @return WebElement
	 * @see findElementByClassName
	 */
	public static WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	
	/**
	 * 
	 * @param expressions
	 * @return WebElement
	 * @see findElementByXpath
	 */
	public static WebElement findElementByXpath(String expressions) {
		WebElement element = driver.findElement(By.xpath(expressions));
		return element;
	}
	
	/**
	 * 
	 * @return String
	 * @see getApplicationUrl
	 */
	public static String getApplicationUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	/**
	 * 
	 * @param element
	 * @return String
	 * @see elementGetText
	 */
	public static String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	/**
	 * @see closeWindow
	 */
	public void closeWindow() {
		driver.close();
	}
	
	/**
	 * @see closeAllWindow
	 */
	public static void closeAllWindow() {
		driver.quit();
	}
	
	/**
	 * 
	 * @param element
	 * @param attributeName
	 * @return String
	 * @see elementGetAttribute
	 */
	public static String elementGetAttribute(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
	
	/**
	 * 
	 * @param element
	 * @return String
	 * @see elementGetAttribute
	 */
	public static String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	
	/**
	 * 
	 * @param element
	 * @param text
	 * @see selectOptionByText
	 */
	
	public static void selectOptionByText(WebElement element,String text ) {
		Select s = new Select(element);
	    s.selectByVisibleText(text);
	}

	/**
	 * 
	 * @param element
	 * @param value
	 * @see selectOptionByAttribute
	 */
	public static void selectOptionByAttribute(WebElement element,String value ) {
		Select s = new Select(element);
	    s.selectByValue(value);
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 * @see selectOptionByIndex
	 */
	public void selectOptionByIndex(WebElement element, int index ) {
		Select s = new Select(element);
	    s.selectByIndex(index);
	}
	
	/**
	 * 
	 * @param element
	 * @param text
	 * @see deSelectOptionByText
	 */
	public void deSelectOptionByText(WebElement element,String text ) {
		Select s = new Select(element);
	    s.deselectByVisibleText(text);
	}
	
	/**
	 * 
	 * @param element
	 * @param value
	 * @see deSelectOptionByAttribute
	 */
	public void deSelectOptionByAttribute(WebElement element,String value ) {
		Select s = new Select(element);
	    s.deselectByValue(value);
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 * @see deSelectOptionByIndex
	 */
	public void deSelectOptionByIndex(WebElement element, int index ) {
		Select s = new Select(element);
	    s.deselectByIndex(index);
	}
	
	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @see getAllOptions
	 */
	public List<WebElement> getAllOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	} 
	
	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @see getAllSelectedOptions
	 */
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getAllSelectedOptions();
		return options;
	} 
	
	/**
	 * 
	 * @param element
	 * @return WebElement
	 * @see getFirstSelectedOption
	 */
	
	public WebElement getFirstSelectedOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}
	
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see isMultiple
	 */
	public boolean isMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;		
	}
	
	/**
	 * 
	 * @param element
	 * @see deSelectAll
	 */
	public void deSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}
	
	/**
	 * @see clickOkInAlert
	 */

	public static void clickOkInAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	/**
	 * @see clickCancelInAlert
	 */
	public void clickCancelInAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
	}
	
	/**
	 * 
	 * @param alert
	 * @return String
	 * @see getTextFromAlertBox
	 */
	public String getTextFromAlertBox(Alert alert) {
		String text = alert.getText();
		return text;
	}
	
	/**
	 * 
	 * @param attributeValue
	 * @see sendKeysUsingAlert
	 */
	
	public void sendKeysUsingAlert(String attributeValue) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(attributeValue);
		
	}
	
	/**
	 * 
	 * @param index
	 * @see frameByIndex
	 */
	
	public void frameByIndex(int index) {
	      driver.switchTo().frame(index);
	}
	
	/**
	 * 
	 * @param nameOrId
	 * @see frameByName
	 */
	public void frameByName(String nameOrId) {
	      driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * 
	 * @param element
	 * @see frameByName
	 */
	public void frameByName(WebElement element) {
	      driver.switchTo().frame(element);
	}
	
	/**
	 * 
	 * @param time
	 * @see implicitWait
	 */
	public static void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @param time
	 * @param expressions
	 * @see explicitWait
	 */
	public void explicitWait(int time , String expressions) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expressions)));
	}
	
	/**
	 * 
	 * @return String
	 * @see parentWindow
	 */
	public String parentWindow() {
		String parent = driver.getWindowHandle();
		return parent;
	}
	
	/**
	 * 
	 * @param element
	 * @see childWindow
	 */
	public void childWindow(String element) {
		driver.switchTo().window(element);
	}
		
	/**
	 * 
	 * @return Set<String>
	 * @see getAllWindows
	 */
	public Set<String> getAllWindows() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	
	/**
	 * 
	 * @param element
	 * @see mouseOverAction
	 */
	public void mouseOverAction(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * 
	 * @param element
	 * @see click
	 */
	public void click(WebElement element) {
		Actions a = new Actions(driver);
		a.click(element).perform();
	}
	
	/**
	 * 
	 * @param element
	 * @see doubleClick
	 */
	public void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * 
	 * @param element
	 * @see rightClick
	 */
	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param sourceElement
	 * @param targetElement
	 * @see dragAndDrop
	 */
	public void dragAndDrop(WebElement sourceElement ,WebElement targetElement) {
		Actions a = new Actions(driver);
		a.dragAndDrop(sourceElement, targetElement).perform();	
	}
	
	/**
	 * 
	 * @param sourceElement
	 * @param targetElement
	 * @see clickAndHold
	 */
	public void clickAndHold(WebElement sourceElement ,WebElement targetElement) {
		Actions a = new Actions(driver);
		a.clickAndHold(sourceElement).moveToElement(targetElement).release(targetElement).perform();
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 * @return WebElement
	 * @see toGetHeadingInTable
	 */
	public static WebElement toGetHeadingInTable(WebElement element,int index) {
		List<WebElement> findElements = element.findElements(By.tagName("th"));
		WebElement webElement = findElements.get(index);
		return webElement;
		
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 * @return WebElement
	 * @see toGetRowInTable
	 */
	public WebElement toGetRowInTable(WebElement element,int index) {
		List<WebElement> findElements = element.findElements(By.tagName("tr"));
		WebElement webElement = findElements.get(index);
		return webElement;
		
		
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 * @return WebElement
	 * @see toGetcolumnsInTable
	 */
	public WebElement toGetcolumnsInTable(WebElement element,int index) {
		List<WebElement> findElements = element.findElements(By.tagName("tr"));
		WebElement webElement = findElements.get(index);
		return webElement;
	}
	
	/**
	 * 
	 * @param index
	 * @param element
	 * @return WebElement
	 * @see getElementIndex
	 */
	public WebElement getElementIndex(int index, List<WebElement> element) {
		WebElement webElement = element.get(index);
		return webElement;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
