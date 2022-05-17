package compiler.expressions;

import compiler.other.DataTypeEnum;
import compiler.other.INode;
import java.util.ArrayList;
import java.util.List;

public class Function extends INode {
    public DataTypeEnum dataType;
    public String name;    
    public List<INode> bodyNoteList;
    public List<FunctionParam> parametersList;

    public Function(DataTypeEnum dataType, String name, List<INode> body, List<FunctionParam> params) {
        super();
        this.dataType = dataType;
        this.name = name;
        ArrayList<INode> newBody = new ArrayList<>();
        for (INode node : body) {
            if (node instanceof FunctionReturnStatement) {
                newBody.add(new FunctionReturnStatement(((FunctionReturnStatement)node).expression, this));
            } else {
                newBody.add(node);
            }
        }
        bodyNoteList = newBody;
        parametersList = params;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s type: %s)", Function.class.getSimpleName(), name, dataType);
    }
}