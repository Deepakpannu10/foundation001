import java.util.ArrayList;
class lec11{


    public static ArrayList<String> subseq1(String ques){
        if(ques.length()==0){
            ArrayList<String> baseres = new ArrayList<>();
            baseres.add("");
            return baseres;
        }
        String roq = ques.substring(1);
        ArrayList<String> recans = subseq1(roq);
        ArrayList<String> myans = new ArrayList<String>();
        char ch= ques.charAt(0);
        // for(String str:recans){
        //     myans.add(str+ch);
        // }
        for(int i=0;i<recans.size();i++){
            myans.add( ch+ recans.get(i));
        }
        for(int i=0;i<recans.size();i++){
            myans.add(recans.get(i));
        }
    return myans;
    }

    public static int stairsPath(int n){
       if(n==0){
            return 1;
        }
        int myans=0;
        if(n-1>=0)
        myans +=  stairsPath(n-1);
        if(n-2>=0)
        myans += stairsPath(n-2);
        if(n-3>=0)
        myans += stairsPath(n-3);
        return myans;
    }

    public static ArrayList<String> stairsPath1(int n){
        if(n==0){
            ArrayList<String> baseres = new ArrayList<>();
            baseres.add("");
            return baseres;
        }
        ArrayList<String> myans = new ArrayList<>();
        if(n-1>=0){
            ArrayList<String> recans = stairsPath1(n-1);
            for(String str : recans ){
                myans.add("1"+str);
            }
        }
        if(n-2>=0){
            ArrayList<String> recans = stairsPath1(n-2);
            for(String str : recans){
                myans.add("2"+str);
            }
        }
        if(n-3>=0){
            ArrayList<String> recans = stairsPath1(n-3);
            for(String str: recans ){
                myans.add("3"+str);
            }
        }
        return myans;
    }

    public static void subseq(String ques,String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        subseq( roq , ans + ch );
        subseq( roq , ans );
    }



    public static void main(String[] args){
        String ques="abc";

        // subseq(ques,"");

        // ArrayList<String> ans = subseq1(ques);
        // System.out.println(ans);
        System.out.println(stairsPath1(4));
    }
}