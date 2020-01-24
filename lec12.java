import java.util.ArrayList;
class lec12{

    public static int mazePath(int sr,int sc,int er,int ec,String path){
        if(sr==er && sc==ec){
            System.out.print(path+"  ");
            return 1;
        }
        int count = 0;
        if(sc+1<=ec)
        count += mazePath(sr,sc+1,er,ec,path+"H");
        if(sr+1<=er)
        count += mazePath(sr+1,sc,er,ec,path+"V");
        return count;
    }

    public static ArrayList<String> mazePath1(int sr,int sc,int er,int ec){
        if(sr == er && sc == ec){
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        ArrayList<String> myans = new ArrayList<>();
        if(sc+1<=ec){
            ArrayList<String> recAns = mazePath1(sr,sc++,er,ec);
            for(String str:recAns){
                myans.add("H"+str);
            }
        }
        if(sr+1<=er){
            ArrayList<String> recAns = mazePath1(sr++,sc,er,ec);
            for(String str:recAns){
                myans.add("V"+str);
            }
        }
        return myans;
    }

    public static ArrayList<String> nokiaKeypad(String[] codes,String ques){
        if(ques.length()==0){
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        int idx = ch - '0';
        String code = codes[idx];
        ArrayList<String> myans = new ArrayList<>();
        ArrayList<String> recAns = nokiaKeypad(codes ,roq);
        for(int i = 0; i <code.length(); i++){
            for(String str:recAns){
                myans.add(code.charAt(i)+str);
            }
        }
        return myans;
    }




    public static void main(String[] args) {
        // System.out.println(mazePath( 0,0,2,2,""));
        // ArrayList<String> ans = mazePath1(0,0,2,2);
        // System.out.println(ans+" "+ ans.size());
        String[] codes ={"?.",",;","abc","def","ghi","jkl","mno","pqrs","tuvw","xyz"};
        String ques="478";
        ArrayList<String> ans = nokiaKeypad(codes,ques);
        System.out.println(ans);
    }
}