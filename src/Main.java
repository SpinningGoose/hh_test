public class Main {

    public static void main(String[] args) {

        Player player = new Player(20,5, 150, 10, 30);
        Game game = new Game(player);
        game.commenceBattle();
    }
}
