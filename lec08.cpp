#include<iostream>

using namespace std;


void printDec(int n){
    if(n==0){
        return; 
    }
    cout<<n<<endl;
    printDec(n-1);

}

void printDecInc(int n){

    if(n==1){
        cout<<n<<endl;
        return;
    }
    cout<<n<<endl;
    printDecInc(n-1);
    cout<<n<<endl;
}

void printZZZ(int n){
    if(n==0){
        return;
    }
    cout<<n<<" ";
    printZZZ(n-1);
    cout<<n<<" ";
    printZZZ(n-1);
    cout<<n<<" ";
}


int main(){

    int n=0;
    cin>>n;

    printDec(n);



}