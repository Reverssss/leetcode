package editor.cn;

import java.util.Random;

public class test {
    public static void main(String[] args) {
        Random random = new Random(10);
        for(int i = 0 ; i < 100 ; i++){
            random.setSeed(100000);
            System.out.println(random.nextInt());
        }
    }
}
