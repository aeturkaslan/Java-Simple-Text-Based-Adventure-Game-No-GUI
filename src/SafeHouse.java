
public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player, "Safe House");
	}
	
	@Override
	public boolean getLocation() {
		player.setHealth(player.getFullHealth());
		System.out.println("You are now full healed!");
		System.out.println("Current Location : Safe House");
		
		return true;
	}

}
