class lec16{


public static int[] merge2SortedArrays(int[] arr1,int[] arr2)
{
int[] merged = new int[arr1.length+arr2.length];
int i=0,j=0,k=0;
while(i<arr1.length && j<arr2.length){
    if(arr1[i]<arr2[j]){
        merged[k]=arr1[i];
        i++; k++;
    }else{
        merged[k]=arr2[j];
        j++; k++;
    }
}
while(i<arr1.length){
       merged[k]=arr1[i];
        i++; k++; 
}
while(j<arr2.length){
       merged[k]=arr2[j];
        j++; k++; 
}
return merged;
}


public static int[] mergeSort(int[] arr,int lo,int hi){
    if(lo==hi){
        int[] base = new int[1];
        base[0]=arr[lo];
        return base;
    }
    int mid=(lo+hi)/2;
    int[] left=mergeSort(arr,lo,mid);
    int[] right=mergeSort(arr,mid+1,hi);
    int[] sorted = merge2SortedArrays(left,right);
    return sorted;
}

public static int partition(int[] arr,int lo,int hi){
    int i = lo;
    int j = lo;
    int pivot = arr[hi];
    while(i<=hi){
        if(arr[i]<=pivot){
            int temp = arr[i];
            arr[i]= arr[j];
            arr[j]=temp;
            i++; j++;
        }else{
            i++;
        }
    }
    return j-1;
}

public static void quickSort(int[] arr,int lo,int hi){
    if(lo>=hi){
        return;
    }
    int pvtidx = partition(arr,lo,hi);
    quickSort(arr,lo,pvtidx-1);
    quickSort(arr,pvtidx+1,hi);

}


public static void main(String[] args){
    int[] arr = {8,6,10,9,11,15,12};
    arr=mergeSort(arr,0,arr.length-1);

    for(int val : arr){
        System.out.print(val+" ");
    }

}

}