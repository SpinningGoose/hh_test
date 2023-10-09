import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public abstract class Creature {
    protected int attack;
    protected int defence;
    protected int maxHP;
    protected int curHP;
    protected int heals;
    protected int minDamage;
    protected int maxDamage;
    protected LinkedList<String> log;


    int getAttack(){
        return attack;
    }

    int getDefence(){
        return defence;
    }

    int getCurHP(){
        return curHP;
    }

    int getMaxHP() {
        return maxHP;
    }

    int getMinDamage() {
        return minDamage;
    }

    int getMaxDamage() {
        return maxDamage;
    }

    int getHeals() {
        return heals;
    }

    LinkedList<String> getLog() {
        return log;
    }



    void applyDamage (int damage) {
        curHP = curHP - damage;
        if (curHP < 0) {curHP = 0;}

    }

    void heal() {
        if (heals > 0) {
            int healAmount = (int) (maxHP * 0.3);
            curHP += healAmount;
            if (curHP > maxHP) {
                healAmount -= (curHP - maxHP);
                curHP = maxHP;
                log.add("healed " + healAmount + " points");
            }
            heals--;
        }
    }

    void hit(Creature creature) {
        int attackModifier = this.attack - creature.getDefence() + 1;
        int dices = 1;
        if (attackModifier > 1) {
            dices = attackModifier;
        }
        Random r = new Random();
        int diceThrow;
        int damage;
        for (int i = 0; i < dices; i++) {
            diceThrow = r.nextInt(6) + 1;
            if (diceThrow >=5) {
                damage = r.nextInt(maxDamage - minDamage + 1) + minDamage;
                creature.applyDamage(damage);
                log.add("hit with " + damage + " points");
                return;
            }
        }
        log.add("no successful throws");
    }


}
