package tournament;
/**
 * ITeam interface has all the basic details of a team. It is implemented by Team class.
 * @author Nitin
 *
 */
public interface ITeam {
	public int getID();
	public String getTeamName();
	public String getCaptainName();
	public int getTeamSize();
	public void addMember(String name);
}
