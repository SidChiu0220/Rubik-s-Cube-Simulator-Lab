public class Tester {

    public static void main(String[] args){

        RubiksCube cube = new RubiksCube();

        System.out.println("Original Face:");
        cube.displayFace(0);

        cube.rotateFaceClockwise(0);

        System.out.println("\nAfter Rotation:");
        cube.displayFace(0);
    }
}