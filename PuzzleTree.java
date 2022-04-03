import PuzzleMatrix;
import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleTree {
    public ArrayList<PuzzleMatrix> puzzleTree;
    public HashMap<PuzzleMatrix,PuzzleMatrix> prevRoot;
    public ArrayList<PuzzleMatrix> solutionList;
    public static int simplices;

    public PuzzleTree(){
        puzzleTree = new ArrayList<PuzzleMatrix>();
        prevRoot = new HashMap<PuzzleMatrix,PuzzleMatrix>();
        solutionList = new ArrayList<PuzzleMatrix>();
        simplices = 0;
    }

    public PuzzleMatrix leastCost(){
        PuzzleMatrix out = puzzleTree.get(0);
        int min = out.getCost();
        for(PuzzleMatrix mat : puzzleTree){
            if(mat.getCost() < min){
                min = mat.getCost();
                out = mat;
            }
        }
        return out;
    }

    public void generateUp(PuzzleMatrix m){
        PuzzleMatrix up;
        int[] empty_idx = m.findEmptySlot();
        int newDepth = m.getDepth()+1;
        //generateUp
        up = new PuzzleMatrix(m);
        up.up(empty_idx);
        up.setDepth(newDepth);
        up.setCost();
        puzzleTree.add(up);
        prevRoot.put(up, m);
    }

    public void generateDown(PuzzleMatrix m){
        PuzzleMatrix down;
        int[] empty_idx = m.findEmptySlot();
        int newDepth = m.getDepth()+1;
        //generateUp
        down = new PuzzleMatrix(m);
        down.down(empty_idx);
        down.setDepth(newDepth);
        down.setCost();
        puzzleTree.add(down);
        prevRoot.put(down, m);
    }

    public void generateLeft(PuzzleMatrix m){
        PuzzleMatrix left;
        int[] empty_idx = m.findEmptySlot();
        int newDepth = m.getDepth()+1;
        //generateUp
        left = new PuzzleMatrix(m);
        left.left(empty_idx);
        left.setDepth(newDepth);
        left.setCost();
        puzzleTree.add(left);
        prevRoot.put(left, m);
    }

    public void generateRight(PuzzleMatrix m){
        PuzzleMatrix right;
        int[] empty_idx = m.findEmptySlot();
        int newDepth = m.getDepth()+1;
        //generateUp
        right = new PuzzleMatrix(m);
        right.right(empty_idx);
        right.setDepth(newDepth);
        right.setCost();
        puzzleTree.add(right);
        prevRoot.put(right, m);
    }

    public void generateChilds(PuzzleMatrix m){
        if(empty_idx[0] == 0){
            //generateUp
            generateUp(m);
            //Cant generateDown
            //generateLeft
            generateLeft(m);
            //generateRight
            generateRight(m);
        } else if(empty_idx[0] == 3){
            //Cant generateUp
            //generateDown
            generateDown(m);
            //generateLeft
            generateLeft(m);
            //generateRight
            generateRight(m);
        } else if(empty_idx[1] == 0){
            //generateUp
            generateUp(m);
            //generateDown
            generateDown(m);
            //generateLeft
            generateLeft(m);
            //Cant generateRight
        } else if(empty_idx[1] == 3){
            //generateUp
            generateUp(m);
            //generateDown
            generateDown(m);
            //Cant generateLeft
            //generateRight
            generateRight(m);
        } else{
            //generateUp
            generateUp(m);
            //generateDown
            generateDown(m);
            //generateLeft
            generateLeft(m);
            //generateRight
            generateRight(m);
        }
        puzzleTree.remove(m);
    }

    public void PuzzleSolving(){
        
    }
}
