package Ex;

public class trifib {
    public static int triFib(int n){
        if(n <= 3){
            return n;
        }
        else{
            return triFib(n-1) + triFib(n - 2) + triFib(n - 3);
        }
    }

    public static void main(String[] args){
//        System.out.println(triFib(1));
//        System.out.println(triFib(2));
//        System.out.println(triFib(3));
//        System.out.println(triFib(4));
//        System.out.println(triFib(5));
//        System.out.println(triFib(6));
//        System.out.println(triFib(7));
//        System.out.println(triFib(8));
//        System.out.println(triFib(9));

//        String str = "hias";
//        System.out.println(str.length());
        int x = -11 / 3;
        System.out.println(x);
    }
}
