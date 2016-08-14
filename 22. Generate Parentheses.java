/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<String>();
        if(n<=0){
            return parenthesis;
        }
        permutations(parenthesis,"",n,n);
        return parenthesis;
    }
    public void permutations(List<String> parenthesis, String s, int open,int close){
        if(open > close){
            return;
        }
        if(open==0 && close ==0){
            parenthesis.add(s);
            return;
        }
        if(open>0){
             permutations(parenthesis,s+'(',(open-1),close);
        }
        if(close>0){
             permutations(parenthesis,s+')',open,(close-1));
        }
    }
}
