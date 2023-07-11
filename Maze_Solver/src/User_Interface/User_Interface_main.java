package User_Interface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


import static User_Interface.DFS.dfSearch;

public class User_Interface_main extends JFrame{
    JLabel label;
    private static int maze[][]=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,9,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,0,0,1,1,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,22,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public ArrayList<Integer> path=new ArrayList<>();
    User_Interface_main() {

        setLayout(null);
        setTitle("MAZE SOLVER - Burning Bettle");
        setSize(600, 600);
        setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        label=new JLabel("Note: Red indicates Starting Point and Green indicates Ending Point");
        label.setBounds(100, 400,500,50);
        this.add(label);
        dfSearch(maze, 1, 1, path);
        //adjusting the location of frame to middle of the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(100, 100);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                Color color = Color.white;
                switch (maze[i][j]) {
                    case 0:
                        color = Color.white;break;
                    case 1:
                        color = Color.orange;break;
                    case 9:
                        color = Color.red;break;
                    case 22:
                        color = Color.green;break;
                }
                g.setColor(color);
                g.fillRect(j * 30, i * 30, 30, 30);
                g.setColor(Color.blue);
                g.drawRect(j * 30, i * 30, 30, 30);
            }
        }
        for (int k = 0; k < path.size(); k += 2) {
            int pathx=path.get(k);
            int pathy=path.get(k+1);
            if(pathx!=1 || pathy!=1) g.setColor(Color.yellow);
            if(pathx!=1 || pathy!=1) g.fillRect(pathx*30, pathy*30, 15, 15);
            if(pathx==1 && pathy==1) {
                g.setColor(Color.red);
                g.fillRect(pathx * 30, pathy * 30, 30, 30);
            }
        }
    }

    public static void main(String[] args) {
        var solver=new User_Interface_main();
    }
}
