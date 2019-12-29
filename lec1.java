import java.util.*;
class lec1{

    public static void main(String[] args){
        boolean[][] board=new boolean[4][4];
        System.out.println(queenpermu(board,0,0));
    }

    public static int queenpermu(boolean[][] board,int cb,int cq){
        int n=board.length;
        // if(cb==n*n){
            if(cq==board.length){
                return 1;
            }
            // return 0;
        // }
        int ans=0;
        // System.out.println("hi");
        for(int i=0;i<n*n;i++){
                if(!board[i/n][i%n]){
                    board[i/n][i%n]=true;
                  ans +=  queenpermu(board,i,cq+1);
                    board[i/n][i%n]=false;;
                }
        }
        return ans;
    }

    public static int queenpermu(boolean[][] board,int cb,int cq){
        int n=board.length;
        if(cb==n*n){
            if(cq==board.length){
                return 1;
            }
            return 0;
        }
        int ans=0;
        // System.out.println("hi");
        for(int i=cb;i<n*n;i++){
                if(!board[i/n][i%n]){
                    board[i/n][i%n]=true;
                  ans +=  queenpermu(board,i+1,cq+1);
                    board[i/n][i%n]=false;;
                }
        }
        return ans;
    }



}