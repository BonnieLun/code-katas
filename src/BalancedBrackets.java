import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    private static Map brackets = new HashMap();

    public static void main(String[] args) {
        brackets.put('{', '}');
        brackets.put('[', ']');
        brackets.put('(', ')');

        System.out.println((isBalanced("{()[][{}]}")) ? "YES" : "NO");

    }

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (Character c : expression.toCharArray()) {
            if (brackets.containsKey(c)) {
                stack.push(c);
            } else if (brackets.containsValue(c)) {
                if (stack.empty()) {
                    return false;
                }
                Character sc = stack.pop();
                if (c != brackets.get(sc)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }


}
