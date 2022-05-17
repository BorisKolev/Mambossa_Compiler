package compiler.ast;

import antlr4.gen.AnacondaLexer;
import antlr4.gen.AnacondaParser;
import compiler.expressions.Program;
import compiler.other.INode;
import compiler.utilities.ParseVisitor;
import compiler.utilities.PythonVisitor;
import compiler.utilities.SemanticAnalyser;
import compiler.utilities.Visualization;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

public class ASTService {
    public static INode compileToAST(String source) {
        Lexer lexer = new AnacondaLexer(CharStreams.fromString(source));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        AnacondaParser parser = new AnacondaParser(tokenStream);
        // Generate Abstract Syntax Trees
        Program tree = (Program)new ParseVisitor().visitCompileUnit(parser.compile());
        tree = new SemanticAnalyser().analyse(tree);
        //Re-order Abstract Syntax Trees based on dependencies of nodes
        ASTSorter sorter = new ASTSorter(tree);
        tree = (Program)sorter.visit(tree);
        return tree;
    }

    public static String compileToPython(INode tree) {
        String result = new PythonVisitor().visit(tree);
        return result;
    }

    public static String visualizeTree(INode tree) {
        String result = new Visualization().visit(tree);
        return result;
    }
}