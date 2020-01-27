import java.util.*;
class lec10{
    
    public static void subStrings(String s){
        for(int i=0;i<s.length();i++){
               for(int j=i;j<=s.length();j++){
                   String str=s.substring(i,j);
                   System.out.print(str+"  ");
               }
            }
    }

    

    public static boolean isPalindrome(String str){
        boolean palin=true;

        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                palin=false;
                break;
            }
        }
        return palin;        
    }

    public static void main(String[] args){
        // String s = "abcdef";
        

        // Scanner scn = new Scanner(System.in);
        // String str=scn.nextLine();
        // String strr=scn.next();


        ArrayList<Integer> al = new ArrayList<>();
        al.add(20);
        al.add(30);
        al.remove(10);
        for(int i=0;i<al.size();i++){
            System.out.print(al.get(i));
        }


        // String a = new String("abcdef");
        // String s=a;
        // a=a+"x";
        // s=s+"x";
        // System.out.println(str+" "+strr);
        // 
    }


}