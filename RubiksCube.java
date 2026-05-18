public class RubiksCube{
    private char [][][] cube = new char[6][3][3];
    static private char[] faceColors = {'W', 'Y', 'G', 'B', 'O', 'R'};
    
    public RubiksCube(){
        //Initiate and assign right colors of all 6 faces
        for (int i = 0; i < cube.length; i++)
        // Loop through the 3 rows of the current face
        for (int j = 0; j < cube[i].length; j++)
            // Loop through the 3 columns of the current row
            for (int k = 0; k < cube[i][j].length; k++) {
                // Assign the color corresponding to the current face index
                cube[i][j][k] = faceColors[i];
            }
    }
    
    public void displayFace(int face){
        for (char[] row:cube[face]){
            for (char col:row)
                System.out.print(col + " ");
                
            System.out.println();
        }
    }
    
    public void displayAll(){
        for (int i = 0;i<6;i++){
            displayFace(i);
        }
    }
}