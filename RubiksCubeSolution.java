public class RubiksCubeSolution{
    private char [][][] cube = new char[6][3][3];
    static private char[] faceColors = {'Y', 'R', 'G', 'O', 'B', 'W'};
    
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
        for (char[] row : cube[face]) {
            System.out.print(padding);
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public void displayCube(){
    //Display all 6 faces in the correct format using at least two calls of displayFace() method
        displayFace(0, "       ");
        
        //Print Middle Faces (Indices 1, 2, 3, 4) side-by-side
        for (int r = 0; r < 3; r++) {
            for (int f = 1; f <= 4; f++) {
                for (int c = 0; c < 3; c++) {
                    System.out.print(cube[f][r][c] + " ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        
        displayFace(5, "       ");
    }
    
    
    public void rotateTop() {
    //Rotate the top face:
    //The stickers the top later is shifted
    //the top rows of the 4 faces that share a side with it will shift
    
        //Swap corners
        char temp = cube[0][0][0];
        cube[0][0][0] = cube[0][2][0]; 
        cube[0][2][0] = cube[0][2][2];
        cube[0][2][2] = cube[0][0][2];
        cube[0][0][2] = temp;
        
        //Swap edges
        temp = cube[0][0][1];
        cube[0][0][1] = cube[0][1][0];
        cube[0][1][0] = cube[0][2][1];
        cube[0][2][1] = cube[0][1][2];
        cube[0][1][2] = temp;
    
        //Blue(4) -> Red(3) -> Green(2) -> Orange(1) -> Blue(4)
        for (int piece = 0;piece < 3;piece++){
        //3 pieces per face are changed, so 4 pieces are exchanged at a time
            temp = cube[1][0][piece];
            cube[1][0][piece] = cube[2][0][piece];
            cube[2][0][piece] = cube[3][0][piece];
            cube[3][0][piece] = cube[4][0][piece];
            cube[4][0][piece] = temp;
        }
    }
    
    public void rotateFace(int face){
    //Rotate the face by using the provided helper methods for setup and execute rotateTop()
    //Remember to undo the setup
    if (face == 0) {
            rotateTop();
        } else if (face == 1) { //Left (Red)
            Helper.spinCubeRight(cube);
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
            Helper.spinCubeLeft(cube);
        } else if (face == 2) { // Front (Green)
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
        } else if (face == 3) { // Right (Orange)
            Helper.spinCubeLeft(cube);
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
            Helper.spinCubeRight(cube);
        } else if (face == 4) { // Back (Blue)
            Helper.spinCubeRight(cube);
            Helper.spinCubeRight(cube);
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
            Helper.spinCubeRight(cube);
            Helper.spinCubeRight(cube);
        } else if (face == 5) { // Down (White)
            Helper.tiltCubeForward(cube);
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
            Helper.tiltCubeBackward(cube);
        }
    }
    
    public void scramble(int moves){
    //Generate and execute a random scramble seperated by spaces on the cube and print it out using displayCube()
    //U is upper/white(0), L is left/red(1), F is front/green(2), R is right/orange(3), B is back/blue(4), D is down/white(5)
    //' is counterclockwise, 2 means rotate twice CW or CCW
    //Example: scramble(3) "U2 L L'"
    
        String[] notation = {"U", "L", "F", "R", "B", "D"};
        String[] suffixes = {"", "2", "'"};
        String scrambleString = "";
        int lastFace = -1;
        
        for (int i = 0;i<moves;i++){
            int face = (int)(Math.random()*6);
            while (face == lastFace)
                face = (int)(Math.random()*6);
            lastFace = face;
    
            int type = (int)(Math.random()*3);
            for (int j = 0;j<=type;j++)
                rotateFace(face);
            
            scrambleString += notation[face] + suffixes[type] + " ";
        }
        
        System.out.println(scrambleString);
        displayCube();
    }
    
    public void execute(String input){
        
    }
}