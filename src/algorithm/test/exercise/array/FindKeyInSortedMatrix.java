package algorithm.test.exercise.array;
/**
 * 在排序的二维数组中找key
 * 
 * @author  j_cong
 * @date    2018/06/04
 * @version V1.0
 */
public class FindKeyInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{}};

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

    }

    public static boolean find(int target, int [][] array) {

        /*
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;

        while (row < array.length && col >= 0) {
                if (target == array[row][col]) {
                    return true;
                } else if (target > array[row][col]) {
                    row++;
                } else{
                    col--;
                }
        }
        return false;
        */

        if(array==null||array.length==0 ||array[0].length==0){
            return false;
        }
        int l1= array[0].length;//列数
        int l2=array.length;//行数

        int temp;
        int j=l1-1;
        if(array[l2-1][l1-1]<target||array[0][0]>target){
            return false;
        }

        while(array[0][j]>target){
            j=j-1;
        }
        temp=j;
        for(int i=0;i<l2;i++){
            if(array[i][temp]==target){
                return true;
            }
        }
        return false;
    }
}
