import java.util.ArrayList;

public class RubiksCubeSolution{
    private String [][][] cube = new String[6][3][3];
    static private String[] faceColors = {"🔲", "🟧", "🟩", "🟥", "🟦", "🟨"};
    
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
        for (String[] row : cube[face]) {
            System.out.print(padding);
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public void displayCube(){
    //Display all 6 faces in the correct format using at least two calls of displayFace() method
        displayFace(0, "          ");
        System.out.println();
        
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
        
        System.out.println();
        displayFace(5, "          ");
    }
    
    
    public void rotateTop() {
    //Rotate the top face:
    //The stickers the top later is shifted
    //the top rows of the 4 faces that share a side with it will shift
        //Swap corners
        String temp = cube[0][0][0];
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
    
        //Blue(4) -> Orange(3) -> Green(2) -> Red(1) -> Blue(4)
        for (int piece = 0;piece < 3;piece++){
        //3 pieces per face are changed, so 4 pieces are exchanged at a time
            temp = cube[1][0][piece];
            cube[1][0][piece] = cube[2][0][piece];
            cube[2][0][piece] = cube[3][0][piece];
            cube[3][0][piece] = cube[4][0][piece];
            cube[4][0][piece] = temp;
        }
    }
    
    public void rotateFace(int face, int times){
    //Rotate the face a set number of times by using the provided helper methods for setup and execute rotateTop()
    //Remember to undo the setup
    for (int i = 0;i < times;i++){
        if (face == 0)
            rotateTop();
        else if (face == 1) { //Left
            Helper.spinCubeRight(cube);
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
            Helper.spinCubeLeft(cube);
        } else if (face == 2) { // Front
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
        } else if (face == 3) { // Right
            Helper.spinCubeLeft(cube);
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
            Helper.spinCubeRight(cube);
        } else if (face == 4) { // Back
            Helper.spinCubeRight(cube);
            Helper.spinCubeRight(cube);
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
            Helper.spinCubeRight(cube);
            Helper.spinCubeRight(cube);
        } else if (face == 5) { // Down
            Helper.tiltCubeForward(cube);
            Helper.tiltCubeForward(cube);
            rotateTop();
            Helper.tiltCubeBackward(cube);
            Helper.tiltCubeBackward(cube);
            }
        }
    }
    
    public void scramble(int moves){
    //Generate and execute a random scramble seperated by spaces on the cube and print it out using displayCube()
    //U is up(0), L is left(1), F is front(2), R is right(3), B is back(4), D is down(5)
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
            rotateFace(face, type+1);
            scrambleString += notation[face] + suffixes[type] + " ";
        }
        
        System.out.println(scrambleString);
        displayCube();
    }
    
    public void execute(String input){
    //Let user input list of strings to solve cube
        String[] moves = input.split(" ");
        ArrayList<Integer> facesToRotate = new ArrayList<>();
        ArrayList<Integer> timesToRotate = new ArrayList<>();
        //Validation Pass
        for (String move : moves){
            int face = -1;
            if (move.substring(0,1).equals("U"))
                face = 0;
            else if (move.substring(0,1).equals("L"))
                face = 1;
            else if (move.substring(0,1).equals("F"))
                face = 2;
            else if (move.substring(0,1).equals("R"))
                face = 3;
            else if (move.substring(0,1).equals("B"))
                face = 4;
            else if (move.substring(0,1).equals("D"))
                face = 5;
            else {
                System.out.println("Invalid Input");
                return;
            }
            
            int times = 1;
            if (move.length() == 2) {
                String suffix = move.substring(1);
                if (suffix.equals("'"))
                    times = 3;
                else if (suffix.equals("2"))
                    times = 2;
                else {
                    System.out.println("Invalid Input");
                    return;
                }
            } else if (move.length() != 1) {
                System.out.println("Invalid Input");
                return;
            }
            facesToRotate.add(face);
            timesToRotate.add(times);
        }
        //Execution Pass
        for (int i = 0; i < facesToRotate.size(); i++) 
            rotateFace(facesToRotate.get(i), timesToRotate.get(i));            
        displayCube();
    }
}