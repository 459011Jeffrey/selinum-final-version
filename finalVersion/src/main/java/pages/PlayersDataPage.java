package pages;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;

import objects.Player;

public class PlayersDataPage {
	private static WebDriver driver;
	private static final String url = "https://www.basketball-reference.com/leagues/NBA_2020_per_game.html";
	static ArrayList<Player> players;
	
	public PlayersDataPage (WebDriver driver) {
		PlayersDataPage.driver = driver;
		players = new ArrayList<Player>();
	}
	
	public  ArrayList<Player> getData() {
		driver.get(url);
		String pageSource = driver.getPageSource();  
		try {
			System.out.println("Getting players");
			Document doc = Jsoup.parse(pageSource);        
			for (Element row : doc.select("#per_game_stats tr")) {
				if (row.select("th.right").text().equals("")) {
					continue;
				}
				else {
					final String rank = row.select("th.right").text();        		
					final String name = row.select("td:nth-of-type(1)").text();        		
					final String team = row.select("td.left:nth-of-type(4)").text();
					final String games = row.select("td.right:nth-of-type(5)").text();
					final String age = row.select("td.right:nth-of-type(3)").text();
					final String firstName = name.substring(0, name.indexOf(" "));
					final String lastName = name.substring(name.indexOf(" ")+1);
					players.add(new Player("p" + rank, lastName, firstName, team, games, age));		
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace(); 
			System.err.println("something went wron when getting the player");
		}		
		return players;
	}
}
