package co.com.bancolombia.certification.despegar.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/features/despegar_buscarTiquetes.feature", glue = "co.com.bancolombia.certification.despegar.stepdefinitions", tags = "@Exitoso")
@CucumberOptions(features = "src/test/resources/features/despegar_buscarTiquetes.feature", glue = "co.com.bancolombia.certification.despegar.stepdefinitions", tags = {"@Exitoso, @NoCiudadOrigen , @NoCiudadDestino"})

public class DespegarRunner {

}