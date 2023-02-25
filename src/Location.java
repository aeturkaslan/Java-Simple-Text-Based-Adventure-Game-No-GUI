
public abstract class Location {
	protected Player player;
	protected String name;
	
	Location (Player player){
		this.player = player;
	}
	
	//The method also must be abstract, because it is defined in an abstract class.
	//We have to override this method in the subclasses.
	public abstract boolean getLocation();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
