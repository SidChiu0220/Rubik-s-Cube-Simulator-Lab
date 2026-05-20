public class Tester {

    public static void main(String[] args){

        RubiksCubeSolution cube = new RubiksCubeSolution();

        System.out.println("Original Face:");
        
        
        cube.displayCube();
        cube.scramble(1);
    }
}