import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Battle {
    private Player player;
    private LinkedList<Monster> monsters;
    private Monster curMonster;
    private Turn turn;
    private LinkedList<String> log;

    public Battle(Player player, IMonsterFactory factory){
        this.player = player;
        Random r = new Random();
      //  RandomMonsterFactory factory = new RandomMonsterFactory();
        monsters = new LinkedList<Monster>();
        if (r.nextInt(2) == 0) {
            turn = Turn.PLAYER;
        } else {
            turn = Turn.COMPUTER;
        }
        for (int i = 0; i < (r.nextInt(3) + 1) ; i++) {
            monsters.add(factory.create());
        }
        Turn[] firstTurn = {Turn.COMPUTER, Turn.PLAYER};
        turn = firstTurn[r.nextInt(firstTurn.length)];
        curMonster = monsters.pop();
        log = new LinkedList<String>();
    }

    public LinkedList<String> getLog(){
        return log;
    }

    public Turn getTurn() {
        return turn;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer (Player player) {
        this.player = player;
    }

    public Monster getCurMonster() {
        return curMonster;
    }

    public void addMonster (Monster monster) {
        monsters.add(monster);
    }

    public void setMonsters (LinkedList<Monster> monsters) {
        this.monsters = monsters;
    }

    public LinkedList<Monster> getMonsters(){
        return monsters;
    }

    void monsterTurn(){
        if (curMonster.getHeals() >0 && curMonster.getCurHP() < (int) (curMonster.getMaxHP() * 0.4)) {
            curMonster.heal();
            log.add("Monster uses heal");
            turn = Turn.PLAYER;
        } else {
            curMonster.hit(player);
            log.add("Monster hits player");
            if (player.getCurHP() == 0) {
                turn = Turn.OVER;
            } else {
                turn = Turn.PLAYER;
            }
        }
    }

    void playerTurn(Action inputAction){
        switch (inputAction) {
            case HEAL:
                player.heal();
                log.add("Player uses heal");
                turn = Turn.COMPUTER;
                break;
        //        return Action.HEAL;
            case ATTACK:
                player.hit(curMonster);
                log.add("Player hits monster");
                if (curMonster.getCurHP() == 0) {
                    log.add("Player kills monster");
                    if (monsters.size() == 0) {
                        turn = Turn.WIN;
                    } else {
                        curMonster = monsters.pop();
                        turn = Turn.COMPUTER;
                    }
            } else {
                    turn = Turn.COMPUTER;
                }
                break;
        //        return Action.ATTACK;
            default:
                throw new IllegalArgumentException("Unknown action");
        }
    }

}
