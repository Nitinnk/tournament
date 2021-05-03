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
	public String toString()
	{
		return this.A.getTeamName()+" Vs "+this.B.getTeamName()+"\n"+this.A.getCaptainName()+" Vs "+this.B.getCaptainName()+"\nMatch is scheduled on "+this.date+"\nFirst team Details are : \n"+this.A+"\nSecond team Details are : "+this.B;
	}
}