package xmlClasses;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import objects.Coach;
import objects.Match;
import objects.Player;
import objects.Team;

public class XMLBuilder {
	private ArrayList<Player> players;
	private ArrayList<Coach> coaches;
	private ArrayList<Team> teams;
	private ArrayList<Match> matches;

	public XMLBuilder(ArrayList<Player> players, ArrayList<Coach> coaches, ArrayList<Team> teams,
			ArrayList<Match> matches) {
		super();
		this.players = players;
		this.coaches = coaches;
		this.teams = teams;
		this.matches = matches;
	}

	public void createXML() {
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			System.out.println("Creating elements");

			Element root = document.createElement("basketball");
			document.appendChild(root);

			for (Player playerfromList : players) {
				Element player = document.createElement("player");
				root.appendChild(player);

				Attr attr = document.createAttribute("id");
				attr.setValue(playerfromList.getID());
				player.setAttributeNode(attr);

				Element names = document.createElement("name");
				player.appendChild(names);

				Element firstName = document.createElement("firstname");
				firstName.appendChild(document.createTextNode(playerfromList.getFirstName()));
				names.appendChild(firstName);

				Element lastname = document.createElement("lastname");
				lastname.appendChild(document.createTextNode(playerfromList.getLastName()));
				names.appendChild(lastname);

				Element age = document.createElement("age");
				age.appendChild(document.createTextNode(playerfromList.getAge()));
				player.appendChild(age);

				Element teamref = document.createElement("team_ref");
				player.appendChild(teamref);

				Attr attrTeamID = document.createAttribute("idref");
				attrTeamID.setValue(playerfromList.getTeam());
				teamref.setAttributeNode(attrTeamID);

				Element games = document.createElement("games_played");
				games.appendChild(document.createTextNode(playerfromList.getGames()));
				player.appendChild(games);
			}

			for (Coach coachesFromList : coaches) { 
				Element coach = document.createElement("coach");
				root.appendChild(coach);

				Attr attr = document.createAttribute("id");
				attr.setValue(coachesFromList.getID());
				coach.setAttributeNode(attr);

				Element names = document.createElement("name");
				coach.appendChild(names);

				Element firstName = document.createElement("firstname");
				firstName.appendChild(document.createTextNode(coachesFromList.getFirstName()));
				names.appendChild(firstName);

				Element lastname = document.createElement("lastname");
				lastname.appendChild(document.createTextNode(coachesFromList.getLastName()));
				names.appendChild(lastname);

				Element teamref = document.createElement("team_ref");
				coach.appendChild(teamref);

				Attr attrTeamID = document.createAttribute("idref");
				attrTeamID.setValue(coachesFromList.getTeam());
				teamref.setAttributeNode(attrTeamID);

				Element performance = document.createElement("performance");
				coach.appendChild(performance);

				Element won = document.createElement("wins");
				won.appendChild(document.createTextNode(coachesFromList.getWon()));
				performance.appendChild(won);

				Element lost = document.createElement("losses");
				lost.appendChild(document.createTextNode(coachesFromList.getLost()));
				performance.appendChild(lost);

				Element ratio = document.createElement("ratio");
				ratio.appendChild(document.createTextNode(coachesFromList.getRatio()));
				performance.appendChild(ratio);
			}

			for (Team teamFromList : teams) { 
				Element team = document.createElement("team");
				root.appendChild(team);

				Attr attr = document.createAttribute("id");
				attr.setValue(teamFromList.getTeamID());
				team.setAttributeNode(attr);

				Element name = document.createElement("team_name");
				name.appendChild(document.createTextNode(teamFromList.getName()));
				team.appendChild(name);

				Element winstLoseRecord = document.createElement("win_loss_record");
				winstLoseRecord.appendChild(document.createTextNode(teamFromList.getWLRecord()));
				team.appendChild(winstLoseRecord);

				for (String playerID : teamFromList.getPlayersID())  {
					Element playerref = document.createElement("player_ref");
					team.appendChild(playerref);

					Attr attrPlayerID = document.createAttribute("idref"); 
					attrPlayerID.setValue(playerID);
					playerref.setAttributeNode(attrPlayerID);
				}

				Element coachref = document.createElement("coach_ref");
				team.appendChild(coachref);

				Attr attrCoachID = document.createAttribute("idref"); 
				attrCoachID.setValue(teamFromList.getCoachID());
				coachref.setAttributeNode(attrCoachID);
			}

			for (Match matchFromList : matches) { 
				Element match = document.createElement("match");
				root.appendChild(match);

				Attr attr = document.createAttribute("id");
				attr.setValue(matchFromList.getMatchID());
				match.setAttributeNode(attr);

				Element team = document.createElement("teams");
				match.appendChild(team);

				Element homeTeamRef = document.createElement("home_team_ref");
				team.appendChild(homeTeamRef);

				Attr attrHomeTeamID = document.createAttribute("idref");
				attrHomeTeamID.setValue(matchFromList.getHomeRef());
				homeTeamRef.setAttributeNode(attrHomeTeamID);

				Element visitorTeamRef = document.createElement("visitor_team_ref");
				team.appendChild(visitorTeamRef);

				Attr attrVisitorTeamID = document.createAttribute("idref");
				attrVisitorTeamID.setValue(matchFromList.getVisitorRef());
				visitorTeamRef.setAttributeNode(attrVisitorTeamID);

				Element date = document.createElement("date");
				date.appendChild(document.createTextNode(matchFromList.getDate()));
				match.appendChild(date);

				Element score = document.createElement("score");
				match.appendChild(score);

				Element homeScore = document.createElement("home_score");
				homeScore.appendChild(document.createTextNode(matchFromList.getHomeScore()));
				score.appendChild(homeScore);

				Element opponentScore = document.createElement("visitor_score");
				opponentScore.appendChild(document.createTextNode(matchFromList.getVisitorScore()));
				score.appendChild(opponentScore);

				Element winner = document.createElement("winner");
				winner.appendChild(document.createTextNode(matchFromList.getWinnerName()));
				score.appendChild(winner);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File("lib/file.xml"));
			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}



