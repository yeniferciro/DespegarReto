#Author: yechavar@bancolombia.com.co
Feature: Buscar tiquetes baratos para viaje
  Yo como viajero  
  Quiero encontrar tiquetes baratos en Despegar 
  Para realizar un viaje entre las ciudades de Medellin y Cartagena

@Exitoso
  Scenario Outline: Busqueda exitosa de tiquetes entre Medellin y Cartagena
    Given el usuario esta en la pagina de Despegar
    When el usuario selecciona la opcion Vuelos
    And el usuario ingresa la ciudad origen "<ciudadorigen>"
    And el usuario ingresa la ciudad destino "<ciudaddestino>"
    And el usuario selecciona la fecha de partida "<fechapartida>"
    And el usuario selecciona la fecha de regreso "<fecharegreso>"
   	And el usuario ingresa el numero de pasajeros "<numeropasajeros>"
    And el usuario selecciona la opcion Buscar
    Then el usuario puede visualizar las opciones de vuelo mas economicas en un Excel

     Examples: 
      | ciudadorigen | ciudaddestino | fechapartida | fecharegreso | numeropasajeros |
      | Medellin | Cartagena | 01/09/2018 | 29/09/2018 | 3 |
      
@NoCiudadOrigen      
   Scenario Outline: Busqueda sin ingreso de ciudad origen
    Given el usuario esta en la pagina de Despegar
    When el usuario selecciona la opcion Vuelos
    And el usuario no ingresa la ciudad origen
    And el usuario ingresa la ciudad destino "<ciudaddestino>"
    And el usuario selecciona la fecha de partida "<fechapartida>"
    And el usuario selecciona la fecha de regreso "<fecharegreso>"
   	And el usuario ingresa el numero de pasajeros "<numeropasajeros>"
    And el usuario selecciona la opcion Buscar
    Then el usuario visualiza un mensaje de error porque no ingreso la ciudad origen

    Examples: 
      | ciudaddestino | fechapartida | fecharegreso | numeropasajeros |
      | Cartagena | 01/09/2018 | 29/09/2018 | 1 |
      

@NoCiudadDestino      
   Scenario Outline: Busqueda sin ingreso de ciudad destino
    Given el usuario esta en la pagina de Despegar
    When el usuario selecciona la opcion Vuelos
    And el usuario ingresa la ciudad origen "<ciudadorigen>"
    And el usuario no ingresa la ciudad destino
    And el usuario selecciona la fecha de partida "<fechapartida>"
    And el usuario selecciona la fecha de regreso "<fecharegreso>"
   	And el usuario ingresa el numero de pasajeros "<numeropasajeros>"
    And el usuario selecciona la opcion Buscar
    Then el usuario visualiza un mensaje de error porque no ingreso la ciudad destino

    Examples: 
      | ciudadorigen | fechapartida | fecharegreso | numeropasajeros |
      | Medellin | 01/09/2018 | 29/09/2018 | 2 |