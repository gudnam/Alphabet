package test.java.alphabet;

import main.java.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by gudnam on 2017. 6. 16..
 */
class AlphabetTest {

    Main.Alphabet alphabet;
    String[][] map;

    @BeforeEach
    void setUp() {
        map = new String[255][20];
    }

    private String[][] getMap(int row, int column) {
        String[][] map = new String[row][column];

        map[0][0] = "A";
        map[0][1] = "A";
        map[0][2] = "E";
        map[0][3] = "F";
        map[1][0] = "B";
        map[1][1] = "C";
        map[1][2] = "D";
        map[1][3] = "G";
        map[2][0] = "J";
        map[2][1] = "L";
        map[2][2] = "O";
        map[2][3] = "H";
        map[3][0] = "N";
        map[3][1] = "K";
        map[3][2] = "J";
        map[3][3] = "I";

        return map;
    }

    @Test
    public void test() {
        alphabet = new Main.Alphabet(4, 4);

        map[0][0] = "A";
        map[0][1] = "A";
        map[0][2] = "E";
        map[0][3] = "F";
        map[1][0] = "B";
        map[1][1] = "C";
        map[1][2] = "D";
        map[1][3] = "G";
        map[2][0] = "J";
        map[2][1] = "L";
        map[2][2] = "O";
        map[2][3] = "H";
        map[3][0] = "N";
        map[3][1] = "K";
        map[3][2] = "J";
        map[3][3] = "I";

        assertTrue(alphabet.solve(map) == 14);
    }

    @Test
    public void test2() {

        alphabet = new Main.Alphabet(4, 4);

        map[0][0] = "A";
        map[0][1] = "A";
        map[0][2] = "E";
        map[0][3] = "F";
        map[1][0] = "B";
        map[1][1] = "C";
        map[1][2] = "D";
        map[1][3] = "G";
        map[2][0] = "J";
        map[2][1] = "L";
        map[2][2] = "O";
        map[2][3] = "H";
        map[3][0] = "N";
        map[3][1] = "K";
        map[3][2] = "J";
        map[3][3] = "I";

        assertTrue(alphabet.solve(map) == 14);
    }

    @Test
    public void testMapIsEmpty() {
        alphabet = new Main.Alphabet(0, 0);
        assertTrue(alphabet.solve(map) == 0);
    }

    @Test
    public void testMapIsEmpty2() {
        alphabet = new Main.Alphabet(2, 2);
        assertTrue(alphabet.solve(map) == 0);
    }

    @Test
    public void testMapIsNull() {
        alphabet = new Main.Alphabet(0, 0);
        String[][] map = null;
        assertTrue(alphabet.solve(map) == 0);
    }

    @Test
    public void testMapIsOne() {
        alphabet = new Main.Alphabet(1, 1);
        map[0][0] = "A";
        assertTrue(alphabet.solve(map) == 1);
    }
}