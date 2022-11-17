public class MazeUtility {

    public static void main(String[] args) {

        char[][] maze = {
                { 'S', '.', '.', '*' },
                { '*', '.', '.', '*' },
                { '*', '.', 'E', 'E' }
        };
        displayMaze(maze);
        int count = countEnd(maze);
        System.out.println("number of E: " +  countEnd(maze));
    }

    public static void displayMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public static  int countEnd(char[][] maze) {
        int count = 0;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(maze[i][j] == 'E'){
                    count++;
                }

            }

        }
        return count;
    }

    public static boolean solvable(char[][] maze){
        //assert valid maze
        if(maze == null || maze.length == 0 || maze[0].length == 0) return false;
        boolean output = false;

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        for(int i = 0; i < maze.length; i++){
            for(int k = 0; k < maze[i].length; k++){
                if(maze[i][k] == 'S') {
                    output = nextStep(i, k, maze, visited);
                    break;
                }
            }
        }

        return output;
    }

    private static boolean nextStep(int x, int y, char[][] maze, boolean[][] visited){
        if(visited[x][y]) return false;
        if(maze[x][y] == '*') return false;
        if(maze[x][y] == 'E') return true;
        if(maze[x][y] == '.'){
            visited[x][y] = true;
            boolean state1 = false;
            boolean state2 = false;
            boolean state3 = false;
            boolean state4 = false;

            if(x - 1 >= 0) {
                state1 = nextStep(x-1, y, maze, visited);
                visited[x-1][y] = false;
            }

            if(y - 1 >= 0){
                state2 = nextStep(x, y-1, maze, visited);
                visited[x][y-1] = false;
            }

            if(x + 1 < maze[0].length) {
                state3 = nextStep(x+1, y, maze, visited);
                visited[x+1][y] = false;

            }

            if(y + 1 < maze.length){
                state4 = nextStep(x, y + 1, maze, visited);
                visited[x][y+1] = false;
            }

            return state1 || state2 || state3 || state4;
        }

        return false;
    }
}
