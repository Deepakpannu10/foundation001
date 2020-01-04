#include<iostream>
#include<vector>

using namespace std;

void print(vector<int>& arr,int i,int j ){
    for(int idx=i;idx<=j;idx++){
        cout<<arr[idx]<<" "; 
    }
    cout<<endl;
}

void findSubArray(vector<int>& arr){

    for(int i=0;i<arr.size();i++){
        for(int j=i;j<arr.size();j++){
            print(arr,i,j);
        }
    }
}

bool binarySearch(vector<int>& arr,int data){
    int lo=0;
    int hi=arr.size()-1;
    while (lo<=hi)
    {int mid=(lo+hi)/2;
        if(arr[mid]==data){       return true;
        }else if(arr[mid]<data){
            lo=mid+1;
        }else{
            hi=mid-1;
        }
    }
    return false;
}

int main(){

    vector<int> arr{10,20,30,40,50};

    
    findSubArray(arr);

    return 0;
}