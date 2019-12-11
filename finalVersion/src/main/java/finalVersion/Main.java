package finalVersion;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.xquery.XQException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Coach;
import objects.Match;
import objects.Player;
import objects.Team;
import pages.CoachesDataPage;
import pages.MatchesDataPage;
import pages.PlayersDataPage;
import pages.TeamsDataPage;
import xmlClasses.XMLBuilder;
import xmlClasses.XPathCheck;
import xmlClasses.XQueryTester;

public class Main {
	private static WebDriver driver;
	
	public static void main(String[] args) {
		setDriver();
		
		PlayersDataPage playersPage = new PlayersDataPage(driver);
		ArrayList<Player> players = playersPage.getData();
		
		CoachesDataPage coachesPage = new CoachesDataPage(driver, players);
		ArrayList<Coach> coaches = coachesPage.getCoaches();
		
		TeamsDataPage teamsPage = new TeamsDataPage(driver, coaches);
		ArrayList<Team> teams = teamsPage.getTeams();
		
		MatchesDataPage matchesPage = new MatchesDataPage(driver);
		ArrayList<Match> matches = matchesPage.getMatches();
		
		driver.close();
		driver.quit();
		
		XMLBuilder xmlBuilder = new XMLBuilder(players, coaches, teams, matches);
		xmlBuilder.createXML();
		
		XPathCheck.run();	
		
		try {
			XQueryTester.execute();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XQException e) {
			e.printStackTrace();
		}
	}

	private static void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(new ChromeOptions().addArguments("headless"));
	}
}
