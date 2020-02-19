class lec22{


    public static int eggsFloor(int e,int f){
        if(e==1 || f==1|| f==0){
            return f;
        }


        int bestOfWorst = Integer.MAX_VALUE;

        for(int i=1;i<=f;i++){
            int case1 = eggsFloor(e, f-i);
            int case2 = eggsFloor(e-1, i-1);
            int worst = Math.max(case1, case2);
            bestOfWorst = Math.min(bestOfWorst, worst);
        }
        return bestOfWorst+1;
    }


    public static int efdp(int egg,int floor){
        int[][] dp = new int[egg+1][floor+1];
        for(int e=0;e<=egg;e++){
            for(int f=0;f<=floor;f++){
                if(e==0){
                    dp[e][f] = 0;
                }else if(e==1 || f==0 || f==1){
                    dp[e][f] = f;
                }else{
                    int bestOfWorst = Integer.MAX_VALUE;
                    for(int i=1;i<=f;i++){
                        int case1 = dp[e][ f-i];
                        int case2 = dp[e-1][ i-1];
                        int worst = Math.max(case1, case2);
                        bestOfWorst = Math.min(bestOfWorst, worst);
                    }
                    dp[e][f] = bestOfWorst+1;
                }
            }
        }
        return dp[egg][floor];
    }


    public static void encoding(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        int num = ques.charAt(0)-'0';
        if(num>=1 && num<= 9){
            encoding(ques.substring(1), ans+(char)(96+num));
        }else{
            return;
        }
        if(ques.length()>1){
            int num1 = ques.charAt(1)-'0';
            int fnum = num*10+num1;
            if(fnum>=10 && fnum<=26){
                encoding(ques.substring(2), ans+(char)(96+fnum));
            }
        }
    }

    public static void main(String[] args){

        // System.out.println(efdp(2,7));
        encoding("023", "");

    }



}