package e11;

public  class Parenthesis {

    private static char openParenthesis = '(';
    private static char closeParenthesis = ')';



    public static boolean isOpen (char a){
        if (openParenthesis == a){
            return true;
        }
        return false;
    }

    public static boolean isClose (char a){
        if (closeParenthesis == a){
            return true;
        }
        return false;
    }


    public static boolean isParenthesis (char a){
        if (closeParenthesis == a || openParenthesis == a ){
            return true;
        }
        return false;
    }


    public static Character getOpponent(char a){
        if (openParenthesis == a){
            return closeParenthesis ;
        }
        else if (closeParenthesis== a){
            return openParenthesis;
        }
        else
            return null;
    }

}
