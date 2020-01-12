class lec09{

    public static void display(int[] arr,int idx){
        if(idx==arr.length){
            return;
        }

        System.out.println(arr[idx]);

        display(arr,idx+1);

    }


    public static int findMax(int[] arr,int idx){
        if(idx==arr.length-1){
            return idx;
        }
        int recAns = findMax(arr,idx+1);
        if(arr[idx]>arr[recAns]){
            return idx;
        }else{
            return recAns;
        }
    }

    public static int[] allIndices(int[] arr,int idx,int data,int count){
        
        if(idx==arr.length){
            int[] baseRes =  new int[count];
            return baseRes;
        }
        if(arr[idx]==data){
            count = count + 1;
        }
        int[] recAns = allIndices(arr,idx+1,data,count);
        if(arr[idx]==data){
            recAns[ count - 1 ]=idx;
        }
        return recAns;
    }

    public static void main(String[] args){
        int[] arr={2,3,2,3,2,3,5};
        // display(arr,0);
        // System.out.println(findMax(arr,0));
        int[] ans = allIndices(arr,0,3,0);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}