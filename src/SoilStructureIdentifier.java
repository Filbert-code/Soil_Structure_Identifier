import edu.princeton.cs.algs4.In;

public class SoilStructureIdentifier {

    // For Testing:
    public static void main(String[] args) {
        SoilStructureIdentifier s = new SoilStructureIdentifier("test_data.txt");
        System.out.println(s.isPathThroughSoil());
    }

    // member variables
    private final int[] soil_structure;
    private final QuickUnion qUnion;
    private final int nSize; // 'n' of the n x n soil matrix

    // constructor
    public SoilStructureIdentifier(String textFileName) {
        // convert String from text file to an int-array
        soil_structure = soilStructureFromTextFile(textFileName);
        // initialize quickUnion instance
        qUnion = new QuickUnion(soil_structure.length);
        nSize = (int) Math.sqrt(soil_structure.length);
    }

    // read data from text file
    public int[] soilStructureFromTextFile(String textFileName) {
        // create Scanner object through the algs4.In class
        In in = new In(textFileName);
        String soil_structure = "";
        // read binary data from given text file in current directory
        while(in.hasNextLine()) {
            soil_structure += in.readLine();
        }
        int[] soil_structure_array = new int[soil_structure.length()];
        int iter = 0;
        // convert the String into an int array
        for(String s: soil_structure.split("")) {
            soil_structure_array[iter++] = Integer.parseInt(s);
        }
        return soil_structure_array;
    }

    // check to see if there is a path for water to pass through the soil
    public boolean isPathThroughSoil() {
        for(int i=0; i < soil_structure.length-nSize; i++) {
            if(soil_structure[i] == 0)
                continue;
            // left-most soil, check right only
            if(i % nSize == 0) {
                if (soil_structure[i+nSize] == 0 && soil_structure[i+1] == 0)
                    continue;
                else if(soil_structure[i+1] == 1)
                    qUnion.union(i+1, i);
            }
            // right-most soil, check left only
            else if(i % nSize == nSize - 1) {
                if (i > nSize && soil_structure[i-nSize] == 0 && soil_structure[i-1] == 0)
                    continue;
                else if(soil_structure[i-1] == 1)
                    qUnion.union(i-1, i);
            }
            // check both left and right
            else {
                if(soil_structure[i+1] == 1) // check right
                    qUnion.union(i+1, i);
                if(soil_structure[i-1] == 1) // check left
                    qUnion.union(i-1, i);
            }
            // check below
            if(soil_structure[i+nSize] == 1) {
                qUnion.union(i+nSize, i);
            }
        }
        for(int k=soil_structure.length-nSize; k < soil_structure.length; k++) {
            if(qUnion.find(k) < nSize)
                return true;
        }
        return false;
    }
}
