package p29753;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int len = Integer.parseInt(st.nextToken());
            double passGrade = Double.parseDouble(st.nextToken());

            String[][] myGrade = new String[len][2];

            for(int i = 0; i < len - 1; i++){
                st = new StringTokenizer(br.readLine(), " ");
                myGrade[i][0] = st.nextToken();
                myGrade[i][1] = st.nextToken();
            }

            myGrade[len-1][0] = br.readLine();

            GradeFinder gf = new GradeFinder(passGrade, myGrade);
            System.out.println(gf.findFinalGrade());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class GradeFinder{

    double passGrade;
    String[][] myGrade;
    String[] grades = {"F", "D0", "D+", "C0", "C+", "B0", "B+", "A0", "A+"};

    public GradeFinder(double passGrade, String[][] myGrade){
        this.passGrade = passGrade;
        this.myGrade = myGrade;
    }

    public String findFinalGrade(){
        double[] tempArr = findTempGrade();

        double denominator = tempArr[0];
        double tempGrade = tempArr[1];


        double finalCredit = Double.parseDouble(myGrade[myGrade.length-1][0]);
        denominator += finalCredit;


        for(String grade : grades){

            double finalGrade = tempGrade + getGrade(finalCredit, grade);
            finalGrade /= denominator;
//            System.out.println(finalGrade);


            BigDecimal finalResult = BigDecimal.valueOf(finalGrade).setScale(2, RoundingMode.DOWN);
            BigDecimal threshold = BigDecimal.valueOf(passGrade);
//            System.out.println(finalResult);

            if(finalResult.compareTo(threshold) > 0) return grade;
        }

        return "impossible";
    }

    private double[] findTempGrade(){
        double denominator = 0.0;
        double temp = 0.0;
        for(int i = 0; i < myGrade.length - 1; i++){
            denominator += Double.parseDouble(myGrade[i][0]);
            temp += getGrade(Double.parseDouble(myGrade[i][0]), myGrade[i][1]);
        }

        return new double[]{denominator, temp};
    }

    private double getGrade(double credit, String grade) {
        switch (grade) {
            case "A+":
                return credit * 4.50;
            case "A0":
                return credit * 4.00;
            case "B+":
                return credit * 3.50;
            case "B0":
                return credit * 3.00;
            case "C+":
                return credit * 2.50;
            case "C0":
                return credit * 2.00;
            case "D+":
                return credit * 1.50;
            case "D0":
                return credit;
            default:
                return 0.00;
        }
    }
}