package com.rodrigo.integrador.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rodrigo.integrador.page.HomePage;
import com.rodrigo.integrador.page.LoginPage;
import com.rodrigo.integrador.page.PanelUserPage;
import com.rodrigo.itegrador.dto.UserDto;

import io.github.jschenfeld.automation.selenium.AbstractUiTest;



public class LoginTest extends AbstractUiTest {
	
	
	@Test(dataProvider = "UserValido")
	public void credencialesValidasTest (UserDto user) {
		HomePage homepage = new HomePage(getDriver());
		homepage.clickLoginLink();
		
		LoginPage loginpage = new LoginPage(getDriver());
		
		assertEquals(loginpage.tituloPagina(), "AUTHENTICATION");
		
		loginpage.completarFormularioLogin(user.getEmail(), user.getPassword());
		
		PanelUserPage paneuserpage = new PanelUserPage(getDriver());
		
		assertEquals(paneuserpage.nombreUsuario(), user.getNombreCompleto());
		
	}
	
	@Test(dataProvider = "UserNoValido")
	public void credencialesNoValidasTest (UserDto user) {
		HomePage homepage = new HomePage(getDriver());
		homepage.clickLoginLink();
		
		LoginPage loginpage = new LoginPage(getDriver());
		
		assertEquals(loginpage.tituloPagina(), "AUTHENTICATION");
		
		loginpage.completarFormularioLogin(user.getEmail(), user.getPassword());
		
		assertEquals(loginpage.emailLoginError(), "Invalid password.");
		
	}
	
	
	@DataProvider(name = "UserValido")
	public Object[][] usuarioValidoData() {
		UserDto user = new UserDto();
		user.setEmail("usuario105.09549883781212@email.com");
		user.setPassword("123123");
		user.setFirstName("bart");
		user.setLastName("simpsons");
		
	 return new Object[][] {
	   { user }
	 };
	}
	
	@DataProvider(name = "UserNoValido")
	public Object[][] usuarioNoValidoData() {
		UserDto user = new UserDto();
		user.setEmail("qweqwe@gmail.com");
		user.setPassword("222");
		user.setFirstName("qwe");
		user.setLastName("qwe");
	 return new Object[][] {
	   { user }
	 };
	}
	
	@Override
	protected String getBaseUrl() {
		// TODO Auto-generated method stub
		return "http://automationpractice.com";
	}

}
