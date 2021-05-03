package tournament;

import java.time.LocalDate;
/**
 * Match class has two opponent teams and the date on which their match is scheduled.
 * @author Nitin
 *
 */
public class Match implements IMatch{
	private ITeam A,B;
	private LocalDate date;
	public Match(ITeam A,ITeam B,LocalDate date)
	{
		this.A=A;
		this.B=B;
		this.date=date;
	}
	/**
	 * getTeam1 returns the first team in match.
	 */
	@Override
	public ITeam getTeam1()
	{
		return A;
	}
	/**
	 * getTeam2 returns the second team in match.
	 */
	@Override
	public ITeam getTeam2()
	{
		return B;
	}
	public String toString()
	{
		return this.A.getTeamName()+" Vs "+this.B.getTeamName()+"\n"+this.A.getCaptainName()+" Vs "+this.B.getCaptainName()+"\nMatch is scheduled on "+this.date+"\nFirst team Details are : \n"+this.A+"\nSecond team Details are : \n"+this.B;
	}
}