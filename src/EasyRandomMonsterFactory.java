import java.util.Random;

public class EasyRandomMonsterFactory implements IMonsterFactory {
    @Override
    public Monster create() {
        Random r = new Random();
        int attack = r.nextInt(15);
        int defence = r.nextInt(15);
        int maxHP = r.nextInt(50);
        int minDamage = r.nextInt(2);
        int maxDamage = minDamage + r.nextInt(5);
        return new Monster(attack, defence, maxHP, minDamage, maxDamage);

    }
}
