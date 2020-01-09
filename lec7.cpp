#include<iostream>
#include<vector>
using namespace std;


int calcIArrI(vector<int>& arr){
    int sum=0;
    int rmo=0;
    for(int i=0;i<arr.size();i++){
        sum +=arr[i];
        rmo +=i*arr[i];
    }
    int mymax=rmo;
    int nra=0;
    for(int i=1;i<arr.size();i++){
        nra = rmo - sum +  arr.size()*arr[i-1];
        if(mymax<nra){
            mymax=nra;
        }
        rmo=nra;
    }
return mymax;
}

void exitPoint(vector<vector<int> >& arr){

    int i=0,j=0;

    int dir=0;

    while(true){
        dir=dir+arr[i][j];
        dir=dir%4;
        if(dir==0){
            j++;
        }else if(dir==1){
            i++;
        }else if(dir==2){
            j--;
        }else{
            i--;
        }
        if(i<0 || i>=arr.size() || j<0 || j>=arr[0].size()){
            break;
        } 
    }

    if(i<0){
        i++;
    }
    if(j<0){
        j++;
    }
    if(i>=arr.size()){
        i--;
    }
    if(j>=arr[0].size()){
        j--;
    }

    cout<<i<<" "<<j<<endl;

}


int main(){

    vector<int> arr{3,2,8,1};

    cout<<calcIArrI(arr)<<endl;


    return 0;
}