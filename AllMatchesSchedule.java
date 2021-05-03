package tournament;

import java.util.List;

public class AllMatchesSchedule {
	private static AllMatchesSchedule ams;
	private CricketSchedule cricketSchedule;
	private BoxingSchedule boxingSchedule;
	private VolleyBallSchedule volleyBallSchedule;
	private AllMatchesSchedule()
	{
	}
	public static AllMatchesSchedule getInstance()
	{
		if(ams==null)
			ams=new AllMatchesSchedule();
		return ams;
	}
	public CricketSchedule getCricketSchedule() {
		return cricketSchedule;
	}
	public void setCricketSchedule(CricketSchedule cricketSchedule) {
		this.cricketSchedule = cricketSchedule;
	}
	public BoxingSchedule getBoxingSchedule() {
		return boxingSchedule;
	}
	public void setBoxingSchedule(BoxingSchedule boxingSchedule) {
		this.boxingSchedule = boxingSchedule;
	}
	public VolleyBallSchedule getVolleyBallSchedule() {
		return volleyBallSchedule;
	}
	public void setVolleyBallSchedule(VolleyBallSchedule volleyBallSchedule) {
		this.volleyBallSchedule = volleyBallSchedule;
	}
	public boolean checkTeamPresence(int teamID)
	{
		if(this.getCricketSchedule()!=null)
			for(IMatch match:this.getCricketSchedule().getMatchList())
				if(teamID==match.getTeam1().getID() || teamID==match.getTeam2().getID())
					return true;
		if(this.getBoxingSchedule()!=null)
			for(IMatch match:this.getBoxingSchedule().getMatchList())
				if(teamID==match.getTeam1().getID() || teamID==match.getTeam2().getID())
					return true;
		if(this.getVolleyBallSchedule()!=null)
			for(IMatch match:this.getVolleyBallSchedule().getMatchList())
				if(teamID==match.getTeam1().getID() || teamID==match.getTeam2().getID())
					return true;
		return false;
	}
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		if(this.getCricketSchedule()==null)
			sb.append("No Cricket Matches Scheduled yet\n");
		else
			sb.append(this.getCricketSchedule().toString());
		
		if(this.getBoxingSchedule()==null)
			sb.append("\nNo Boxing Matches Scheduled yet\n");
		else
			sb.append("\n"+this.getBoxingSchedule().toString());
		
		if(this.getVolleyBallSchedule()==null)
			sb.append("\nNo VolleyBall Matches Scheduled yet\n");
		else
			sb.append("\n"+this.getVolleyBallSchedule().toString());
		
		return String.valueOf(sb);
	}
}
