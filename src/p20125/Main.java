package p20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[][] field = readField(br);
            Measurement measurement = new Measurement(field);
            measurement.calculate();
            System.out.print(measurement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char[][] readField(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] field = new char[n][];
        for (int i = 0; i < n; i++) {
            field[i] = br.readLine().toCharArray();
        }
        return field;
    }
}

class Measurement {
    private final char[][] field;
    private int heartRow;
    private int heartCol;
    private int leftArm;
    private int rightArm;
    private int waist;
    private int leftLeg;
    private int rightLeg;

    public Measurement(char[][] field) {
        this.field = field;
    }

    public void calculate() {
        int n = field.length;
        // 심장 위치 찾기
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == '*') {
                    heartRow = i + 1;
                    heartCol = j;
                    break outer;
                }
            }
        }

        // 왼쪽 팔 길이 계산
        for (int j = heartCol - 1; j >= 0 && field[heartRow][j] == '*'; j--) {
            leftArm++;
        }

        // 오른쪽 팔 길이 계산
        for (int j = heartCol + 1; j < n && field[heartRow][j] == '*'; j++) {
            rightArm++;
        }

        // 허리 길이 계산
        int waistRow = heartRow + 1;
        while (waistRow < n && field[waistRow][heartCol] == '*') {
            waist++;
            waistRow++;
        }

        // 왼쪽 다리 길이 계산
        int leftLegRow = waistRow;
        int leftLegCol = heartCol - 1;
        while (leftLegRow < n && leftLegCol >= 0 && field[leftLegRow][leftLegCol] == '*') {
            leftLeg++;
            leftLegRow++;
        }

        // 오른쪽 다리 길이 계산
        int rightLegRow = waistRow;
        int rightLegCol = heartCol + 1;
        while (rightLegRow < n && rightLegCol < n && field[rightLegRow][rightLegCol] == '*') {
            rightLeg++;
            rightLegRow++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // 심장 위치 출력 (1부터 시작하도록 조정)
        sb.append(heartRow + 1).append(' ').append(heartCol + 1).append('\n');
        sb.append(leftArm).append(' ').append(rightArm).append(' ').append(waist).append(' ').append(leftLeg).append(' ').append(rightLeg);
        return sb.toString();
    }
}
