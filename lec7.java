class lec7{


    public static void spiralPrint(int[][] arr){
        int minr=0,minc=0;
        int maxr=arr.length-1,maxc=arr[0].length-1;

        int count=0;
        // handle case where rows != cols
        while(count<arr.length*arr[0].length){
            // top wall fixed min
            for(int i=minc;i<=maxc;i++){
                System.out.print(arr[minr][i]+" ");
                count++;
            }
            minr++;
            // right wall
            for(int i=minr;i<=maxr;i++){
                System.out.print(arr[i][maxc]+" ");
                count++;
            }
            maxc--;

            // bottom wall

            for(int i=maxc;i>=minc;i--){
                System.out.print(arr[maxr][i]+" ");
                count++;
            }
            maxr--;

            //left wall
            for(int i=maxr;i>=minr;i--){
                System.out.print(arr[i][minc]+" ");
                count++;
            }
            minc++;


        }
    }


    

    public static void display(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+", ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }


    public static void transpose(int[][] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i<j){
                    int temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                }
            }
        }


    }


    public static void rotate(int[][] arr){

        transpose(arr);

        for(int i=0;i<arr.length/2;i++){
            for(int j=0;j<arr[i].length;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[arr.length-1-i][j];
                arr[arr.length-1-i][j]=temp;
            }
        }
    }



    public static void main(String[] args){
        int[][] arr={{1,2,3,10,20},
                     {4,5,6,30,40},
                     {7,8,9,50,60},
                     {11,12,13,14,15},
                     {16,17,18,19,100}};
                    // display(arr);
                    // rotate(arr);
                    // display(arr);
                    spiralPrint(arr);
    }

}