class Solution {
    public int reverseDegree(String s) {
        int total=0;
        for(int i=0;i<s.length();i++){
            int reverseindex=26-(s.charAt(i)-'a');
            int stringindex=i+1;
            total =total+ reverseindex * stringindex;
        }
      return total;
        
    }
}