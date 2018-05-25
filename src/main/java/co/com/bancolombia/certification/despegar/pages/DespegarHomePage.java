package co.com.bancolombia.certification.despegar.pages;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DespegarHomePage {

	WebDriver driver;

	Calendar fecha = Calendar.getInstance();
	int año = fecha.get(Calendar.YEAR);
	int mes = fecha.get(Calendar.MONTH) + 1;

	public DespegarHomePage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void ingresarADespegar() {
		driver.get("https://www.despegar.com.co");
		driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/span")).click();
		driver.manage().window().maximize();
	}

	
	public void seleccionarOpcionVuelos() {
		driver.findElement(By.className("nevo-icon-flights")).click();
	}

	
	public void ingresarCiudadOrigen(String ciudadOrigen) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(ciudadOrigen);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	}

	
	public void ingresarCiudadDestino(String ciudadDestino) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(ciudadDestino);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	}

	public void seleccionarFechaPartida(String fechaPartida) throws InterruptedException {
		int dia = Dia(fechaPartida);
		int mes = Mes(fechaPartida);

		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input")).click();

		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/i")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/i")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div["+ mes +"]/div[4]/span["+ dia +"]")).click();	
	}
	
	
	public void seleccionarFechaRegreso(String fechaRegreso) {
		
		int dia = Dia(fechaRegreso);
        int mes = Mes(fechaRegreso);
        
        driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/input")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div["+ mes + "]/div[4]/span[" + dia + "]")).click();
    }

	
	public int Mes(String fechaRecibida) {
		String[] fechaSinSeparador = fechaRecibida.split("/");
		int contadorMes = Integer.parseInt(fechaSinSeparador[1]) - mes + 1;
		return contadorMes;
	}

	
	public int Dia(String fechaRecibida) {
		String[] fechaSinSeparador = fechaRecibida.split("/");
		int dia = Integer.parseInt(fechaSinSeparador[0]);
		return dia;
	}
	
	
	public void ingresarNumeroPasajeros(String numeroPasajeros) {
		driver.findElement(By.xpath("//*[@id='searchbox-sbox-all-boxes']/div/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div/input")).click();
				
		int pasajeros = Integer.parseInt(numeroPasajeros);
		
        for (int i=1; i<pasajeros; i++) {
        	driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]")).click(); 		
        } 
	}

	
	public void seleccionarOpcionBuscar() {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[4]/div/a")).click();
	}

	
	public void noIngresarCiudadOrigen() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	}


	public String visualizarMensajeDeErroPorCiudadOrigen() {
		return driver.findElement(By.xpath("//span[text()='Ingresa un origen']")).getText();
	}


	public void noIngresarCiudadDestino() {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	}


	public String visualizarMensajeDeErroPorCiudadDestino() {
		return driver.findElement(By.xpath("//span[text()='Ingresa un destino']")).getText();
	}

	
}
