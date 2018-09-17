package GeekUniversity.Java.Lesson6HW;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Tree tree = new Tree();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            tree.insert(tree.randomNumber(random));
        }
        System.out.println(tree.balance());
    }
}
