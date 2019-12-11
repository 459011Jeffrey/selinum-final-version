package objects;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private String name;
	private String rank;
	private String WLRecord;
	private List<String> playersID;
	private String coachID;
	private String teamID;
	private static String[][] TeamNames;
	private static ArrayList<Coach> coaches;
	
	
	public Team(String name, String rank, String WLRecord) {
		super();
		this.name = name;
		this.rank = rank;
		this.WLRecord = WLRecord;
		setTeamID();
		getCoach();
	}
	private void getCoach() {
		for (Coach coach : coaches) {
			if (coach.getTeam().equals(teamID)) {
				coachID = coach.getID();
				playersID = coach.getPlayerRef();
			}
		}
		
	}
	public static String[][] getTeamTags() {
		return TeamNames;
	}
	
	public void setCoach(String coachID) {
		this.coachID = coachID;
	}
	public void setPlayersID(List<String> players) {
		this.playersID = players;
	}
	public void setTeamID() {
		for (String[] stringWithName : TeamNames) {
			if (stringWithName[0].equals(name)) {
				teamID = stringWithName[1];
			}
		}
	}
	public String getName() {
		return name;
	}
	public String getRank() {
		return rank;
	}
	public List<String> getPlayersID() {
		return playersID;
	}
	public String getCoachID() {
		return coachID;
	}
	public String getTeamID() {
		return teamID;
	}
	public String getWLRecord() {
		return WLRecord;
	}
	public static void createTags() {
	TeamNames = new String[30][2];
	TeamNames[0][0] = "Atlanta Hawks";
	TeamNames[0][1] = "ATL";
	TeamNames[1][0] = "Boston Celtics";
	TeamNames[1][1] = "BOS";
	TeamNames[2][0] = "Brooklyn Nets";
	TeamNames[2][1] = "BRK";
	TeamNames[3][0] = "Charlotte Hornets";
	TeamNames[3][1] = "CHO";
	TeamNames[4][0] = "Chicago Bulls";
	TeamNames[4][1] = "CHI";
	TeamNames[5][0] = "Cleveland Cavaliers";
	TeamNames[5][1] = "CLE";
	TeamNames[6][0] = "Dallas Mavericks";
	TeamNames[6][1] = "DAL";
	TeamNames[7][0] = "Denver Nuggets";
	TeamNames[7][1] = "DEN";
	TeamNames[8][0] = "Detroit Pistons";
	TeamNames[8][1] = "DET";
	TeamNames[9][0] = "Golden State Warriors";
	TeamNames[9][1] = "GSW";
	TeamNames[10][0] = "Houston Rockets";
	TeamNames[10][1] = "HOU";
	TeamNames[11][0] = "Indiana Pacers";
	TeamNames[11][1] = "IND";
	TeamNames[12][0] = "Los Angeles Clippers";
	TeamNames[12][1] = "LAC";
	TeamNames[13][0] = "Los Angeles Lakers";
	TeamNames[13][1] = "LAL";
	TeamNames[14][0] = "Memphis Grizzlies";
	TeamNames[14][1] = "MEM";
	TeamNames[15][0] = "Miami Heat";
	TeamNames[15][1] = "MIA";
	TeamNames[16][0] = "Milwaukee Bucks";
	TeamNames[16][1] = "MIL";
	TeamNames[17][0] = "Minnesota Timberwolves";
	TeamNames[17][1] = "MIN";
	TeamNames[18][0] = "New Orleans Pelicans";
	TeamNames[18][1] = "NOP";
	TeamNames[19][0] = "New York Knicks";
	TeamNames[19][1] = "NYK";
	TeamNames[20][0] = "Oklahoma City Thunder";
	TeamNames[20][1] = "OKC";
	TeamNames[21][0] = "Orlando Magic";
	TeamNames[21][1] = "ORL";
	TeamNames[22][0] = "Philadelphia 76ers";
	TeamNames[22][1] = "PHI";
	TeamNames[23][0] = "Phoenix Suns";
	TeamNames[23][1] = "PHO";
	TeamNames[24][0] = "Portland Trail Blazers";
	TeamNames[24][1] = "POR";
	TeamNames[25][0] = "Sacramento Kings";
	TeamNames[25][1] = "SAC";
	TeamNames[26][0] = "San Antonio Spurs";
	TeamNames[26][1] = "SAS";
	TeamNames[27][0] = "Toronto Raptors";
	TeamNames[27][1] = "TOR";
	TeamNames[28][0] = "Utah Jazz";
	TeamNames[28][1] = "UTA";
	TeamNames[29][0] = "Washington Wizards";
	TeamNames[29][1] = "WAS";
	}
	public static ArrayList<Coach> getCoaches() {
		return coaches;
	}
	public static void setCoaches(ArrayList<Coach> coaches) {
		Team.coaches = coaches;
	}
}
