// Generated from DeAL.g4 by ANTLR 4.5.3
package edu.ucla.cs.wis.bigdatalog.compiler.language;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DeALLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, LINE_COMMENT=27, MULTILINE_COMMENT=28, NEWLINE=29, 
		WS=30, STRING=31, DATA_TYPE=32, SORT_ORDER=33, MODULE=34, DATABASE=35, 
		EXPORT=36, INDEX=37, KEY=38, IF=39, THEN=40, ELSE=41, TRUE=42, FALSE=43, 
		NIL=44, BEGIN=45, END=46, CHOICE=47, MULTI=48, SINGLE=49, EMPTY=50, RETURN=51, 
		LIMIT=52, SORT=53, DESC=54, ASC=55, MOD=56, OPC=57, LOG=58, EXP=59, STEP=60, 
		DIV=61, AGGREGATE_FSMAX=62, AGGREGATE_FSMIN=63, AGGREGATE_FSCNT=64, AGGREGATE_FSSUM=65, 
		IDENTIFIER=66, VARIABLENAME=67, INPUT_VARIABLE=68, INTEGER=69, DECIMAL=70;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "LINE_COMMENT", "MULTILINE_COMMENT", "NEWLINE", "WS", "STRING", 
		"DATA_TYPE", "SORT_ORDER", "MODULE", "DATABASE", "EXPORT", "INDEX", "KEY", 
		"IF", "THEN", "ELSE", "TRUE", "FALSE", "NIL", "BEGIN", "END", "CHOICE", 
		"MULTI", "SINGLE", "EMPTY", "RETURN", "LIMIT", "SORT", "DESC", "ASC", 
		"MOD", "OPC", "LOG", "EXP", "STEP", "DIV", "AGGREGATE_FSMAX", "AGGREGATE_FSMIN", 
		"AGGREGATE_FSCNT", "AGGREGATE_FSSUM", "IDENTIFIER", "VARIABLENAME", "INPUT_VARIABLE", 
		"INTEGER", "DECIMAL", "DIGIT", "LETTER", "UPPERCASELETTER", "LOWERCASELETTER", 
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
		"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'('", "'{'", "','", "'}'", "')'", "'['", "']'", "'|'", "':'", 
		"'<-'", "'~'", "'='", "'~='", "'>'", "'<'", "'>='", "'<='", "'*='", "'~*='", 
		"'*'", "'/'", "'-'", "'+'", "'@'", "'_'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "LINE_COMMENT", "MULTILINE_COMMENT", "NEWLINE", "WS", 
		"STRING", "DATA_TYPE", "SORT_ORDER", "MODULE", "DATABASE", "EXPORT", "INDEX", 
		"KEY", "IF", "THEN", "ELSE", "TRUE", "FALSE", "NIL", "BEGIN", "END", "CHOICE", 
		"MULTI", "SINGLE", "EMPTY", "RETURN", "LIMIT", "SORT", "DESC", "ASC", 
		"MOD", "OPC", "LOG", "EXP", "STEP", "DIV", "AGGREGATE_FSMAX", "AGGREGATE_FSMIN", 
		"AGGREGATE_FSCNT", "AGGREGATE_FSSUM", "IDENTIFIER", "VARIABLENAME", "INPUT_VARIABLE", 
		"INTEGER", "DECIMAL"
	};
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


	public DeALLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DeAL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 30:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			setText(String.valueOf(getText().substring(1, getText().length()-1)));
			break;
		case 1:
			setText(String.valueOf(getText().substring(1, getText().length()-1)));
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2H\u02c7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\7\34\u0109\n\34\f\34\16\34\u010c\13"+
		"\34\3\34\5\34\u010f\n\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\7\35"+
		"\u0119\n\35\f\35\16\35\u011c\13\35\3\35\3\35\3\35\5\35\u0121\n\35\3\35"+
		"\3\35\3\36\5\36\u0126\n\36\3\36\3\36\3\36\3\36\3\37\6\37\u012d\n\37\r"+
		"\37\16\37\u012e\3\37\3\37\3 \3 \3 \3 \7 \u0137\n \f \16 \u013a\13 \3 "+
		"\3 \3 \3 \3 \3 \7 \u0142\n \f \16 \u0145\13 \3 \3 \5 \u0149\n \3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0186\n!\3\"\3\"\5\"\u018a\n\"\3#\3"+
		"#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3"+
		"/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\39\39\39\39\3:\3"+
		":\3:\3:\3;\3;\3;\3;\3<\3<\3<\3<\3=\3=\3=\3=\3=\3>\3>\3>\3>\3?\3?\3?\3"+
		"?\5?\u0225\n?\3?\3?\3?\3?\3@\3@\3@\3@\5@\u022f\n@\3@\3@\3@\3@\3A\3A\3"+
		"A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\5A\u0242\nA\3B\3B\3B\3B\5B\u0248\nB\3"+
		"B\3B\3B\3B\3C\3C\3C\3C\7C\u0252\nC\fC\16C\u0255\13C\3D\3D\3D\3D\7D\u025b"+
		"\nD\fD\16D\u025e\13D\3E\3E\3E\7E\u0263\nE\fE\16E\u0266\13E\3E\3E\6E\u026a"+
		"\nE\rE\16E\u026b\7E\u026e\nE\fE\16E\u0271\13E\3F\3F\3F\7F\u0276\nF\fF"+
		"\16F\u0279\13F\5F\u027b\nF\3G\6G\u027e\nG\rG\16G\u027f\5G\u0282\nG\3G"+
		"\3G\6G\u0286\nG\rG\16G\u0287\3H\3H\3I\3I\5I\u028e\nI\3J\3J\3K\3K\3L\3"+
		"L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3"+
		"X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3c"+
		"\3c\3d\3d\3e\3e\3\u011a\2f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a"+
		"\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087"+
		"E\u0089F\u008bG\u008dH\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2"+
		"\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab"+
		"\2\u00ad\2\u00af\2\u00b1\2\u00b3\2\u00b5\2\u00b7\2\u00b9\2\u00bb\2\u00bd"+
		"\2\u00bf\2\u00c1\2\u00c3\2\u00c5\2\u00c7\2\u00c9\2\3\2\'\4\2\f\f\17\17"+
		"\5\2\13\f\16\17\"\"\3\2$$\4\2))^^\4\2//aa\4\2C\\c|\5\2\62;C\\c|\3\2\63"+
		";\3\2\62;\3\2C\\\3\2c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHh"+
		"h\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2"+
		"QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4"+
		"\2ZZzz\4\2[[{{\4\2\\\\||\u02d1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3"+
		"\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\3\u00cb\3\2\2\2\5\u00cd\3\2\2\2\7\u00cf"+
		"\3\2\2\2\t\u00d1\3\2\2\2\13\u00d3\3\2\2\2\r\u00d5\3\2\2\2\17\u00d7\3\2"+
		"\2\2\21\u00d9\3\2\2\2\23\u00db\3\2\2\2\25\u00dd\3\2\2\2\27\u00df\3\2\2"+
		"\2\31\u00e2\3\2\2\2\33\u00e4\3\2\2\2\35\u00e6\3\2\2\2\37\u00e9\3\2\2\2"+
		"!\u00eb\3\2\2\2#\u00ed\3\2\2\2%\u00f0\3\2\2\2\'\u00f3\3\2\2\2)\u00f6\3"+
		"\2\2\2+\u00fa\3\2\2\2-\u00fc\3\2\2\2/\u00fe\3\2\2\2\61\u0100\3\2\2\2\63"+
		"\u0102\3\2\2\2\65\u0104\3\2\2\2\67\u0106\3\2\2\29\u0114\3\2\2\2;\u0125"+
		"\3\2\2\2=\u012c\3\2\2\2?\u0148\3\2\2\2A\u0185\3\2\2\2C\u0189\3\2\2\2E"+
		"\u018b\3\2\2\2G\u0192\3\2\2\2I\u019b\3\2\2\2K\u01a2\3\2\2\2M\u01a8\3\2"+
		"\2\2O\u01ac\3\2\2\2Q\u01af\3\2\2\2S\u01b4\3\2\2\2U\u01b9\3\2\2\2W\u01be"+
		"\3\2\2\2Y\u01c4\3\2\2\2[\u01c8\3\2\2\2]\u01ce\3\2\2\2_\u01d2\3\2\2\2a"+
		"\u01d9\3\2\2\2c\u01df\3\2\2\2e\u01e6\3\2\2\2g\u01ec\3\2\2\2i\u01f3\3\2"+
		"\2\2k\u01f9\3\2\2\2m\u01fe\3\2\2\2o\u0203\3\2\2\2q\u0207\3\2\2\2s\u020b"+
		"\3\2\2\2u\u020f\3\2\2\2w\u0213\3\2\2\2y\u0217\3\2\2\2{\u021c\3\2\2\2}"+
		"\u0224\3\2\2\2\177\u022e\3\2\2\2\u0081\u0241\3\2\2\2\u0083\u0247\3\2\2"+
		"\2\u0085\u024d\3\2\2\2\u0087\u0256\3\2\2\2\u0089\u025f\3\2\2\2\u008b\u027a"+
		"\3\2\2\2\u008d\u0281\3\2\2\2\u008f\u0289\3\2\2\2\u0091\u028d\3\2\2\2\u0093"+
		"\u028f\3\2\2\2\u0095\u0291\3\2\2\2\u0097\u0293\3\2\2\2\u0099\u0295\3\2"+
		"\2\2\u009b\u0297\3\2\2\2\u009d\u0299\3\2\2\2\u009f\u029b\3\2\2\2\u00a1"+
		"\u029d\3\2\2\2\u00a3\u029f\3\2\2\2\u00a5\u02a1\3\2\2\2\u00a7\u02a3\3\2"+
		"\2\2\u00a9\u02a5\3\2\2\2\u00ab\u02a7\3\2\2\2\u00ad\u02a9\3\2\2\2\u00af"+
		"\u02ab\3\2\2\2\u00b1\u02ad\3\2\2\2\u00b3\u02af\3\2\2\2\u00b5\u02b1\3\2"+
		"\2\2\u00b7\u02b3\3\2\2\2\u00b9\u02b5\3\2\2\2\u00bb\u02b7\3\2\2\2\u00bd"+
		"\u02b9\3\2\2\2\u00bf\u02bb\3\2\2\2\u00c1\u02bd\3\2\2\2\u00c3\u02bf\3\2"+
		"\2\2\u00c5\u02c1\3\2\2\2\u00c7\u02c3\3\2\2\2\u00c9\u02c5\3\2\2\2\u00cb"+
		"\u00cc\7\60\2\2\u00cc\4\3\2\2\2\u00cd\u00ce\7*\2\2\u00ce\6\3\2\2\2\u00cf"+
		"\u00d0\7}\2\2\u00d0\b\3\2\2\2\u00d1\u00d2\7.\2\2\u00d2\n\3\2\2\2\u00d3"+
		"\u00d4\7\177\2\2\u00d4\f\3\2\2\2\u00d5\u00d6\7+\2\2\u00d6\16\3\2\2\2\u00d7"+
		"\u00d8\7]\2\2\u00d8\20\3\2\2\2\u00d9\u00da\7_\2\2\u00da\22\3\2\2\2\u00db"+
		"\u00dc\7~\2\2\u00dc\24\3\2\2\2\u00dd\u00de\7<\2\2\u00de\26\3\2\2\2\u00df"+
		"\u00e0\7>\2\2\u00e0\u00e1\7/\2\2\u00e1\30\3\2\2\2\u00e2\u00e3\7\u0080"+
		"\2\2\u00e3\32\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5\34\3\2\2\2\u00e6\u00e7"+
		"\7\u0080\2\2\u00e7\u00e8\7?\2\2\u00e8\36\3\2\2\2\u00e9\u00ea\7@\2\2\u00ea"+
		" \3\2\2\2\u00eb\u00ec\7>\2\2\u00ec\"\3\2\2\2\u00ed\u00ee\7@\2\2\u00ee"+
		"\u00ef\7?\2\2\u00ef$\3\2\2\2\u00f0\u00f1\7>\2\2\u00f1\u00f2\7?\2\2\u00f2"+
		"&\3\2\2\2\u00f3\u00f4\7,\2\2\u00f4\u00f5\7?\2\2\u00f5(\3\2\2\2\u00f6\u00f7"+
		"\7\u0080\2\2\u00f7\u00f8\7,\2\2\u00f8\u00f9\7?\2\2\u00f9*\3\2\2\2\u00fa"+
		"\u00fb\7,\2\2\u00fb,\3\2\2\2\u00fc\u00fd\7\61\2\2\u00fd.\3\2\2\2\u00fe"+
		"\u00ff\7/\2\2\u00ff\60\3\2\2\2\u0100\u0101\7-\2\2\u0101\62\3\2\2\2\u0102"+
		"\u0103\7B\2\2\u0103\64\3\2\2\2\u0104\u0105\7a\2\2\u0105\66\3\2\2\2\u0106"+
		"\u010a\7\'\2\2\u0107\u0109\n\2\2\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2"+
		"\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010a\3\2\2\2\u010d\u010f\7\17\2\2\u010e\u010d\3\2\2\2\u010e\u010f\3"+
		"\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\7\f\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0113\b\34\2\2\u01138\3\2\2\2\u0114\u0115\7\61\2\2\u0115\u0116\7,\2\2"+
		"\u0116\u011a\3\2\2\2\u0117\u0119\13\2\2\2\u0118\u0117\3\2\2\2\u0119\u011c"+
		"\3\2\2\2\u011a\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u0120\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011d\u011e\7,\2\2\u011e\u0121\7\61\2\2\u011f\u0121\7\2"+
		"\2\3\u0120\u011d\3\2\2\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\b\35\2\2\u0123:\3\2\2\2\u0124\u0126\7\17\2\2\u0125\u0124\3\2\2"+
		"\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\7\f\2\2\u0128\u0129"+
		"\3\2\2\2\u0129\u012a\b\36\2\2\u012a<\3\2\2\2\u012b\u012d\t\3\2\2\u012c"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2"+
		"\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b\37\2\2\u0131>\3\2\2\2\u0132\u0138"+
		"\7$\2\2\u0133\u0134\7$\2\2\u0134\u0137\7$\2\2\u0135\u0137\n\4\2\2\u0136"+
		"\u0133\3\2\2\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2"+
		"\2\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u013c\7$\2\2\u013c\u0149\b \3\2\u013d\u0143\7)\2\2\u013e\u013f\7^\2\2"+
		"\u013f\u0142\t\5\2\2\u0140\u0142\n\5\2\2\u0141\u013e\3\2\2\2\u0141\u0140"+
		"\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0146\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0147\7)\2\2\u0147\u0149\b \4"+
		"\2\u0148\u0132\3\2\2\2\u0148\u013d\3\2\2\2\u0149@\3\2\2\2\u014a\u014b"+
		"\7k\2\2\u014b\u014c\7p\2\2\u014c\u014d\7v\2\2\u014d\u014e\7g\2\2\u014e"+
		"\u014f\7i\2\2\u014f\u0150\7g\2\2\u0150\u0186\7t\2\2\u0151\u0152\7n\2\2"+
		"\u0152\u0153\7q\2\2\u0153\u0154\7p\2\2\u0154\u0186\7i\2\2\u0155\u0156"+
		"\7h\2\2\u0156\u0157\7n\2\2\u0157\u0158\7q\2\2\u0158\u0159\7c\2\2\u0159"+
		"\u0186\7v\2\2\u015a\u015b\7u\2\2\u015b\u015c\7v\2\2\u015c\u015d\7t\2\2"+
		"\u015d\u015e\7k\2\2\u015e\u015f\7p\2\2\u015f\u0186\7i\2\2\u0160\u0161"+
		"\7c\2\2\u0161\u0162\7p\2\2\u0162\u0186\7{\2\2\u0163\u0164\7e\2\2\u0164"+
		"\u0165\7q\2\2\u0165\u0166\7o\2\2\u0166\u0167\7r\2\2\u0167\u0168\7n\2\2"+
		"\u0168\u0169\7g\2\2\u0169\u0186\7z\2\2\u016a\u016b\7n\2\2\u016b\u016c"+
		"\7k\2\2\u016c\u016d\7u\2\2\u016d\u0186\7v\2\2\u016e\u016f\7f\2\2\u016f"+
		"\u0170\7c\2\2\u0170\u0171\7v\2\2\u0171\u0172\7g\2\2\u0172\u0173\7v\2\2"+
		"\u0173\u0174\7k\2\2\u0174\u0175\7o\2\2\u0175\u0186\7g\2\2\u0176\u0177"+
		"\7f\2\2\u0177\u0178\7q\2\2\u0178\u0179\7w\2\2\u0179\u017a\7d\2\2\u017a"+
		"\u017b\7n\2\2\u017b\u0186\7g\2\2\u017c\u017d\7u\2\2\u017d\u017e\7j\2\2"+
		"\u017e\u017f\7q\2\2\u017f\u0180\7t\2\2\u0180\u0186\7v\2\2\u0181\u0182"+
		"\7d\2\2\u0182\u0183\7{\2\2\u0183\u0184\7v\2\2\u0184\u0186\7g\2\2\u0185"+
		"\u014a\3\2\2\2\u0185\u0151\3\2\2\2\u0185\u0155\3\2\2\2\u0185\u015a\3\2"+
		"\2\2\u0185\u0160\3\2\2\2\u0185\u0163\3\2\2\2\u0185\u016a\3\2\2\2\u0185"+
		"\u016e\3\2\2\2\u0185\u0176\3\2\2\2\u0185\u017c\3\2\2\2\u0185\u0181\3\2"+
		"\2\2\u0186B\3\2\2\2\u0187\u018a\5o8\2\u0188\u018a\5m\67\2\u0189\u0187"+
		"\3\2\2\2\u0189\u0188\3\2\2\2\u018aD\3\2\2\2\u018b\u018c\5\u00afX\2\u018c"+
		"\u018d\5\u00b3Z\2\u018d\u018e\5\u009dO\2\u018e\u018f\5\u00bf`\2\u018f"+
		"\u0190\5\u00adW\2\u0190\u0191\5\u009fP\2\u0191F\3\2\2\2\u0192\u0193\5"+
		"\u009dO\2\u0193\u0194\5\u0097L\2\u0194\u0195\5\u00bd_\2\u0195\u0196\5"+
		"\u0097L\2\u0196\u0197\5\u0099M\2\u0197\u0198\5\u0097L\2\u0198\u0199\5"+
		"\u00bb^\2\u0199\u019a\5\u009fP\2\u019aH\3\2\2\2\u019b\u019c\5\u009fP\2"+
		"\u019c\u019d\5\u00c5c\2\u019d\u019e\5\u00b5[\2\u019e\u019f\5\u00b3Z\2"+
		"\u019f\u01a0\5\u00b9]\2\u01a0\u01a1\5\u00bd_\2\u01a1J\3\2\2\2\u01a2\u01a3"+
		"\5\u00a7T\2\u01a3\u01a4\5\u00b1Y\2\u01a4\u01a5\5\u009dO\2\u01a5\u01a6"+
		"\5\u009fP\2\u01a6\u01a7\5\u00c5c\2\u01a7L\3\2\2\2\u01a8\u01a9\5\u00ab"+
		"V\2\u01a9\u01aa\5\u009fP\2\u01aa\u01ab\5\u00c7d\2\u01abN\3\2\2\2\u01ac"+
		"\u01ad\5\u00a7T\2\u01ad\u01ae\5\u00a1Q\2\u01aeP\3\2\2\2\u01af\u01b0\5"+
		"\u00bd_\2\u01b0\u01b1\5\u00a5S\2\u01b1\u01b2\5\u009fP\2\u01b2\u01b3\5"+
		"\u00b1Y\2\u01b3R\3\2\2\2\u01b4\u01b5\5\u009fP\2\u01b5\u01b6\5\u00adW\2"+
		"\u01b6\u01b7\5\u00bb^\2\u01b7\u01b8\5\u009fP\2\u01b8T\3\2\2\2\u01b9\u01ba"+
		"\5\u00bd_\2\u01ba\u01bb\5\u00b9]\2\u01bb\u01bc\5\u00bf`\2\u01bc\u01bd"+
		"\5\u009fP\2\u01bdV\3\2\2\2\u01be\u01bf\5\u00a1Q\2\u01bf\u01c0\5\u0097"+
		"L\2\u01c0\u01c1\5\u00adW\2\u01c1\u01c2\5\u00bb^\2\u01c2\u01c3\5\u009f"+
		"P\2\u01c3X\3\2\2\2\u01c4\u01c5\5\u00b1Y\2\u01c5\u01c6\5\u00a7T\2\u01c6"+
		"\u01c7\5\u00adW\2\u01c7Z\3\2\2\2\u01c8\u01c9\5\u0099M\2\u01c9\u01ca\5"+
		"\u009fP\2\u01ca\u01cb\5\u00a3R\2\u01cb\u01cc\5\u00a7T\2\u01cc\u01cd\5"+
		"\u00b1Y\2\u01cd\\\3\2\2\2\u01ce\u01cf\5\u009fP\2\u01cf\u01d0\5\u00b1Y"+
		"\2\u01d0\u01d1\5\u009dO\2\u01d1^\3\2\2\2\u01d2\u01d3\5\u009bN\2\u01d3"+
		"\u01d4\5\u00a5S\2\u01d4\u01d5\5\u00b3Z\2\u01d5\u01d6\5\u00a7T\2\u01d6"+
		"\u01d7\5\u009bN\2\u01d7\u01d8\5\u009fP\2\u01d8`\3\2\2\2\u01d9\u01da\5"+
		"\u00afX\2\u01da\u01db\5\u00bf`\2\u01db\u01dc\5\u00adW\2\u01dc\u01dd\5"+
		"\u00bd_\2\u01dd\u01de\5\u00a7T\2\u01deb\3\2\2\2\u01df\u01e0\5\u00bb^\2"+
		"\u01e0\u01e1\5\u00a7T\2\u01e1\u01e2\5\u00b1Y\2\u01e2\u01e3\5\u00a3R\2"+
		"\u01e3\u01e4\5\u00adW\2\u01e4\u01e5\5\u009fP\2\u01e5d\3\2\2\2\u01e6\u01e7"+
		"\5\u009fP\2\u01e7\u01e8\5\u00afX\2\u01e8\u01e9\5\u00b5[\2\u01e9\u01ea"+
		"\5\u00bd_\2\u01ea\u01eb\5\u00c7d\2\u01ebf\3\2\2\2\u01ec\u01ed\5\u00b9"+
		"]\2\u01ed\u01ee\5\u009fP\2\u01ee\u01ef\5\u00bd_\2\u01ef\u01f0\5\u00bf"+
		"`\2\u01f0\u01f1\5\u00b9]\2\u01f1\u01f2\5\u00b1Y\2\u01f2h\3\2\2\2\u01f3"+
		"\u01f4\5\u00adW\2\u01f4\u01f5\5\u00a7T\2\u01f5\u01f6\5\u00afX\2\u01f6"+
		"\u01f7\5\u00a7T\2\u01f7\u01f8\5\u00bd_\2\u01f8j\3\2\2\2\u01f9\u01fa\5"+
		"\u00bb^\2\u01fa\u01fb\5\u00b3Z\2\u01fb\u01fc\5\u00b9]\2\u01fc\u01fd\5"+
		"\u00bd_\2\u01fdl\3\2\2\2\u01fe\u01ff\5\u009dO\2\u01ff\u0200\5\u009fP\2"+
		"\u0200\u0201\5\u00bb^\2\u0201\u0202\5\u009bN\2\u0202n\3\2\2\2\u0203\u0204"+
		"\5\u0097L\2\u0204\u0205\5\u00bb^\2\u0205\u0206\5\u009bN\2\u0206p\3\2\2"+
		"\2\u0207\u0208\5\u00afX\2\u0208\u0209\5\u00b3Z\2\u0209\u020a\5\u009dO"+
		"\2\u020ar\3\2\2\2\u020b\u020c\5\u00b3Z\2\u020c\u020d\5\u00b5[\2\u020d"+
		"\u020e\5\u009bN\2\u020et\3\2\2\2\u020f\u0210\5\u00adW\2\u0210\u0211\5"+
		"\u00b3Z\2\u0211\u0212\5\u00a3R\2\u0212v\3\2\2\2\u0213\u0214\5\u009fP\2"+
		"\u0214\u0215\5\u00c5c\2\u0215\u0216\5\u00b5[\2\u0216x\3\2\2\2\u0217\u0218"+
		"\5\u00bb^\2\u0218\u0219\5\u00bd_\2\u0219\u021a\5\u009fP\2\u021a\u021b"+
		"\5\u00b5[\2\u021bz\3\2\2\2\u021c\u021d\5\u009dO\2\u021d\u021e\5\u00a7"+
		"T\2\u021e\u021f\5\u00c1a\2\u021f|\3\2\2\2\u0220\u0221\5\u00a1Q\2\u0221"+
		"\u0222\5\u00bb^\2\u0222\u0225\3\2\2\2\u0223\u0225\5\u00afX\2\u0224\u0220"+
		"\3\2\2\2\u0224\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\5\u00afX"+
		"\2\u0227\u0228\5\u0097L\2\u0228\u0229\5\u00c5c\2\u0229~\3\2\2\2\u022a"+
		"\u022b\5\u00a1Q\2\u022b\u022c\5\u00bb^\2\u022c\u022f\3\2\2\2\u022d\u022f"+
		"\5\u00afX\2\u022e\u022a\3\2\2\2\u022e\u022d\3\2\2\2\u022f\u0230\3\2\2"+
		"\2\u0230\u0231\5\u00afX\2\u0231\u0232\5\u00a7T\2\u0232\u0233\5\u00b1Y"+
		"\2\u0233\u0080\3\2\2\2\u0234\u0235\5\u00a1Q\2\u0235\u0236\5\u00bb^\2\u0236"+
		"\u0237\5\u009bN\2\u0237\u0238\5\u00b1Y\2\u0238\u0239\5\u00bd_\2\u0239"+
		"\u0242\3\2\2\2\u023a\u023b\5\u00afX\2\u023b\u023c\5\u009bN\2\u023c\u023d"+
		"\5\u00b3Z\2\u023d\u023e\5\u00bf`\2\u023e\u023f\5\u00b1Y\2\u023f\u0240"+
		"\5\u00bd_\2\u0240\u0242\3\2\2\2\u0241\u0234\3\2\2\2\u0241\u023a\3\2\2"+
		"\2\u0242\u0082\3\2\2\2\u0243\u0244\5\u00a1Q\2\u0244\u0245\5\u00bb^\2\u0245"+
		"\u0248\3\2\2\2\u0246\u0248\5\u00afX\2\u0247\u0243\3\2\2\2\u0247\u0246"+
		"\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a\5\u00bb^\2\u024a\u024b\5\u00bf"+
		"`\2\u024b\u024c\5\u00afX\2\u024c\u0084\3\2\2\2\u024d\u0253\5\u0095K\2"+
		"\u024e\u0252\5\u0091I\2\u024f\u0252\5\u008fH\2\u0250\u0252\t\6\2\2\u0251"+
		"\u024e\3\2\2\2\u0251\u024f\3\2\2\2\u0251\u0250\3\2\2\2\u0252\u0255\3\2"+
		"\2\2\u0253\u0251\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0086\3\2\2\2\u0255"+
		"\u0253\3\2\2\2\u0256\u025c\5\u0093J\2\u0257\u025b\5\u0091I\2\u0258\u025b"+
		"\5\u008fH\2\u0259\u025b\7a\2\2\u025a\u0257\3\2\2\2\u025a\u0258\3\2\2\2"+
		"\u025a\u0259\3\2\2\2\u025b\u025e\3\2\2\2\u025c\u025a\3\2\2\2\u025c\u025d"+
		"\3\2\2\2\u025d\u0088\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0260\7&\2\2\u0260"+
		"\u0264\t\7\2\2\u0261\u0263\t\b\2\2\u0262\u0261\3\2\2\2\u0263\u0266\3\2"+
		"\2\2\u0264\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u026f\3\2\2\2\u0266"+
		"\u0264\3\2\2\2\u0267\u0269\7a\2\2\u0268\u026a\t\b\2\2\u0269\u0268\3\2"+
		"\2\2\u026a\u026b\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026c\3\2\2\2\u026c"+
		"\u026e\3\2\2\2\u026d\u0267\3\2\2\2\u026e\u0271\3\2\2\2\u026f\u026d\3\2"+
		"\2\2\u026f\u0270\3\2\2\2\u0270\u008a\3\2\2\2\u0271\u026f\3\2\2\2\u0272"+
		"\u027b\7\62\2\2\u0273\u0277\t\t\2\2\u0274\u0276\5\u008fH\2\u0275\u0274"+
		"\3\2\2\2\u0276\u0279\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278"+
		"\u027b\3\2\2\2\u0279\u0277\3\2\2\2\u027a\u0272\3\2\2\2\u027a\u0273\3\2"+
		"\2\2\u027b\u008c\3\2\2\2\u027c\u027e\5\u008fH\2\u027d\u027c\3\2\2\2\u027e"+
		"\u027f\3\2\2\2\u027f\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0282\3\2"+
		"\2\2\u0281\u027d\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283\3\2\2\2\u0283"+
		"\u0285\7\60\2\2\u0284\u0286\5\u008fH\2\u0285\u0284\3\2\2\2\u0286\u0287"+
		"\3\2\2\2\u0287\u0285\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u008e\3\2\2\2\u0289"+
		"\u028a\t\n\2\2\u028a\u0090\3\2\2\2\u028b\u028e\5\u0093J\2\u028c\u028e"+
		"\5\u0095K\2\u028d\u028b\3\2\2\2\u028d\u028c\3\2\2\2\u028e\u0092\3\2\2"+
		"\2\u028f\u0290\t\13\2\2\u0290\u0094\3\2\2\2\u0291\u0292\t\f\2\2\u0292"+
		"\u0096\3\2\2\2\u0293\u0294\t\r\2\2\u0294\u0098\3\2\2\2\u0295\u0296\t\16"+
		"\2\2\u0296\u009a\3\2\2\2\u0297\u0298\t\17\2\2\u0298\u009c\3\2\2\2\u0299"+
		"\u029a\t\20\2\2\u029a\u009e\3\2\2\2\u029b\u029c\t\21\2\2\u029c\u00a0\3"+
		"\2\2\2\u029d\u029e\t\22\2\2\u029e\u00a2\3\2\2\2\u029f\u02a0\t\23\2\2\u02a0"+
		"\u00a4\3\2\2\2\u02a1\u02a2\t\24\2\2\u02a2\u00a6\3\2\2\2\u02a3\u02a4\t"+
		"\25\2\2\u02a4\u00a8\3\2\2\2\u02a5\u02a6\t\26\2\2\u02a6\u00aa\3\2\2\2\u02a7"+
		"\u02a8\t\27\2\2\u02a8\u00ac\3\2\2\2\u02a9\u02aa\t\30\2\2\u02aa\u00ae\3"+
		"\2\2\2\u02ab\u02ac\t\31\2\2\u02ac\u00b0\3\2\2\2\u02ad\u02ae\t\32\2\2\u02ae"+
		"\u00b2\3\2\2\2\u02af\u02b0\t\33\2\2\u02b0\u00b4\3\2\2\2\u02b1\u02b2\t"+
		"\34\2\2\u02b2\u00b6\3\2\2\2\u02b3\u02b4\t\35\2\2\u02b4\u00b8\3\2\2\2\u02b5"+
		"\u02b6\t\36\2\2\u02b6\u00ba\3\2\2\2\u02b7\u02b8\t\37\2\2\u02b8\u00bc\3"+
		"\2\2\2\u02b9\u02ba\t \2\2\u02ba\u00be\3\2\2\2\u02bb\u02bc\t!\2\2\u02bc"+
		"\u00c0\3\2\2\2\u02bd\u02be\t\"\2\2\u02be\u00c2\3\2\2\2\u02bf\u02c0\t#"+
		"\2\2\u02c0\u00c4\3\2\2\2\u02c1\u02c2\t$\2\2\u02c2\u00c6\3\2\2\2\u02c3"+
		"\u02c4\t%\2\2\u02c4\u00c8\3\2\2\2\u02c5\u02c6\t&\2\2\u02c6\u00ca\3\2\2"+
		"\2!\2\u010a\u010e\u011a\u0120\u0125\u012e\u0136\u0138\u0141\u0143\u0148"+
		"\u0185\u0189\u0224\u022e\u0241\u0247\u0251\u0253\u025a\u025c\u0264\u026b"+
		"\u026f\u0277\u027a\u027f\u0281\u0287\u028d\5\b\2\2\3 \2\3 \3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}