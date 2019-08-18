package algorithm.test.exercise.笔试真题.大华;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByFile {

    public static void main(String[] args) throws IOException {

        List<String> input = readFile("E://input.txt");
        Collections.sort(input);

        try ( PrintWriter w = new PrintWriter("E://out.txt")){
            for(String line : input){
                w.println(line);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }


    public static List<String> readFile(String path) throws IOException {
        List<String> list = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            if (line.lastIndexOf("---") < 0) {
                list.add(line);
            }
        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }

}
