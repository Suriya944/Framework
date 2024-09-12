package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	WebElement txtUserName = driver.findElement(By.id("email"));
	txtUserName.sendKeys("sudharsan");
	WebElement txtPass = driver.findElement(By.id("pass"));
	txtPass.sendKeys("123456789");
	WebElement txtLogin = driver.findElement(By.xpath("//button[text()='Log in']"));
	txtLogin.click();
	
	
	}
}
