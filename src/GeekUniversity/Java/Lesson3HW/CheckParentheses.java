package GeekUniversity.Java.Lesson3HW;

import java.util.Stack;

public class CheckParentheses {
    Stack<Character> stack;
    String line;
    char tempch;
    char tempchpop;

    public CheckParentheses (){
        stack = new Stack();
    }

    public void getLine (String line){
        this.line = line;
    }

    public boolean isleftBracket (char ch){
        return (ch == '{' || ch == '(' || ch == '[');
    }

    public boolean isRightBracket (char ch){
        return (ch == '}' || ch == ')' || ch == ']');
    }

    public boolean isBadBracketInStack (char ch, char chpop){
      return !((ch == ')' && chpop != '(') || (ch == '}' && chpop != '{') || (ch == ']' && chpop != '['));
    }


    public void checkBrackets (String txt) {
        this.line = txt;

        for (int i = 0; i < line.length(); i++) {
            tempch = line.charAt(i);
            if (isleftBracket(tempch)) {
                stack.push(tempch);
            } else if (isRightBracket(tempch)) {
                if (!stack.empty()){
                    tempchpop = stack.pop();
                    if (isBadBracketInStack(tempch,tempchpop)){
                        throw new RuntimeException("Скобки не совпадают!!!");
                    }
                }
            }
        }
    }
}
