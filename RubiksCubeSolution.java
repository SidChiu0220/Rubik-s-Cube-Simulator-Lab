public class RubiksCubeSolution{
    private char [][][] cube = new char[6][3][3];
    static private char[] faceColors = {'W', 'Y', 'G', 'B', 'O', 'R'};
    
    public RubiksCubeSolution(){
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
    
    public void rotateFaceClockwise(int face){

    char[][] temp = new char[3][3];

    // Copy rotated values into temp
    for (int row = 0; row < 3; row++){
        for (int col = 0; col < 3; col++){

            temp[col][2 - row] = cube[face][row][col];

        }
    }

    // Copy temp back into cube
    for (int row = 0; row < 3; row++){
        for (int col = 0; col < 3; col++){

            cube[face][row][col] = temp[row][col];

        }
    }
}
}