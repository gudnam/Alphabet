package main.java;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();

        if (R < 1 || C > 20)
            return;

        scanner.nextLine();

        String[][] map = new String[255][20];
        for (int i=0; i<R; i++) {
            String str = scanner.next();
            for (int j=0; j<C; j++) {
                map[i][j] = str.substring(j, j+1);
            }
            scanner.nextLine();
        }

        Alphabet alphabet = new Alphabet(R, C);
        System.out.println(alphabet.solve(map));
    }

    public static class Alphabet {

        private int row;
        private int column;
        private Queue<AlphabetQueueData> queue;

        public Alphabet(int row, int column) {
            this.row = row;
            this.column = column;
            queue = new LinkedList<>();
        }

        public int solve(String[][] map) {

            if (map == null)
                return 0;

            int x = 0, y = 0, l = 1;
            push(x, y, l, Arrays.asList(map[x][y]));
            int max = l;

            while(!queue.isEmpty()) {

                AlphabetQueueData location = pop();
                x = location.x;
                y = location.y;
                l = location.l;
                List<String> alphabets = location.alphabets;

                if (map[x][y] == null)
                    return 0;

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
}
