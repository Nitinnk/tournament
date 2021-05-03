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
				}
			}
			break;
		case 2:
			int teamID=takeIDInput(in,tournament);
			tournament.exit(teamID);
			System.out.println("Successfully Exited from the tournament");
			askHomePage(in,tournament);
			break;
		case 3:
			int teamID1=takeIDInput(in,tournament);
			tournament.printTeamDetails(teamID1);
			askHomePage(in,tournament);
			break;
		case 4:
			tournament.printAllTeams();
			askHomePage(in,tournament);
			break;
		case 5:
			tournament.printAllCricketTeams();
			askHomePage(in,tournament);
			break;
		case 6:
			tournament.printAllBoxingTeams();
			askHomePage(in,tournament);
			break;
		case 7:
			tournament.printAllVolleyBallTeams();
			askHomePage(in,tournament);
			break;
		case 8:
			tournament.printAllMatchesSchedule();
			askHomePage(in,tournament);
			break;
		case 9:
			tournament.printAllCricketMatchSchedules();
			askHomePage(in,tournament);
			break;
		case 10:
			tournament.printAllBoxingMatchSchedules();
			askHomePage(in,tournament);
			break;
		case 11:
			tournament.printAllVolleyBallMatchSchedules();
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
					System.exit(0);
			}
		}
		return 0;
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
		boxingTeam.printTeam();
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
		cricketTeam.printTeam();
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
		volleyBallTeam.printTeam();
		tournament.addVolleyBallTeam((VolleyBallTeam) volleyBallTeam);
		askHomePage(in,tournament);
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
}
