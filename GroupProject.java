//Kennedy Torrent & Benjamin Richards
//COP3330
//Shahram Jahani
//Simulates the game minesweeper


import java.util.*;
public class GroupProject {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = 0;
        MineSweeper game;
        
        while (size < 6) {
        System.out.printf("Enter the size of the board (e.g. size 5 = 5 x 5 board): ");
        size = scan.nextInt();
        if (size < 6)
        System.out.printf("Size has to be 6 or greater\n");
        }
        game = new MineSweeper(size);
		
        game.InitializeMinefield(game.getMineField());
        game.InitializeMaskMatrix(game.getMask());
        game.RandomizeMines(game.getMineField());
        game.PlaceClues(game.getMineField());


        if(game.DoGame(game.getMineField(), game.getMask()) == 1)
            System.out.print("You lose!!!\n");
        else   
            System.out.print("YOU WIN!!!!\n");


        game.PrintMinefield(game.getMineField(), game.getMask());
    }
}

class MineSweeper {
	
	private char minefield[][];
	private int mask[][];
	private int numMines;
	
	MineSweeper() {
		
		this.minefield = new char[8][8];
		this.mask = new int[8][8];
		this.numMines = 10;
		
	}
	
	MineSweeper(int size) {
		
		this.minefield = new char[size][size];
		this.mask = new int[size][size];
		this.numMines = (size * size / 32) * 5;		
	}
	
	char[][] getMineField() {
		
		return this.minefield;
		
	}
	
	int[][] getMask() {
		
		return this.mask;
		
	}
	int getNumMines() {
		
		return this.numMines;
		
	}

    public int DoGame(char minefield[][], int mask[][]) {
        Scanner scan = new Scanner(System.in);        
        while(1==1) {
            PrintMinefield(minefield, mask);

            System.out.print("Give us coordinates. ");
            int row, col;
            row = col = minefield.length + 1;

            while (row > minefield.length - 1 || col > minefield.length - 1 || row < 0 || col < 0) {
            row = scan.nextInt();
            col = scan.nextInt();
            if (row > minefield.length - 1 || col > minefield.length - 1 || row < 0 || col < 0)
            System.out.printf("Invalid coordinates entered\n");
            }

            int lose = UncoverCell(row, col, minefield, mask);

            if(lose!=0)
                return 1;




            int count = UncoveredCount(mask);
            if(count == (mask.length * mask.length) - getNumMines())
                break;

            System.out.print("count of uncovered = " + count);
        }
        return 0;
    }

    
    public int UncoveredCount(int mask[][]) {
         int count = 0;

        for(int i = 0; i < mask.length; i++) {
            for(int j = 0; j < mask.length; j++) {
                if(mask[i][j] == 1)
                    count++;
            }
        }


        return count;

    }

      public int UncoverCell(int row, int col, char minefield[][], int mask[][]) {
        
        if(minefield[row][col] == '*')
            return 1;

        mask[row][col] = 1;


        if(minefield[row][col] == '0') {

            //right neighbor
            if(col + 1 < mask.length && mask[row][col+1] == 0)
                UncoverCell(row, col + 1, minefield, mask);

            //left
            if(col - 1 >= 0 && mask[row][col-1] == 0)
                UncoverCell(row, col - 1, minefield, mask);

            //bottom left
            if(col - 1 >= 0 && row + 1 < mask.length && mask[row + 1][col - 1] == 0)
                UncoverCell(row + 1, col - 1, minefield, mask);

            //bottom right
            if(col - 1 >= 0 && row - 1 >= 0 && mask[row-1][col-1] == 0)
                UncoverCell(row - 1, col - 1, minefield, mask);

            //bottom
            if(row + 1 < mask.length && mask[row + 1][col] == 0)
                UncoverCell(row + 1, col, minefield, mask);            

            //top
            if(row - 1 >= 0 && mask[row - 1][col] == 0)
                UncoverCell(row - 1, col, minefield, mask);

            //top left
            if(col - 1 >= 0 && row + 1 < mask.length && mask[row + 1][col - 1] == 0)
                UncoverCell(row, col - 1, minefield, mask);

            //top right
            if(col - 1 >= 0 && row - 1 >= 0 && mask[row - 1][col - 1] == 0)
                UncoverCell(row, col - 1, minefield, mask);
        }

        return 0;
    }





    public void InitializeMaskMatrix(int mask[][]) {
      
        for(int i = 0; i < mask.length; i++) {
            for(int j = 0; j < mask.length; j++) {
                mask[i][j] = 0;
            }
        }
    }

    public void InitializeMinefield(char matrix[][]) {
       
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[i][j] = '#';
            }
        }
    }


    public void PrintMinefield(char matrix[][], int mask[][]) {
        System.out.print("\n\n");

        System.out.print(" \t");
        for(int i = 0; i < matrix.length; i++)
            System.out.printf("%2d", i);

        System.out.print("\n\n\n");

        for(int i = 0; i < matrix.length; i++) {
            System.out.print(i + "\t ");

            for(int j = 0; j < matrix.length; j++) {
                if(mask[i][j] == 1)
                    System.out.print(matrix[i][j] + " ");
                else
                    System.out.print((char) '^' + " ");
            }

            System.out.print("\n");
        }
    }



    public void RandomizeMines(char matrix[][]) {
        
        for(int i = 0; i < getNumMines(); i++)
        {        
            int row = (int)(Math.random() * matrix.length);
            int col = (int)(Math.random() * matrix.length);

            if(matrix[row][col] == '*')
            {
                i--;
                System.out.print("Duplicate occured!\n");
                continue;
            }

            matrix[row][col] = '*';
        }
    }


    public void PlaceClues(char matrix[][]) {
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                int numMines = 0;

                //top left neighbor
                if(i - 1 >= 0 && j - 1 >= 0 && matrix[i-1][j-1] == '*')
                    numMines++;
                if(i - 1 >= 0 && j >= 0 && matrix[i-1][j] == '*')
                    numMines++;
                if(i - 1 >= 0 && j + 1 < matrix.length && matrix[i-1][j+1] == '*')
                    numMines++;

                //the same row
                if(j - 1 >= 0 && matrix[i][j-1] == '*')
                    numMines++;
                if(j + 1 < matrix.length && matrix[i][j+1] == '*')
                    numMines++;

                //the bottom row
                if(i + 1 < matrix.length && j - 1 >= 0 && matrix[i+1][j-1] == '*')
                    numMines++;
                if(i + 1 < matrix.length && matrix[i+1][j] == '*')
                    numMines++;
                if(i + 1 < matrix.length && j + 1 < matrix.length && matrix[i+1][j+1] == '*')
                    numMines++;

                if(!(matrix[i][j] == '*'))
                {
                    matrix[i][j] = (char)(numMines + 48);
                }
            }
        }
    }
}



