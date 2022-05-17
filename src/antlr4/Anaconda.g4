grammar Anaconda;

compile
    : statements
    ;

statements
    : (statement EndOfLine)*
    ;

statement
    : function
    | functionReturn
	| declaration
	| assignment
	| ifElseStatement
	| whileStatement
	| expression
    ;

function
    : type=Int name=Var LeftPara params=functionParam* RightPara LeftBracket body=statements RightBracket
    | type=Float name=Var LeftPara params=functionParam* RightPara LeftBracket body=statements RightBracket
    | type=Bool name=Var LeftPara params=functionParam* RightPara LeftBracket body=statements RightBracket
    | type=Void name=Var LeftPara params=functionParam* RightPara LeftBracket body=statements RightBracket
    ;

functionReturn
    : Return expr=expression
    ;

functionParam
    : param=declaration
    | Comma param=declaration
    ;

declaration
    : type=Float name=Var
	| type=Int name=Var
	| type=Bool name=Var
    ;

assignment
    : variable=Var op=(Assign|AssignMinus|AssignPlus|AsssignMultiply|AsssignDivide|AsssignPower|AsssignModulo) right=expression
    ;

ifElseStatement
    : ifStat = ifStatement elseIfStat = elseIfStatement*  elseStat = elseStatement?
    ;

ifStatement
    : If LeftPara expr=expression RightPara LeftBracket body=statements RightBracket
    ;

elseIfStatement
    : Else If LeftPara expr=expression RightPara LeftBracket body=statements RightBracket
    ;

elseStatement
    : Else LeftBracket body=statements RightBracket
    ;

whileStatement
    : While LeftPara expr=expression RightPara LeftBracket body=statements RightBracket
    ;

expression
    :   LeftPara expression RightPara                                                                                               # parensExpr
    |   op=(Add|Subtract) expression                                                                                                # unaryExpr
	|	left=expression op=Power right=expression                                                                                   # infixExpr
    |   left=expression op=(Divide|Multiply|Modulo) right=expression                                                                # infixExpr
	|   left=expression op=(Subtract|Add) right=expression                                                                          # infixExpr
	|   value=(Number|Var)                                                                                                          # valueExpr
	|   Not expression																							                    # notExpr
	|   left=expression op=(Equals|NegativeEquals|LessThan|GreaterThan|LessThanEquals|GreaterThanEquals|And|Or) right=expression	# booleanExpr
	|   name=Var LeftPara params=functionCallParam* RightPara                                                                       # functionCallExpr
    ;

functionCallParam
    : (expression | Comma expression)
    ;

Int                     : 'int';
Float                   : 'float';
Bool                    : 'bool';
Void                    : 'void';
Add                     : '+' ;
Subtract                : '-' ;
Multiply                : '*' ;
Divide                  : '/' ;
Power                   : '^' ;
Modulo                  : '%' ;
Or                      : '||';
And                     : '&&';
Assign                  : '=' ;
AssignPlus              : '+=' ;
AssignMinus             : '-=' ;
AsssignMultiply         : '*=' ;
AsssignDivide           : '/=' ;
AsssignPower            : '^=' ;
AsssignModulo           : '%=' ;
Not                     : '!';
GreaterThan             : '>';
LessThan                : '<';
Equals                  : '==';
NegativeEquals          : '!=';
GreaterThanEquals       : '>=';
LessThanEquals          : '<=';
If                      : 'if';
Else                    : 'else';
While                   : 'while';
Return                  : 'return';
LeftPara                : '(';
RightPara               : ')';
LeftBracket             : '{';
RightBracket            : '}';
Comma                   : ',';
Var                     : ('a'..'z'|'A'..'Z'|'_')+ ;
Number                  : [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;
EndOfLine               : ';';
Space                   : [ \t\r\n] -> channel(HIDDEN);
