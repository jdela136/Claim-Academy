package statTracker;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Team a = new Team();
		a.setId(1);
		a.setTeamName("New York Yankees");
		Player one = new Player();
		one.setFirstName("Jay");
		one.setLastName("Dee");
		one.setId(1);
		a.addPlayerToRoster(one);
		Player two = new Player();
		two.setFirstName("J");
		two.setLastName("D");
		two.setId(2);
		a.addPlayerToRoster(two);
		Player three = new Player(3, "A", "B");
		a.addPlayerToRoster(three);
		Player four = new Player(4, "Ace", "Breaker");
		a.addPlayerToRoster(four);
		Player five = new Player(5, "Boom", "Stick");
		a.addPlayerToRoster(five);
		Player six = new Player(6, "Big", "Papi");
		a.addPlayerToRoster(six);
		Player seven = new Player(7, "David", "Ortiz");
		a.addPlayerToRoster(seven);
		Player eight = new Player(8, "Eddie", "Guerrero");
		a.addPlayerToRoster(eight);
		Player nine = new Player(9, "Angel", "Garza");
		a.addPlayerToRoster(nine);
		Player ten = new Player(10, "Denise", "Feierabend");
		a.addPlayerToRoster(ten);

		Team b = new Team();
		b.setId(2);
		b.setTeamName("Homestead McGlovins");
		Player eleven = new Player();
		eleven.setFirstName("Jay");
		eleven.setLastName("Dee");
		eleven.setId(11);
		b.addPlayerToRoster(eleven);
		Player twelve = new Player();
		twelve.setFirstName("J");
		twelve.setLastName("D");
		twelve.setId(12);
		b.addPlayerToRoster(twelve);
		Player thirteen = new Player(13, "A", "B");
		b.addPlayerToRoster(thirteen);
		Player fourteen = new Player(14, "Ace", "Breaker");
		b.addPlayerToRoster(fourteen);
		Player fifteen = new Player(15, "Boom", "Stick");
		b.addPlayerToRoster(fifteen);
		Player sixteen = new Player(16, "Big", "Papi");
		b.addPlayerToRoster(sixteen);
		Player seventeen = new Player(17, "David", "Ortiz");
		b.addPlayerToRoster(seventeen);
		Player eighteen = new Player(18, "Eddie", "Guerrero");
		b.addPlayerToRoster(eighteen);
		Player nineteen = new Player(19, "Angel", "Garza");
		b.addPlayerToRoster(nineteen);
		Player twenty = new Player(20, "Denise", "Feierabend");
		b.addPlayerToRoster(twenty);

		Game game = new Game(a, b);
		game.getAwayTeam().setLineUp(eight, two, four, one, five, six, seven, three, nine, ten);
		game.getHomeTeam().setLineUp(eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen,
				nineteen, twenty);
		game.setId(1);
		game.startGame();

		while (!game.isEndGame()) {
			System.out.println("1- strike, 2- ball, 3-hit, 4-out");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				if (!game.getLastAtBat().isEndAtBat()) {
					game.getLastAtBat().addStrike();
					System.out.println(game.getLastAtBat().getLastPitch().toString());
					System.out.println(game.getLastAtBat().toString());
				} else {
					game.addAtBat();
					game.getLastAtBat().addStrike();
					System.out.println(game.getLastAtBat().getLastPitch().toString());
					System.out.println(game.getLastAtBat().toString());
				}
				break;
			case 2:
				if (!game.getLastAtBat().isEndAtBat()) {
					game.getLastAtBat().addBall();
					System.out.println(game.getLastAtBat().getLastPitch().toString());
					System.out.println(game.getLastAtBat().toString());
				} else {
					game.addAtBat();
					game.getLastAtBat().addBall();
					System.out.println(game.getLastAtBat().getLastPitch().toString());
					System.out.println(game.getLastAtBat().toString());
				}
				break;
			case 3:
				System.out.println("1-single, 2-double, 3-triple, 4-homerun");
				Scanner in2 = new Scanner(System.in);
				int choice2 = in2.nextInt();
				if (!game.getLastAtBat().isEndAtBat()) {
					switch (choice2) {
					case 1:
						game.getLastAtBat().baseHit(1);
						break;
					case 2:
						game.getLastAtBat().baseHit(2);
						break;
					case 3:
						game.getLastAtBat().baseHit(3);
						break;
					case 4:
						game.getLastAtBat().baseHit(4);
						break;
					}
				} else {
					game.addAtBat();
					switch (choice2) {
					case 1:
						game.getLastAtBat().baseHit(1);
						break;
					case 2:
						game.getLastAtBat().baseHit(2);
						break;
					case 3:
						game.getLastAtBat().baseHit(3);
						break;
					case 4:
						game.getLastAtBat().baseHit(4);
						break;
					}
				}
				System.out.println(game.getLastAtBat().getLastPitch().toString());
				System.out.println(game.getLastAtBat().toString());
				System.out.println("Final Score: " + game.getAwayTeam() + ": " + game.getAwayScore() + " " + game.getHomeTeam() + ": " + game.getHomeScore() );
				break;
			case 4:
				if (!game.getLastAtBat().isEndAtBat()) {
					game.getLastAtBat().outMade();
				} else {
					game.addAtBat();
					game.getLastAtBat().outMade();
				}
				System.out.println(game.getLastAtBat().getLastPitch().toString());
				System.out.println(game.getLastAtBat().toString());
				break;
			case 5:
				System.out.println("What batter");
				in2 = new Scanner(System.in);
				int batter = in2.nextInt();
				System.out.println("Where does he end");
				int base = in2.nextInt();
				game.getLastAtBat().moveRunner(base, batter);
				System.out.println(game.getLastAtBat().toString());
				break;
			default:
				game.setEndGame(true);
				System.out.println("Final Score: " + game.getAwayTeam() + ": " + game.getAwayScore() + " " + game.getHomeTeam() + ": " + game.getHomeScore() );
			}
		}

	}

}
