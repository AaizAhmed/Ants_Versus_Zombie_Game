package proj4;

public class WeaverAnt extends Ant{

	public WeaverAnt() {
		
		super(10, 20, "Weaver Ant");
		
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
	 * This method attacks a zombie. Weaver ant attacks the 2nd zombie in the horde not the 1st one.
	 */
	public void attack(Game game) {	
		
		
		//checking if there is a second zombie in the horde
		if (game.getHorde().size() > 1) {			
			
		Zombie z = game.getHorde().elementAt(1);
		z.takeDamage(15);
		
		}		
	}

}
