package algorithm.test.exercise.link;

import java.util.ArrayList;
import java.util.Random;

/**
 * 从大小写字符以及数字中随机选取4个字符组成唯一ID，不允许重复选取
 *
 * @author  j_cong
 * @date    2018/03/17
 * @version V1.0
 */
public class UniqueID {

    public static void main(String[] args) {

    }

    //生成思维不重复的验证码
    public static String fourRandomGen(){
        char[] chars={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
        Random random=new Random();
        int count=0;
        String str = "";
        ArrayList st = new ArrayList();

        str.toCharArray();
        StringBuilder sb=new StringBuilder();//动态字符串

        while(true){
            char c=chars[random.nextInt(chars.length)];

            if(sb.indexOf(c+"")==-1){
                sb.append(c);
                count++;
                if(count==4){
                    break;
                }
            }

        }
        return sb.toString();
    }
}
