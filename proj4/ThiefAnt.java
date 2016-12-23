package proj4;

public class ThiefAnt extends Ant{

	public ThiefAnt() {
		
		super(25, 15, "Thief Ant");		
		
	}

	/**
	 * This methods sets up the life of the ant back to the initial life after an invasion.
	 */
	public void setNewLife() {
		super.setLife(25);		
	}

	/**
	 * This method reflects the damage on the life of an ant after a fight.
	 */
	public void takeDamage(int i, Zombie zombie) {	
		
		super.takeDamage(i);	   
	}
	
	/**
	 * This method attacks a zombie. Thief ant gives half of the damage taken by a zombie back to the zombie.
	 */
	public void attack(Game game) {
		
		Zombie z = game.getHorde().elementAt(0);
		
		//giving half the damage taken from a zombie back to the zombie.
		int damage = 0;
		if (z instanceof ArmoredZombie)       damage = 5;
		if (z instanceof GiantZombie)         damage = 17; 
		if (z instanceof InfectedZombie)      damage = 12;
		if (z instanceof RadioactiveZombie)   damage = 2;
		if (z instanceof StandardZombie)      damage = 5;
		if (z instanceof VoodooZombie)        damage = 5;
		if (z instanceof ZombieNinja)         damage = 7;
		if (z instanceof ZombieScientist)     damage = 2;
		
		z.takeDamage(damage);	
		
	}

}
