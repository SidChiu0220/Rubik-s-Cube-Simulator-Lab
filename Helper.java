public class Helper {
    public static void rotateFaceClockwise(char[][] face) {
        char temp = face[0][0];
        face[0][0] = face[1][0];
        face[1][0] = face[1][1];
        face[1][1] = face[0][1];
        face[0][1] = temp;
    }

    public static void rotateFaceCounterClockwise(char[][] face) {
        char temp = face[0][0];
        face[0][0] = face[0][1];
        face[0][1] = face[1][1];
        face[1][1] = face[1][0];
        face[1][0] = temp;
    }

    public static void tiltCubeForward(char[][][] cube) {
        char[][] tempYellow = cube[0];
        cube[0] = cube[4];
        cube[4] = cube[5];
        cube[5] = cube[2];
        cube[2] = tempYellow;
        
        rotateFaceClockwise(cube[1]);
        rotateFaceCounterClockwise(cube[3]);
    }

    public static void spinCubeRight(char[][][] cube) {
        char[][] tempOrange = cube[1];
        cube[1] = cube[4];
        cube[4] = cube[3];
        cube[3] = cube[2];
        cube[2] = tempOrange;
        
        rotateFaceClockwise(cube[0]);
        rotateFaceCounterClockwise(cube[5]);
    }
}