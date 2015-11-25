// Generated from Formula.g4 by ANTLR 4.4

package ca.ece.ubc.cpen221.mp5.antlrStuff;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormulaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, RANGE=6, LPAREN=7, RPAREN=8, AND=9, 
		WHITESPACE=10, OR=11, STRING=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "RANGE", "LPAREN", "RPAREN", "AND", 
		"WHITESPACE", "OR", "STRING"
	};


	    // This method makes the lexer or parser stop running if it encounters
	    // invalid input and throw a RuntimeException.
	    public void reportErrorsAsExceptions() {
	        //removeErrorListeners();
	        
	        addErrorListener(new ExceptionThrowingErrorListener());
	    }
	    
	    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
	        @Override
	        public void syntaxError(Recognizer<?, ?> recognizer,
	                Object offendingSymbol, int line, int charPositionInLine,
	                String msg, RecognitionException e) {
	            throw new RuntimeException(msg);
	        }
	    }


	public FormulaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Formula.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16W\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\6\13H\n\13\r"+
		"\13\16\13I\3\13\3\13\3\f\3\f\3\f\3\r\3\r\7\rS\n\r\f\r\16\rV\13\r\2\2\16"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\6\3\2\63"+
		"\67\5\2\13\f\17\17\"\"\5\2\62;C\\c|\7\2\"\"))\62;C\\c|X\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3"+
		"\33\3\2\2\2\5 \3\2\2\2\7\'\3\2\2\2\t-\3\2\2\2\13\60\3\2\2\2\r9\3\2\2\2"+
		"\17?\3\2\2\2\21A\3\2\2\2\23C\3\2\2\2\25G\3\2\2\2\27M\3\2\2\2\31P\3\2\2"+
		"\2\33\34\7p\2\2\34\35\7c\2\2\35\36\7o\2\2\36\37\7g\2\2\37\4\3\2\2\2 !"+
		"\7t\2\2!\"\7c\2\2\"#\7v\2\2#$\7k\2\2$%\7p\2\2%&\7i\2\2&\6\3\2\2\2\'(\7"+
		"r\2\2()\7t\2\2)*\7k\2\2*+\7e\2\2+,\7g\2\2,\b\3\2\2\2-.\7k\2\2./\7p\2\2"+
		"/\n\3\2\2\2\60\61\7e\2\2\61\62\7c\2\2\62\63\7v\2\2\63\64\7g\2\2\64\65"+
		"\7i\2\2\65\66\7q\2\2\66\67\7t\2\2\678\7{\2\28\f\3\2\2\29:\t\2\2\2:;\7"+
		"\60\2\2;<\7\60\2\2<=\3\2\2\2=>\t\2\2\2>\16\3\2\2\2?@\7*\2\2@\20\3\2\2"+
		"\2AB\7+\2\2B\22\3\2\2\2CD\7(\2\2DE\7(\2\2E\24\3\2\2\2FH\t\3\2\2GF\3\2"+
		"\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\b\13\2\2L\26\3\2\2\2MN"+
		"\7~\2\2NO\7~\2\2O\30\3\2\2\2PT\t\4\2\2QS\t\5\2\2RQ\3\2\2\2SV\3\2\2\2T"+
		"R\3\2\2\2TU\3\2\2\2U\32\3\2\2\2VT\3\2\2\2\5\2IT\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}