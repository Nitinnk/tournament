package tournament;

import java.time.LocalDate;

public class Match implements IMatch{
	private ITeam A,B;
	private LocalDate date;
	public Match(ITeam A,ITeam B,LocalDate date)
	{
		this.A=A;
		this.B=B;
		this.date=date;
	}
	@Override
	public void printMatchDetails()
	{
		System.out.println(this.A.getTeamName()+" Vs "+this.B.getTeamName());
		System.out.println(this.A.getCaptainName()+" Vs "+this.B.getCaptainName());
		System.out.println("Match is scheduled on "+this.date);
		System.out.println("First team Details are : ");
		this.A.printTeam();
		System.out.println("Second team Details are : ");
		this.B.printTeam();
	}
}
