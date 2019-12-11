package pages;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;

import objects.Coach;
import objects.Player;

public class CoachesDataPage {
	private static WebDriver driver;
	private static final String url = "https://www.basketball-reference.com/leagues/NBA_2020_coaches.html";
	private static ArrayList<Coach> coaches;
	private static ArrayList<Player> players;
	
	public CoachesDataPage(WebDriver driver,  ArrayList<Player> players) {
		CoachesDataPage.driver = driver;
		coaches = new ArrayList<Coach>();
		CoachesDataPage.players = players;
	}
	public ArrayList<Coach> getCoaches() {
		driver.get(url);
		String pageSource = driver.getPageSource();  
		try {
			System.out.println("Getting coaches");
			Document doc = Jsoup.parse(pageSource);
			int count = 0;
			for (Element row : doc.select("#NBA_coaches tr")) {
				if (row.select("th.left").text().equals("") || row.select("th.left").text().equals("Coach")) {
					continue;
				}
				else {
					final String name = row.select("th.left").text();        		
					final String team = row.select("td.left").text();
					final String gamesWon = row.select("td.right:nth-of-type(13)").text();
					final String gamesLost = row.select("td.right:nth-of-type(14)").text();
					final String ratio = row.select("td.right:nth-of-type(15)").text();
					final String firstName = name.substring(0, name.indexOf(" "));
					final String lastName = name.substring(name.indexOf(" ")+1);
					coaches.add(new Coach("c" + count++, lastName, firstName, team, gamesWon, gamesLost, ratio));
					for (Player player: players) {
						if (player.getTeam().equals(team)) {
							coaches.get(coaches.size()-1).addPlayer(player.getID());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong with the coaches");
		}
		return coaches;	
	} 
}
