package p15828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.bufferSize, ip.packets));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int bufferSize = Integer.parseInt(br.readLine());

        List<Integer> packets = new ArrayList<>();

        int packet = 0;

        while ((packet = Integer.parseInt(br.readLine())) != -1) {
            packets.add(packet);
        }

        return new Input(bufferSize, packets);
    }

    static class Input {

        int bufferSize;
        List<Integer> packets;

        public Input(int bufferSize, List<Integer> packets) {
            this.bufferSize = bufferSize;
            this.packets = packets;
        }
    }
}

class Solution {

    public String solution(int buffersize, List<Integer> packets) {
        Router router = new Router(buffersize);
        router.communication(packets);
        return getAnswer(router.getBuffer());
    }

    private String getAnswer(List<Integer> buffer) {
        if (buffer.isEmpty()) return "empty";

        StringBuilder answer = new StringBuilder();
        for (Integer i : buffer) {
            answer.append(i).append(" ");
        }
        return answer.toString();
    }

}

class Router {

    int bufferSize;
    LinkedList<Integer> buffer = new LinkedList<>();

    public Router(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public List<Integer> getBuffer() {
        return this.buffer;
    }

    public void communication(List<Integer> packets) {
        for (int packet : packets) {
            calc(packet);
        }
    }

    private void calc(int packet) {
        if (packet == 0) {
            this.buffer.removeFirst();
        } else if(this.buffer.size() < this.bufferSize) {
            this.buffer.addLast(packet);
        }
    }
}