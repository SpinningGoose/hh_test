import java.io.IOException;

public class Game {
    Battle battle;
    Readable reader;

    public Game(Player player){
       battle = new Battle(player, new RandomMonsterFactory());
       reader = new NumberReader();
    }

    void commenceBattle() {
        Action action;
        System.out.println("You face " + (battle.getMonsters().size() + 1) + " monsters!");
        while (battle.getTurn() != Turn.WIN && battle.getTurn() != Turn.OVER) {
            System.out.print("\nPlayer hp: " + battle.getPlayer().getCurHP() + " | Monster hp: " + battle.getCurMonster().getCurHP() + "\n");
            System.out.println("Monster heals: " + battle.getCurMonster().getHeals());
            System.out.print("Heals: " + battle.getPlayer().getHeals() + "\n \n");
            switch (battle.getTurn()) {
                case PLAYER:
                    try {
                        action = reader.read();
                        battle.playerTurn(action);
                        System.out.println(battle.getLog().getLast());
                        System.out.println(battle.getPlayer().getLog().getLast());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case COMPUTER:
                    battle.monsterTurn();
                    System.out.println(battle.getLog().getLast());
                    System.out.println(battle.getCurMonster().getLog().getLast());
                    break;
                default:
                    break;
            }

        }
        if (battle.getTurn() == Turn.WIN) {
            System.out.println("Victory!");
        } else {
            System.out.println("Defeat!");
        }
    }


}
