/**
 * Created by egor__000 on 22.11.2016.
 */
public class Battle {
    private DateHelper dateHelper;
    private Squad red;
    private Squad blue;

    public Battle(Squad red, Squad blue) {
        dateHelper = new DateHelper();
        this.red = red;
        this.blue = blue;
    }

    public void fight(){
        while (true){
            Warrior redWarrior = red.getRandomWarrior();
            Warrior blueWarrior = blue.getRandomWarrior();
            blueWarrior.takeDamage(redWarrior.attack());
            dateHelper.skipTime();
            if (!blue.hasAliveWarriors()){
                System.out.println("WINNER: " + red.getName());
                System.out.println("Battle time: " + dateHelper.getFormattedDiff());
                return;
            }
            redWarrior = red.getRandomWarrior();
            blueWarrior = blue.getRandomWarrior();
            redWarrior.takeDamage(blueWarrior.attack());
            dateHelper.skipTime();
            if (!red.hasAliveWarriors()){
                System.out.println("WINNER: " + blue.getName());
                System.out.println("Battle time: " + dateHelper.getFormattedDiff());
                return;
            }
        }
    }
}
