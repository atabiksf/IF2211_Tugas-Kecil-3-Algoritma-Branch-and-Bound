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
        String relativePath = "..\\test\\";
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
}