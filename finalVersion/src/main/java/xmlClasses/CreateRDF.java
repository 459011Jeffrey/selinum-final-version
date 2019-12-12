package xmlClasses;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateRDF {

	static String personURI    = "http://basketball";
	static String fullName     = "John Smith";

	private static WebDriver driver;
	//		model.write(System.out);
	public static void main(String[] args) {
		// some definitions
		

		// create an empty Model
		Model model = ModelFactory.createDefaultModel();
		
		Property name = model.createProperty( personURI + "name" );
		
		Resource player = model.createResource(personURI);
		Resource human = model.createResource(personURI+ "human");

		//model.add(player, personURI+"human", human);
		player.addProperty(name, "");
				
		model.write(System.out);
		
		
	}
	





	private static void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(new ChromeOptions().addArguments("headless"));
	}


}
