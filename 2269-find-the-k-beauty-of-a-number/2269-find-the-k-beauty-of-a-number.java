class Solution {
    public int divisorSubstrings(int num, int k) {
        String strNum = String.valueOf(num);
        int l = 0;
        int res = 0;
        for(int r=0;r<strNum.length();r++){
            if(r-l+1==k){
                int divisor = Integer.valueOf(strNum.substring(l,r+1));
                if(divisor!=0 && num%divisor == 0){
                    res++;
                }
                l++;
            }
        }
        return res;
    }
}