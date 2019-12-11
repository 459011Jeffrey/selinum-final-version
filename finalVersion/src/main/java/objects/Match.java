package objects;

public class Match {
	private String matchID;
	private String visitorRef;
	private String homeRef;
	private String date;
	private String visitorScore;
	private String homeScore;
	private String winnerName;
	
	public Match(String matchID, String visitorRef, String homeRef, String date, String visitorScore,
			String homeScore, String winnerName) {
		super();
		this.matchID = matchID;
		for (String[] string : Team.getTeamTags()) {
			if (string[0].equals(visitorRef)) {
				this.visitorRef = string[1];
			}
			if (string[0].equals(homeRef)) {
				this.homeRef = string[1];
			}
		}
		this.date = date;
		this.visitorScore = visitorScore;
		this.homeScore = homeScore;
		this.winnerName = winnerName;
	}
	public String getMatchID() {
		return matchID;
	}
	public void setMatchID(String matchID) {
		this.matchID = matchID;
	}
	public String getVisitorRef() {
		return visitorRef;
	}
	public void setVisitorRef(String visitorRef) {
		this.visitorRef = visitorRef;
	}
	public String getHomeRef() {
		return homeRef;
	}
	public void setHomeRef(String homeRef) {
		this.homeRef = homeRef;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVisitorScore() {
		return visitorScore;
	}
	public void setVisitorScore(String visitorScore) {
		this.visitorScore = visitorScore;
	}
	public String getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(String homeScore) {
		this.homeScore = homeScore;
	}
	public String getWinnerName() {
		return winnerName;
	}
	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}

}
