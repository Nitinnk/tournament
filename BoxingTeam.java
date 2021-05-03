package tournament;
public class BoxingTeam extends Team{
	private int age,weight;
	public BoxingTeam(int id,String teamName,String captainName,int age,int weight)
	{
		super(id,teamName,captainName,1);
		this.age=age;
		this.weight=weight;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String toString()
	{
		return "Team Name : "+this.getTeamName()+"\nBoxer Name : "+this.getCaptainName()+"\nID : "+this.getID()+"\nBoxer Age : "+this.getAge()+"\nBoxer Weight : "+this.getWeight();
	}
}
