/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        if(s.length()<2)
            return false;
        Stack<Character> st = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                st.push(c);
            }
            else if(c==')'||c==']'||c=='}'){
                if(st.empty())
                    return false;
                if(c==')'&&(st.pop() =='('))
                    continue;
                else if (c==']'&&(st.pop() =='['))
                    continue;
                else if (c=='}'&&(st.pop() =='{'))
                    continue;
                else
                    return false;
            }
        }
        if(st.empty())
            return true;
        return false;
    }
}
