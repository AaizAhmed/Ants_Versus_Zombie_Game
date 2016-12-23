package proj4;

public class FireAnt extends Ant{

	public FireAnt() {
		
		super(20, 15, "Fire Ant");
		
	}

	/**
	 * This methods sets up the life of the ant back to the initial life after an invasion.
	 */
	public void setNewLife() {
		super.setLife(20);		
	}

	/**
	 * This method reflects the damage on the life of an ant after a fight.
	 */
	public void takeDamage(int i, Zombie zombie) {		
		
		super.takeDamage(i);		
	
	}
	
	/**
	 * This method attacks a zombie. Fire ant gives more damage to flammable zombies
	 */
	public void attack(Game game) {
		
		Zombie z = game.getHorde().elementAt(0);
		
		if (z instanceof InfectedZombie || z instanceof RadioactiveZombie) {
			
		// gives 20 damage to the zombie if it is flammable. 	
			z.takeDamage(20);
		}
		
		else {	
		 // normal damage
		   z.takeDamage(10);	
		}		
	}

}
