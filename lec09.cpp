#include<iostream>
#include<vector>

using namespace std;

void displayReverse(vector<int>& arr,int idx){

    if(idx==arr.size()){
        return;
    }
    displayReverse(arr,idx+1);
    cout<< arr[idx] << " ";
}


int findFirstOcc(vector<int>& arr,int data,int idx){
    if(idx==arr.size()){
        return -1; }
    int res = findFirstOcc(arr,data,idx+1);
    if(arr[idx]==data){
        return idx; }
    return res;
}
int findLastOcc(vector<int>& arr,int data, int idx){
    if(idx==arr.size()){
        return -1; }
    int lastocc = findLastOcc(arr,data,idx+1);
    if(arr[idx] == data){
        if(lastocc != -1){
            return lastocc; } else{
            return idx;
        }
    }
    return lastocc;
}

 vector<int> allIndices(vector<int>& arr,int idx,int data,int count){
        
        if(idx==arr.size()){
            vector<int> baseRes(count,0);
            return baseRes;
        }
        if(arr[idx]==data){
            count = count + 1;
        }
        vector<int> recAns = allIndices(arr,idx+1,data,count);
        if(arr[idx]==data){
            recAns[ count - 1 ]=idx;
        }
        return recAns;
    }


int main(){

    vector<int> arr{2,3,2,3,2,3,5};
    // displayReverse(arr,0);

    vector<int> ans = allIndices(arr,0,3,0);
    for(int i=0;i<ans.size();i++){
        cout<<ans[i]<<" ";
    }

    return 0;
}