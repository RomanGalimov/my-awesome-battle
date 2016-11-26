/**
 * Created by egor__000 on 21.11.2016.
 */
public class Archer implements Warrior, Cloneable{
    private static final int ARCHER_DAMAGE = 35;
    private int health = 80;
    private String name;
    private Squad squad;

    public Archer(String name) {
        this.name = name;
    }

    @Override
    public int attack() {
        return ARCHER_DAMAGE;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void setSquadName(String squadName) {
        squad.setName(squadName);
    }

    @Override
    public String toString() {
        return "Archer " + name + " (damage " + ARCHER_DAMAGE + ", health " + health + ")";
    }

    @Override
    public Object clone(){
        Archer archer = null;
        try {
            archer = (Archer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
        archer.name = new String(name);
        return archer;
    }
}
