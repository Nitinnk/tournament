package tournament;

public class CricketTeam extends Team{
	
	CricketTeam(int id,String teamName,String captainName)
	{
		super(id,teamName,captainName,11);
	}
	public void printTeam()
	{
		System.out.println("Cricket Team Details: ");
		super.printTeam();
	}
	
}
