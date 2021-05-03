package tournament;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
	private static Tournament tournament;
	private List<CricketTeam>cricketTeamsList;
	private List<BoxingTeam>boxingTeamsList;
	private List<VolleyBallTeam>volleyBallTeamsList;
	private List<IMatch>matchList;
	private List<IMatch>cricketSchedule;
	private List<IMatch>boxingSchedule;
	private List<IMatch>volleyBallSchedule;
	private LocalDate startDate,cricketDate,boxingDate,volleyBallDate;
	public LocalDate getCricketDate() {
		return cricketDate;
	}
	public void setCricketDate(LocalDate cricketDate) {
		this.cricketDate = cricketDate;
	}
	public LocalDate getBoxingDate() {
		return boxingDate;
	}
	public void setBoxingDate(LocalDate boxingDate) {
		this.boxingDate = boxingDate;
	}
	public LocalDate getVolleyBallDate() {
		return volleyBallDate;
	}
	public void setVolleyBallDate(LocalDate volleyBallDate) {
		this.volleyBallDate = volleyBallDate;
	}
	private Tournament()
	{
		
	}
	public static synchronized Tournament getInstance()
	{
		if(tournament==null)
			tournament=new Tournament();
		return tournament;
	}
	public void setStartDate(LocalDate date)
	{
		this.startDate=startDate;
		this.setCricketDate(date);
		this.setBoxingDate(date);
		this.setVolleyBallDate(date);
	}
	public void printTeamDetails(int teamID)
	{
		if(this.cricketTeamsList!=null)
		{
			for(int i=0;i<this.cricketTeamsList.size();i++)
				if(this.cricketTeamsList.get(i).getID()==teamID)
				{
					this.cricketTeamsList.get(i).printTeam();
					return;
				}
		}
		if(this.boxingTeamsList!=null)
		{
			for(int i=0;i<this.boxingTeamsList.size();i++)
				if(this.boxingTeamsList.get(i).getID()==teamID)
				{
					this.boxingTeamsList.get(i).printTeam();
					return;
				}
		}
		if(this.volleyBallTeamsList!=null)
		{
			for(int i=0;i<this.volleyBallTeamsList.size();i++)
				if(this.volleyBallTeamsList.get(i).getID()==teamID)
				{
					this.volleyBallTeamsList.get(i).printTeam();
					return;
				}
		}
		
	}
	public void exit(int teamID)
	{
		if(this.volleyBallTeamsList==null && this.boxingTeamsList==null && this.cricketTeamsList==null)
		{
			System.out.println("No Team is registered yet\n");
			return;
		}
		for(int i=0;i<this.cricketTeamsList.size();i++)
			if(this.cricketTeamsList.get(i).getID()==teamID)
			{
				this.cricketTeamsList.remove(i);
				return;
			}
		for(int i=0;i<this.boxingTeamsList.size();i++)
			if(this.boxingTeamsList.get(i).getID()==teamID)
			{
				this.boxingTeamsList.remove(i);
				return;
			}
		for(int i=0;i<this.volleyBallTeamsList.size();i++)
			if(this.volleyBallTeamsList.get(i).getID()==teamID)
			{
				this.volleyBallTeamsList.remove(i);
				return;
			}
	}
	public boolean isPresent(int teamID)
	{
		if(this.volleyBallTeamsList==null && this.boxingTeamsList==null && this.cricketTeamsList==null)
		{
			return false;
		}
		if(this.isPresentInCricketTeam(teamID))
			return true;
		if(this.isPresentInBoxingTeam(teamID))
			return true;
		if(this.isPresentInVolleyBallTeam(teamID))
			return true;
		return false;
	}
	public boolean isPresentInCricketTeam(int teamID)
	{
		if(this.cricketTeamsList==null)
			return false;
		for(CricketTeam ct:this.cricketTeamsList)
			if(ct.getID()==teamID)
				return true;
		return false;
	}
	public boolean isPresentInBoxingTeam(int teamID)
	{
		if(this.boxingTeamsList==null)
			return false;
		for(BoxingTeam ct:this.boxingTeamsList)
			if(ct.getID()==teamID)
				return true;
		return false;
	}
	public boolean isPresentInVolleyBallTeam(int teamID)
	{
		if(this.volleyBallTeamsList==null)
			return false;
		for(VolleyBallTeam ct:this.volleyBallTeamsList)
			if(ct.getID()==teamID)
				return true;
		return false;
	}
	public void addCricketTeam(CricketTeam ct)
	{
		if(this.cricketTeamsList==null)
			this.cricketTeamsList=new ArrayList<CricketTeam>(6);
		if(this.cricketTeamsList.size()==6)
		{
			System.out.println("All slots are filled\nBetter Luck Next Time");
			return ;
		}
		this.cricketTeamsList.add(ct);
		if(this.cricketTeamsList.size()%2==0)
		{
			CricketMatch cm=new CricketMatch(this.cricketTeamsList.get(this.cricketTeamsList.size()-2),this.cricketTeamsList.get(this.cricketTeamsList.size()-1),this.cricketDate);
			this.setCricketDate(this.cricketDate.plusDays(1));
			this.addCricketSchedule(cm);
			this.addMatchList(cm);
		}
	}
	public void addCricketSchedule(CricketMatch cm)
	{
		if(this.cricketSchedule==null)
			this.cricketSchedule=new ArrayList<IMatch>();
		this.cricketSchedule.add(cm);
	}
	public void addBoxingSchedule(BoxingMatch bm)
	{
		if(this.boxingSchedule==null)
			this.boxingSchedule=new ArrayList<IMatch>();
		this.boxingSchedule.add(bm);
	}
	public void addVolleyBallSchedule(VolleyBallMatch vm)
	{
		if(this.volleyBallSchedule==null)
			this.volleyBallSchedule=new ArrayList<IMatch>();
		this.volleyBallSchedule.add(vm);
	}
	public void addMatchList(IMatch im)
	{
		if(this.matchList==null)
			this.matchList=new ArrayList<IMatch>();
		this.matchList.add(im);
	}
	public void addBoxingTeam(BoxingTeam bt)
	{
		if(this.boxingTeamsList==null)
			this.boxingTeamsList=new ArrayList<BoxingTeam>(6);
		if(this.boxingTeamsList.size()==6)
		{
			System.out.println("All slots are filled\nBetter Luck Next Time");
			return ;
		}
		this.boxingTeamsList.add(bt);
		if(this.boxingTeamsList.size()%2==0)
		{
			BoxingMatch bm=new BoxingMatch(this.boxingTeamsList.get(this.boxingTeamsList.size()-2),this.boxingTeamsList.get(this.boxingTeamsList.size()-1),this.boxingDate);
			this.setBoxingDate(this.boxingDate.plusDays(1));
			this.addBoxingSchedule(bm);
			this.addMatchList(bm);
		}
	}
	public void addVolleyBallTeam(VolleyBallTeam vt)
	{
		if(this.volleyBallTeamsList==null)
			this.volleyBallTeamsList=new ArrayList<VolleyBallTeam>(6);
		if(this.volleyBallTeamsList.size()==6)
		{
			System.out.println("All slots are filled\nBetter Luck Next Time");
			return ;
		}
		this.volleyBallTeamsList.add(vt);
		if(this.volleyBallTeamsList.size()%2==0)
		{
			VolleyBallMatch vm=new VolleyBallMatch(this.volleyBallTeamsList.get(this.volleyBallTeamsList.size()-2),this.volleyBallTeamsList.get(this.volleyBallTeamsList.size()-1),this.volleyBallDate);
			this.setVolleyBallDate(this.volleyBallDate.plusDays(1));
			this.addVolleyBallSchedule(vm);
			this.addMatchList(vm);
		}
	}
	public void printAllCricketMatchSchedules()
	{
		if(this.cricketSchedule==null)
		{
			System.out.println("No Cricket Match is scheduled yet\n");
			return;
		}
		System.out.println("Cricket Matches : ");
		for(IMatch cm:this.cricketSchedule)
		{
			cm.printMatchDetails();
		}
	}
	public void printAllBoxingMatchSchedules()
	{
		if(this.boxingSchedule==null)
		{
			System.out.println("No Boxing Match is scheduled yet\n");
			return;
		}
		System.out.println("Boxing Matches : ");
		for(IMatch bm:this.boxingSchedule)
		{
			bm.printMatchDetails();
		}
	}
	public void printAllVolleyBallMatchSchedules()
	{
		if(this.volleyBallSchedule==null)
		{
			System.out.println("No VolleyBall Match is scheduled yet\n");
			return;
		}
		System.out.println("VolleyBall Matches : ");
		for(IMatch vm:this.volleyBallSchedule)
		{
			vm.printMatchDetails();
		}
	}
	public void printAllMatchesSchedule()
	{
		if(this.matchList==null)
		{
			System.out.println("No Match is scheduled yet\n");
			return;
		}
		this.printAllCricketMatchSchedules();
		this.printAllBoxingMatchSchedules();
		this.printAllVolleyBallMatchSchedules();
	}
	public void printAllCricketTeams()
	{
		if(this.cricketTeamsList==null)
		{
			System.out.println("No Cricket Team is registered yet\n");
			return;
		}	
		for(CricketTeam ct:this.cricketTeamsList)
			ct.printTeam();
	}
	public void printAllBoxingTeams()
	{
		if(this.boxingTeamsList==null)
		{
			System.out.println("No Boxing Team is registered yet\n");
			return;
		}	
		for(BoxingTeam bt:this.boxingTeamsList)
			bt.printTeam();
	}
	public void printAllVolleyBallTeams()
	{
		if(this.volleyBallTeamsList==null)
		{
			System.out.println("No VolleyBall Team is registered yet\n");
			return;
		}	
		for(VolleyBallTeam vt:this.volleyBallTeamsList)
			vt.printTeam();
	}
	public void printAllTeams()
	{
		if(this.volleyBallTeamsList==null && this.boxingTeamsList==null && this.cricketTeamsList==null)
		{
			System.out.println("No Team is registered yet\n");
			return;
		}
		System.out.println("All Cricket Teams List : ");
		this.printAllCricketTeams();
		System.out.println("All Boxing Teams List : ");
		this.printAllBoxingTeams();
		System.out.println("All VolleyBall Teams List : ");
		this.printAllVolleyBallTeams();
	}
}