
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.award = award;
	}

	@Override
	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("Current Location : " + this.getName());
		System.out.println("Be careful! There are " + obsCount + " " + obstacle.getName() + "(s) here!");
		System.out.println("<A>ttack or <W>alk Away");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();

		if (selCase.equals("A")) {
			if (combat(obsCount)) {
				System.out.println("You defeated all the enemies at " + this.getName() + " area!");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " acquired!");
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " acquired!");
					player.getInv().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " acquired!");
					player.getInv().setFirewood(true);
				}
				return true;
			} 
			if (player.getHealth() <= 0) {
				System.out.println("You died!");
				return false;
			}
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
				System.out.println("<H>it or <F>lee");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("H")) {
					System.out.println("You Hit Enemy!");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println();
						System.out.println("Enemy Hit You!");
						player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHit();
					}
				} else {
					return false;
				}
			}

			if (obstacle.getHealth() <= 0 && player.getHealth() > 0) {
				System.out.println("You Defeated The Enemy!!");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("You have gained +" + obstacle.getAward() + " for defeating " + obstacle.getName());
				System.out.println("Your current money: " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("-------------------");
		}
		return true;
	}

	public void playerStats() {
		System.out.println("== Player Stats ==");
		System.out.println("Health: " + player.getHealth());
		System.out.println("Damage: " + player.getTotalDamage());
		System.out.println("Money: " + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Weapon: " + player.getInv().getwName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Armor: " + player.getInv().getaName());
		}
	}

	public void enemyStats() {
		System.out.println("== " + obstacle.getName() + " Stats ==");
		System.out.println("Enemy Health: " + obstacle.getHealth());
		System.out.println("Enemy Damage: " + obstacle.getDamage());
		System.out.println("Enemy Award: " + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Player's Health: " + player.getHealth());
		System.out.println(obstacle.getName() + " health: " + obstacle.getHealth());
		System.out.println();
	}

}
