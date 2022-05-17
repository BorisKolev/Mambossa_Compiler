import compiler.ast.ASTService;
import compiler.other.INode;
import compiler.utilities.FileHelper;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            FileHelper.clearTargetFiles();
            for (File file : FileHelper.getSourceFiles()) {
                System.out.println("\033[0;32mOpening " + file.getName());
                String contents = FileHelper.readFile(file.toPath());
                System.out.println("\033[0;93m Building Abstract Syntax Tree");
                INode tree = null;
                try {
                    tree = ASTService.compileToAST(contents);
                    System.out.println("\033[1;34m  Starting Visualization");
                    try {
                        String result = ASTService.visualizeTree(tree);
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("\033[1;91m  Error:" + e.getMessage());
                    } finally {
                        System.out.println("\033[1;34m  Ending Visualization");
                    }
                } catch (Exception e) {
                    System.out.println("\033[1;91m Error:" + e.getMessage());
                } finally {
                    System.out.println("\033[0;93m Finished Abstract Syntax Tree");
                }
                if (tree == null) {
                    System.out.println("\033[1;91mFailed:" + file.getName());
                    continue;
                }
                FileHelper.generatePythonFile(tree, file.getName());
                System.out.println("\033[0;32mClosing " + file.getName() + "\n");
            }
        } catch(Exception e) {
            System.out.println("\033[1;91mError:" + e.getMessage());
        }
    }
}
