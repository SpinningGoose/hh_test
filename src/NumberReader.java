import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberReader implements Readable {
    BufferedReader br;

    NumberReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public Action read() throws IOException {
        System.out.print("Choose action \n 1 - Attack \n 2 - Heal\n");
        String tmp;
        int res;
        while (true) {
            tmp = br.readLine();
            res = Integer.parseInt(tmp);
            switch (res) {
                case 1:
                    return Action.ATTACK;
                case 2:
                    return Action.HEAL;
                default:
                    System.out.println("Ummm, there is no such option, choose again");
                    break;
            }
        }
    }
}
