//Assume '_' is 0, 'G' is 1, 'W' is 2
private class Position{
    int x;
    int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public void findLen(int[][] matrix){
    int m = matrix.length;
        if(m<1) return; 
    int n = matrix[0].length;
    int[][] result = new int[m][n];
    boolean[][] visited = new boolean[m][n];
    Queue<Position> queue = new LinkedList<Position>();
    int curLevel_nums = 0;
    int nextLevel_nums = 0;
    int level = 1;. more info on 1point3acres.com
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(matrix[i][j] == 1){//enqueue gate
                    visited[i][j] = true;. 
                        queue.add(new Position(i, j));
                        curLevel_nums++;
                }
            }
        }
    while(!queue.isEmpty()){
        Position cur = queue.poll();
            curLevel_nums--;
        int[] arr = {1,-1,1,-1};
        for(int i=0; i<arr.length; ++i){
            Position newP;
            if(i<2){
                newP = new Position(cur.x+arr[i], cur.y);
            }
            else{
                newP = new Position(cur.x, cur.y+arr[i]);
            }
            if(newP.x<0 || newP.x>=m || newP.y<0 || newP.y>=n || visited[newP.x][newP.y]){ 
                continue;
            }. more info on 1point3acres.com
            else{
                if(matrix[newP.x][newP.y]==2){
                    visited[newP.x][newP.y] = true;
                    result[newP.x][newP.y] = -1;
                }
                else{//matrix[newP.x][newP.y]==0
                    visited[newP.x][newP.y] = true;
                    result[newP.x][newP.y] = level;
                    queue.add(newP);
                    nextLevel_nums++;
                }
            }
        }
        if(curLevel_nums==0){
            curLevel_nums = nextLevel_nums;
            nextLevel_nums = 0;
                level++;
        }
    }
    for(int i=0; i<m; ++i){
        for(int j=0; j<n; ++j){
            System.out.print(result[i][j]+ "  ");
        }
        System.out.println();
    }
}
