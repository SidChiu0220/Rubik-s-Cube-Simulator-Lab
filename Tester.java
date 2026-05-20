public class Tester {

    public static void main(String[] args){

        RubiksCubeSolution cube = new RubiksCubeSolution();

        System.out.println("Original Face:");
        cube.displayCube();

        cube.rotateTop(true);
        System.out.println("\nAfter Rotation:");
        cube.displayCube();
    }
}