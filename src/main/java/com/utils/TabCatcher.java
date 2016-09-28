package com.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.steps.steps;

public class TabCatcher {
	public void setTab(){
		WebDriver driver=steps.driver;
		 String base = driver.getWindowHandle();
			Set<String> set = driver.getWindowHandles();

			//set.remove(base);
			//assert set.size() == 1;
			
			/*if(set.toArray()[0].equals(base)){
				
			}else{
				driver.switchTo().window((String) set.toArray()[0]).close();
			}*/
			driver.switchTo().window((String) set.toArray()[1]).close();
			driver.switchTo().window(base);
	}
	public void setBaseTab(){
		WebDriver driver=steps.driver;
		 String base = driver.getWindowHandle();
			Set<String> set = driver.getWindowHandles();

			//set.remove(base);
			//assert set.size() == 1;
			
			/*if(set.toArray()[0].equals(base)){
				
			}else{
				driver.switchTo().window((String) set.toArray()[0]).close();
			}*/
			driver.switchTo().window(base);
			
	}
	public void setPopUpTab(){
		WebDriver driver=steps.driver;
		 String base = driver.getWindowHandle();
			Set<String> set = driver.getWindowHandles();

			//set.remove(base);
			//assert set.size() == 1;
			
			/*if(set.toArray()[0].equals(base)){
				
			}else{
				driver.switchTo().window((String) set.toArray()[0]).close();
			}*/
			driver.switchTo().window((String) set.toArray()[1]);
			
			
	}
	public void closePopUpTab(){
		WebDriver driver=steps.driver;
		 String base = driver.getWindowHandle();
			Set<String> set = driver.getWindowHandles();

			//set.remove(base);
			//assert set.size() == 1;
			
			/*if(set.toArray()[0].equals(base)){
				
			}else{
				driver.switchTo().window((String) set.toArray()[0]).close();
			}*/
			
			driver.switchTo().window((String) set.toArray()[1]).close();
			driver.switchTo().window(base);
			
	}
	public void setCurrentTab(){
		WebDriver driver=steps.driver;
		 String base = driver.getWindowHandle();
			Set<String> set = driver.getWindowHandles();

			//set.remove(base);
			//assert set.size() == 1;
			
			/*if(set.toArray()[0].equals(base)){
				
			}else{
				driver.switchTo().window((String) set.toArray()[0]).close();
			}*/
			//driver.switchTo().window(base).close();
			driver.switchTo().window((String) set.toArray()[0]);
			
	}

}
