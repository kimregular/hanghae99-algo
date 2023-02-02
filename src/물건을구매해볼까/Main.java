package 물건을구매해볼까;


public class Main {
    public int solution(int price) {
        price = (1000 - price);
        int answer = 0;
        int[] myCoins = {500, 100, 50, 10};
        for (int myCoin : myCoins) {
            answer += (price / myCoin);
            price %= myCoin;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main method = new Main();
        int price = 160;
        System.out.println(method.solution(price));
    }
}
