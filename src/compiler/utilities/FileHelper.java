package compiler.utilities;

import compiler.ast.ASTService;
import compiler.other.INode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHelper {
    public static void generatePythonFile(INode tree, String fileName) {
        System.out.println("\033[1;35m Compiling file to python");
        String result;
        try {
            result = ASTService.compileToPython(tree);
            writeFile(fileName, result);
        } catch(Exception e) {
            System.out.println("\033[1;31mError:" + e.getMessage());
        } finally {
            System.out.println("\033[1;35m Python file compiled");
        }
    }

    private static void writeFile(String fileName, String contents) throws IOException {
        String filePath = String.format("src/python/%s%s.%s",
                fileName.replaceFirst("[.][^.]+$", ""), "", "py");
        File temp = new File(filePath);
        temp.createNewFile();
        FileWriter fw = new FileWriter(temp, false);
        fw.write(contents);
        fw.close();
    }

    public static File[] getSourceFiles() {
        File folder = new File("src/anaconda");
        return folder.listFiles();
    }

    public static void clearTargetFiles() {
        File folder = new File("src/python");
        File[] files = folder.listFiles();
        assert files != null;
        for (File file : files) {
            file.delete();
        }
    }

    public static String readFile(Path path) throws IOException {
        byte[] encoded = Files.readAllBytes(path);
        return new String(encoded, StandardCharsets.UTF_8);
    }
}