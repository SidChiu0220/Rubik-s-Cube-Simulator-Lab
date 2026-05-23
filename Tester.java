import java.util.*;

public class Tester {
    public static void main(String[] args){
        RubiksCubeSolution cube = new RubiksCubeSolution();

        System.out.println("Original Face:");
        cube.displayCube();
        
        Scanner console = new Scanner(System.in);
        
        while (true) {
            System.out.print("\nEnter 'display', 'reset', 'scramble(number)', moves seperated by spaces, or 'exit': ");
            String input = console.nextLine().trim();
            
            if (input.equals("exit")) {
                break;
            }            
            // Check if input is "display"
            if (input.equals("display"))
                cube.displayCube();
            // Check if input is "reset"
            else if (input.equals("reset")){
                cube = new RubiksCubeSolution();
                cube.displayCube();
            }
            // Check if input starts with "scramble"
            else if (input.length()>8 && input.substring(0, 8).equals("scramble")) {
                String num = input.substring(8);
                boolean isValid = true;
                // Manual character verification check
                for (int i = 0; i < num.length(); i++) {
                    char c = num.charAt(i);
                    if (c < '0' || c > '9')
                        isValid = false;
                }
                
                if (isValid && !num.isEmpty()) {
                    int moves = Integer.parseInt(num);
                    cube.scramble(moves);
                }
                else 
                    System.out.println("Invalid Input");
            } 
            // Treat anything else as normal move string execution
            else
                cube.execute(input);
        }
    }
}