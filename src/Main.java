public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Coliseum!");
        Warrior[] redWarriors = new Warrior[3];
        redWarriors[0] = new Saber("Dixon");
        redWarriors[1] = new Saber("Segul");
        redWarriors[2] = new Archer("Rubickon");
        Squad red = new Squad("REDS", redWarriors);
        Warrior[] blueWarriors = new Warrior[3];
        blueWarriors[0] = new Saber("Joke");
        blueWarriors[1] = new Saber("CptCandy");
        blueWarriors[2] = new Archer("ShadowBurn");
        Squad blue = new Squad("BLUES", blueWarriors);
        Battle battle = new Battle(red, blue);
        battle.fight();
    }
}
