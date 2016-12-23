package proj4;

public class LeafcutterAnt extends Ant{

	public LeafcutterAnt() {
		super(10, 20, "Leafcutter Ant");
		
	}

	/**
	 * This methods sets up the life of the ant back to the initial life after an invasion.
	 */
	public void setNewLife() {
		super.setLife(10);		
	}

	/**
	 * This method reflects the damage on the life of an ant after a fight.
	 */
	public void takeDamage(int i, Zombie zombie) {
		
		super.takeDamage(i);
	}
	
	/**
	 * This method attacks a zombie
	 */
	public void attack(Game game) {
		
		Zombie z = game.getHorde().elementAt(0);
		z.takeDamage(10);		
		
	}

}
