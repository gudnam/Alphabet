package main.java;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();

        scanner.nextLine();

        String[][] map = new String[R][C];
        for (int i=0; i<R; i++) {
            String str = scanner.next();
            for (int j=0; j<C; j++) {
                map[i][j] = str.substring(j, j+1);
            }
            scanner.nextLine();
        }

        AlphabetForSubmit alphabet = new AlphabetForSubmit(R, C);
        alphabet.solve(map);
    }
}

class AlphabetForSubmit {

    private int row, column;
    private Queue<AlphabetQueueData> queue;

    public AlphabetForSubmit(int row, int column) {
        this.row = row;
        this.column = column;
        queue = new LinkedList<>();
    }

    public int solve(String[][] map) {
        int x = 0, y = 0, l = 1;
        push(x, y, l, Arrays.asList(map[x][y]));
        int max = l;

        while(!queue.isEmpty()) {

            AlphabetQueueData location = pop();
            x = location.x;
            y = location.y;
            l = location.l;
            List<String> alphabets = location.alphabets;

            if (x+1 <= row-1 && !alphabets.contains(map[x+1][y])) {
                List<String> alphabetsToPush = new ArrayList<>();
                alphabetsToPush.addAll(alphabets);
                alphabetsToPush.add(map[x+1][y]);
                push(x+1, y, l+1, alphabetsToPush);
            }
            if (x-1 >= 0 && !alphabets.contains(map[x-1][y])) {
                List<String> alphabetsToPush = new ArrayList<>();
                alphabetsToPush.addAll(alphabets);
                alphabetsToPush.add(map[x-1][y]);
                push(x-1, y, l+1, alphabetsToPush);
            }
            if (y+1 <= column-1 && !alphabets.contains(map[x][y+1])) {
                List<String> alphabetsToPush = new ArrayList<>();
                alphabetsToPush.addAll(alphabets);
                alphabetsToPush.add(map[x][y+1]);
                push(x, y+1, l+1, alphabetsToPush);
            }
            if (y-1 >= 0 && !alphabets.contains(map[x][y-1])) {
                List<String> alphabetsToPush = new ArrayList<>();
                alphabetsToPush.addAll(alphabets);
                alphabetsToPush.add(map[x][y-1]);
                push(x, y-1, l+1, alphabetsToPush);
            }

            if (max < l)
                max = l;
        }

        System.out.println(max);
        return max;
    }

    public void push(int x, int y, int l, List<String> alphabet) {
        queue.add(new AlphabetQueueData(x, y, l, alphabet));
    }

    public AlphabetQueueData pop() {
        AlphabetQueueData data = queue.poll();
        queue.remove(data);
        return data;
    }

    public Queue<AlphabetQueueData> getQueue() {
        return queue;
    }
}

class AlphabetQueueData {
    int x;
    int y;
    int l;
    List<String> alphabets = new ArrayList<>();

    public AlphabetQueueData(int x, int y, int l, List<String> alphabets) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.alphabets = alphabets;
    }

    public void add(String alphabet) {
        this.alphabets.add(alphabet);
    }
}
