package p18352;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int numOfCities = Integer.parseInt(st.nextToken());
            int numOfRoads = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            int startCity = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> map = new ArrayList<>();

            for (int i = 0; i < numOfCities + 1; i++) {
                map.add(new ArrayList<>());
            }

            for (int i = 0; i < numOfRoads; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map.get(x).add(y);
            }

            PathFinder pf = new PathFinder(map, dis, startCity);
            pf.getCities();
            if (pf.flag) {
                System.out.println(-1);
            } else {
                Collections.sort(pf.result);
                for (int x : pf.result) {
                    System.out.println(x);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    ArrayList<ArrayList<Integer>> map;
    boolean[] isVisited;
    int dis;
    int startCity;
    ArrayList<Integer> result = new ArrayList<>();
    boolean flag = true; // -1 출력 결정 플래그


    public PathFinder(ArrayList<ArrayList<Integer>> map, int dis, int startCity) {
        this.map = map;
        this.isVisited = new boolean[map.size()];
        this.dis = dis;
        this.startCity = startCity;
    }

    public void getCities() {
        Queue<City> q = new LinkedList<>();
        q.offer(new City(startCity, 0));
        isVisited[startCity] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                City currentCity = q.poll();

                if (currentCity.distance == dis) {
                    flag = false;
                    result.add(currentCity.num);
                }


                for (int nextCity : map.get(currentCity.num)) {
                    if (!isVisited[nextCity]) {
                        isVisited[nextCity] = true;
                        q.offer(new City(nextCity, currentCity.distance + 1));
                    }
                }
            }
        }
    }
}

class City {
    int num;
    int distance;

    public City(int num, int distance) {
        this.num = num;
        this.distance = distance;
    }
}
