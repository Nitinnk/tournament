package tournament;

import java.util.ArrayList;
import java.util.List;

public class Schedule implements ISchedule{
	private List<IMatch>matches;
	@Override
	public void addMatch(IMatch match)
	{
		if(this.matches==null)
			this.matches=new ArrayList<IMatch>();
		this.matches.add(match);
	}
	/**
	 * getMatchList returns the list of all the matches that have been added.
	 * @return
	 */
	public List<IMatch> getMatchList()
	{
		return this.matches;
	}
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		for(IMatch match:this.matches)
		{
			sb.append(match.toString()+"\n");
		}
		return String.valueOf(sb);
	}
}
