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
    private Map<String, Boolean> charList;
    private Queue<Integer[]> queue;

    public AlphabetForSubmit(int row, int column) {
        this.row = row;
        this.column = column;
        charList = new HashMap<>();
        queue = new LinkedList<>();
    }

    public int solve(String[][] map) {
        int x = 0, y = 0, l = 1;
        String c = map[x][y];
        charList.put(c, true);
        push(x, y, l);
        int max = l;

        while(!queue.isEmpty()) {

            Integer[] location = pop();
            x = location[0];
            y = location[1];
            l = location[2];

            List<String> alphabets = new ArrayList<>();

            if (x+1 <= row-1 && charList.get(map[x+1][y]) == null) {
                push(x+1, y, l+1);
                alphabets.add(map[x+1][y]);
            }
            if (x-1 >= 0 && charList.get(map[x-1][y]) == null) {
                push(x-1, y, l+1);
                alphabets.add(map[x-1][y]);
            }
            if (y+1 <= column-1 && charList.get(map[x][y+1]) == null) {
                push(x, y+1, l+1);
                alphabets.add(map[x][y+1]);
            }
            if (y-1 >= 0 && charList.get(map[x][y-1]) == null) {
                push(x, y-1, l+1);
                alphabets.add(map[x][y-1]);
            }

            if (alphabets.size() != 0) {
                for (String alphabet : alphabets) {
                    charList.put(alphabet, true);
                }
            }

            if (max < l)
                max = l;
        }

        System.out.println(max);
        return max;
    }

    public void push(int x, int y, int l) {
        Integer location[] = {x, y, l};
        queue.add(location);
    }

    public Integer[] pop() {
        Integer[] pop = queue.poll();
        queue.remove(pop);
        return pop;
    }

    public Queue<Integer[]> getQueue() {
        return queue;
    }
}
