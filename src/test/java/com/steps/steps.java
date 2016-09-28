package com.steps;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObjects.BetaHomePgObject;
import com.pageObjects.BetaLoginPgObject;
import com.pageObjects.HomePgObject;
import com.pageObjects.HomePortalPgObject;
import com.pageObjects.LinkToHomePgObject;
import com.pageObjects.LoginPgObject;
import com.pageObjects.ProductsPgObject;
import com.pageObjects.VOdashBoardPgObject;
import com.pageObjects.VoOptionPgObject;
import com.prodPgObjects.CheckOutPgObject;
import com.titanium.Base;
import com.titanium.lunchers.DriverLuncher;
import com.utils.TabCatcher;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class steps extends Base {
	public static WebDriver driver;
	Base base;
	HomePgObject homePgObject;
	LoginPgObject loginPgObject;
	TabCatcher tabCatcher;
	VOdashBoardPgObject vOdashBoardPgObject;
	ProductsPgObject productsPgObject;
	LinkToHomePgObject linkToHomePgObject;
	VoOptionPgObject voOptionPgObject;
	HomePortalPgObject homePortalPgObject;
	BetaLoginPgObject betaLoginPgObject;
	BetaHomePgObject betaHomePgObject;
	CheckOutPgObject checkOutPgObject;
	
	
	@Before
	public void setup(){
		driver=DriverLuncher.luncher();
	}
	@After
	public void closeDriver(){
		driver.close();
	}
	@Given("^user direts to the VO click on login button \"([^\"]*)\"$")
	public void user_direts_to_the_VO_click_on_login_button(String arg1) throws Throwable {
		driver.get(arg1);
		 Thread.sleep(1000);
		 
		  homePortalPgObject = new HomePortalPgObject(driver);
		    homePortalPgObject.clickPortalLogin();
		 //homePgObject=new HomePgObject(driver);
			//homePgObject.clickIRLogin();
	}


	
	/*@Given("^user direts to the VO \"([^\"]*)\"$")
	public void user_direts_to_the_VO(String arg1) throws Throwable {
		 driver.get(arg1);
		 Thread.sleep(1000);
	}
	
	@Given("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
		homePgObject=new HomePgObject(driver);
		homePgObject.clickIRLogin();
	}*/

	@Given("^click on vo_option \"([^\"]*)\"$")
	public void click_on_vo_option(String arg1) throws Throwable {
		voOptionPgObject = new VoOptionPgObject(driver);
	  if (arg1.equals("current")) {
		 voOptionPgObject.clickCurrentVo();
		 Thread.sleep(1000);
	} else if (arg1.equals("beta")) {
		voOptionPgObject.clickBetaVO();
		 Thread.sleep(1000);
	}
	}

	@When("^user enter valid username \"([^\"]*)\" and valid password \"([^\"]*)\"$")
	public void user_enter_valid_username_and_valid_password(String arg1, String arg2) throws Throwable {
		loginPgObject=new LoginPgObject(driver);
		
		loginPgObject.enterIRID(arg1); 
		loginPgObject.enterPWD(arg2);
	}

	@When("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
	   loginPgObject.clickLogin();
	   Thread.sleep(1000);
	}


@When("^close the error msg$")
public void close_the_error_msg() throws Throwable {
	try{
		  
		   WebDriverWait wait = new WebDriverWait(driver, 4);
		   Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		   //Accepting alert.
		   alert.accept();
		  
		}catch(Throwable e){
		   System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
		}
}
	@When("^click on direct shop$")
	public void click_on_direct_shop() throws Throwable {
		loginPgObject.clickShop();
	}

	/*@When("^user directs to vo$")
	public void user_directs_to_vo() throws Throwable {
		TabCatcher tabCatcher=new TabCatcher();
		tabCatcher.setTab();
	}*/	
	@When("^user directs to vo \"([^\"]*)\"$")
	public void user_directs_to_vo(String arg1) throws Throwable {
	    if (arg1.equals("qua_ir")|arg1.equals("qua_rc")) {
	    	TabCatcher tabCatcher=new TabCatcher();
			tabCatcher.setTab();
			
		} else if (arg1.equals("unqua_ir")){
			TabCatcher tabCatcher=new TabCatcher();
			tabCatcher.setTab();
			
			vOdashBoardPgObject.closepopup();
			vOdashBoardPgObject = new VOdashBoardPgObject(driver);
		}
	}
	
	
	@Then("^click on Shop tab$")
	public void click_on_Shop_tab() throws Throwable {
		vOdashBoardPgObject = new VOdashBoardPgObject(driver);
		vOdashBoardPgObject.clickShopNow();
		Thread.sleep(1000);
		
		
	//Vcon pop up
		/*try{
			  
			   WebDriverWait wait = new WebDriverWait(driver, 4);
			   Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			   //Accepting alert.
			   alert.accept();
			  
			}catch(Throwable e){
			   System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
			}*/

	}
	
	@Given("^directs to products page \"([^\"]*)\"$")
	public void directs_to_products_page(String arg1) throws Throwable {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		//System.out.println(tabs2.size()+"gddddddddddddd");
		productsPgObject=new ProductsPgObject(driver);
		 // driver.switchTo().window(tabs2.get(0));
		
		 //Assert.assertEquals(arg1, productsPgObject.getProdHeaderImg());
		
		 //driver.switchTo().window(tabs2.get(0)).close();
		
		//Thread.sleep(1000);
		// driver.switchTo().window(tabs2.get(0));
		
	}

	@When("^user click on signout$")
	public void user_click_on_signout() throws Throwable {
		vOdashBoardPgObject = new VOdashBoardPgObject(driver);
		   vOdashBoardPgObject.clickSignOut();
		   Thread.sleep(1000);
		   linkToHomePgObject = new LinkToHomePgObject(driver);
		   linkToHomePgObject.clickHomeLink();  
		   Thread.sleep(1000);
	}
	
	@Given("^user click on portal_login button$")
	public void user_click_on_portal_login_button() throws Throwable {
	    homePortalPgObject = new HomePortalPgObject(driver);
	    homePortalPgObject.clickPortalLogin();
	}
	@When("^user enter valid beta_username \"([^\"]*)\" and valid beta_password \"([^\"]*)\"$")
	public void user_enter_valid_beta_username_and_valid_beta_password(String arg1, String arg2) throws Throwable {
	    betaLoginPgObject = new BetaLoginPgObject(driver);
	    betaLoginPgObject.enterBIrId(arg1);
	    betaLoginPgObject.enterBPwd(arg2);
	}

	@When("^click on beta_Login button$")
	public void click_on_beta_Login_button() throws Throwable {
	    betaLoginPgObject.clickBlogin();
	}

	@When("^check error msg$")
	public void check_error_msg() throws Throwable {
	    betaLoginPgObject.chkInvalidCred();
	    Thread.sleep(1000);
	}

	@When("^user directs to beta_vo$")
	public void user_directs_to_beta_vo() throws Throwable {
		Thread.sleep(10000);
	}

	@Then("^click on beta_Shop tab$")
	public void click_on_beta_Shop_tab() throws Throwable {
		betaHomePgObject= new BetaHomePgObject(driver);
		Thread.sleep(10000);
		betaHomePgObject.clickShop();
		
Thread.sleep(1000);
		//vcon 
	/*	try{
			  
			   WebDriverWait wait = new WebDriverWait(driver, 4);
			   Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			   //Accepting alert.
			   alert.accept();
			  
			}catch(Throwable e){
			   System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
			}*/

	}

	@When("^user click on beta_signout$")
	public void user_click_on_beta_signout() throws Throwable {
		betaHomePgObject= new BetaHomePgObject(driver);
		betaHomePgObject.selectSignOut();
		Thread.sleep(1000);
		linkToHomePgObject = new LinkToHomePgObject(driver);
		   linkToHomePgObject.clickHomeLink(); 
		   Thread.sleep(1000);
	}
	
	@Then("^directs to products page without vo \"([^\"]*)\"$")
	public void directs_to_products_page_without_vo(String arg1) throws Throwable {
		productsPgObject=new ProductsPgObject(driver);
		 Assert.assertEquals(arg1, productsPgObject.getProdHeaderImg());
	}
}
