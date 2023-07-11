package User_Interface;

import java.util.ArrayList;

public class DFS {
    public static boolean dfSearch(int maze[][], int x, int y, ArrayList<Integer> path){
        //marking visited cells as 3
        //0 -->path
        //1 --> block
        //2 -->visited
        //16 --> start point
        //22 --> end point
        //base case
        if(maze[x][y]==22){
            path.add(y);
            path.add(x);
            return true;
        }
        //creating direction array
        if(maze[x][y]==0||maze[x][y]==9){
            maze[x][y]=2;
            int dx=-1;
            int dy=0;
            if (dfSearch(maze, x+dx,y+dy,path)){
                path.add(y);
                path.add(x);
                return true;
            }
            dx=1;
            dy=0;
            if (dfSearch(maze, x+dx,y+dy,path)){
                path.add(y);
                path.add(x);
                return true;
            }
            dx=0;
            dy=-1;
            if (dfSearch(maze, x+dx,y+dy,path)){
                path.add(y);
                path.add(x);
                return true;
            }
            dx=0;
            dy=1;
            if (dfSearch(maze, x+dx,y+dy,path)){
                path.add(y);
                path.add(x);
                return true;
            }
        }
        return false;
    }
}
