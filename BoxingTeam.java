package tournament;

public class BoxingTeam extends Team{
	private int age,weight;
	BoxingTeam(int id,String teamName,String captainName,int age,int weight)
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

	public void printTeam()
	{
		System.out.println("Boxing Team Details: ");
		System.out.println("Boxer Name : "+this.getCaptainName());
		System.out.println("Boxer Age : "+this.getAge());
		System.out.println("Boxer Weight : "+this.getWeight());
	}
}
