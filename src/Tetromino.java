import java.awt.*;
import java.util.*;

public class Tetromino {
    private int[][] shape;
    private Color color;
    private int Sx, Sy; //spawn location

    public Tetromino(int[][] shape, Color color) {
        this.shape = shape;
        this.color = color;
        //spawn
        this.Sx = 4;  
        this.Sy = 0;
    }
    public int[][] getShape() { return this.shape; }
    public Color getColor() { return this.color; }
    public int getX() {return this.Sx; }
    public int getY() { return this.Sy; }

    //rotate tetromino
    public void setShape(int[][] newShape) {
        this.shape = newShape;
    }
    public int[][] rotateShape() {
        int column = shape.length;
        int row = shape[0].length;
        int[][] rotate = new int[row][column];

        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                rotate[j][column - 1 - i] = shape[i][j];
            }
        }
        return rotate;
    }

    //move the tetro
    public void move(int x, int y) {
        this.Sx += x;
        this.Sy += y;
    }
    //random shape
    public static Tetromino randomShape() {
        int[][][] allShape = {
            {{1,1},{1,1}},
            {{1,1,1,1}},
            {{0,1,0},{1,1,1}},
            {{1,1,0},{0,1,1}},
            {{0,1,1},{1,1,0}},
            {{1,0,0},{1,1,1}},
            {{0,0,1},{1,1,1}}
        };
        Color[] allColor = {
            Color.CYAN,
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.BLUE,
            Color.PINK,
            Color.GREEN
        };
        Random random = new Random();
        int roller = random.nextInt(7);
        return new Tetromino(allShape[roller], allColor[roller]);
    }
}