import edu.princeton.cs.algs4.In;

public class SoilStructureIdentifier {

    // For Testing:
    public static void main(String[] args) {
        SoilStructureIdentifier s = new SoilStructureIdentifier("test_data.txt");

    }

    // member variables
    private int[] soil_structure;
    private QuickUnion qUnion;

    // constructor
    public SoilStructureIdentifier(String textFileName) {
        // convert String from text file to an int-array
        int[] soil_structure = soilStructureFromTextFile(textFileName);
        // initialize quickUnion instance
        qUnion = new QuickUnion(soil_structure.length);
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

    // check to see if there is a path for water to pass throught the soil
    public void isPathThroughSoil() {
        // 'n' of the n x n soil matrix
        int width = (int) Math.sqrt(soil_structure.length);
        for(int i=width; i < soil_structure.length; i++) {
            switch (i % width) {
                case 0: { // left-most soil, don't check left
                    if(soil_structure[i+1] == 1) { // check right
                        // ToDo: make a connection
                    }
                    else if(soil_structure[i+width] == 1) {
                        // ToDo: make a connection
                    }
                    break;
                }
                case 3: { // right-most soil, don't check right
                    if(soil_structure[i-1] == 1) { // check left
                        // ToDo: make a connection
                    }
                    else if(soil_structure[i+width] == 1) {
                        // ToDo: make a connection
                    }
                    break;
                }
                default: {

                    break;
                }
            }
            if(i % width == 0) // left-most soil, don't check left
            if(i % width == 3) // right-most soil, don't check right
            if(soil_structure[i-1] == 1) // check left
            if(soil_structure[i+1] == 1) // check right
            if(soil_structure[i+width] == 1) // check above

        }
    }
}
