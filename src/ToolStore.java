
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
			selItemID = armorMenu();
			buyArmor(selItemID);
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
			if(player.getMoney() >= price) {
				System.out.println("That would come handy when you argue with someone.");	
			}
			
			break;
			
		case 2:
			damage = 3;
			wName = "Sword";
			price = 35;
			if(player.getMoney() >= price) {
				System.out.println("That's a preetty big knife you got there.");	
			}
			
			break;
		case 3:
			damage = 7;
			wName = "Rifle";
			price = 45;
			if(player.getMoney() >= price) {
				System.out.println("It isn't hunting season yet. Or is it?");	
			}
			
			break;
		case 4:
			System.out.println("Leaving the shop... 'Come back any time!' says the merchant.");
			break;
		default:
			System.out.println("Invalid selection!");
			break;
		}
		
		if(price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney()-price);
				System.out.println(wName +" equipped!" + "Damage: " + player.getDamage() + " -->>" + " "+ player.getTotalDamage() );
				System.out.println("Remaining money:" + player.getMoney());
			}else {
				System.out.println("Not enough money!");
			}
		}
		
	}
	
	
	public int armorMenu() {
		System.out.println("1) Light-Weight Armor \t Blocked Damage: 1 \t Price: 15 \t ");
		System.out.println("2) Medium-Weight Armor \t Blocked Damage: 3 \t Price: 25 \t ");
		System.out.println("3) Heavy-Weight Armor \t Blocked Damage: 5 \t Price: 40 \t");
		System.out.println("4) Exit");
		System.out.println("Choose the one you liked the most, wanderer");
		System.out.print("Select an armor: ");
		int selArmorID = scan.nextInt();
		return selArmorID;		
	}
	
	public void buyArmor(int itemID) {
		int avoid=0, price=0;
		String aName = null;
		switch(itemID) {
		case 1:
			avoid = 1;
			aName = "Light-Weight Armor";
			price = 15;
			if(player.getMoney() >= price) {
			System.out.println("Better than nothing, right?");	
			}
			
			break;
		case 2:
			avoid = 3;
			aName = "Medium-Weight Armor";
			price = 40;
			if(player.getMoney() >= price) {
			System.out.println("Not much, but does the job.");	
			}
			
			break;
		case 3:
			avoid = 5;
			aName = "Heavy-Weight Armor";
			price = 45;
			if (player.getMoney() >= price) {
			System.out.println("That looks hard to pierce through");	
			}
			
			break;
		case 4:
			System.out.println("Exiting shop... 'Come back any time!' says the merchant.");
			break;
		default:
			System.out.println("Invalid selection!");
			break;		
		}
		
		if (price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				
				player.setMoney(player.getMoney() - price);
				System.out.println(aName +" equipped! " + "Blocked Damage: " + player.getInv().getArmor()  );
				System.out.println("Remaining money:" + player.getMoney());
			}
			else {
				System.out.println("Not enough money!");
			}
		}
		
	}

}
