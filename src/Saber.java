/**
 * Created by egor__000 on 21.11.2016.
 */
public class Saber implements Warrior {
    private static final int SABER_DAMAGE = 40;
    private int health = 100;
    private String name;
    private Squad squad;

    public Saber(String name) {
        this.name = name;
    }

    @Override
    public int attack() {
        return SABER_DAMAGE;
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
        return "Saber " + name + " (damage " + SABER_DAMAGE + ", health " + health + ")";
    }

    @Override
    public Object clone() {
        Saber saber = null;
        try {
            saber = (Saber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
        saber.name = new String(name); //нет необходимости клонировать строки.
        return saber;
    }
}
