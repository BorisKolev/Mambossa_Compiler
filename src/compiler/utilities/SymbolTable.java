package compiler.utilities;

import compiler.expressions.Function;
import compiler.expressions.FunctionParam;
import compiler.other.Scope;
import compiler.other.DataTypeEnum;
import compiler.other.ScopeTypeEnum;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

public class SymbolTable {
    public SymbolTable parent;
    public Scope scope;
    private final Hashtable<String, Symbol> hashTable = new Hashtable<>();

    public SymbolTable(ScopeTypeEnum type) {
        this.scope = new Scope(UUID.randomUUID(), type);
        this.parent = null;
        if (type == ScopeTypeEnum.Program) {
            ArrayList<FunctionParam> intPrintParams = new ArrayList<>();
            intPrintParams.add(new FunctionParam("a", DataTypeEnum.Integer));
            Function intPrint = new Function(DataTypeEnum.Integer, "print",
                    new ArrayList<>(), intPrintParams);
            ArrayList<FunctionParam> floatPrintParams = new ArrayList<>();
            floatPrintParams.add(new FunctionParam("a", DataTypeEnum.Float));
            Function floatPrint = new Function(DataTypeEnum.Float, "print",
                    new ArrayList<>(), floatPrintParams);
            ArrayList<FunctionParam> boolPrintParams = new ArrayList<>();
            boolPrintParams.add(new FunctionParam("a", DataTypeEnum.Bool));
            Function boolPrint = new Function(DataTypeEnum.Bool, "print",
                    new ArrayList<>(), boolPrintParams);
            this.add(new Symbol(new FunctionNameDefinition(intPrint).toString(),
                    DataTypeEnum.Integer, intPrint.parametersList));
            this.add(new Symbol(new FunctionNameDefinition(floatPrint).toString(),
                    DataTypeEnum.Float, floatPrint.parametersList));
            this.add(new Symbol(new FunctionNameDefinition(boolPrint).toString(),
                    DataTypeEnum.Bool, boolPrint.parametersList));
        }
    }

    public SymbolTable(SymbolTable parent, ScopeTypeEnum type) {
        this.scope = new Scope(UUID.randomUUID(), type);
        this.parent = parent;
    }

    public void add(Symbol symbol) {
        symbol.scope = this.scope;
        hashTable.put(symbol.name, symbol);
    }

    public boolean containsDeclaration(String name) {
        if (hashTable.containsKey(name)) {
            return true;
        }
        if (this.scope.type() != ScopeTypeEnum.Function && this.parent != null) {
            return this.parent.containsDeclaration(name);
        }
        return false;
    }

    public boolean contains(String name) {
        if (hashTable.containsKey(name)) {
            return true;
        }
        if (this.parent != null) {
            return this.parent.contains(name);
        }
        return false;
    }

    public Symbol get(String name) {
        if (hashTable.containsKey(name)) {
            return hashTable.get(name);
        }
        if (this.parent != null && this.parent.contains(name)) {
            return this.parent.get(name);
        }
        return null;
    }
}