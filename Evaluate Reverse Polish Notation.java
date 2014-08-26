import java.util.ArrayDeque;

public class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        for(int i = tokens.length - 1; i >= 0; i--) {
            stack.push(tokens[i]);
        }
        while(stack.size() > 2){
            try {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(calc(a, b, stack.pop()));
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
        if(stack.size() != 1) throw new IllegalArgumentException();
        
        try {
            int r = Integer.valueOf(stack.pop());
            return r;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    
    private String calc(int a, int b, String op) {
        switch(op.charAt(0)) {
            case '+':
                return String.valueOf(a + b);
            case '-':
                return String.valueOf(a - b);
            case '*':
                return String.valueOf(a * b);
            case '/':
                if(b==0) throw new IllegalArgumentException();
                else return String.valueOf(a / b);
        }
        throw new IllegalArgumentException();
    }
}
