package proj4;

public class ArmyAnt extends Ant{
	

	public ArmyAnt () {
		
		super (30, 35, "Army Ant");
		
	}	
	
	/**
	 * This methods sets up the life of the ant back to the initial life after an invasion.
	 */
	public void setNewLife() {
		super.setLife(30);
		}
	
	/**
	 * This method reflects the damage on the life of ant after a fight.
	 */
	public void takeDamage(int i, Zombie zombie) {		
		
		super.takeDamage(i);			
	}
	
	/**
	 * This method attacks a zombie. Army Ant gives an extra damage of 5 * number of total army ants recruited to every zombie 
	 */
	public void attack(Game game) {
		
		Zombie z = game.getHorde().elementAt(0);
		
		int count = game.getArmyCount();
		
		z.takeDamage(10);
		//Giving extra damage = 5*count
		z.takeDamage(5*count);			
		
	}

	public static void main (String [] args) {
		
		Game g = new Game();
		ArmyAnt a = new ArmyAnt ();
		GiantZombie z = new  GiantZombie();
		System.out.println(g.getFood());
		
		g.getColony().add(a);
		g.getHorde().add(z);
		
		System.out.println(g.getColony().size());
		z.attack(g);
		a.attack(g);
		
		System.out.println("Ant life after attack: " + z.getLife() + "\nZombie life after attack: " + a.getLife() + "\nFood: " + g.getFood());
		
	}
	
	
}
