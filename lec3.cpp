
#include<iostream>

using namespace std;


int fact(int x){
    int ans=1;
    for(int i=1;i<=x;i){
        ans=ans*i;
    }
    return ans;
}

void display(int n,int r){
    int nfact=fact(n);
    int nmrfact=fact(n-r);

    cout<<nfact/nmrfact;
}

int deciToOct(int num){
    int ans=0;
    int pow=1;
    while(num!=0){
        int rem=num%8;
        num=num/8;
        ans+=pow*rem;   // ans=ans+pow8rem;
        pow=pow*10;
    }
    return ans;
}

int octalAddtion(int n1,int n2){
    int ans=0;
    int pow=1;
    int carry=0;
    int sb=8;
    while(n1>0 || n2>0 || carry>0){
        int nom=n1%10;
        int ntm=n2%10;
        n1=n1/10;
        n2=n2/10;
        int digit=nom+ntm+carry;
        carry=digit/sb;
        digit=digit%sb;

        ans=ans+digit*pow;
        pow=pow*10;
    }
    return ans;


}

int octalSub(int a,int b){
    int ans=0;
    bool isSwap=false;
    if(a<b){
        int temp=a;
        a=b;
        b=temp;
        isSwap=true;
    }
    int pow=1;
    int borrow=0, sb = 8;
    while(a!=0){
        int nom=a%10;
        a=a/10;
        int ntm=b%10;
        b=b/10;
        int octet=nom-ntm-borrow;
        if(octet<0){
            octet=octet+sb;
            borrow=1;
        }else{
            borrow=0;
        }
        ans=ans+octet*pow;
        pow=pow*10;
    }
    if(isSwap==true){
        ans=-ans;
    }
    return ans;
}

int main(){
    // int n=5;
    // int r=2;

    int n1=777;
    int n2=777;
    int oct=octalAddtion(n1,n2);

    cout<<oct<<endl;

    // int nfact=fact(n);

    // int nmrfact=fact(n-r);
    
    // display(n,r);
    // cout<<nfact/nmrfact;

    return 0;
}