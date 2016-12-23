package proj4;

public class PharaohAnt extends Ant{

	public PharaohAnt() {
		
		super(10, 15, "Pharaoh Ant");
		
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
	 * This method attacks a zombie. It gives extra damage to a zombie if it is gigantic. 
	 */
	public void attack(Game game) {
		
		Zombie z = game.getHorde().elementAt(0);
		
		if (z instanceof GiantZombie || z instanceof RadioactiveZombie) {
			
			//extra damage if zombie is gigantic
		    z.takeDamage(30); 
		}
		else
			//normal damage
			z.takeDamage(10);		
		
	}

}
