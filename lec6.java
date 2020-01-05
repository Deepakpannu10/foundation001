class lec6{


    static Scanner scn=new Scanner(System.in);

    public static boolean binarySearch(int[] arr,int data){

        int lo=0;
        int hi=arr.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(arr[mid]==data){
                return true;
            }else if(arr[mid]<data){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return false;
    }

    public static int[] binarySearchCeilAndFloor(int[] arr,int data){
        // bonus question not done in class.
        int[] ans=new int[2];
        int lo=0;
        int hi=arr.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
           // write your code here.
        }
        return ans;
    }

    // 2-d array begins

    // demo
    public static void fill(int[][] arr){
        int count=1;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=count;
                count++;
            }
        }

    }

    
// user input

public static void input(int[][] arr){

    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            arr[i][j]=scn.nextInt();
        }
    }
}

// spiral printing
    public static void spiral(int[][] arr){

        int count=0;
        int minr=0 , maxr=arr.length-1;
        int minc=0 , maxc=arr[0].length-1;


        while(count < arr.length*arr[0].length){
            for(int i=minr;i<=maxr;i++){
                System.out.print(arr[i][minc]+" ");
                count++;
            }   
            minc++;

            for(int i=minc;i<=maxc;i++){
                System.out.print(arr[maxr][i]+" ");
                count++;
            }
            maxr--;

            for(int i=maxr;i>=minr;i--){
                System.out.print(arr[i][maxc]+" ");
                count++;
            }
            maxc--;

            for(int i=maxc;i>=minc;i--){
                System.out.print(arr[minr][i]);
                count++;
            }
            minr++;
        }
    }


    public static void main(String[] args){
        
        

        
        int[][] arr=new int[4][4];
        fill(arr);
    }

}