package 캐릭터의좌표2;

public class Solution {
    Move m = new Move();


    public int[] solution(String[] keyinput, int[] board) {

        m.maxWidth = board[m.xPos] / 2;
        m.maxHeight = board[m.yPos] / 2;
        for (String moveKey : keyinput) {
            m.move(moveKey);
        }
        return m.answer;
    }
}
