package GeekUniversity.Java.Lesson3HW;

import java.util.Stack;

public class ReverseString {
    Stack <Character> stack;
    String linetoinvert;
    StringBuilder stringBuilder;

    public void invertString (String line){
        linetoinvert = line;
        for (int i = 0; i < linetoinvert.length(); i++) {
            stack.push(linetoinvert.charAt(i));
        }
        for (int i = 0; i < stack.capacity(); i++) {
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder);
    }
}
