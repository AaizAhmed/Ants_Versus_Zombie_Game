package proj4;

public class SugarAnt extends Ant {

	public SugarAnt() {
		
		super(20, 20, "Sugar Ant");
		
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
	 * This method attacks a zombie. If a zombie dies extra 5 food is added. 
	 */
	public void attack(Game game) {
		
		Zombie z = game.getHorde().elementAt(0);
		z.takeDamage(10);
		
		//extra food if zombie dies during the attack.
		if (z.getLife() == 0 || z.getLife() < 0) {		 
			game.setFood(5);
		}
	}

}
