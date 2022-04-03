public class Main {
    public static void main(String[] args) {
        PuzzleMatrix init = new PuzzleMatrix();
        init.readFile();
        if(init.readFile){
            init.printMatrix();
            if(init.canSolved()){
                long startTime = System.currentTimeMillis();
                PuzzleTree tree = new PuzzleTree();
                tree.puzzleTree.add(init);
                tree.generateChilds(init);
                tree.PuzzleSolving();
                long endTime = System.currentTimeMillis();
                for(PuzzleMatrix matrix : tree.solutionList){
                    System.out.println("Proses: ");
                    matrix.printMatrix();
                }
                System.out.println("Simpul yang dibangkitkan : " + tree.simplices);
                long totalTime = endTime - startTime;
                System.out.println("Total time : " + totalTime + " ms");
            }
        }
    }
}
