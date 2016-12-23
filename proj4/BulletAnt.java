package proj4;

public class BulletAnt extends Ant{

	public BulletAnt() {
		
		super(1, 10 , "Bullet Ant");
		
	}

	/**
	 * This methods sets up the life of the ant back to the initial life after an invasion.
	 */
	public void setNewLife() {
		super.setLife(1);		
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
		z.takeDamage(25);	
		
	}
}
