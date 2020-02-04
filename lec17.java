class lec17{


    public static String toggleChars(String str){
        String ans = "";
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            int ch1 = str.charAt(i);
            System.out.print(ch1+" ");
            if(ch>='a' && ch<='z'){
                ch =(char)( ch -'a' + 'A');
            }else{
                ch =(char)( ch -'A' + 'a');                
            }
        ans = ans + ch;
        }
    return ans;
    }



    public static int fibo(int n,int[] dp){
        if(n==0|| n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int nm1 = fibo(n-1,dp);
        int nm2 = fibo(n-2,dp);
        dp[n] = nm2+nm1;
        return nm1+nm2;
    }

    public static void main(String[] args){
        // System.out.println(toggleChars("VsTeR"));
        int[] dp = new int[47];
        System.out.println(fibo(46,dp));
    
    }
}