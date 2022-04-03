import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleTree {
    public ArrayList<PuzzleMatrix> puzzleTree;
    public HashMap<PuzzleMatrix,PuzzleMatrix> prevRoot;
    public ArrayList<PuzzleMatrix> solutionList;
    public int simplices;

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
        if(empty_idx[0] != 3){
            up = new PuzzleMatrix(m);
            up.up(empty_idx);
            up.setDepth(newDepth);
            up.setCost();
            puzzleTree.add(up);
            prevRoot.put(up, m);
            simplices++;
        }
    }

    public void generateDown(PuzzleMatrix m){
        PuzzleMatrix down;
        int[] empty_idx = m.findEmptySlot();
        int newDepth = m.getDepth()+1;
        //generateUp
        if(empty_idx[0] != 0){
            down = new PuzzleMatrix(m);
            down.down(empty_idx);
            down.setDepth(newDepth);
            down.setCost();
            puzzleTree.add(down);
            prevRoot.put(down, m);
            simplices++;
        }
    }

    public void generateLeft(PuzzleMatrix m){
        PuzzleMatrix left;
        int[] empty_idx = m.findEmptySlot();
        int newDepth = m.getDepth()+1;
        //generateUp
        if(empty_idx[1] != 3){
            left = new PuzzleMatrix(m);
            left.left(empty_idx);
            left.setDepth(newDepth);
            left.setCost();
            puzzleTree.add(left);
            prevRoot.put(left, m);
            simplices++;
        }
    }

    public void generateRight(PuzzleMatrix m){
        PuzzleMatrix right;
        int[] empty_idx = m.findEmptySlot();
        int newDepth = m.getDepth()+1;
        //generateUp
        if(empty_idx[1] != 0){
            right = new PuzzleMatrix(m);
            right.right(empty_idx);
            right.setDepth(newDepth);
            right.setCost();
            puzzleTree.add(right);
            prevRoot.put(right, m);
            simplices++;
        }
    }

    public void generateChilds(PuzzleMatrix m){
        //generateUp
        generateUp(m);
        //generateDown
        generateDown(m);
        //generateLeft
        generateLeft(m);
        //generateRight
        generateRight(m);
        puzzleTree.remove(m);
    }

    public void PuzzleSolving(){
        PuzzleMatrix mat; 
        mat = leastCost();
        while(mat.getCost() - mat.getDepth() != 0){
            generateChilds(mat);
            mat = leastCost();
        }
        solutionList.add(mat);
        while(prevRoot.containsKey(mat)){
            mat = prevRoot.get(mat);
            solutionList.add(0,mat);
        }
    }

}
