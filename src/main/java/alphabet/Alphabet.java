package main.java.alphabet;

import java.util.*;

/**
 * Created by gudnam on 2017. 6. 17..
 */
public class Alphabet {

    private int row, column;
    private Map<String, Boolean> charList;
    private Queue<Integer[]> queue;

    public Alphabet(int row, int column) {
        this.row = row;
        this.column = column;
        charList = new HashMap<>();
        queue = new LinkedList<>();
    }

    public int solve(String[][] map) {
        showMap(map);

        int x = 0, y = 0, l = 1;
        String c = map[x][y];
        charList.put(c, true);
        push(x, y, l);
        int max = l;

        while(!queue.isEmpty()) {

            showQueue();

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

        System.out.println("max : " + max);
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
        for (Integer[] i : queue) {
            System.out.print(String.format("(%d,%d)", i[0], i[1]));
        }
        System.out.println("]");
    }
}
