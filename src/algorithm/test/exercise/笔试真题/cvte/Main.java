package algorithm.test.exercise.笔试真题.cvte;

public class Main {

    public static void main(String[] args) {
        int[] A = {2,3,2,1,5};
        int[] B = {8,5,3,2,1,1};
        System.out.println(maxSubstring(A, B));

    }


    public static int maxSubstring(int[] A, int[] B){
        String strOne = "";
        String strTwo = "";

        for (int num : A) {
            strOne += num;
        }
        for (int num : B) {
            strTwo += num;
        }

        if(strOne==null || strTwo == null){
            return 0;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return 0;
        }
        String max = "";
        String min = "";
        if(strOne.length() < strTwo.length()){
            max = strTwo;
            min = strOne;
        } else{
            max = strTwo;
            min = strOne;
        }
        String current = "";
        for(int i=0; i<min.length(); i++){
            for(int begin=0, end=min.length()-i; end<=min.length(); begin++, end++){
                current = min.substring(begin, end);
                if(max.contains(current)){
                    return current.length();
                }
            }
        }
        return 0;
    }

    public static int LCS(int[] A, int[] B){

        String str1 = "";
        String str2 = "";

        for (int num : A) {
            str1 += num;
        }
        for (int num : B) {
            str2 += num;
        }

        int[][] c = new int[str1.length() + 1][str2.length() + 1];
        for(int row = 0; row <= str1.length(); row++)
            c[row][0] = 0;
        for(int column = 0; column <= str2.length(); column++)
            c[0][column] = 0;

        for(int i = 1; i <= str1.length(); i++)
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else if(c[i][j-1] > c[i-1][j])
                    c[i][j] = c[i][j-1];
                else
                    c[i][j] = c[i-1][j];
            }
        return c[str1.length()][str2.length()];
    }

}
