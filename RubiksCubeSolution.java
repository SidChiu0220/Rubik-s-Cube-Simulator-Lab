public class RubiksCubeSolution{
    private char [][][] cube = new char[6][2][2];
    static private char[] faceColors = {'Y', 'O', 'B', 'R', 'G', 'W'};
    
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
    
    public void displayFace(int face, String padding){
    //Display the assigned face and assinged padding
        for (char[] row:cube[face]){
            System.out.print(padding); // Add padding
            for (char col:row)
                System.out.print(col + " ");
                
            System.out.println();
        }
    }
    
    public void displayCube() {
    //Display all 6 faces in the correct format using at least two calls of displayFace() method
        
        // 1. Print Top Face (Index 0) with 6 spaces of padding
        displayFace(0, "     ");
        
        // 2. Print Middle Faces (Indices 1, 2, 3, 4) side-by-side
        // We loop through the 3 rows manually so they stay on the same line
        for (int r = 0; r < 2; r++) {
            
            // Print row 'r' for each middle face sequentially
            for (int f = 1; f <= 4; f++) {
                for (int c = 0; c < 2; c++) {
                    System.out.print(cube[f][r][c] + " ");
                }
                System.out.print(" ");
            }
            System.out.println(); // Move to the next line after finishing row r for all 4 faces
        }
        
        // 3. Print Bottom Face (Index 5) with 6 spaces of padding
        displayFace(5, "     ");
    }
    
    
    public void rotateTop(boolean clockwise) {
        // 1. Save the top-left sticker of the Yellow face so it doesn't get lost
        char temp = cube[0][0][0];
        
        // 2. Shift the remaining 3 stickers of the Yellow face based on direction
        if (clockwise) {
            cube[0][0][0] = cube[0][1][0]; 
            cube[0][1][0] = cube[0][1][1];
            cube[0][1][1] = cube[0][0][1]; 
            cube[0][0][1] = temp;
        } else {
            cube[0][0][0] = cube[0][0][1]; 
            cube[0][0][1] = cube[0][1][1];
            cube[0][1][1] = cube[0][1][0]; 
            cube[0][1][0] = temp;
        }

        // 3. Define the cycle order of the 4 side faces surrounding the Top layer
        // Clockwise: Orange(1) <- Blue(2) <- Red(3) <- Green(4) <- Orange(1)
        // Counter-Clockwise: Orange(1) <- Green(4) <- Red(3) <- Blue(2) <- Orange(1)
        int[] faces;
        if (clockwise)
            faces = new int[]{1, 2, 3, 4, 1};
        else
            faces = new int[]{1, 4, 3, 2, 1};
        
        // 4. Loop through both columns (index 0 and 1) of the top row
        for (int c = 0; c < 2; c++) {
            // Save the starting face's sticker for this column
            char t = cube[faces[0]][0][c];
            
            for (int i = 0; i < 4; i++) {
                cube[faces[i]][0][c] = cube[faces[i + 1]][0][c];
            }
            
            // Put the saved starting sticker into the final face of the cycle
            cube[faces[3]][0][c] = t;
        }
    }
}