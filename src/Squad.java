import java.util.Random;

/**
 * Created by egor__000 on 21.11.2016.
 */
public class Squad implements Cloneable{
    String name; //почему нет модификаторов доступа? тут действительно нужен package-local?
    Warrior[] warriors;

    public Squad(String name, Warrior[] warriors) {
        this.name = name;
        this.warriors = warriors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Warrior getRandomWarrior(){ //сложная реализация
        Random r = new Random();
        int size = warriors.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (warriors[i].isAlive()){
                count++;
            }
        }
        int index = r.nextInt(count);
        int i = 0;
        while (i != index || !warriors[i].isAlive()){
            if (!warriors[i].isAlive()){
                index++;
            }
            i++;
        }
        return warriors[i];
    }

    public boolean hasAliveWarriors(){
        for (Warrior w: warriors){
            if (w.isAlive()) return true;
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Squad squad = (Squad) super.clone();
        squad.name = new String(name);
        int size = warriors.length;
        squad.warriors = new Warrior[size];
        for (int i = 0; i < size; i++) {
            squad.warriors[i] = (Warrior) warriors[i].clone();
        }
        return squad;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("Squad \""); //StringBuffer имеет низкую производительность из-за дополнительной потокобезопасной синхронизации. Рекомендуется использовать StringBuilder
        result.append(name);
        result.append("\" {");
        int size = warriors.length;
        for (int i = 0; i < size; i++) {
            if (i > 0) result.append(", ");
            result.append(warriors[i].toString());
        }
        result.append("}");//можно было просто использовать Arrays.toString(warriors)
        return result.toString();
    }
}
