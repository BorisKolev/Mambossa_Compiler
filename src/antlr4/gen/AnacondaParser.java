package antlr4.gen;// Generated from C:/Users/a3rog/BorisTest/src/Antlr4\Anaconda.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AnacondaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Add=1, Subtract=2, Multiply=3, Divide=4, Power=5, Modulo=6, Assign=7, 
		AssignPlus=8, AssignMinus=9, AsssignMultiply=10, AsssignDivide=11, AsssignPower=12, 
		AsssignModulo=13, Not=14, GreaterThan=15, LessThan=16, Equals=17, NegativeEquals=18, 
		GreaterThanEquals=19, LessThanEquals=20, Or=21, And=22, Int=23, Float=24, 
		Bool=25, Void=26, If=27, Else=28, While=29, Return=30, LeftPara=31, RightPara=32, 
		LeftBracket=33, RightBracket=34, Comma=35, Variable=36, Number=37, EndOfLine=38, 
		Space=39;
	public static final int
		RULE_compile = 0, RULE_statements = 1, RULE_statement = 2, RULE_function = 3, 
		RULE_functionReturn = 4, RULE_functionParam = 5, RULE_declaration = 6, 
		RULE_assignment = 7, RULE_ifElseStatement = 8, RULE_ifStatement = 9, RULE_elseIfStatement = 10, 
		RULE_elseStatement = 11, RULE_whileStatement = 12, RULE_expression = 13, 
		RULE_functionCallParam = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"compile", "statements", "statement", "function", "functionReturn", "functionParam", 
			"declaration", "assignment", "ifElseStatement", "ifStatement", "elseIfStatement", 
			"elseStatement", "whileStatement", "expression", "functionCallParam"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'^'", "'%'", "'='", "'+='", "'-='", 
			"'*='", "'/='", "'^='", "'%='", "'!'", "'>'", "'<'", "'=='", "'!='", 
			"'>='", "'<='", "'||'", "'&&'", "'int'", "'float'", "'bool'", "'void'", 
			"'if'", "'else'", "'while'", "'return'", "'('", "')'", "'{'", "'}'", 
			"','", null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Add", "Subtract", "Multiply", "Divide", "Power", "Modulo", "Assign", 
			"AssignPlus", "AssignMinus", "AsssignMultiply", "AsssignDivide", "AsssignPower", 
			"AsssignModulo", "Not", "GreaterThan", "LessThan", "Equals", "NegativeEquals", 
			"GreaterThanEquals", "LessThanEquals", "Or", "And", "Int", "Float", "Bool", 
			"Void", "If", "Else", "While", "Return", "LeftPara", "RightPara", "LeftBracket", 
			"RightBracket", "Comma", "Variable", "Number", "EndOfLine", "Space"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Anaconda.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnacondaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompileContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public CompileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterCompile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitCompile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitCompile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileContext compile() throws RecognitionException {
		CompileContext _localctx = new CompileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			statements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> EndOfLine() { return getTokens(AnacondaParser.EndOfLine); }
		public TerminalNode EndOfLine(int i) {
			return getToken(AnacondaParser.EndOfLine, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Subtract) | (1L << Not) | (1L << Int) | (1L << Float) | (1L << Bool) | (1L << Void) | (1L << If) | (1L << While) | (1L << Return) | (1L << LeftPara) | (1L << Variable) | (1L << Number))) != 0)) {
				{
				{
				setState(32);
				statement();
				setState(33);
				match(EndOfLine);
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionReturnContext functionReturn() {
			return getRuleContext(FunctionReturnContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfElseStatementContext ifElseStatement() {
			return getRuleContext(IfElseStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				function();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				functionReturn();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				ifElseStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				whileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(46);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public FunctionParamContext params;
		public StatementsContext body;
		public TerminalNode LeftPara() { return getToken(AnacondaParser.LeftPara, 0); }
		public TerminalNode RightPara() { return getToken(AnacondaParser.RightPara, 0); }
		public TerminalNode LeftBracket() { return getToken(AnacondaParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(AnacondaParser.RightBracket, 0); }
		public TerminalNode Int() { return getToken(AnacondaParser.Int, 0); }
		public TerminalNode Variable() { return getToken(AnacondaParser.Variable, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<FunctionParamContext> functionParam() {
			return getRuleContexts(FunctionParamContext.class);
		}
		public FunctionParamContext functionParam(int i) {
			return getRuleContext(FunctionParamContext.class,i);
		}
		public TerminalNode Float() { return getToken(AnacondaParser.Float, 0); }
		public TerminalNode Bool() { return getToken(AnacondaParser.Bool, 0); }
		public TerminalNode Void() { return getToken(AnacondaParser.Void, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		int _la;
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				((FunctionContext)_localctx).type = match(Int);
				setState(50);
				((FunctionContext)_localctx).name = match(Variable);
				setState(51);
				match(LeftPara);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Float) | (1L << Bool) | (1L << Comma))) != 0)) {
					{
					{
					setState(52);
					((FunctionContext)_localctx).params = functionParam();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				match(RightPara);
				setState(59);
				match(LeftBracket);
				setState(60);
				((FunctionContext)_localctx).body = statements();
				setState(61);
				match(RightBracket);
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				((FunctionContext)_localctx).type = match(Float);
				setState(64);
				((FunctionContext)_localctx).name = match(Variable);
				setState(65);
				match(LeftPara);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Float) | (1L << Bool) | (1L << Comma))) != 0)) {
					{
					{
					setState(66);
					((FunctionContext)_localctx).params = functionParam();
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				match(RightPara);
				setState(73);
				match(LeftBracket);
				setState(74);
				((FunctionContext)_localctx).body = statements();
				setState(75);
				match(RightBracket);
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				((FunctionContext)_localctx).type = match(Bool);
				setState(78);
				((FunctionContext)_localctx).name = match(Variable);
				setState(79);
				match(LeftPara);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Float) | (1L << Bool) | (1L << Comma))) != 0)) {
					{
					{
					setState(80);
					((FunctionContext)_localctx).params = functionParam();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(RightPara);
				setState(87);
				match(LeftBracket);
				setState(88);
				((FunctionContext)_localctx).body = statements();
				setState(89);
				match(RightBracket);
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				((FunctionContext)_localctx).type = match(Void);
				setState(92);
				((FunctionContext)_localctx).name = match(Variable);
				setState(93);
				match(LeftPara);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Float) | (1L << Bool) | (1L << Comma))) != 0)) {
					{
					{
					setState(94);
					((FunctionContext)_localctx).params = functionParam();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100);
				match(RightPara);
				setState(101);
				match(LeftBracket);
				setState(102);
				((FunctionContext)_localctx).body = statements();
				setState(103);
				match(RightBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionReturnContext extends ParserRuleContext {
		public ExpressionContext expr;
		public TerminalNode Return() { return getToken(AnacondaParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterFunctionReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitFunctionReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitFunctionReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionReturnContext functionReturn() throws RecognitionException {
		FunctionReturnContext _localctx = new FunctionReturnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(Return);
			setState(108);
			((FunctionReturnContext)_localctx).expr = expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionParamContext extends ParserRuleContext {
		public DeclarationContext param;
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Comma() { return getToken(AnacondaParser.Comma, 0); }
		public FunctionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterFunctionParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitFunctionParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitFunctionParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamContext functionParam() throws RecognitionException {
		FunctionParamContext _localctx = new FunctionParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionParam);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Float:
			case Bool:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				((FunctionParamContext)_localctx).param = declaration();
				}
				break;
			case Comma:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(Comma);
				setState(112);
				((FunctionParamContext)_localctx).param = declaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public TerminalNode Float() { return getToken(AnacondaParser.Float, 0); }
		public TerminalNode Variable() { return getToken(AnacondaParser.Variable, 0); }
		public TerminalNode Int() { return getToken(AnacondaParser.Int, 0); }
		public TerminalNode Bool() { return getToken(AnacondaParser.Bool, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaration);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Float:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				((DeclarationContext)_localctx).type = match(Float);
				setState(116);
				((DeclarationContext)_localctx).name = match(Variable);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				((DeclarationContext)_localctx).type = match(Int);
				setState(118);
				((DeclarationContext)_localctx).name = match(Variable);
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				((DeclarationContext)_localctx).type = match(Bool);
				setState(120);
				((DeclarationContext)_localctx).name = match(Variable);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public Token variable;
		public Token op;
		public ExpressionContext right;
		public TerminalNode Variable() { return getToken(AnacondaParser.Variable, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Assign() { return getToken(AnacondaParser.Assign, 0); }
		public TerminalNode AssignPlus() { return getToken(AnacondaParser.AssignPlus, 0); }
		public TerminalNode AssignMinus() { return getToken(AnacondaParser.AssignMinus, 0); }
		public TerminalNode AsssignMultiply() { return getToken(AnacondaParser.AsssignMultiply, 0); }
		public TerminalNode AsssignDivide() { return getToken(AnacondaParser.AsssignDivide, 0); }
		public TerminalNode AsssignPower() { return getToken(AnacondaParser.AsssignPower, 0); }
		public TerminalNode AsssignModulo() { return getToken(AnacondaParser.AsssignModulo, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			((AssignmentContext)_localctx).variable = match(Variable);
			setState(124);
			((AssignmentContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Assign) | (1L << AssignPlus) | (1L << AssignMinus) | (1L << AsssignMultiply) | (1L << AsssignDivide) | (1L << AsssignPower) | (1L << AsssignModulo))) != 0)) ) {
				((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(125);
			((AssignmentContext)_localctx).right = expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStatementContext extends ParserRuleContext {
		public IfStatementContext ifStat;
		public ElseIfStatementContext elseIfStat;
		public ElseStatementContext elseStat;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitIfElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitIfElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseStatementContext ifElseStatement() throws RecognitionException {
		IfElseStatementContext _localctx = new IfElseStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifElseStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			((IfElseStatementContext)_localctx).ifStat = ifStatement();
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(128);
					((IfElseStatementContext)_localctx).elseIfStat = elseIfStatement();
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(134);
				((IfElseStatementContext)_localctx).elseStat = elseStatement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expr;
		public StatementsContext body;
		public TerminalNode If() { return getToken(AnacondaParser.If, 0); }
		public TerminalNode LeftPara() { return getToken(AnacondaParser.LeftPara, 0); }
		public TerminalNode RightPara() { return getToken(AnacondaParser.RightPara, 0); }
		public TerminalNode LeftBracket() { return getToken(AnacondaParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(AnacondaParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(If);
			setState(138);
			match(LeftPara);
			setState(139);
			((IfStatementContext)_localctx).expr = expression(0);
			setState(140);
			match(RightPara);
			setState(141);
			match(LeftBracket);
			setState(142);
			((IfStatementContext)_localctx).body = statements();
			setState(143);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseIfStatementContext extends ParserRuleContext {
		public ExpressionContext expr;
		public StatementsContext body;
		public TerminalNode Else() { return getToken(AnacondaParser.Else, 0); }
		public TerminalNode If() { return getToken(AnacondaParser.If, 0); }
		public TerminalNode LeftPara() { return getToken(AnacondaParser.LeftPara, 0); }
		public TerminalNode RightPara() { return getToken(AnacondaParser.RightPara, 0); }
		public TerminalNode LeftBracket() { return getToken(AnacondaParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(AnacondaParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitElseIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitElseIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(Else);
			setState(146);
			match(If);
			setState(147);
			match(LeftPara);
			setState(148);
			((ElseIfStatementContext)_localctx).expr = expression(0);
			setState(149);
			match(RightPara);
			setState(150);
			match(LeftBracket);
			setState(151);
			((ElseIfStatementContext)_localctx).body = statements();
			setState(152);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public StatementsContext body;
		public TerminalNode Else() { return getToken(AnacondaParser.Else, 0); }
		public TerminalNode LeftBracket() { return getToken(AnacondaParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(AnacondaParser.RightBracket, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(Else);
			setState(155);
			match(LeftBracket);
			setState(156);
			((ElseStatementContext)_localctx).body = statements();
			setState(157);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expr;
		public StatementsContext body;
		public TerminalNode While() { return getToken(AnacondaParser.While, 0); }
		public TerminalNode LeftPara() { return getToken(AnacondaParser.LeftPara, 0); }
		public TerminalNode RightPara() { return getToken(AnacondaParser.RightPara, 0); }
		public TerminalNode LeftBracket() { return getToken(AnacondaParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(AnacondaParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(While);
			setState(160);
			match(LeftPara);
			setState(161);
			((WhileStatementContext)_localctx).expr = expression(0);
			setState(162);
			match(RightPara);
			setState(163);
			match(LeftBracket);
			setState(164);
			((WhileStatementContext)_localctx).body = statements();
			setState(165);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InfixExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Power() { return getToken(AnacondaParser.Power, 0); }
		public TerminalNode Multiply() { return getToken(AnacondaParser.Multiply, 0); }
		public TerminalNode Divide() { return getToken(AnacondaParser.Divide, 0); }
		public TerminalNode Modulo() { return getToken(AnacondaParser.Modulo, 0); }
		public TerminalNode Add() { return getToken(AnacondaParser.Add, 0); }
		public TerminalNode Subtract() { return getToken(AnacondaParser.Subtract, 0); }
		public InfixExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterInfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitInfixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitInfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Add() { return getToken(AnacondaParser.Add, 0); }
		public TerminalNode Subtract() { return getToken(AnacondaParser.Subtract, 0); }
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExprContext extends ExpressionContext {
		public Token value;
		public TerminalNode Number() { return getToken(AnacondaParser.Number, 0); }
		public TerminalNode Variable() { return getToken(AnacondaParser.Variable, 0); }
		public ValueExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitValueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExpressionContext {
		public TerminalNode Not() { return getToken(AnacondaParser.Not, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Equals() { return getToken(AnacondaParser.Equals, 0); }
		public TerminalNode NegativeEquals() { return getToken(AnacondaParser.NegativeEquals, 0); }
		public TerminalNode GreaterThan() { return getToken(AnacondaParser.GreaterThan, 0); }
		public TerminalNode LessThan() { return getToken(AnacondaParser.LessThan, 0); }
		public TerminalNode GreaterThanEquals() { return getToken(AnacondaParser.GreaterThanEquals, 0); }
		public TerminalNode LessThanEquals() { return getToken(AnacondaParser.LessThanEquals, 0); }
		public TerminalNode Or() { return getToken(AnacondaParser.Or, 0); }
		public TerminalNode And() { return getToken(AnacondaParser.And, 0); }
		public BooleanExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterBooleanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitBooleanExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExprContext extends ExpressionContext {
		public Token name;
		public FunctionCallParamContext params;
		public TerminalNode LeftPara() { return getToken(AnacondaParser.LeftPara, 0); }
		public TerminalNode RightPara() { return getToken(AnacondaParser.RightPara, 0); }
		public TerminalNode Variable() { return getToken(AnacondaParser.Variable, 0); }
		public List<FunctionCallParamContext> functionCallParam() {
			return getRuleContexts(FunctionCallParamContext.class);
		}
		public FunctionCallParamContext functionCallParam(int i) {
			return getRuleContext(FunctionCallParamContext.class,i);
		}
		public FunctionCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitFunctionCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExprContext extends ExpressionContext {
		public TerminalNode LeftPara() { return getToken(AnacondaParser.LeftPara, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightPara() { return getToken(AnacondaParser.RightPara, 0); }
		public ParensExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(168);
				match(LeftPara);
				setState(169);
				expression(0);
				setState(170);
				match(RightPara);
				}
				break;
			case 2:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Add || _la==Subtract) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(173);
				expression(8);
				}
				break;
			case 3:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				((ValueExprContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Variable || _la==Number) ) {
					((ValueExprContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(Not);
				setState(176);
				expression(3);
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				((FunctionCallExprContext)_localctx).name = match(Variable);
				setState(178);
				match(LeftPara);
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Subtract) | (1L << Not) | (1L << LeftPara) | (1L << Comma) | (1L << Variable) | (1L << Number))) != 0)) {
					{
					{
					setState(179);
					((FunctionCallExprContext)_localctx).params = functionCallParam();
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(185);
				match(RightPara);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(200);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExpressionContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(189);
						((InfixExprContext)_localctx).op = match(Power);
						setState(190);
						((InfixExprContext)_localctx).right = expression(8);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExpressionContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(192);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Modulo))) != 0)) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(193);
						((InfixExprContext)_localctx).right = expression(7);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExpressionContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(195);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Subtract) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(196);
						((InfixExprContext)_localctx).right = expression(6);
						}
						break;
					case 4:
						{
						_localctx = new BooleanExprContext(new ExpressionContext(_parentctx, _parentState));
						((BooleanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(197);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(198);
						((BooleanExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GreaterThan) | (1L << LessThan) | (1L << Equals) | (1L << NegativeEquals) | (1L << GreaterThanEquals) | (1L << LessThanEquals) | (1L << Or) | (1L << And))) != 0)) ) {
							((BooleanExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(199);
						((BooleanExprContext)_localctx).right = expression(3);
						}
						break;
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionCallParamContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(AnacondaParser.Comma, 0); }
		public FunctionCallParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).enterFunctionCallParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnacondaListener ) ((AnacondaListener)listener).exitFunctionCallParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnacondaVisitor ) return ((AnacondaVisitor<? extends T>)visitor).visitFunctionCallParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallParamContext functionCallParam() throws RecognitionException {
		FunctionCallParamContext _localctx = new FunctionCallParamContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionCallParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Add:
			case Subtract:
			case Not:
			case LeftPara:
			case Variable:
			case Number:
				{
				setState(205);
				expression(0);
				}
				break;
			case Comma:
				{
				setState(206);
				match(Comma);
				setState(207);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00d5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\3"+
		"\7\3&\n\3\f\3\16\3)\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\5\3"+
		"\5\3\5\3\5\7\58\n\5\f\5\16\5;\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5F\n\5\f\5\16\5I\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5T\n\5"+
		"\f\5\16\5W\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5b\n\5\f\5\16\5"+
		"e\13\5\3\5\3\5\3\5\3\5\3\5\5\5l\n\5\3\6\3\6\3\6\3\7\3\7\3\7\5\7t\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b|\n\b\3\t\3\t\3\t\3\t\3\n\3\n\7\n\u0084\n\n"+
		"\f\n\16\n\u0087\13\n\3\n\5\n\u008a\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00b7\n\17\f\17\16\17\u00ba\13\17"+
		"\3\17\5\17\u00bd\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\7\17\u00cb\n\17\f\17\16\17\u00ce\13\17\3\20\3\20\3\20\5\20"+
		"\u00d3\n\20\3\20\2\3\34\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\7"+
		"\3\2\t\17\3\2\3\4\3\2&\'\4\2\5\6\b\b\3\2\21\30\2\u00e2\2 \3\2\2\2\4\'"+
		"\3\2\2\2\6\61\3\2\2\2\bk\3\2\2\2\nm\3\2\2\2\fs\3\2\2\2\16{\3\2\2\2\20"+
		"}\3\2\2\2\22\u0081\3\2\2\2\24\u008b\3\2\2\2\26\u0093\3\2\2\2\30\u009c"+
		"\3\2\2\2\32\u00a1\3\2\2\2\34\u00bc\3\2\2\2\36\u00d2\3\2\2\2 !\5\4\3\2"+
		"!\3\3\2\2\2\"#\5\6\4\2#$\7(\2\2$&\3\2\2\2%\"\3\2\2\2&)\3\2\2\2\'%\3\2"+
		"\2\2\'(\3\2\2\2(\5\3\2\2\2)\'\3\2\2\2*\62\5\b\5\2+\62\5\n\6\2,\62\5\16"+
		"\b\2-\62\5\20\t\2.\62\5\22\n\2/\62\5\32\16\2\60\62\5\34\17\2\61*\3\2\2"+
		"\2\61+\3\2\2\2\61,\3\2\2\2\61-\3\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3"+
		"\2\2\2\62\7\3\2\2\2\63\64\7\31\2\2\64\65\7&\2\2\659\7!\2\2\668\5\f\7\2"+
		"\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7"+
		"\"\2\2=>\7#\2\2>?\5\4\3\2?@\7$\2\2@l\3\2\2\2AB\7\32\2\2BC\7&\2\2CG\7!"+
		"\2\2DF\5\f\7\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2"+
		"\2\2JK\7\"\2\2KL\7#\2\2LM\5\4\3\2MN\7$\2\2Nl\3\2\2\2OP\7\33\2\2PQ\7&\2"+
		"\2QU\7!\2\2RT\5\f\7\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2"+
		"\2WU\3\2\2\2XY\7\"\2\2YZ\7#\2\2Z[\5\4\3\2[\\\7$\2\2\\l\3\2\2\2]^\7\34"+
		"\2\2^_\7&\2\2_c\7!\2\2`b\5\f\7\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2"+
		"\2df\3\2\2\2ec\3\2\2\2fg\7\"\2\2gh\7#\2\2hi\5\4\3\2ij\7$\2\2jl\3\2\2\2"+
		"k\63\3\2\2\2kA\3\2\2\2kO\3\2\2\2k]\3\2\2\2l\t\3\2\2\2mn\7 \2\2no\5\34"+
		"\17\2o\13\3\2\2\2pt\5\16\b\2qr\7%\2\2rt\5\16\b\2sp\3\2\2\2sq\3\2\2\2t"+
		"\r\3\2\2\2uv\7\32\2\2v|\7&\2\2wx\7\31\2\2x|\7&\2\2yz\7\33\2\2z|\7&\2\2"+
		"{u\3\2\2\2{w\3\2\2\2{y\3\2\2\2|\17\3\2\2\2}~\7&\2\2~\177\t\2\2\2\177\u0080"+
		"\5\34\17\2\u0080\21\3\2\2\2\u0081\u0085\5\24\13\2\u0082\u0084\5\26\f\2"+
		"\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008a\5\30\r\2"+
		"\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\23\3\2\2\2\u008b\u008c"+
		"\7\35\2\2\u008c\u008d\7!\2\2\u008d\u008e\5\34\17\2\u008e\u008f\7\"\2\2"+
		"\u008f\u0090\7#\2\2\u0090\u0091\5\4\3\2\u0091\u0092\7$\2\2\u0092\25\3"+
		"\2\2\2\u0093\u0094\7\36\2\2\u0094\u0095\7\35\2\2\u0095\u0096\7!\2\2\u0096"+
		"\u0097\5\34\17\2\u0097\u0098\7\"\2\2\u0098\u0099\7#\2\2\u0099\u009a\5"+
		"\4\3\2\u009a\u009b\7$\2\2\u009b\27\3\2\2\2\u009c\u009d\7\36\2\2\u009d"+
		"\u009e\7#\2\2\u009e\u009f\5\4\3\2\u009f\u00a0\7$\2\2\u00a0\31\3\2\2\2"+
		"\u00a1\u00a2\7\37\2\2\u00a2\u00a3\7!\2\2\u00a3\u00a4\5\34\17\2\u00a4\u00a5"+
		"\7\"\2\2\u00a5\u00a6\7#\2\2\u00a6\u00a7\5\4\3\2\u00a7\u00a8\7$\2\2\u00a8"+
		"\33\3\2\2\2\u00a9\u00aa\b\17\1\2\u00aa\u00ab\7!\2\2\u00ab\u00ac\5\34\17"+
		"\2\u00ac\u00ad\7\"\2\2\u00ad\u00bd\3\2\2\2\u00ae\u00af\t\3\2\2\u00af\u00bd"+
		"\5\34\17\n\u00b0\u00bd\t\4\2\2\u00b1\u00b2\7\20\2\2\u00b2\u00bd\5\34\17"+
		"\5\u00b3\u00b4\7&\2\2\u00b4\u00b8\7!\2\2\u00b5\u00b7\5\36\20\2\u00b6\u00b5"+
		"\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bd\7\"\2\2\u00bc\u00a9\3\2"+
		"\2\2\u00bc\u00ae\3\2\2\2\u00bc\u00b0\3\2\2\2\u00bc\u00b1\3\2\2\2\u00bc"+
		"\u00b3\3\2\2\2\u00bd\u00cc\3\2\2\2\u00be\u00bf\f\t\2\2\u00bf\u00c0\7\7"+
		"\2\2\u00c0\u00cb\5\34\17\n\u00c1\u00c2\f\b\2\2\u00c2\u00c3\t\5\2\2\u00c3"+
		"\u00cb\5\34\17\t\u00c4\u00c5\f\7\2\2\u00c5\u00c6\t\3\2\2\u00c6\u00cb\5"+
		"\34\17\b\u00c7\u00c8\f\4\2\2\u00c8\u00c9\t\6\2\2\u00c9\u00cb\5\34\17\5"+
		"\u00ca\u00be\3\2\2\2\u00ca\u00c1\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00c7"+
		"\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\35\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d3\5\34\17\2\u00d0\u00d1\7%\2"+
		"\2\u00d1\u00d3\5\34\17\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3"+
		"\37\3\2\2\2\22\'\619GUcks{\u0085\u0089\u00b8\u00bc\u00ca\u00cc\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}