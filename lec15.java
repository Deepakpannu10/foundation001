class lec15{

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[ j ];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr){
        for(int i = 0; i<arr.length - 1 ; i++){
            for(int j = 0 ; j<arr.length - 1 - i ; j++ ){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);    
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i<arr.length - 1 ; i++){
            for(int j = i + 1 ; j<arr.length ; j++ ){
                if(arr[i]>arr[j]){
                    swap(arr,i,j);    
                }
            }
        }
    }


    public static void bubbleRec(int[] arr,int st,int end){
        if(st==end){
            if(end==0){
                return;
            }
            bubbleRec(arr,0,end-1);
            return;
        }
        if(arr[st]>arr[st+1]){
            swap(arr,st,st+1);
        }
        bubbleRec(arr,st+1,end);
    }



    public static void main(String[] args){
        int[] arr={3,8,-1,4,6,1,7};

        bubbleRec(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }


}