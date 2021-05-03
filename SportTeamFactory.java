package tournament;

public class SportTeamFactory {
	public static ITeam getClass(String sportName,int id,String teamName,String captainName)
	{
		if(sportName.equalsIgnoreCase("cricket"))
			return new CricketTeam(id,teamName,captainName);
		else
			if(sportName.equalsIgnoreCase("volleyball"))
				return new VolleyBallTeam(id,teamName,captainName);
			else
				return null;
	}
	public static ITeam getClass(String sportName,int id,String teamName,String captainName,int boxerAge,int boxerWeight)
	{
			if(sportName.equalsIgnoreCase("boxing"))
				return new BoxingTeam(id,teamName,captainName,boxerAge,boxerWeight);
			else
				return null;
	}
}
