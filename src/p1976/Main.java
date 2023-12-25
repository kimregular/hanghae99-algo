package p1976;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfCities = Integer.parseInt(br.readLine());
            int numOfDestinations = Integer.parseInt(br.readLine());

            int[] connection = new int[numOfCities + 1];
            ConnectionLoader cl = new ConnectionLoader(connection);

            for (int i = 1; i < numOfCities + 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j < numOfCities + 1; j++) {
                    int city = Integer.parseInt(st.nextToken());
                    if (city == 1) {
                        cl.connectUnion(i, j);
                    }
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startCity = Integer.parseInt(st.nextToken());
            for (int i = 1; i < numOfDestinations; i++) {
                int nextCity = Integer.parseInt(st.nextToken());

                if (!cl.isConnected(startCity, nextCity)) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ConnectionLoader {

    int[] connection;

    public ConnectionLoader(int[] connection) {
        this.connection = connection;
        for (int i = 0; i < this.connection.length; i++) {
            this.connection[i] = i;
        }
    }

    public boolean isConnected(int cityA, int cityB) {
        return connectFind(cityA) == connectFind(cityB);
    }

    public int connectFind(int city) {
        if (city != this.connection[city]) {
            this.connection[city] = connectFind(this.connection[city]);
        }
        return this.connection[city];
    }

    public void connectUnion(int cityA, int cityB) {
        int a = connectFind(cityA);
        int b = connectFind(cityB);
        if(a != b) this.connection[a] = b;
    }
}