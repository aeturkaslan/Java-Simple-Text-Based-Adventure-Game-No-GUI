import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome To The Adventure Game!");
		System.out.println("Please Enter Your Name: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectCha();
	}

}
