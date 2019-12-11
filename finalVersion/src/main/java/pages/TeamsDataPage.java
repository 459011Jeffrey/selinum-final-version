package pages;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;

import objects.Coach;
import objects.Team;

public class TeamsDataPage {
	private static WebDriver driver;
	private static final String url = "https://www.basketball-reference.com/leagues/NBA_2020_standings.html";
	private static ArrayList<Coach> coaches;
	private static ArrayList<Team> teams;
	
	public TeamsDataPage(WebDriver driver, ArrayList<Coach> coaches) {
		TeamsDataPage.driver = driver;
		TeamsDataPage.coaches = coaches;
		teams = new ArrayList<Team>();
	}
	
	public ArrayList<Team> getTeams () {
		driver.get(url);
		String pageSource = driver.getPageSource();  
		try {
			Team.createTags();
			Team.setCoaches(coaches);
			System.out.println("Getting teams");
			Document doc = Jsoup.parse(pageSource);
			for (Element row : doc.select("#expanded_standings tr")) {
				if (row.select(".left").text().equals("Team")  || row.select(".left").text().equals(""))  {
					continue;
				} else {
					final String name = row.select(".left").text();
					final String rank = row.select(".right").text();
					final String WLRecord = row.select("td.center:nth-of-type(2)").text();
					teams.add(new Team(name,rank, WLRecord));
				}
			}
		}
		catch (Exception e) {
			System.out.println("Teams are not working yet");
		}	
		return teams;
	}
}
