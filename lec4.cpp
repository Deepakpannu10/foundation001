#include<iostream>
#include<vector>
using namespace std;

void input(vector<int>& arr){
    for(int i=0;i<arr.size();i++){
        cin>>arr[i];
    }
}

void display(vector<int>& arr){
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

 int span(vector<int>& arr){
        int myMax=arr[0];
        int myMin=arr[0];
        for(int i=1;i<arr.size();i++){
            if(arr[i]>myMax){
                myMax=arr[i];
            }
            if(arr[i]<myMin){
                myMin=arr[i];
            }
        }
        return myMax-myMin;
    }

    void printBar(vector<int>& arr){
        int myMax=arr[0];
        for(int i=1;i<arr.size();i++){
            if(myMax<arr[i]){
                myMax=arr[i];
            }
        }
        for(int i=myMax;i>0;i--){
            for(int j=0;j<arr.size();j++){
                if(arr[j]>=i){
                    cout<<"* ";
                }else{
                    cout<<"  ";
                }
            }
            cout<<endl;
        }
    }

    void swap(vector<int>& arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    void reverseArray(vector<int>& arr){
        int i=0;
        int j=arr.size()-1;

        while(i<j){
            swap(arr , i, j);
            i++; j--;
        }
    }

int main(){


    // int size=0;
    // cin>>size;

    vector<int> arr{3,5,7,1,4,2};
    // printBar(arr);
    display(arr);
    reverseArray(arr);
    // input(arr);
    display(arr);
    return 0;
}