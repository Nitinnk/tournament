package tournament;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Tournament class is a singleton class whose instance has all the details of the tournament. like list of each sport teams, schedules of matches.
 * This instance is responsible for storing teams list,date and scheduling matches.
 * @author Nitin
 *
 */
public class Tournament {
	private static Tournament tournament;
	private List<CricketTeam>cricketTeamsList;
	private List<BoxingTeam>boxingTeamsList;
	private List<VolleyBallTeam>volleyBallTeamsList;
	private boolean registered=false;
	private LocalDate startDate,cricketDate,boxingDate,volleyBallDate;
	private CricketSchedule cs;
	private BoxingSchedule bs;
	private VolleyBallSchedule vs;
	private Tournament()
	{
	}
	public static synchronized Tournament getInstance()
	{
		if(tournament==null)
			tournament=new Tournament();
		return tournament;
	}
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
	public List<CricketTeam> getCricketTeamsList() {
		return cricketTeamsList;
	}
	public void setCricketTeamsList(List<CricketTeam> cricketTeamsList) {
		this.cricketTeamsList = cricketTeamsList;
	}
	public List<BoxingTeam> getBoxingTeamsList() {
		return boxingTeamsList;
	}
	public void setBoxingTeamsList(List<BoxingTeam> boxingTeamsList) {
		this.boxingTeamsList = boxingTeamsList;
	}
	public List<VolleyBallTeam> getVolleyBallTeamsList() {
		return volleyBallTeamsList;
	}
	public void setVolleyBallTeamsList(List<VolleyBallTeam> volleyBallTeamsList) {
		this.volleyBallTeamsList = volleyBallTeamsList;
	}
	public void setStartDate(LocalDate date)
	{
		this.startDate=startDate;
		this.setCricketDate(date);
		this.setBoxingDate(date);
		this.setVolleyBallDate(date);
	}
	public ISchedule getCricketSchedule()
	{
		if(this.cs==null)
			cs=new CricketSchedule();
		return cs;
	}
	public ISchedule getBoxingSchedule()
	{
		if(this.bs==null)
			bs=new BoxingSchedule();
		return bs;
	}
	public ISchedule getVolleyBallSchedule()
	{
		if(this.vs==null)
			vs=new VolleyBallSchedule();
		return vs;
	}
	public AllMatchesSchedule getAllMatchesSchedule()
	{
		return AllMatchesSchedule.getInstance();
	}
	public ISchedule getCricketScheduleToMain()
	{
		return this.cs;
	}
	public ISchedule getBoxingScheduleToMain()
	{
		return this.bs;
	}
	public ISchedule getVolleyBallScheduleToMain()
	{
		return this.vs;
	}
	/**
	 * checkRegistered method will check whether any team is playing in the tournament now or not.
	 * @return boolean
	 */
	public boolean checkRegistered()
	{
		if((this.volleyBallTeamsList==null ||this.volleyBallTeamsList.size()==0) && (this.boxingTeamsList==null || this.boxingTeamsList.size()==0) && (this.cricketTeamsList==null || this.cricketTeamsList.size()==0))
		{
			return false;
		}
		return true;
	}
	/**
	 * exit method is used to remove the team whose teamID will be given by the user.
	 * @param teamID
	 */
	public void exit(int teamID)
	{
		if(this.volleyBallTeamsList==null && this.boxingTeamsList==null && this.cricketTeamsList==null)
		{
			return;
		}
		if(this.cricketTeamsList!=null)
		{
			for(int i=0;i<this.cricketTeamsList.size();i++)
				if(this.cricketTeamsList.get(i).getID()==teamID)
				{
					this.cricketTeamsList.remove(i);
					return;
				}
		}
		if(this.boxingTeamsList!=null)
		{
			for(int i=0;i<this.boxingTeamsList.size();i++)
				if(this.boxingTeamsList.get(i).getID()==teamID)
				{
					this.boxingTeamsList.remove(i);
					return;
				}
		}
		if(this.volleyBallTeamsList!=null)
		{
			for(int i=0;i<this.volleyBallTeamsList.size();i++)
				if(this.volleyBallTeamsList.get(i).getID()==teamID)
				{
					this.volleyBallTeamsList.remove(i);
					return;
				}
		}
		
	}
	/**
	 * isPresent method will check whether any team is present with the given teamID or not.
	 * @param teamID
	 * @return boolean
	 */
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
	/**
	 * isPresentInCricketTeam method will check whether any cricket team is present with the given teamID or not.
	 * @param teamID
	 * @return
	 */
	public boolean isPresentInCricketTeam(int teamID)
	{
		if(this.cricketTeamsList==null)
			return false;
		for(CricketTeam ct:this.cricketTeamsList)
			if(ct.getID()==teamID)
				return true;
		return false;
	}
	/**
	 * isPresentInBoxingTeam method will check whether any boxing team is present with the given teamID or not.
	 * @param teamID
	 * @return
	 */
	public boolean isPresentInBoxingTeam(int teamID)
	{
		if(this.boxingTeamsList==null)
			return false;
		for(BoxingTeam ct:this.boxingTeamsList)
			if(ct.getID()==teamID)
				return true;
		return false;
	}
	/**
	 * isPresentInVolleyBall Team method will check whether any volleyBall team is present with the given teamID or not.
	 * @param teamID
	 * @return
	 */
	public boolean isPresentInVolleyBallTeam(int teamID)
	{
		if(this.volleyBallTeamsList==null)
			return false;
		for(VolleyBallTeam ct:this.volleyBallTeamsList)
			if(ct.getID()==teamID)
				return true;
		return false;
	}
	/**
	 *  getCurrentTeam method will return the team with given teamID.
	 * @param teamID
	 * @return
	 */
	public ITeam getCurrentTeam(int teamID)
	{
		if(this.isPresentInCricketTeam(teamID))
			return this.getCurrentCricketTeam(teamID);
		if(this.isPresentInBoxingTeam(teamID))
			return this.getCurrentBoxingTeam(teamID);
		if(this.isPresentInVolleyBallTeam(teamID))
			return this.getCurrentVolleyBallTeam(teamID);
		return null;
	}
	/**
	 *  getCurrentCricketTeam method will return the cricket team with given teamID.
	 * @param teamID
	 * @return
	 */
	public ITeam getCurrentCricketTeam(int teamID)
	{
		for(CricketTeam ct:this.cricketTeamsList)
			if(ct.getID()==teamID)
				return ct;
		return null;
	}
	/**
	 *  getCurrentBoxingTeam method will return the boxing team with given teamID.
	 * @param teamID
	 * @return
	 */
	public ITeam getCurrentBoxingTeam(int teamID)
	{
		for(BoxingTeam ct:this.boxingTeamsList)
			if(ct.getID()==teamID)
				return ct;
		return null;
	}
	/**
	 *  getCurrentVolleyBallTeam method will return the volley ball team with given teamID.
	 * @param teamID
	 * @return
	 */
	public ITeam getCurrentVolleyBallTeam(int teamID)
	{
		for(VolleyBallTeam ct:this.volleyBallTeamsList)
			if(ct.getID()==teamID)
				return ct;
		return null;
	}
	/**
	 * addCricketTeam method will add the given cricket team to the cricketteamslist.
	 * It also schedules matches between two consecutive cricket teams and adds that match to the cricket schedule.
	 * @param ct
	 */
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
			this.getCricketSchedule().addMatch(cm);
		}
	}/**
	 * addBoxxingTeam method will add the given boxing team to the boxingteamslist.
	 * It also schedules matches between two consecutive boxing teams and adds that match to the boxing schedule.
	 * @param bt
	 */
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
			this.getBoxingSchedule().addMatch(bm);
		}
	}
	/**
	 * addVolleyBallTeam method will add the given VolleyBall team to the VolleyBallteamslist.
	 * It also schedules matches between two consecutive VolleyBall teams and adds that match to the VolleyBall schedule.
	 * @param vt
	 */
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
			this.getVolleyBallSchedule().addMatch(vm);
		}
	}
	/**
	 * scheduleAllMatches method will add all the sport schedules to the AllMatchesSchedule instance.
	 */
	public void scheduleAllMatches()
	{
		AllMatchesSchedule ams=AllMatchesSchedule.getInstance();
		ams.setCricketSchedule(this.cs);
		ams.setBoxingSchedule(this.bs);
		ams.setVolleyBallSchedule(this.vs);
	}
}