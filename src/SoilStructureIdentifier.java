import edu.princeton.cs.algs4.In;

public class SoilStructureIdentifier {
    public static void main(String[] args) {
        SoilStructureIdentifier s = new SoilStructureIdentifier();
        s.soilStructureFromTextFile("test_data.txt");
    }
    // constructor
    public SoilStructureIdentifier() {
        // ToDo: initilialize data structure
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
        for(String s: soil_structure.split("")) {
            soil_structure_array[iter++] = Integer.parseInt(s);
        }
        return soil_structure_array;
    }
}
