import java.util.LinkedList;

public class Player extends Creature {


    public Player (int attack, int defence, int maxHP, int minDamage, int maxDamage)  {
        if (attack < 0 || attack > 30) {
            throw new IllegalArgumentException("Attack value out of bounds");
        }
        this.attack = attack;
        if (defence < 0 || defence > 30) {
            throw new IllegalArgumentException("Defence value out of bounds");
        }
        this.defence = defence;
        if (maxHP < 0) {
            throw new IllegalArgumentException("HP value is negative");
        }
        this.maxHP = maxHP;
        curHP = maxHP;
        if (minDamage > maxDamage || minDamage < 0 || maxDamage < 0) {
            throw new IllegalArgumentException("Invalid damage range");
        }
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        heals = 4;
        log = new LinkedList<String>();
    }

}
