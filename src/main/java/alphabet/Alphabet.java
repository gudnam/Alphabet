package main.java.alphabet;

import java.util.*;

/**
 * Created by gudnam on 2017. 6. 17..
 */
public class Alphabet {

    private int row, column;
    private Queue<AlphabetQueueData> queue;

    public Alphabet(int row, int column) {
        this.row = row;
        this.column = column;
        queue = new LinkedList<>();
    }

    public int solve(String[][] map) {
        showMap(map);

        int x = 0, y = 0, l = 1;
        push(x, y, l, Arrays.asList(map[x][y]));
        int max = l;

        while(!queue.isEmpty()) {

            showQueue();

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

    private void showMap(String[][] map) {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private void showQueue() {
        System.out.print("[");
        for (AlphabetQueueData data : queue) {
            System.out.print(String.format("(%d,%d)", data.x, data.y));
        }
        System.out.println("]");
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
}
