package org.karkakasadara.tests.athenaassessments.questionbank;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AdminRole {
	
	static WebDriver driver;
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@Test(priority=1)
	public void setUpDriver() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Subasri\\Downloads\\geckodriver\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.navigate().to("https://uat.karkakasadara.in/");
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=2)
	public void loginAsAdmin() throws InterruptedException{
		
		WebElement email=wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		email.click();
		
		email.sendKeys("demoadmin@velammal.edu.in");
		
		WebElement password= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
		password.click();
		
		password.sendKeys("adminuat");
		
		WebElement signIn=driver.findElement(By.xpath("//body/app-root[1]/layout[1]/empty-layout[1]/div[1]/div[1]/auth-sign-in[1]/div[1]/div[1]/div[1]/form[1]/button[1]"));
		signIn.click();
		
		Thread.sleep(1000);
		
		Reporter.log("Login Successful");
		
	}
	
	@Test(priority=3)
	public void checkQuestionBankModuleIsAvailable() {
		
		String pageSource= driver.getPageSource();
		String header="Your Approvals Awaited";
		
		driver.findElement(By.xpath("//span[contains(text(),'Athena Assessments')]")).click();
		
		if(!(pageSource.equals(header))) {
			
			driver.findElement(By.xpath("//span[contains(text(),'Question Bank')]")).click();
		}
		else {
			driver.findElement(By.xpath("//a[contains(text(),'Question Bank')]")).click();
		}	
		
	}

	@Test(priority=4)
	public void checkQuestionbankScreen() {
		
		WebElement actualHeadingPath= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Question Bank')]")));
		String actualHeadingText= actualHeadingPath.getText();
		System.out.println("Actual text is: " +actualHeadingText);
		String expectedHeading="Question Bank";
		Assert.assertEquals(actualHeadingText, expectedHeading);

	}
	/*
	@Test(priority=5)
	public void fieldsToBeSelected(){
		
		//Syllabus
		WebElement syllabus=driver.findElement(By.xpath("//span[contains(text(),'Select Syllabus')]"));
		syllabus.click();
		
		driver.findElement(By.xpath("//span[contains(text(),'NewGen')]")).click();
		
		//Grade
		WebElement grade=driver.findElement(By.xpath("//span[contains(text(),'Select Grade')]"));
		grade.click();
		
		driver.findElement(By.xpath("//mat-option[@id='mat-option-19']")).click();// 5
		
		//Subject
		WebElement subject=driver.findElement(By.xpath("//span[contains(text(),'Select Subject')]"));
		subject.click();
		
		driver.findElement(By.xpath("//span[contains(text(),'English')]")).click();
		
		//Chapter
		WebElement chapter=driver.findElement(By.xpath("//span[contains(text(),'Select Chapter')]"));
		chapter.click();
		
		driver.findElement(By.xpath("//mat-option[@id='mat-option-0']")).click();// All
		
		//Concept
		WebElement concept=driver.findElement(By.xpath("//span[contains(text(),'Select Concept')]"));
		concept.click();
				
		driver.findElement(By.xpath("//mat-option[@id='mat-option-1']")).click();// All
	}
	
	@Test(priority=6)
	public void fieldsThatAlreadySelected(){
		
		//Assessment Type
		WebElement practiceOrAthena=driver.findElement(By.xpath("//div[contains(@class,'mat-form-field-flex ng-tns-c86-12')]"));
		System.out.println("Practice/ Athena: " + practiceOrAthena.getText());

		// MCQ/ Descriptive
		WebElement assessmentType=driver.findElement(By.xpath("//div[contains(@class,'mat-form-field-flex ng-tns-c86-14')]"));
		System.out.println("MCQ/ Descriptive: " + assessmentType.getText());
		
		//Bloom Level
		WebElement bloomLevel=driver.findElement(By.xpath("//div[contains(@class,'mat-form-field-flex ng-tns-c86-16')]"));
		System.out.println("Which level? " + bloomLevel.getText());
		
	}	
	
	@Test(priority=7)
	public void clickSubmitButton(){
		
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
	}
	
	@Test(priority=8)
	public void takeScreenshotOfDisplayedQuestions() throws IOException{
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'p-2 bg-card shadow rounded overflow-hidden mt-3')]")));
		TakesScreenshot screenShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File sourceFile=screenShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File destinationFile=new File("D://Screenshot/Admin/QuestionBank.png");
		//Copy file at destination
		FileUtils.copyFile(sourceFile, destinationFile);
		
	}*/
	
	@Test(priority=9)
	public void clickOnAddQuestion() {
		
		driver.findElement(By.xpath("//span[contains(text(),'Add Question')]")).click();
		
	}
	
	@Test(priority=10)
	public void selectFields() {
		
		//Syllabus
		WebElement syllabus=driver.findElement(By.xpath("//span[contains(text(),'Select Syllabus')]"));
		syllabus.click();
				
		driver.findElement(By.xpath("//span[contains(text(),'NewGen')]")).click();
				
		//Grade
		WebElement grade=driver.findElement(By.xpath("//span[contains(text(),'Select Grade')]"));
		grade.click();
				
		driver.findElement(By.xpath("//mat-option[@id='mat-option-80']")).click();// 6
				
		//Subject
		WebElement subject=driver.findElement(By.xpath("//span[contains(text(),'Select Subject')]"));
		subject.click();
				
		driver.findElement(By.xpath("//span[contains(text(),'English')]")).click();
				
		//Chapter
		WebElement chapter=driver.findElement(By.xpath("//span[contains(text(),'Select Chapter')]"));
		chapter.click();
			
		driver.findElement(By.xpath("//mat-option[@id='mat-option-117']")).click();// Unit 2
				
		//Concept
		addNewConcept();
		
		//Bloom level
		WebElement level=driver.findElement(By.xpath("//span[contains(text(),'Select Bloom Level')]"));
		level.click();
								
		driver.findElement(By.xpath("//span[contains(text(),'2 - Understanding')]")).click();
		
	}
	
	public void addNewConcept() {
		
		WebElement conceptField=driver.findElement(By.xpath("//span[contains(text(),'Select Concept')]"));
		conceptField.click();
		List<WebElement> concept=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'ng-tns-c126-92 ng-trigger ng-trigger-transformPanel mat-select-panel mat-primary')]")));
		
		if(concept.isEmpty()) {
			WebElement addNewConcept= driver.findElement(By.xpath("//b[@id='bt']"));
			
			addNewConcept.click();
			
			WebElement text=driver.findElement(By.xpath("//input[@id='mat-input-5']"));
			text.click();
			
			text.sendKeys("Tenses");
			
			driver.findElement(By.xpath("//input[@id='mat-input-5']")).click();//  click on Add Concept button
		}
		
		else {
			
			driver.findElement(By.xpath("//mat-option[@id='mat-option-60']")).click();// select Punctuations
		}
		
	}
	@Test(priority=11)
	public void displaySelectedFields() {
		
		WebElement assessmentType2=driver.findElement(By.xpath("//div[contains(@class,'mat-form-field-flex ng-tns-c86-14')]"));
		System.out.println("MCQ/ Descriptive: " + assessmentType2.getText());
		
		WebElement feedbackType=driver.findElement(By.xpath("//div[contains(@class,'mat-form-field-flex ng-tns-c86-16')]"));
		System.out.println("Generic/Custom feedback : " + feedbackType.getText());
		
	}
	
	@Test(priority=12)
	public void ifNoIsSelected() {
		
		WebElement noButton=driver.findElement(By.id("mat-radio-3"));
		System.out.println("Is No button is selected? " + noButton.isSelected());
	}
	
	@Test(priority=13)
	public void enterQuestionAndOption() {
		
		WebElement questionArea=driver.findElement(By.xpath("//textarea[@id='mat-input-0']"));
		questionArea.click();
		
		questionArea.sendKeys("I love to play football \r\n" + "Select the correct option");// Question
		
		WebElement optionA=driver.findElement(By.xpath("//textarea[@id='mat-input-1']"));
		optionA.click();
		
		optionA.sendKeys("I, love to play football");
		
		WebElement optionB=driver.findElement(By.xpath("//textarea[@id='mat-input-2']"));
		optionB.click();
		
		optionB.sendKeys("I love to play football!");
		
		WebElement optionC=driver.findElement(By.xpath("//textarea[@id='mat-input-3']"));
		optionC.click();
		
		optionC.sendKeys("I love to play football.");
		
		WebElement optionD=driver.findElement(By.xpath("//textarea[@id='mat-input-4']"));
		optionD.click();
		
		optionD.sendKeys("I love to play. football");
	}
	
	@Test(priority=14)
	public void selectCorrectOption() {
		
		WebElement optionField=driver.findElement(By.xpath("//div[contains(@class,'mat-form-field-flex ng-tns-c86-21')]"));
		optionField.click();
		
		driver.findElement(By.xpath("//mat-option[@id='mat-option-10']")).click();// Option C is correct
		
	}
	
	@Test(priority=15)
	public void clickSubmit() {
		
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		
	}
	
}
