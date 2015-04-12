import java.util.*;
class WallGate {
    public static int[][] solution(int[][] maze){
        int m = maze.length;
        if(m<1) return new int[m][m];
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        for(boolean[] row : visited)
            Arrays.fill(row, false);
        int[][] sol = new int[m][n];
        for(int[] row : sol)
            Arrays.fill(row, 0);
        Queue<Queue<Position>> queue = new LinkedList<>();
        for(int i=0;i<m;++i)
            for(int j=0;j<n;++j)
                if(maze[i][j] == 1) {
                    Queue<Position> gate = new LinkedList<>();
                    gate.add(new Position(i,j));
                    queue.add(gate);
                    sol[i][j] = 0;
                    visited[i][j] = true;
                }
        while(!queue.isEmpty()){
            Queue<Position> bfs = queue.poll();
            Position p = bfs.poll();
            int i = p.x, j = p.y;
            // bfs : up
            if(isValid(maze, i, j-1, visited)){
                bfs.add(new Position(i, j-1));
                sol[i][j-1] = sol[i][j] + 1;
                visited[i][j-1]=true;
            }
            // similarly do: left down and right
            if(isValid(maze, i, j+1, visited)){
                bfs.add(new Position(i, j+1));
                sol[i][j+1] = sol[i][j] + 1;
                visited[i][j+1]=true;
            }
            if(isValid(maze, i-1, j, visited)){
                bfs.add(new Position(i-1, j));
                sol[i-1][j] = sol[i-1][j] + 1;
                visited[i-1][j]=true;           
            }
            if(isValid(maze, i+1, j, visited)){
                bfs.add(new Position(i+1, j));
                sol[i+1][j] = sol[i+1][j] + 1;
                visited[i+1][j]=true;
            }
            if(!bfs.isEmpty())
                queue.add(bfs);
        }
        return sol;
    }
    public static boolean isValid(int[][] maze, int i, int j, boolean[][] visited){
        int m = maze.length;
        if(m<1)
            return false;
        int n = maze[0].length;
        if(i<0 || i >= m || j < 0 || j >= n || visited[i][j] || maze[i][j]==-1)
            return false;
        return true;
    }
    public static class Position{
        public int x;
        public int y;
        public Position(int x, int y){
            this.x = x; this.y = y;
        }
    }
    public static void printMaze(int[][] maze){
        System.out.println(Arrays.deepToString(maze));
    }
    public static void main(String[] args){
        // For simplicity, assuming W(-1), O(0), G(1). 
        Random rdm = new Random();
        int size = 5;
        int[][] test = new int[size][size];
        // Generate Random Gates and initilize rest cells on maze
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                test[i][j]=rdm.nextInt(2);
        // Generate Random Walls       
        int num_walls = 2;
        for(int i=0;i<num_walls;++i){
            int x = rdm.nextInt(size);
            int y = rdm.nextInt(size);
            test[x][y] = -1;
        }
        printMaze(test);
        printMaze(solution(test));
    }
}
