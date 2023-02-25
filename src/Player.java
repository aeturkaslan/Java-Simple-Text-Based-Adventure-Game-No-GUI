import java.util.Scanner;

public class Player {
	private int damage, health, money;
	private String name, cName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
	}
	
	public void selectCha() {
		switch(chaMenu()) {
		case 1:
			setcName("Samurai");
			setDamage(5);
			setHealth(21);
			setMoney(15);
			
			System.out.println("You chose to be a(n) " + getcName());
			System.out.println("Stats: \t Damage: " + getDamage() + "\t Health: " + getHealth() + "\t Money: " + getMoney());
			
			break;
			
		case 2:
			setcName("Archer");
			setDamage(7);
			setHealth(18);
			setMoney(20);
			
			System.out.println("You chose to be a(n) " + getcName());
			System.out.println("Stats: \t Damage: " + getDamage() + "\t Health: " + getHealth() + "\t Money: " + getMoney());
			
			break;
			
		case 3:
			setcName("Knight");
			setDamage(8);
			setHealth(24);
			setMoney(5);
			
			System.out.println("You chose to be a(n) " + getcName());
			System.out.println("Stats: \t Damage: " + getDamage() + "\t Health: " + getHealth() + "\t Money: " + getMoney());
			
			break;
			
		default:
			setcName("Samurai");
			setDamage(5);
			setHealth(21);
			setMoney(15);
			
			System.out.println("Your character is created as " + getcName() + " by default");
			System.out.println("Stats: \t Damage: " + getDamage() + "\t Health: " + getHealth() + "\t Money: " + getMoney());
			break;
		
		}
	}
	
	public int chaMenu() {
		System.out.println("Please select character class: ");
		System.out.println("1) Samurai \t Damage: 5 \t Health: 21 \t Money: 15 ");
		System.out.println("2) Archer \t Damage: 7 \t Health: 18 \t Money: 20 ");
		System.out.println("3) Knight \t Damage: 8 \t Health: 24 \t Money: 5 ");
		System.out.println("Your Selection: ");
		int chaID = scan.nextInt();
		
		while(chaID < 1 || chaID > 3) {
			System.out.println("Invalid selection! Please choose a number 1-3.");
			chaID = scan.nextInt();
		}
		return chaID;

	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	
	
	
	
}
