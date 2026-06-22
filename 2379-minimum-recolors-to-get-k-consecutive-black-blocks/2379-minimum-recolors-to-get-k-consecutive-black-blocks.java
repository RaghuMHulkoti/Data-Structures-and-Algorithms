class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l=0;
        int countW=0;
        int minres = Integer.MAX_VALUE;
        for(int r = 0;r<blocks.length();r++){
            if(blocks.charAt(r) == 'W'){
                countW++;
            }
            if(r-l+1==k){
                minres = Math.min(minres,countW);
                if(blocks.charAt(l) == 'W') countW--;
                l++;
            }
        }
        return minres;
    }
}