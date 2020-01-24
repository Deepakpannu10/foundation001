class lec13{


    public static int floodFill(int[][] arr,int i,int j){
        if(i==arr.length-1 && j == arr[0].length-1){return 1;}
        arr[i][j] = 1 ;
        int count=0;
        // i-1,j
        if(i-1>=0 && arr[i-1][j]!=1){count += floodFill(arr,i-1,j);}
        // i,j-1
        if(j-1>=0 && arr[i][j-1]!=1){count += floodFill(arr,i,j-1);}
        // i+1,j
        if(i+1<arr.length && arr[i+1][j]!=1){count += floodFill(arr,i+1,j);}
        // i , j+1
        if(j+1<arr[0].length && arr[i][j+1] !=1 ){count += floodFill(arr,i , j+1);}
        arr[i][j] = 0;
        return count;
    }

    public static int floodFill(int[][] arr,int i,int j,String psf){
        if(i==arr.length-1 && j == arr[0].length-1)
        {System.out.println(psf);
            return 1;}
        arr[i][j] = 1 ;
        int count=0;
        // i-1,j
        if(i-1>=0 && arr[i-1][j]!=1){count += floodFill(arr,i-1,j,psf+'U');}
        // i,j-1
        if(j-1>=0 && arr[i][j-1]!=1){count += floodFill(arr,i,j-1,psf+'L');}
        // i+1,j
        if(i+1<arr.length && arr[i+1][j]!=1){count += floodFill(arr,i+1,j,psf+'D');}
        // i , j+1
        if(j+1<arr[0].length && arr[i][j+1] !=1 ){count += floodFill(arr,i , j+1,psf+'R');}
        arr[i][j] = 0;
        return count;
    }

    public static void main(String[] args){
        int[][] arr= {{0,0,0,0,0},{0,0,1,0,1},{0,0,0,0,0},{0,0,0,1,0}};
        System.out.println(floodFill(arr,0,0,""));
    }

}