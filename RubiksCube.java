import java.util.ArrayList;

public class RubiksCube{
    private char [][][] cube = new char[6][3][3];
    static private char[] faceColors = {'Y', 'R', 'G', 'O', 'B', 'W'};
    
    public RubiksCube(){
    //Initiate and assign right colors of all 6 faces
    }
    
    public void displayFace(int face, String padding){
    //Display the assigned face and assinged padding
    }

    public void displayCube(){
    //Display all 6 faces in the correct format using at least two calls of displayFace() method
    }
    
    
    public void rotateTop() {
    //Rotate the top face:
    //The stickers the top later is shifted
    //the top rows of the 4 faces that share a side with it will shift
    }
    
    public void rotateFace(int face){
    ////Rotate the face a set number of times by using the provided helper methods for setup and execute rotateTop()
    //Remember to undo the setup
    }
    
    public void scramble(int moves){
    //Generate and execute a random scramble seperated by spaces on the cube and print it out using displayCube()
    //U is upper/white(0), L is left/red(1), F is front/green(2), R is right/orange(3), B is back/blue(4), D is down/white(5)
    //' is counterclockwise, 2 means rotate twice CW or CCW
    //Example: scramble(3) "U2 L L'"
    }
    
    public void execute(String input){
    //Let user input list of strings to solve cube
    }
}