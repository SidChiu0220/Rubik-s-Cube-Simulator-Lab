public class Helper {
    public static void tiltCubeForward(String[][][] cube) {
        String[][] orig0 = cube[0];
        String[][] orig2 = cube[2];
        String[][] orig4 = cube[4];
        String[][] orig5 = cube[5];

        cube[0] = orig2;
        cube[2] = orig5;
        
        String[][] new5 = new String[3][3];
        String[][] new4 = new String[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                new5[r][c] = orig4[2 - r][2 - c];
                new4[r][c] = orig0[2 - r][2 - c];
            }
        }
        cube[5] = new5;
        cube[4] = new4;

        rotateFaceCounterClockwise(cube[1]);
        rotateFaceClockwise(cube[3]);
    }

    public static void tiltCubeBackward(String[][][] cube) {
        String[][] orig0 = cube[0];
        String[][] orig2 = cube[2];
        String[][] orig4 = cube[4];
        String[][] orig5 = cube[5];

        cube[2] = orig0;
        cube[5] = orig2;
        
        String[][] new0 = new String[3][3];
        String[][] new4 = new String[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                new0[r][c] = orig4[2 - r][2 - c];
                new4[r][c] = orig5[2 - r][2 - c];
            }
        }
        cube[0] = new0;
        cube[4] = new4;

        rotateFaceClockwise(cube[1]);
        rotateFaceCounterClockwise(cube[3]);
    }

    public static void spinCubeRight(String[][][] cube) {
        String[][] temp = cube[1];
        cube[1] = cube[4];
        cube[4] = cube[3];
        cube[3] = cube[2];
        cube[2] = temp;
        rotateFaceClockwise(cube[5]);
        rotateFaceCounterClockwise(cube[0]);
    }

    public static void spinCubeLeft(String[][][] cube) {
        String[][] temp = cube[1];
        cube[1] = cube[2];
        cube[2] = cube[3];
        cube[3] = cube[4];
        cube[4] = temp;
        rotateFaceClockwise(cube[0]);
        rotateFaceCounterClockwise(cube[5]);
    }

    public static void rotateFaceClockwise(String[][] face) {
        String temp = face[0][0];
        face[0][0] = face[2][0]; face[2][0] = face[2][2]; face[2][2] = face[0][2]; face[0][2] = temp;
        temp = face[0][1];
        face[0][1] = face[1][0]; face[1][0] = face[2][1]; face[2][1] = face[1][2]; face[1][2] = temp;
    }

    public static void rotateFaceCounterClockwise(String[][] face) {
        String temp = face[0][0];
        face[0][0] = face[0][2]; face[0][2] = face[2][2]; face[2][2] = face[2][0]; face[2][0] = temp;
        temp = face[0][1];
        face[0][1] = face[1][2]; face[1][2] = face[2][1]; face[2][1] = face[1][0]; face[1][0] = temp;
    }
}