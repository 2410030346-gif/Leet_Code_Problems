class Problem_5 {
    public String longestPalindrome(String s) {
     if(s==null || s.length()<2)return s;
     int start=0,end=0;
     for(int i=0;i<s.length();i++){
        int len1=expandfromcenter(s,i,i);
        int len2=expandfromcenter(s,i,i+1);
        int len=Math.max(len1,len2);
        if(len>end-start+1){
            int half=len/2;
            if(len%2==1){
                start=i-half;
                end=i+half;
            }
            else{
                start=i-half+1;
                end=i+half;
            }
        }
     }   
     return s.substring(start,end+1);
    }
    private int expandfromcenter(String s,int left,int right)
{
    while(left>=0 && right<s.length()&& s.charAt(left)==s.charAt(right)){
        left--;
        right++;

    }
    return right-left-1;
}}