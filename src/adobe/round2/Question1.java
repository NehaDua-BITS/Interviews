package adobe.round2;

import java.util.ArrayList;
import java.util.List;

public class Question1 {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        Question1 obj = new Question1();
        int count = 0;
        List<Cell> infectedCells = obj.infectNeighbours(grid);
        if (infectedCells.size() > 0) {
            count++;
            count += obj.infectAllNewOnes(infectedCells, grid);
        }

        System.out.println("Number of days = " + count);
    }

    private List<Cell> infectNeighbours(int[][] grid) {
        List<Cell> infectedCells = new ArrayList<>();

        int[] neighRows = {0, 0, 1, -1};
        int[] neighCols = {1, -1, 0, 0};
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {  //infected
                    for (int k = 0; k < 4; k++) {
                        int neighX = i + neighRows[k];
                        int neighY = j + neighCols[k];
                        if (isValid(neighX,neighY, grid)) {
                            infectedCells.add(new Cell(neighX, neighY));
                            grid[neighX][neighY] = -1; //to avoid adding again in list
                        }
                    }
                }
            }
        }

        return infectedCells;
    }

    private int infectAllNewOnes(List<Cell> cellList, int[][] grid) {
        int count = 0;
        int[] neighRows = {0, 0, 1, -1};
        int[] neighCols = {1, -1, 0, 0};

        if (cellList == null) {
            return 0;
        }

        int start = 0;
        while (start != cellList.size()) {
            int size = cellList.size(); //new infected ones from prev iteration
            for (int i = start; i < size; i++) {
                Cell cell = cellList.get(i);
                //infect neighbours
                for (int k = 0 ; k < 4; k++) {
                    int neighX = cell.row  + neighRows[k];
                    int neighY = cell.col + neighCols[k];
                    if (isValid(neighX,neighY,grid)) {
                        cellList.add(new Cell(neighX, neighY));
                        grid[neighX][neighY] = -1; //to avoid adding again in list
                    }
                }
            }
            start = size;

            if (cellList.size() > size) { //if anyone was infected or not
                count++;
            }
        }
        return count;
    }


    private boolean isValid(int neighX, int neighY, int[][] grid) {
        return (neighX >= 0 && neighX < grid.length) &&
                (neighY >= 0 && neighY < grid[0].length) &&
                grid[neighX][neighY] != 0 &&
                grid[neighX][neighY] != -1;
    }

    class Cell {
        int row;
        int col;

        Cell (int x, int y) {
            this.row = x;
            this.col = y;
        }
    }
}
