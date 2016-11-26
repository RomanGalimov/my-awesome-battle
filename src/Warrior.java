/**
 * Created by egor__000 on 21.11.2016.
 */
public interface Warrior extends Cloneable{
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    void setSquadName(String name);
    Object clone();
}
