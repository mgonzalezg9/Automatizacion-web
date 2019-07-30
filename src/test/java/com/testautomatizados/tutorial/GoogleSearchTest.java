package com.testautomatizados.tutorial;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	private WebDriver driver;
	
	@Before
	// M�todo para preparar los tests que se van a realizar
	public void setUp() {
		// Indicamos d�nde est� el ejecutable del driver
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		
		// Creamos el driver de Chrome
		driver = new ChromeDriver();
		
		// Le decimos al driver que maximice la ventana de Chrome
		driver.manage().window().maximize();
		
		// Le indicamos la p�gina que tiene que abrir
		driver.get("http://google.com");
	}
	
	@Test
	// Test para probar la b�squeda
	public void testGooglePage() {
		// Buscamos la caja de b�squeda que hay en la p�gina
		WebElement searchBox = driver.findElement(By.name("q"));
		
		// Borramos el contenido de la caja de b�squeda
		searchBox.clear();
		
		// Introducimos texto en la caja de b�squeda
		String queryText = "Selenium Tutorial";
		searchBox.sendKeys(queryText);
		
		// Enviamos el texto introducido
		searchBox.submit();
		
		// Esperamos a que la p�gina ya haya cargado
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Creamos una lista con los resultados de la b�squeda que arroja la p�gina
		List<WebElement> lista = driver.findElements(By.className("g"));
		
		// Si la b�squeda arroj� resultados el test fue pasado con �xito
		assertTrue(!lista.isEmpty());		
	}

	@After
	// M�todo de finalizaci�n de los tests
	public void tearDown() {
		// Cerramos la ventana del navegador
		driver.quit();
	}
	
}
