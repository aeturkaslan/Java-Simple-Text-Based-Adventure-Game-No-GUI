
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;

	BattleLoc(Player player, String name, Obstacle obstacle) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
	}
	
	@Override
	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("Current Location : " + this.getName());
		System.out.println("Be careful! There are " + obsCount + " " + obstacle.getName() + "(s) here!");
		System.out.println("<A>ttack or <W>alk Away");
		String selCase = scan.next();
		selCase = selCase.toUpperCase();
		
		if (selCase.equals("A")) {
			if(combat(obsCount)) {
				System.out.println("You defeated all the enemies at " + this.getName() + " area!");
				return true;
			}else {
				System.out.println("You died!");
				return false;
			}
		}
		return true;
	}
	
	public boolean combat(int obsCount) {
		for (int i=0 ; i < obsCount ; i++) {
			playerStats();
			enemyStats();
		}
		return true;
	}
	
	public void playerStats() {
		System.out.println("== Player Stats ==");
		System.out.println("Health: " + player.getHealth());
		System.out.println("Damage: " + player.getTotalDamage());
		System.out.println("Money: " + player.getMoney());
		if(player.getInv().getDamage() > 0) {
			System.out.println("Weapon: " + player.getInv().getwName());
		}
		if(player.getInv().getArmor() > 0) {
			System.out.println("Armor: " + player.getInv().getaName());
		}
	}
	
	
	public void enemyStats() {
		System.out.println("== " + obstacle.getName() +" Stats ==");
		System.out.println("Enemy Health: " + obstacle.getHealth());
		System.out.println("Enemy Damage: " + obstacle.getDamage());
		System.out.println("Enemy Award: " + obstacle.getAward());
	}

}
