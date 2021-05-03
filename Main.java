package tournament;
import java.time.LocalDate;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		Tournament tournament=Tournament.getInstance();
		tournament.setStartDate(LocalDate.of(2021, 5, 10));
		homePage(in,tournament);
	}
	public static void homePage(Scanner in,Tournament tournament)
	{
		System.out.println("Welcome to the Sports Tournament");
		System.out.println("Choose the operation number");
		System.out.println("1-Register your Team for the tournament");
		System.out.println("2-Exit from the tournament");
		System.out.println("3-Print Details of your team");
		System.out.println("4-Print All the teams participating in the tournament");
		System.out.println("5-Print All the Cricket teams participating in the tournament");
		System.out.println("6-Print All the Boxing teams participating in the tournament");
		System.out.println("7-Print All the VolleyBall teams participating in the tournament");
		System.out.println("8-Print All the Match Schedules in the tournament");
		System.out.println("9-Print All the Cricket Match Schedules in the tournament");
		System.out.println("10-Print All the Boxing Match Schedules in the tournament");
		System.out.println("11-Print All the VolleyBall Match Schedules in the tournament");
		System.out.println("12-Exit");
		switch(in.nextInt())
		{
		case 1:
			System.out.println("Enter the Sport Name : ");
			String sportName=in.next();
			if(sportName.equalsIgnoreCase("boxing"))
			{
				askBoxingTeamDetails(in,sportName,tournament);
			}
			else
			{
				if(sportName.equalsIgnoreCase("cricket"))
				{
					askCricketTeamDetails(in,sportName,tournament);
				}
				else
				{
					if(sportName.equalsIgnoreCase("volleyball"))
					{
						askVolleyBallTeamDetails(in,sportName,tournament);
					}
					else
					{
						System.out.println("Invalid Input");
						askHomePage(in,tournament);
					}
				}
			}
			break;
		case 2:
			int teamID=takeIDInput(in,tournament);
			if(tournament.getAllMatchesSchedule().checkTeamPresence(teamID))
				System.out.println("Cannot exit the tournament after match is scheduled");
			else
			{
				tournament.exit(teamID);
				System.out.println("Successfully Exited from the tournament");
			}
			askHomePage(in,tournament);
			break;
		case 3:
			int teamID1=takeIDInput(in,tournament);
			ITeam team=tournament.getCurrentTeam(teamID1);
			System.out.println(team);
			askHomePage(in,tournament);
			break;
		case 4:
			printAllTeams(tournament);
			askHomePage(in,tournament);
			break;
		case 5:
			printAllCricketTeams(tournament);
			askHomePage(in,tournament);
			break;
		case 6:
			printAllBoxingTeams(tournament);
			askHomePage(in,tournament);
			break;
		case 7:
			printAllVolleyBallTeams(tournament);
			askHomePage(in,tournament);
			break;
		case 8:
			tournament.scheduleAllMatches();
			if(tournament.getAllMatchesSchedule().equals(null))
				System.out.println("No Matches are scheduled yet");
			else
				System.out.println(tournament.getAllMatchesSchedule());
			askHomePage(in,tournament);
			break;
		case 9:
			ISchedule temp=tournament.getCricketScheduleToMain();
			if(temp==null)
				System.out.println("No Cricket Matches are scheduled yet");
			else
				System.out.println(temp);
			askHomePage(in,tournament);
			break;
		case 10:
			ISchedule temp1=tournament.getBoxingScheduleToMain();
			if(temp1==null)
				System.out.println("No Boxing Matches are scheduled yet");
			else
				System.out.println(temp1);
			askHomePage(in,tournament);
			break;
		case 11:
			ISchedule temp2=tournament.getVolleyBallScheduleToMain();
			if(temp2==null)
				System.out.println("No VolleyBall Matches are scheduled yet");
			else
				System.out.println(temp2);
			askHomePage(in,tournament);
			break;
		case 12:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Input");
			System.exit(0);
		}
	}
	public static int takeIDInput(Scanner in,Tournament tournament)
	{
		if(!tournament.checkRegistered())
		{
			System.out.println("No team is Registered until now");
			askHomePage(in,tournament);
		}
		System.out.println("Enter the Team ID : ");
		int id=in.nextInt();
		if(tournament.isPresent(id))
			return id;
		else
		{
			System.out.println("ID entered does not exist in our database.\n Do you want to try again?(y/n)");
			char choice=in.next().charAt(0);
			switch(choice)
			{
			case 'y':
				takeIDInput(in,tournament);
				break;
			case 'n':
				System.exit(0);
				default:
					System.out.println("Invalid Input");
					System.exit(0);
			}
		}
		return 0;
	}
	public static void askHomePage(Scanner in,Tournament tournament)
	{
		System.out.println("1-Go Back to HomePage");
		System.out.println("2-Exit");
		switch(in.nextInt())
		{
		case 1:homePage(in,tournament);
		break;
		case 2:
			System.exit(0);
			default:
				System.out.println("Invalid Input");
				System.exit(0);
		}
	}
	public static void askBoxingTeamDetails(Scanner in,String sportName,Tournament tournament)
	{
		System.out.println("Enter the Team Name : ");
		String teamName=in.next();
		System.out.println("Enter the Team ID : ");
		int teamID=in.nextInt();
		System.out.println("Enter the Boxer Name : ");
		String boxerName=in.next();
		System.out.println("Enter the Boxer Age : ");
		int boxerAge=in.nextInt();
		System.out.println("Enter the Boxer Weight : ");
		int boxerWeight=in.nextInt();
		ITeam boxingTeam=SportTeamFactory.getClass(sportName,teamID, teamName,boxerName,boxerAge,boxerWeight);
		boxingTeam.addMember(boxerName);
		System.out.println(boxingTeam);
		tournament.addBoxingTeam((BoxingTeam) boxingTeam);
		askHomePage(in,tournament);
	}
	public static void askCricketTeamDetails(Scanner in,String sportName,Tournament tournament)
	{
		System.out.println("Enter the Team Name : ");
		String teamName=in.next();
		System.out.println("Enter the Team ID : ");
		int teamID=in.nextInt();
		System.out.println("Enter the Captain Name : ");
		String captainName=in.next();
		ITeam cricketTeam=SportTeamFactory.getClass(sportName,teamID, teamName, captainName);
		System.out.println("Enter the Team members names : ");
		for(int i=0;i<cricketTeam.getTeamSize();i++)
		{
			System.out.print("Team Member Name : ");
			cricketTeam.addMember(in.next());
			System.out.println();
		}
		System.out.println(cricketTeam);
		tournament.addCricketTeam((CricketTeam) cricketTeam);
		askHomePage(in,tournament);
	}
	public static  void askVolleyBallTeamDetails(Scanner in,String sportName,Tournament tournament)
	{
		System.out.println("Enter the Team Name : ");
		String teamName=in.next();
		System.out.println("Enter the Team ID : ");
		int teamID=in.nextInt();
		System.out.println("Enter the Captain Name : ");
		String captainName=in.next();
		ITeam volleyBallTeam=SportTeamFactory.getClass(sportName,teamID, teamName, captainName);
		System.out.println("Enter the Team members names : ");
		for(int i=0;i<volleyBallTeam.getTeamSize();i++)
		{
			System.out.print("Team Member Name : ");
			volleyBallTeam.addMember(in.next());
			System.out.println();
		}
		System.out.println(volleyBallTeam);
		tournament.addVolleyBallTeam((VolleyBallTeam) volleyBallTeam);
		askHomePage(in,tournament);
	}
	public static void printAllTeams(Tournament tournament)
	{
		if(tournament.getVolleyBallTeamsList()==null && tournament.getBoxingTeamsList()==null && tournament.getCricketTeamsList()==null)
		{
			System.out.println("No Team is registered yet\n");
			return;
		}
		System.out.println("All Cricket Teams List : ");
		printAllCricketTeams(tournament);
		System.out.println("All Boxing Teams List : ");
		printAllBoxingTeams(tournament);
		System.out.println("All VolleyBall Teams List : ");
		printAllVolleyBallTeams(tournament);
	}
	public static void printAllCricketTeams(Tournament tournament)
	{
		if(tournament.getCricketTeamsList()==null)
		{
			System.out.println("No Cricket Team is registered yet\n");
			return;
		}	
		for(CricketTeam ct:tournament.getCricketTeamsList())
		{
			System.out.println(ct);
		}
			
	}
	public static void printAllBoxingTeams(Tournament tournament)
	{
		if(tournament.getBoxingTeamsList()==null)
		{
			System.out.println("No Boxing Team is registered yet\n");
			return;
		}	
		for(BoxingTeam bt:tournament.getBoxingTeamsList())
			System.out.println(bt);
	}
	public static void printAllVolleyBallTeams(Tournament tournament)
	{
		if(tournament.getVolleyBallTeamsList()==null)
		{
			System.out.println("No VolleyBall Team is registered yet\n");
			return;
		}	
		for(VolleyBallTeam vt:tournament.getVolleyBallTeamsList())
			System.out.println(vt);
	}
}
