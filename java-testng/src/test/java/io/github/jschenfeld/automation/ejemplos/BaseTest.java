package io.github.jschenfeld.automation.ejemplos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println();
		System.out.println("beforeTest");
	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println();
		System.out.println("beforeSuite");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println();
		System.out.println("beforeClass");
	}
	

    @BeforeMethod(alwaysRun = true)
    public void cualquierCosa() {
		System.out.println();
    	System.out.println("beforeMethod");
    }
    
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
    	System.out.println("afterMethod");
		System.out.println();
    }
    
    @AfterClass(alwaysRun = true)
    public void afterClass() {
    	System.out.println("afterClass");
		System.out.println();
    }
    
    @AfterTest
    public void afterTest() {
    	System.out.println("afterTest");
		System.out.println();
    }
    
    @AfterSuite
    public void afterSuite() {
    	System.out.println("afterSuite");
		System.out.println();
    }
}