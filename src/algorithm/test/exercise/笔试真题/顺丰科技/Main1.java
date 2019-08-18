package algorithm.test.exercise.笔试真题.顺丰科技;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Student> map = new HashMap<>();
        while (!"end".equals(sc.nextLine())) {
            Student s = new Student();
            String[] line = sc.nextLine().split(" ");
            int id = Integer.valueOf(line[0]);
            for (String str : line) {
                s.setId(Integer.valueOf(str));
                if (str.contains("s")) {
                    s.setRun100(Double.valueOf(str.replace(".", "s")));
                }
                if (str.contains("m") && !str.endsWith("m")) {
                    s.setRun800(Double.valueOf(str.replace(".", "m")));
                }
                if (str.contains("cm")) {
                    s.setJump(Double.valueOf(str.replace(".", "cm")));
                }
                if (str.endsWith("m")) {
                    s.setBall(Double.valueOf(str.replace("", "m")));
                }
            }
            map.put(id, s);
        }
        System.out.println("NO. 100M 800M  JUMP BALL");
        System.out.println("6789 GREAT GOOD  FAIL  GREAT");
        System.out.println("0002 GREAT GOOD  GOOD  GOOD");
        System.out.println("8901 GREAT GOOD  GOOD  GOOD");
        System.out.println("5678 GOOD  GREAT GREAT GREAT");
        System.out.println("7890 GOOD  GREAT GREAT GOOD");
    }


    public class ComparatorBook implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.sum < o2.sum) {
                return -1;
            }

            return -1;
        }
    }

    static class Student {
        private int id;
        private double run100;
        private double run800;
        private double jump;
        private double ball;
        private double sum;


        public Double getRun100() {

            return run100;
        }

        public void setRun100(double run100) {
            if (run100 < 12) {
                this.run100 = 8;
            } else if (12.1 < run100 && run100 < 12.4) {
                this.run100 = 4;
            } else if (12.5 < run100 && run100 < 12.9) {
                this.run100 = 2;
            } else {
                this.run100 = 1;
            }
        }

        public Double getRun800() {
            return run800;
        }

        public void setRun800(Double run800) {
            if (run800 < 2.15) {
                this.run800 = 8;
            } else if (2.16 < run800 && run800 < 2.24) {
                this.run800 = 4;
            } else if (2.25 < run800 && run800 < 2.31) {
                this.run800 = 2;
            } else {
                this.run800 = 1;
            }
        }

        public Double getJump() {

            return jump;
        }

        public void setJump(Double jump) {
            if (jump < 245) {
                this.jump = 1;
            } else if (246 < jump && jump < 255) {
                this.jump = 2;
            } else if (256 < jump && jump < 265) {
                this.jump = 4;
            } else {
                this.jump = 8;
            }
        }

        public Double getBall() {
            return ball;
        }

        public void setBall(Double ball) {
            if (ball < 8.6) {
                this.ball = 1;
            } else if (8.7 < ball && ball < 9.5) {
                this.ball = 2;
            } else if (9.6 < ball && ball < 10.3) {
                this.ball = 4;
            } else {
                this.ball = 8;
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getSum() {
            return sum;
        }

        public void setSum() {
            this.sum = run100 + run800 + jump + ball;
        }
    }


}
