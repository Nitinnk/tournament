package tournament;

import java.util.ArrayList;

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
	public void printTeam()
	{
		System.out.println("Captain is "+this.captainName);
		for(String member:this.teamMembers)
		{
			System.out.println(member);
		}
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
		// TODO Auto-generated method stub
		return this.id;
	}
	
}
