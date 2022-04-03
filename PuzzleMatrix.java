import java.io.File;
import java.util.Scanner;

public class PuzzleMatrix {
    private int[][] matrices;
    private static int rowSize = 4;
    private static int colSize = 4;

    public PuzzleMatrix(){
        matrices = new int[rowSize][colSize];
    }

    public void readFile(){
        int i,j,elmt;
        Scanner scan = new Scanner(System.in);
        String relativePath = ".\\test\\";
        String pathInput;
        System.out.print("Masukkan nama file : ");
        pathInput = scan.nextLine();
        scan.close();

        File testFile = new File(relativePath + pathInput);
        try{
            Scanner fileScanner = new Scanner(testFile);
            for(i = 0; i < rowSize; i++){
                for(j = 0; j < colSize; j++){
                    elmt = fileScanner.nextInt();
                    matrices[i][j] = elmt;
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }     
    }

    public void printMatrix(){
        for(i = 0; i < rowSize; i++){
            for(j = 0; j < colSize; j++){
                elmt = matrices[i][j];
                if(j == colSize - 1){
                    System.out.println(elmt + " ");
                } else{
                    System.out.print(elmt);
                }
            }
        }
    }

    public int kurangI(int i){ //hanya dapat menerima parameter 1-16
        int p, q, row, col, value;
        value = 0;
        row = 0;
        col = 0;

        for(p = 0; p < rowSize; p++){
            for(q = 0; q < colSize; q++){
                if(matrices[p][q] == i){
                    row = p;
                    col = q;
                    break;
                }
            }
        }
        for(p = row; p < rowSize; p++){
            for(q = col; q < colSize; q++){
                if(matrices[p][q] < i){
                    value++;
                }
            }
        }
        return value;
    }

    public int[] findEmptySlot(){
        int[] idx = new int[2];
        boolean found = false;

        int i = 0;
        while(i < 4 && !found){
            int j = 0;
            while(j < 4 && !found){
                if(matrices[i][j] == 16){
                    idx[0] = i;
                    idx[1] = j;
                    found = true;
                } else{
                    j++;
                }
            }
            i++;
        }

        return idx;
    }

    public boolean canSolved(){
        int i, sumKurangI;
        int[] empty_idx = findEmptySlot();
        
        sumKurangI = 0;
        for(i = 1; i <= 16; i++){
            int val = kurangI(i);
            System.out.println("KURANG[" + i + "] = " + val);
            sumKurangI += val;
        }
        if(empty_idx[0]+empty_idx[1] % 2 == 0){
            sumKurangI += 1;
        }
        System.out.println();
        System.out.println("Total + X = " + sumKurangI);
        System.out.println();
        if(sumKurangI % 2 != 0){
            System.out.println("Puzzle tidak dapat diselesaikan!");
            return false;
        }
        return true;
    }


}