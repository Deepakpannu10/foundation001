class lec18{


    public static int mazePath(int sr,int sc,int er,int ec){
        int[][] dp = new int[er+1][ec+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j]=1;
                }else if(i==dp.length-1){
                    dp[i][j]=dp[i][j+1];
                }else if(j==dp[0].length-1){
                    dp[i][j]=dp[i+1][j];
                }else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static int stairsPath(int n){
        int[] dp = new int[n+1];
        dp[0] =1;
        for(int i=1;i<=n;i++){
        int myans=0;
        if(i-1>=0)
        myans += dp[i-1];
        if(i-2>=0)
        myans += dp[i-2];
        if(i-3>=0)
        myans += dp[i-3];
        dp[i]=myans;
        }     
        return dp[n];
     }



    public static int stairsPathM(int n,int[] dp){
        if(n==0){
             return 1;
         }
         if(dp[n]!=0){
             return dp[n];
         }
         int myans=0;
         if(n-1>=0)
         myans +=  stairsPathM(n-1,dp);
         if(n-2>=0)
         myans += stairsPathM(n-2,dp);
         if(n-3>=0)
         myans += stairsPathM(n-3,dp);
         dp[n]=myans;
         return myans;
     }
    public static void main(String[] args){
        
        // System.out.println(mazePath(0,0,3,4));

        System.out.println(stairsPath(7));


    }


}