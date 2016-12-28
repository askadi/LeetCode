public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0)
            return false;
        if(num ==2)
            return false;
        if((num & (num-1)) == 0){
            int count = 0;
            while(num>1){
                num >>= 1;
                count++;
            }
            if((count %2) == 0){
                return true;
            }
            
        }
        return false;
    }
}
