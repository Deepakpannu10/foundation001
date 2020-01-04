class lec5{

    public static void rearrange(int[] value,int[] index) {
        for(int i=0;i<value.length;i++){
                while(index[i]!=i){
                    int idx=index[i];

                    swap(value,i,idx);
                    swap(index,i,idx);
                }
            }
        }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void maxSumSubArray(int [] gen){
        // kadane's algo.
        int sum=0, max=0;
        int os=0;
        int oe=0;
        int cs=0; int ce=0;
        while(ce<gen.length){
            if(sum>0){
                sum= sum+gen[ce];
            }else{
                cs=ce;
                sum=gen[ce];
            }
          
            if(max<sum){
                max=sum;
                os=cs;
                oe=ce;
            }            
            ce++;
        }
        for(int i=os;i<=oe;i++){
            System.out.print(gen[i]+" ");
        }




    }


    

    public static void main(String[] args){
        // int[] arr={50,40,70,60,90};
        // int[] index={3,0,4,1,2};
        // int[] arr={5,-3,2,-8,1,4,7,-1,6,-8};
        // maxSumSubArray(arr);

        int[] arr={1,2,3,3,3,3,4,4,8,8,9,9,11,23,23,23,45,56};

    }
}