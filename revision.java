import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class genericTree{
    
    static node root=null;


    static class node{
        int data=0;
        node left;
        node right;
        node(int d){
            this.data = d;
            this.left = this.right = null;
        }
    }

    public static void construct(int[] data){
        ArrayList<node> stack  = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            if(data[i] == -1){
                stack.remove(stack.size()-1);
            }else{
                node nn = new node(data[i]);
                if(root == null){
                    root = nn;
                }else{
                    node cp = stack.get(stack.size()-1);
                    if(cp.left == null){
                        cp.left = nn;
                    }else{
                        cp.right = nn;
                    }
                }
                stack.add(nn);
            }
        }
    }

    public static void display(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" -> ");
        if(root.left!=null) System.out.print(root.left.data+" ");
        if(root.right!=null) System.out.print(root.right.data+" ");
        System.out.println(".");
        if(root.left!=null) display(root.left);
        if(root.right!=null) display(root.right);
    }

    public static void preOrderI(node root){
        ArrayList<node> stack = new ArrayList<>();
        stack.add(root);
        while(stack.size()>0){
            node cp = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            System.out.print(cp.data+" ");
            if(cp.right!=null){
                stack.add(cp.right);
            }
            if(cp.left!=null){
                stack.add(cp.left);
            }
        }
    }


    public static node construct1(int[] pre,int[] in,int plo,int phi,int ilo,int ihi){
        if(ilo==ihi){
            node basenode = new node(in[ilo]);
        return basenode;
        }
        node croot = new node(pre[plo]);
        int count = 0;
        int i=ilo;
        while(pre[plo] != in[i]){
            count++;
            i++;
        }
        croot.left = construct1(pre, in, plo+1, plo+count,ilo, ilo+count-1);
        croot.right = construct1(pre, in, plo+count+1,phi, i+1 , ihi);
        return croot;
    }


    static class bstHelper{
        boolean isBst = true;
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE;
        int height = 0;
        boolean isBalanced = true;
    }


    public static bstHelper isBalBst(node root){
        if(root == null){
            bstHelper baseAns = new bstHelper();
            return baseAns;
        }

        bstHelper left = isBalBst(root.left);
        bstHelper right = isBalBst(root.right);
        bstHelper myAns = new bstHelper();
        myAns.isBst = left.isBst && right.isBst && left.max<root.data && right.min>root.data;
        myAns.isBalanced = left.isBalanced && right.isBalanced && (left.height-right.height)>=-1 &&(left.height-right.height)<=1;
        if((myAns.isBst && myAns.isBalanced) == false){
            return myAns;
        }
        myAns.height = Math.max(left.height, right.height)+1;
        myAns.max = Math.max(root.data, Math.max(left.max, right.max));
        myAns.min = Math.min(root.data, Math.min(left.min, right.min));
        return myAns;
    }


    static class helper{
        int dia=0;
        int height=0;
    }

    public static int height (node root){
        if(root==null) return 0;
        int lh= height(root.left);
        int rh = height(root.right);
        int myheight = Math.max(lh, rh)+1;

        return myheight;
    }

    public static int kwDiameter(node root){
        if(root == null){
            return 0;
        }
        int left = kwDiameter(root.left);
        int right = kwDiameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        int myans = Math.max(lh+rh+1, Math.max(left, right));
        return myans;
    }

    public static helper diameter(node root){
        if(root == null){
            helper baseAns = new helper();
            return baseAns;
        }
        helper left = diameter(root.left);
        helper right = diameter(root.right);
        helper myans = new helper();
        myans.dia = Math.max(left.height+right.height+1, Math.max(left.dia, right.dia));
        myans.height = Math.max(left.height, right.height)+1;
        return myans;
    }



    public static void main(String[] args){
        int[] data = {10,20,40,-1,50,80,-1,90,-1,-1,-1,30,60,-1,70};    
        construct(data);
        // System.out.println(root.data);
        // display(root);
        // System.out.println(max(root));
        // System.out.println(lca(root, 50,100));
        // levelOrderZZ(root);
        // preOrderI(root);
        int[] pre = {10,20,40,50,80,90,30,60,70};
        int[] in = {40,20,80,50,90,10,60,30,70};
        root  = construct1(pre, in, 0, pre.length-1, 0, in.length-1);
        display(root);
        helper ans = diameter(root);
        System.out.println(ans.dia);
    }
}