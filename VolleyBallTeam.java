package tournament;

public class VolleyBallTeam extends Team{
	VolleyBallTeam(int id,String teamName,String captainName)
	{
		super(id,teamName,captainName,6);
	}
	public void printTeam()
	{
		System.out.println("VolleyBall Team Details: ");
		super.printTeam();
	}
}
