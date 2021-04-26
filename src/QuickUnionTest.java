import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickUnionTest {

    @org.junit.jupiter.api.Test
    void testQuickFindCount() {
        QuickFind uf = new QuickFind(5);

        uf.union(0, 1);
        uf.union(1, 4);
        uf.union(2, 3);

        int actual = uf.getConnectedComponentCount();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    void testSoilStructureFromTextFile() {
        SoilStructureIdentifier s = new SoilStructureIdentifier();
        int[] sStructure = s.soilStructureFromTextFile("test_data.txt");

        int actual = sStructure.length;
        int expected = 25;

        assertEquals(actual, expected);
    }
}