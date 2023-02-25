
public abstract class BattleLoc extends Location {
	Obstacle obstacle;

	BattleLoc(Player player, String name, Obstacle obstacle) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
	}
	
	@Override
	public boolean getLocation() {
		return true;
	}
	

}
