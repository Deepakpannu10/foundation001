class lec20{

    public static int coinChange(int[] arr,int target){
        int[] dp=new int[target+1];
        dp[0] = 1;

        for(int i=1;i<=target;i++){
            for(int j=0;j<arr.length;j++){
                if(i-arr[j]>=0){
                    dp[i] += dp[i-arr[j]];
                }
            }
        }


        return dp[target];
    }



    public static int knapsack0_1(int[] cost,int[] wt,int cap){
        int[][] dp = new int[cost.length+1][cap+1];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j]; // na ki call

                if(j-wt[i-1]>=0 ){ // han ki call valid h ya ni
                    if(dp[i][j]<(cost[i-1]+dp[i-1][j-wt[i-1]])) // agr h toh uthane mai fayda h ya ni
                    dp[i][j] = cost[i-1]+dp[i-1][j-wt[i-1]];
                }
            }
        }
        return dp[cost.length][cap];
    }



    public static void main(String[] args){
        int[] arr={5,2,3};
        int[] cost = {45,20,15,25,30};
        int[] wt= {3,4,1,2,5};

        System.out.println(knapsack0_1(cost, wt, 7));
    }
}