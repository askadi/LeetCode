public class Solution {
    public String getHint(String secret, String guess) {
       int n[]=new int[256];
       Integer i=0,bulls=0,cows=0;
      // Iterator<char> it = secret.toCharArray();
       for(char c : secret.toCharArray()){
           if(c==guess.charAt(i))
                bulls++;
            else{
                if(n[c]++ < 0)
                    cows++;
                if(n[guess.charAt(i)]-- > 0)
                    cows++;
            }
            i++;
       }
       return new String(bulls.toString()+"A"+cows.toString()+"B");
    }
}
