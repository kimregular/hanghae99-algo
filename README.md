# 알고리즘 풀이 모음

## 코드 스니펫

### 두 선분이 겹치는지 확인하는 로직

```java
public boolean isConnected(int[] line1, int[] line2) {
    return Math.max(line1[0], line2[0]) <= Math.min(line1[1], line2[1]);
}

// 아래 두 선분은 겹치는 선분임
int[] line1 = {1, 3};
int[] line2 = {2, 4};
// 2 <= 3 -> true

// 아래 두 선분은 겹치지 않는 선분임
int[] line3 = {1, 3};
int[] line4 = {5, 9};
// 5 <= 3 -> false
```

### 두 점 사이의 거리 구하기

```java
private double getDistance(double[] star1, double[] star2) {
    double width = star2[1] - star1[1];
    double height = star2[0] - star1[0];
    return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
}
```

### 4개 점의 좌표가 있을 때 해당 점으로 만들 수 있는 도형이 정사각형인지 판단하기

```java
private boolean isSquare(int[][] points) { // 4개 점의 (x, y) 주어짐
    Set<Double> lengthSet = new HashSet<>();
    for (int i = 0; i < points.length; i++) {
        for (int j = 0; j < points.length; j++) {
            if (i == j) continue;
            lengthSet.add(getLength(points[i], points[j]));
        }
    }
    return lengthSet.size() == 2;
}

// lengthSet의 크기가 2라면 정사각형이다
// 각 변의 길이 똑같아야하고
// 각 대각선의 길이가 똑같아야한다.
```

## 다시 풀기 리스트

- https://www.acmicpc.net/problem/15565

- https://www.acmicpc.net/problem/1598

- https://www.acmicpc.net/problem/17298

- https://www.acmicpc.net/problem/4963

- https://www.acmicpc.net/problem/1260

- https://www.acmicpc.net/problem/11724

- https://www.acmicpc.net/problem/10026

- https://www.acmicpc.net/problem/2503

- https://www.acmicpc.net/problem/1090

- https://www.acmicpc.net/problem/1987

- https://www.acmicpc.net/problem/1018

- https://www.acmicpc.net/problem/26169

- https://www.acmicpc.net/problem/1436

- https://www.acmicpc.net/problem/1676

- https://www.acmicpc.net/problem/1966

- https://www.acmicpc.net/problem/18110

- https://www.acmicpc.net/problem/1520

- https://www.acmicpc.net/problem/11659

- https://www.acmicpc.net/problem/1167

- https://www.acmicpc.net/problem/1967

- https://www.acmicpc.net/problem/1068

- https://www.acmicpc.net/problem/1991

- https://www.acmicpc.net/problem/11053

- https://www.acmicpc.net/problem/11722

- https://www.acmicpc.net/problem/2941

- https://www.acmicpc.net/problem/11660

- https://www.acmicpc.net/problem/1717

- https://www.acmicpc.net/problem/1976

- https://www.acmicpc.net/problem/17352

- https://www.acmicpc.net/problem/1629

- https://www.acmicpc.net/problem/2805

- https://www.acmicpc.net/problem/4375

- https://www.acmicpc.net/problem/15663
- https://www.acmicpc.net/problem/16198
- https://www.acmicpc.net/problem/2230
- https://www.acmicpc.net/problem/1806
- https://www.acmicpc.net/problem/14921
- https://www.acmicpc.net/problem/2579
- https://www.acmicpc.net/problem/18111
- https://www.acmicpc.net/problem/27446
- https://www.acmicpc.net/problem/17626
- https://www.acmicpc.net/problem/11068
- https://www.acmicpc.net/problem/11637