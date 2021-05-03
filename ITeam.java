package tournament;

public interface ITeam {
	public int getID();
	public String getTeamName();
	public String getCaptainName();
	public int getTeamSize();
	public void addMember(String name);
}
