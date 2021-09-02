package stackDS.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        print("Enter infix expression:");
        String infixExp = sc.nextLine();

        final String R_L = "R-L";
        final String L_R = "L-R";

        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("(",4);
        precedence.put(")",4);
        precedence.put("^",3);
        precedence.put("*",2);
        precedence.put("/",2);
        precedence.put("+",1);
        precedence.put("-",1);

        Map<String, String> associative = new HashMap<>();
        associative.put("*",L_R);
        associative.put("/",L_R);
        associative.put("-",L_R);
        associative.put("+",L_R);
        associative.put("^",R_L);

        Stack<String> stack = new Stack<>();

        String result = "";

        for (int i=0; i<infixExp.length(); i++){
            String currentValue = String.valueOf(infixExp.charAt(i));

            if (stack.size() == 0 && precedence.containsKey(currentValue)){
                stack.push(currentValue);
                continue;
            }

            if (!precedence.containsKey(currentValue)){
                result += currentValue;
                continue;
            }

            int currentPrec = precedence.get(currentValue);
            int topPrec = 0;
            if (stack.size() != 0) topPrec = precedence.get(stack.peek());

            if (currentValue.equals("(")){
                stack.push(currentValue);
            }
            else if (currentValue.equals(")")){
                while (!(stack.peek().equals("("))){
                    result += stack.pop();
                }
                if (stack.peek().equals("(")) stack.pop();
            }
            else if (currentPrec > topPrec){
                stack.push(currentValue);
            }
            else if (currentPrec < topPrec){
                while (currentPrec <= topPrec && !(stack.size() == 0) && !( stack.peek().equals("(") )){
                    if (currentPrec == topPrec){
                        if (L_R.equals(associative.get(currentValue))){
                            result += stack.pop();
                            topPrec = (stack.size()!=0) ? precedence.get(stack.peek()) : 0;
                        }
                        else if (R_L.equals(associative.get(currentValue))){
                            stack.push(currentValue);
                            break;
                        }
                    }
                    else {
                        result += stack.pop();
                        topPrec = (stack.size()!=0) ? precedence.get(stack.peek()) : 0;
                    }

                }

                if (stack.size() == 0 || currentPrec>topPrec) stack.push(currentValue);
            }
            else {
                if (R_L.equals(associative.get(currentValue))){
                    stack.push(currentValue);
                }
                else if (L_R.equals(associative.get(currentValue))){
                    while (currentPrec <= topPrec && !(stack.size() == 0) && !( stack.peek().equals("(") )){
                        if (currentPrec == topPrec){
                            if (L_R.equals(associative.get(currentValue))){
                                result += stack.pop();
                                topPrec = (stack.size()!=0) ? precedence.get(stack.peek()) : 0;
                            }
                            else if (R_L.equals(associative.get(currentValue))){
                                stack.push(currentValue);
                                break;
                            }
                        }
                        else {
                            result += stack.pop();
                            topPrec = (stack.size()!=0) ? precedence.get(stack.peek()) : 0;
                        }

                    }
                }
            }
        }


        if (stack.size() != 0) {
            while (stack.size() != 0){
                result += stack.pop();
            }
        }

        printLn("Output : "+result);

    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }
}
