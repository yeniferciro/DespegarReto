package co.com.bancolombia.certification.despegar.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import co.com.bancolombia.certification.despegar.pages.DespegarHomePage;
import co.com.bancolombia.certification.despegar.pages.DespegarResultsPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DespegarSteps {

	WebDriver driver;
	DespegarHomePage despegarHomePage;
	DespegarResultsPage despegarResultsPage;

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		despegarHomePage = new DespegarHomePage(driver);
		despegarResultsPage = new DespegarResultsPage(driver);
	}

	@Given("el usuario esta en la pagina de Despegar")
	public void usuarioIngresaAPaginaDespegar() {
		despegarHomePage.ingresarADespegar();
	}

	@When("el usuario selecciona la opcion Vuelos")
	public void usuarioSeleccionaOpcionVuelos() {
		despegarHomePage.seleccionarOpcionVuelos();
	}

	@And("el usuario ingresa la ciudad origen \"(.*)\"$")
	public void usuarioIngresaCiudadOrigen(String ciudadOrigen) throws InterruptedException {
		despegarHomePage.ingresarCiudadOrigen(ciudadOrigen);
	}

	@And("el usuario ingresa la ciudad destino \"(.*)\"$")
	public void usuarioIngresaCiudadDestino(String ciudadDestino) throws InterruptedException {
		despegarHomePage.ingresarCiudadDestino(ciudadDestino);
	}

	@And("el usuario selecciona la fecha de partida \"(.*)\"$")
	public void usuarioSeleccionaFechaPartida(String fechaPartida) throws InterruptedException {
		despegarHomePage.seleccionarFechaPartida(fechaPartida);
	}

	@And("el usuario selecciona la fecha de regreso \"(.*)\"$")
	public void usuarioSeleccionaFechaRegreso(String fechaRegreso) throws InterruptedException {
		despegarHomePage.seleccionarFechaRegreso(fechaRegreso);
	}

	@And("el usuario ingresa el numero de pasajeros \"(.*)\"$")
	public void usuarioIngresaNumeroPasajeros(String numeroPasajeros) throws InterruptedException {
		despegarHomePage.ingresarNumeroPasajeros(numeroPasajeros);
	}

	@And("el usuario selecciona la opcion Buscar")
	public void usuarioSeleccionaOpcionBuscar() {
		despegarHomePage.seleccionarOpcionBuscar();
	}

	@Then("el usuario puede visualizar las opciones de vuelo mas economicas en un Excel")
	public void usuarioVisualizaVuelos() throws InterruptedException {
		despegarResultsPage.visualizarVuelos();
	}

	@And("el usuario no ingresa la ciudad origen")
	public void usuarioNoIngresaCiudadOrigen() throws InterruptedException {
		despegarHomePage.noIngresarCiudadOrigen();
	}

	@Then("el usuario visualiza un mensaje de error porque no ingreso la ciudad origen")
	public void usuarioVisualizaMensajeDeErrorPorNoIngresarCiudadOrigen() {
		String result = despegarHomePage.visualizarMensajeDeErroPorCiudadOrigen();
		assertEquals("Ingresa un origen", result);
	}

	@And("el usuario no ingresa la ciudad destino")
	public void usuarioNoIngresaCiudadDestino() throws InterruptedException {
		despegarHomePage.noIngresarCiudadDestino();
	}

	@Then("el usuario visualiza un mensaje de error porque no ingreso la ciudad destino")
	public void usuarioVisualizaMensajeDeErrorPorNoIngresarCiudadDestino() {
		String result = despegarHomePage.visualizarMensajeDeErroPorCiudadDestino();
		assertEquals("Ingresa un destino", result);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}