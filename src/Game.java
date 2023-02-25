import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome To The Adventure Game!");
		System.out.println("Please Enter Your Name: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectCha();
		start();
	}
	
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("===============================");
			System.out.println();
			System.out.println("Select a place to travel: ");
			System.out.println("1) Safe House - A safe place to rest and heal your wounds. No enemies.");
			System.out.println("2) Cave - Chance of encountering a zombie or a small group of zombies. Be aware!");
			System.out.println("3) Forest - Chance of encountering a vampire or a small group of vampires. Be aware!");
			System.out.println("4) River - Chance of encountering a bear or a small group of bears. Be aware!");
			System.out.println("5) Shop - Right place to buy some weapons and armors");
			System.out.println("Location you want to go : ");
			int selLoc = scan.nextInt();
			
			while (selLoc < 0 || selLoc > 5) {
				System.out.println("Invalid place selection! Please select between 1-5");
				selLoc = scan.nextInt();
			}
			
			switch(selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
				
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}
			
			if(!location.getLocation()){
				System.out.println("Game Over!");
				break;
			}
		}
	}

}
