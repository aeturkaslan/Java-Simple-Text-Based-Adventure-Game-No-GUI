
public class ToolStore extends NormalLoc{

	ToolStore(Player player) {
		super(player, "Shop");
	}
	
	public boolean getLocation() {
		System.out.println("Welcome! We got everything you may need. Take a look.");
		System.out.println("Money: " + player.getMoney());
		System.out.println("1) Weapons");
		System.out.println("2) Armors");
		System.out.println("3) Exit");
		System.out.print("Your Selection: ");
		int selTool = scan.nextInt();
		int selItemID;
		switch(selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			
			break;
		default:
			System.out.println("Leaving the shop...");
		}
		
		return true;
	}
	
	public int weaponMenu() {
		System.out.println("You won't fight bare-handed, will you?");
		System.out.println("1) Gun \t\t Price: 25 \t Damage: 2");
		System.out.println("2) Sword \t Price: 35 \t Damage: 3");
		System.out.println("3) Rifle \t Price: 45 \t Damage: 7");
		System.out.println("4) Exit");
		System.out.print("Select a weapon: ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;		
	}
	
	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		
		switch(itemID) {
		case 1:
			damage = 2;
			wName = "Gun";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "Sword";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Rifle";
			price = 45;
			break;
		default:
			System.out.println("Invalid selection!");
			break;
		}
		
		if(player.getMoney() >= price) {
			player.getInv().setDamage(damage);
			player.getInv().setwName(wName);
			player.setMoney(player.getMoney()-price);
			System.out.println(wName +" equipped!" + "Damage: " + player.getDamage() + " -->>" + " "+ (player.getDamage() + player.getInv().getDamage()) );
			System.out.println("Remaining money:" + player.getMoney());
		}else {
			System.out.println("Not enough money!");
		}
		
	}

}
