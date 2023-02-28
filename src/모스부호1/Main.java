package 모스부호1;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String letter = ".... . .-.. .-.. ---";
        System.out.println(s.solution(letter));
    }
}

class Solution {
    public String solution(String letter) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] alph = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o", "p1260","q","r","s","t","u","v","w","x","y","z"};
        String answer = "";

        for (String str : letter.split(" ")) {
            for (int i = 0; i < morse.length; i++) {
                if (morse[i].equals(str)) {
                    answer += alph[i];
                    break;
                }
            }
        }
        return answer;
    }
}