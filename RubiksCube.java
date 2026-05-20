public class RubiksCube{
    private char [][][] cube = new char[6][2][2];
    static private char[] faceColors = {'Y', 'R', 'G', 'O', 'B', 'W'};
    
    public RubiksCube(){
    //Initiate and assign right colors of all 6 faces
    }
    
    public void displayFace(int face){
    //Display the assigned face and assinged padding
    }
    
    public void displayAll(){
    //Display all 6 faces in the correct format using at least two calls of displayFace() method
    }
    
    public void rotateTop(boolean clockwise){
    //Rotate the top face:
    //The stickers the top later is shifted
    //the top rows of the 4 faces that share a side with it will shift
    }
    
    public void rotateFace(int face, boolean clockwise) {
    }
    
    public void scramble(int moves){
    }
}
