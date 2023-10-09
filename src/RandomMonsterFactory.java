import java.util.Random;

public class RandomMonsterFactory implements IMonsterFactory {
    @Override
    public Monster create() {
        Random r = new Random();
        int attack = 15 + r.nextInt(16);
        int defence = 15 + r.nextInt(16);
        int maxHP = 50 + r.nextInt(50);
        int minDamage = 5 + r.nextInt(10);
        int maxDamage = minDamage + r.nextInt(15);
        return new Monster(attack, defence, maxHP, minDamage, maxDamage);

    }
}
