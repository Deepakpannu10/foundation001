class lec21{



    public static int mcm(int[] arr){
        int[][]  dp = new int[arr.length-1][arr.length-1];
        
        for(int gap=0;gap <dp[0].length;gap++){
            for(int i=0,j=i+gap;j<dp[0].length;i++,j++){
               if(gap==0){
                   dp[i][j] = 0;
               }else if(gap==1){
                   dp[i][j] = arr[i] * arr[j+1] * arr[j];
               }else{
                   dp[i][j] = Integer.MAX_VALUE;
                for(int k=0;k<gap;k++){
                    int lp = dp[i][i+k];
                    int rp = dp[i+1+k][j];
                    int multiCost = arr[i] * arr[j+1] * arr[i+1+k];
                    dp[i][j] = Math.min(dp[i][j] ,lp+rp+multiCost);
                }
               }
            }
          }
          return dp[0][dp[0].length-1];
    }


    public static int unKnapsack(int[] wts,int[] cost,int cap){
        int[] dp=new int[cap+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<wts.length;j++){
                if(i-wts[j]>=0){
                    dp[i] = Math.max(dp[i], dp[i-wts[j]]+cost[j]);
                }
            }
        }
        return dp[cap];
    }





    public static void main(String[] args){
        // int[] arr= {10,20,30,40,50,60};
        int[] wts={3,4,1,2,5};
        int[] cost = {45,20,15,25,30};
        System.out.println(unKnapsack(wts, cost, 7));
    }
}