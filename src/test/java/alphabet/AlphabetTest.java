package test.java.alphabet;

import main.java.alphabet.Alphabet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by gudnam on 2017. 6. 16..
 */
class AlphabetTest {

    Alphabet alphabet;

    int R, C;
    Character[][] map;

    @BeforeEach
    void setUp() {
        R = 4;
        C = 4;
        alphabet = new Alphabet(R, C);
    }

    private String[][] getMap(int row, int column) {
        String[][] map = new String[row][column];

        map[0][0] = "A";
        map[0][1] = "B";
        map[0][2] = "C";
        map[0][3] = "E";
        map[1][0] = "B";
        map[1][1] = "D";
        map[1][2] = "H";
        map[1][3] = "I";
        map[2][0] = "C";
        map[2][1] = "F";
        map[2][2] = "A";
        map[2][3] = "B";
        map[3][0] = "E";
        map[3][1] = "G";
        map[3][2] = "J";
        map[3][3] = "K";

        return map;
    }

    @Test
    public void test() {

        assertTrue(alphabet.solve(getMap(R, C)) == 7);
    }

    @Test
    public void testPush() {
        int x = 0, y =1, l = 0;
        alphabet.push(x, y, l);
        LinkedList<Integer[]> values = (LinkedList) alphabet.getQueue();
        Integer[] value = values.get(values.size()-1);
        assertTrue(value[0] == x && value[1] == y);
    }

    @Test
    public void testPop() {
        int x = 0, y =1, l=0;
        int x1 = 1, y1 =0, l1=1;
        alphabet.push(x, y, l);
        alphabet.push(x1, y1, l1);
        Integer[] value = alphabet.pop();
        assertTrue(value[0] == x && value[1] == y);

        LinkedList<Integer[]> values = (LinkedList) alphabet.getQueue();
        Integer[] value1 = values.get(values.size()-1);
        assertTrue(value1[0] == x1 && value1[1] == y1);
    }
}