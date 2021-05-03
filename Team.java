package tournament;

import java.util.ArrayList;
/**
 * Team class instance has all the basic details of any particular sport team.
 * @author Nitin
 *
 */
public class Team implements ITeam{
	private int id;
	private int teamSize;
	private String teamName;
	private String captainName;
	private ArrayList<String>teamMembers;
	public Team(int id,String teamName,String captainName,int teamSize)
	{
		this.id=id;
		this.teamName=teamName;
		this.captainName=captainName;
		this.teamSize=teamSize;
	}
	public String toString()
	{
		return "Team Name : "+this.getTeamName()+"\nCaptain Name : "+this.getCaptainName()+"\nID : "+this.getID()+"\n"+"Team Members : "+this.getTeam();
	}
	/**
	 * addMember method is used to add the name of a team member to that instance's teamMembers list.
	 */
	@Override
	public void addMember(String name)
	{
		if(this.teamMembers==null)
			this.teamMembers=new ArrayList<String>();
		this.teamMembers.add(name);
	}
	public ArrayList<String> getTeam()
	{
		return this.teamMembers;
	}
	@Override
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	@Override
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String getCaptainName() {
		return captainName;
	}
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	@Override
	public int getID() {
		return this.id;
	}
	
}
