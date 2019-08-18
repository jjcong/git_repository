package algorithm.test.exercise.笔试真题.链家;
import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l =Integer.valueOf(sc.nextLine());

        for(int rr=0;rr<l;rr++){
            String[] strs = sc.nextLine().split(" ");

            int x=Integer.valueOf(strs[0]);
            int a=Integer.valueOf(strs[1]);
            int c=Integer.valueOf(strs[2]);
            int y=Integer.valueOf(strs[3]);
            int b=Integer.valueOf(strs[4]);
            int d=Integer.valueOf(strs[5]);
            int xtime=(x%b==0)?x/b:x/b+1;
            int ytime=(y%a==0)?y/a:y/a+1;
            int xtime11=(xtime*d);//存活时间
            int ytime11=(ytime*c);
            int xtime1=xtime11-d;//存活时间
            int ytime1=ytime11-c;
            if(xtime1>ytime1) {
                System.out.println("XIAOZHI");
            }else if(xtime1<ytime1){
                System.out.println("XIAOCHUN");
            }else {
                System.out.println("TIE");
            }



        }

    }

}
