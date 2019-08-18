package algorithm.test.exercise.笔试真题.美团;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=scanner.nextInt();
            }

            int m = scanner.nextInt();

            for(int j=0;j<m;j++){
                int x =scanner.nextInt();
                int sum = a[0];
                int count = 1;
                for(int i =1;i<=n;i++){
                    if(sum>=x){
                        System.out.println(count);
                        break;
                    }else{
                        sum = sum+a[i];
                    }
                    count++;
                }
            }
        }
    }

}
