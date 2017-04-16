package psc.com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PsTakeCare {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		PsTakeCare pages=new PsTakeCare();
		System.out.println("**********TestCase 1 has Started**********");
		pages.clickURL();
		pages.tclickOncountryLink();
		System.out.println("**********TestCase 1 has Completd**********");
		System.out.println("**********TestCase 2 has Started**********");
		pages.clickURL();
		pages.tclickOnBangaloreLink();
		System.out.println("**********TestCase 2 has Completd**********");
		System.out.println("**********TestCase 3 has Started**********");
		pages.clickURL();
		pages.tcSerachTotalSurgeryHospitalAndDoctor();
		System.out.println("**********TestCase 3 has Completd**********");
		System.out.println("**********TestCase 4 has Started**********");
		pages.clickURL();
		pages.tcSearchSurgery();
		System.out.println("**********TestCase 4 has Completd**********");
		System.out.println("**********TestCase 5 has Started**********");
		pages.clickURL();
		pages.ClickForInformationToPatient();
		System.out.println("**********TestCase 5 has Completd**********");

	}
	
	public void clickURL(){
		System.setProperty("webdriver.gecko.driver", "C:\\GickDriver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://pstakecare.com/");
	} 
	
	public  void tclickOncountryLink(){
		try{
			wait=new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='city-toggle-slide']/section/section[2]/div[2]/button"))).click();
			Thread.sleep(30000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='site-header']/section/section[1]/div[4]/div"))).click();
			String ExpectedTitle="Book surgery packages online with best Doctors & Hospitals at affordable prices, Normal Delivery, Hernia, Breast Cancer, Cataract, Caesarean | PSTakeCare";
			String ActualValue=driver.getTitle();
			if(ExpectedTitle.contains(ActualValue)){
				System.out.println("Verified SuccessFully");
			}
			driver.quit();
			
		}catch(Exception e){
			e.getMessage();
		}
		
	} 
	public  void tclickOnBangaloreLink() throws InterruptedException{
		wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='city-toggle-slide']/section/section[2]/div[1]/div[2]/button"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='site-header']/section/section[1]/div[3]/div"))).click();
		Thread.sleep(3000);
		String ExpectedTitle="Book surgery packages online with best Doctors & Hospitals at affordable prices, Normal Delivery, Hernia, Breast Cancer, Cataract, Caesarean | PSTakeCare";
		String ActualValue=driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualValue);
		System.out.println("Verified SuccessFully");
		driver.quit();
		
	} 
	public  String tcSerachTotalSurgeryHospitalAndDoctor(){
		try{
			wait=new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='city-toggle-slide']/section/section[2]/div[2]/button"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='site-header']/section/section[1]/div[4]/div"))).click();
			String strSpecialChar="#@%$&";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='typeahead-surgery']"))).sendKeys(strSpecialChar);
			driver.findElement(By.xpath("//*[@id='home-page-search-row']/div/div[2]/button")).click();
			Thread.sleep(3000);
			String ExpectedValue="Aastha Hospital, Kandivali West, Mumbai - Book Your Surgery with PSTakeCare";
			String ActualValue=driver.getTitle();
			if(ExpectedValue.contains(ActualValue)){
				System.out.println("Verified Successfully");
			}
			else{
				System.out.println("User Not able to get title");
			}
			driver.quit();
			
		}catch(Exception e){
			e.getMessage();
		}
		return "0";
		
	} 
	
	public String tcSearchSurgery(){
		try{
			wait=new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='city-toggle-slide']/section/section[2]/div[2]/button"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='site-header']/section/section[1]/div[4]/div"))).click();
			String strSurgeryName="Total Knee Replacement (TKR)";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='typeahead-surgery']"))).sendKeys(strSurgeryName);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='home-page-search-row']/div/div[2]/button"))).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='suggestion-list']/div[1]/div[1]/div[2]"))).click();
			Thread.sleep(3000);
			String ExpectedValue="Total Knee Replacement (TKR) Surgery in India - Research & Book Online with PSTakeCare";
			String ActualValue=driver.getTitle();
			System.out.println("Actualvalue="+ActualValue);
			
			if(ExpectedValue.contains(ActualValue)){
				System.out.println("User SuccessFully Redirect on hospital page");
			}else{
				System.out.println("User is Not able to Redirect on hospital page");
			}
			driver.findElement(By.xpath("//*[@id='home-page-content']/section/section[3]/div[2]/div[1]/div[1]/div[4]/label[1]/div[1]/input")).click();
			driver.findElement(By.xpath("//*[@id='home-page-content']/section/section[3]/div[2]/div[1]/div[1]/div[6]/div")).click();
			
			String strlabelbangalore=driver.findElement(By.xpath("//*[@id='home-page-content']/section/section[3]/div[2]/div[2]/div/div[1]/div[1]")).getText();
			System.out.println(""+strlabelbangalore);
			if(strlabelbangalore.contains("Showing results for Bangalore")){
				System.out.println("Only Bangalore related results are displaying");
				
			}else{
				System.out.println("User is not able to get bangalore related results");
			}
			driver.quit();
		}catch(Exception e){
			e.getMessage();
		}
		return "0";
		
	} 
	
	public void ClickForInformationToPatient() throws InterruptedException{
		wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='city-toggle-slide']/section/section[2]/div[2]/button"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='site-header']/section/section[2]/nav/a[1]")).click();
		Thread.sleep(30000);
		String ExpectedValue="Medical tourism in India Plan Surgery at best Hospitals | PSTakeCare";
		String ActualValue=driver.getTitle();
		if(ExpectedValue.contains(ActualValue)){
			System.out.println("User is able to see medical-tourism-in-india page");
		}else{
			System.out.println("User is not able to see medical-tourism-in-india page");
		}
		driver.quit();
		
		
	} 
	


}
