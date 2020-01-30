package e11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.Stack;

public class Parser {


    public static void main(String[] args) throws IOException {

        System.out.println("enter your expression :");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();

        Stack<Character> pila = new Stack<>();

        boolean isCorrectExpression = false;

        boolean isEndOfExpression = true;

        /*
        for(int i = 0; i < expression.length(); i++) {
            System.out.println(expression.charAt(i));
        }

         */

        for( int i = 0; i < expression.length() ; i++ ){

            char symbol = expression.charAt(i);

            if( Parenthesis.isParenthesis(symbol)){


                if(Parenthesis.isOpen(symbol)){
                    pila.push(symbol);
                }
                else {

                    if(pila.isEmpty()){
                        isEndOfExpression = false;
                        break;
                    }

                    else {
                        pila.pop();
                    }
                }
            }
        }
        if (pila.isEmpty()&& isEndOfExpression){
            isCorrectExpression = true;
        }
        else {
            isCorrectExpression= false;
        }

        if (isCorrectExpression){
            System.out.println( expression +"This expression is correct ");
        }
        else {
            System.out.println(expression + "This expression is Not correct");
        }
    }

}
