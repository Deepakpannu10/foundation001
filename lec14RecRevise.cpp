#include<iostream>
#include<vector>
using namespace std;

void printInc(int n){
    if(n==0){
        return;
    }
    printInc(n-1);
    cout<<n<<endl;
}

void printDec(int n){
    if(n==0){
        return;
    }
    cout<<n<<endl;
    printDec(n-1);
}

void printIncDec(int n){
    if(n==1){
        cout<<n<<endl;
        return;
    }
    cout<<n<<endl;
    printIncDec(n-1);
    cout<<n<<endl;
}

int fact(int n){
        if(n==1){
            return 1;
        }
        int recans = fact(n-1);
        int myans=n*recans;
        return myans;
    }

vector<int> allIndices(vector<int> &arr,int idx,int data,int count){
        if(idx==arr.size()){
            vector<int> baseres (count,0);
            return baseres;
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

    void subStrings(string s){
        for(int i=0;i<s.length();i++){
               for(int j=1;j<=s.length()-i;j++){
                   string str=s.substr(i,j);
                   cout<<str+"  ";
               }
            }
    }

    
 void subseq(string ques,string ans){
        if(ques.length() == 0){
            cout<<(ans)<<endl;
            return;
        }
        char ch = ques[0];
        string roq = ques.substr(1);
        subseq( roq , ans +  ch );
        subseq( roq , ans );
    }


 vector<string> subseq1(string ques){
        if(ques.length()==0){
            vector<string> baseres ;
            baseres.push_back("");
            return baseres;
        }
        string roq = ques.substr(1);
        vector<string> recans = subseq1(roq);
        vector<string> myans ;   char ch= ques[0];
        for(int i=0;i<recans.size();i++){
            myans.push_back( ch+ recans[i]);
        }
        for(int i=0;i<recans.size();i++){
            myans.push_back(recans[i]);
        }
    return myans;
    }


    vector<string> anyJumpSp(int n){
        if(n==0){
            vector<string> baseres;
            baseres.push_back("");
            return baseres;
        }
        vector<string> myans;
        for(int i =1 ;n-i>=0;i++){
            vector<string> recans = anyJumpSp(n-i);
            for(int x=0;x<recans.size();x++){
                myans.push_back(to_string(i)+recans[x]);
            }
        }
    return myans;
    }

int main(){

    // printDec(5);
    // printInc(5);
    // printIncDec(5);
    // subseq("abc","");
    vector<string> ans = anyJumpSp(7);
        for(int i=0;i<ans.size();i++){
            cout<<ans[i]<<" ";
        }
        return 0;
}