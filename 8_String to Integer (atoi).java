/*
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front. 
*/

public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length()<1){
            return 0;
        }
        str = str.trim();
        char[] strArray = str.toCharArray();
        char sign = '+';
        int j=0;
        if(strArray[0]=='-'){
            sign = '-';
            j++;
        }
        else if(strArray[0]=='+'){
            j++;
        }
        double result=0;
        for(int i =j;i<str.length();i++){
            if(Character.isDigit(strArray[i])){
                int digit = strArray[i] - '0';
                result = result*10 + digit;
            }
            else
                break;
        }
        if(sign == '-'){
            if((result*-1)<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return (int)(result*(-1));
        }
        if(result>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        return (int)result;
    }
}
