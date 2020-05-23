package com.rodrigo.integrador.test;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rodrigo.integrador.page.HomePage;
import com.rodrigo.integrador.page.LoginPage;
import com.rodrigo.integrador.page.PanelUserPage;
import com.rodrigo.integrador.page.RegistroPage;
import com.rodrigo.itegrador.dto.UserDto;

import io.github.jschenfeld.automation.selenium.AbstractUiTest;


public class RegistroTest extends AbstractUiTest{

	@Test(dataProvider = "user")
	public void RegistroCompletoTest(UserDto entity) {
		HomePage homepage = new HomePage(getDriver());
		homepage.clickLoginLink();
		
		LoginPage loginpage = new LoginPage(getDriver());
		
		assertEquals(loginpage.tituloPagina(), "AUTHENTICATION");
		
		loginpage.crearCuenta(entity.getEmail());
		
		RegistroPage registropage = new RegistroPage(getDriver());
		assertEquals(registropage.tituloPagina(), "CREATE AN ACCOUNT");
		
		registropage.completarFormulario(entity);
		
		PanelUserPage panelUserPage = new PanelUserPage(getDriver());
		assertEquals(panelUserPage.tituloPagina(), "MY ACCOUNT");
		assertEquals(panelUserPage.nombreUsuario(), entity.getNombreCompleto());
		
	}
	

	@Test
	public void verificarMjeErrorTest() {
		HomePage homepage = new HomePage(getDriver());
		homepage.clickLoginLink();
		
		LoginPage loginpage = new LoginPage(getDriver());
		
		assertEquals(loginpage.tituloPagina(), "AUTHENTICATION");
		
		loginpage.crearCuenta("prueba");
		
		assertEquals(loginpage.emailError(), "Invalid email address.");
	}
	
	@DataProvider(name = "user")
	public Object[][] userData() {
	 UserDto user = new UserDto();
	 user.setFirstName("pepe");
	 user.setLastName("apelli");
	 user.setPassword("123123");
	 user.setAdressFirstName("av. siempre viva");
	 user.setAdressLastName("av. siempre viva 123");
	 user.setAdress("av. siempre viva");
	 user.setCity("Resistencia");
	 user.setState("Alabama");
	 user.setCodePostal("03500");
	 user.setCountry("United States");
	 user.setMobilePhone("362468887931");
	 user.setAdressAlias("Aliass 1");
	 user.setAditionalInformation("informacion adicional");
	 user.setEmail(this.generarEmail());
	 
	 return new Object[][] {
	   { user }
	 };
	}
	
	public String generarEmail() {
		
		return "usuario"+(Math.random()*6 + 100)+"@email.com";
	}
	
	@Override
	protected String getBaseUrl() {
		// TODO Auto-generated method stub
		return "http://automationpractice.com";
	}
}
