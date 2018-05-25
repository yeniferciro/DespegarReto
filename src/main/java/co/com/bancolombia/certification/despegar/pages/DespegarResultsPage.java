package co.com.bancolombia.certification.despegar.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import co.com.bancolombia.certification.despegar.utils.DespegarExcel;

public class DespegarResultsPage {

	WebDriver driver;
	
	public DespegarResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visualizarVuelos() throws InterruptedException {
		Object[][] data = new Object[7][1];
		
		Thread.sleep(3000);
			 			 
		List<WebElement> listaPreciosVuelos= driver.findElements(By.xpath("//div[@id='clusters']//main-fare//flights-price-element//span[@class='amount price-amount']"));
		
		for(int i=0; i<7;i++){
			data[i][0] = listaPreciosVuelos.get(i).getText();
		}
		
		DespegarExcel.crearExcel(data);
	}
}
