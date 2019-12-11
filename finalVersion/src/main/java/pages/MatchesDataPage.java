package pages;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;

import objects.Match;

public class MatchesDataPage {
	private static WebDriver driver;
	private static final String url = "https://www.basketball-reference.com/leagues/NBA_2020_games.html";
	private static ArrayList<Match> matches;
	
	public MatchesDataPage(WebDriver driver) {
		MatchesDataPage.driver = driver;
		matches = new ArrayList<Match>();
	}
	
	public  ArrayList<Match> getMatches () {
		driver.get(url);
		String pageSource = driver.getPageSource();  
		try {
			System.out.println("Getting matches");
			Document doc = Jsoup.parse(pageSource);
			int counter = 0;
			for (Element row : doc.select("#schedule tr")) {
				if (row.select("th.left").text().equals(""))  {
					continue;
				} 
				else {
					final String date = row.select("th.left").text();
					final String visitor = row.select("td.left:nth-of-type(2)").text();
					final String home = row.select("td.left:nth-of-type(4)").text();
					final String visitorScore = row.select("td.right:nth-of-type(3)").text();
					final String homeScore = row.select("td.right:nth-of-type(5)").text();
					int homeS = Integer.valueOf(visitorScore);
					int visitorS = Integer.valueOf(homeScore);
					final String winner = homeS > visitorS ? visitor : home;
					matches.add(new Match("m" + counter++, visitor, home, date, visitorScore, homeScore, winner));
				}
			}
		}
		catch (Exception e) {
			System.out.println("Matches are not working yet");
			e.printStackTrace();
		}
		return matches;
	}
}
