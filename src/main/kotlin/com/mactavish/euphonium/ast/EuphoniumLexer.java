// Generated from E:/MyProjects/Euphonium/src/main/kotlin/com/mactavish/euphonium/grammar\Euphonium.g4 by ANTLR 4.8
package com.mactavish.euphonium.ast;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EuphoniumLexer extends Lexer {
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, BOOL = 28, INT = 29, STRING = 30, TYPE = 31, TYPENAME = 32, ID = 33, COMMENT = 34, NL = 35, WS = 36;
	public static final String[] ruleNames = makeRuleNames();
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u0106\b\1\4\2\t" + "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" + "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4" + "\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f" + "\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21" + "\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26" + "\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33" + "\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35" + "\3\35\5\35\u00a2\n\35\3\36\6\36\u00a5\n\36\r\36\16\36\u00a6\3\37\3\37" + "\3 \3 \3 \7 \u00ae\n \f \16 \u00b1\13 \3 \3 \3 \3 \7 \u00b7\n \f \16 " + "\u00ba\13 \3 \5 \u00bd\n \3!\3!\5!\u00c1\n!\3\"\3\"\3\"\3\"\3\"\3\"\3" + "\"\3\"\3\"\3\"\3\"\3\"\3\"\6\"\u00d0\n\"\r\"\16\"\u00d1\3\"\5\"\u00d5" + "\n\"\3#\3#\3#\3#\7#\u00db\n#\f#\16#\u00de\13#\3$\3$\3$\3$\7$\u00e4\n$" + "\f$\16$\u00e7\13$\3%\3%\3&\3&\7&\u00ed\n&\f&\16&\u00f0\13&\3&\5&\u00f3" + "\n&\3&\3&\3&\3&\3\'\5\'\u00fa\n\'\3\'\3\'\3\'\3\'\3(\6(\u0101\n(\r(\16" + "(\u0102\3(\3(\5\u00af\u00b8\u00ee\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21" + "\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30" + "/\31\61\32\63\33\65\34\67\359\36;\37=\2? A\2C!E\"G#I\2K$M%O&\3\2\n\4\2" + "$$^^\4\2))^^\n\2$$))cdhhppttvvxx\3\2C\\\4\2&&aa\3\2c|\4\2C\\c|\4\2\13" + "\13\"\"\2\u0116\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3" + "\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2" + "\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3" + "\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2" + "\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2" + "9\3\2\2\2\2;\3\2\2\2\2?\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2K\3" + "\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3\2\2" + "\2\13Y\3\2\2\2\r[\3\2\2\2\17]\3\2\2\2\21_\3\2\2\2\23a\3\2\2\2\25d\3\2" + "\2\2\27f\3\2\2\2\31i\3\2\2\2\33l\3\2\2\2\35o\3\2\2\2\37q\3\2\2\2!t\3\2" + "\2\2#w\3\2\2\2%y\3\2\2\2\'|\3\2\2\2)\u0081\3\2\2\2+\u0083\3\2\2\2-\u0085" + "\3\2\2\2/\u0087\3\2\2\2\61\u008b\3\2\2\2\63\u008d\3\2\2\2\65\u008f\3\2" + "\2\2\67\u0094\3\2\2\29\u00a1\3\2\2\2;\u00a4\3\2\2\2=\u00a8\3\2\2\2?\u00bc" + "\3\2\2\2A\u00be\3\2\2\2C\u00d4\3\2\2\2E\u00d6\3\2\2\2G\u00df\3\2\2\2I" + "\u00e8\3\2\2\2K\u00ea\3\2\2\2M\u00f9\3\2\2\2O\u0100\3\2\2\2QR\7*\2\2R" + "\4\3\2\2\2ST\7+\2\2T\6\3\2\2\2UV\7/\2\2V\b\3\2\2\2WX\7-\2\2X\n\3\2\2\2" + "YZ\7,\2\2Z\f\3\2\2\2[\\\7\61\2\2\\\16\3\2\2\2]^\7\'\2\2^\20\3\2\2\2_`" + "\7@\2\2`\22\3\2\2\2ab\7@\2\2bc\7?\2\2c\24\3\2\2\2de\7>\2\2e\26\3\2\2\2" + "fg\7>\2\2gh\7?\2\2h\30\3\2\2\2ij\7?\2\2jk\7?\2\2k\32\3\2\2\2lm\7#\2\2" + "mn\7?\2\2n\34\3\2\2\2op\7#\2\2p\36\3\2\2\2qr\7(\2\2rs\7(\2\2s \3\2\2\2" + "tu\7~\2\2uv\7~\2\2v\"\3\2\2\2wx\7.\2\2x$\3\2\2\2yz\7k\2\2z{\7h\2\2{&\3" + "\2\2\2|}\7g\2\2}~\7n\2\2~\177\7u\2\2\177\u0080\7g\2\2\u0080(\3\2\2\2\u0081" + "\u0082\7}\2\2\u0082*\3\2\2\2\u0083\u0084\7\177\2\2\u0084,\3\2\2\2\u0085" + "\u0086\7=\2\2\u0086.\3\2\2\2\u0087\u0088\7n\2\2\u0088\u0089\7g\2\2\u0089" + "\u008a\7v\2\2\u008a\60\3\2\2\2\u008b\u008c\7<\2\2\u008c\62\3\2\2\2\u008d" + "\u008e\7?\2\2\u008e\64\3\2\2\2\u008f\u0090\7v\2\2\u0090\u0091\7{\2\2\u0091" + "\u0092\7r\2\2\u0092\u0093\7g\2\2\u0093\66\3\2\2\2\u0094\u0095\7h\2\2\u0095" + "\u0096\7w\2\2\u0096\u0097\7p\2\2\u00978\3\2\2\2\u0098\u0099\7v\2\2\u0099" + "\u009a\7t\2\2\u009a\u009b\7w\2\2\u009b\u00a2\7g\2\2\u009c\u009d\7h\2\2" + "\u009d\u009e\7c\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a2" + "\7g\2\2\u00a1\u0098\3\2\2\2\u00a1\u009c\3\2\2\2\u00a2:\3\2\2\2\u00a3\u00a5" + "\5=\37\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6" + "\u00a7\3\2\2\2\u00a7<\3\2\2\2\u00a8\u00a9\4\62;\2\u00a9>\3\2\2\2\u00aa" + "\u00af\7$\2\2\u00ab\u00ae\5A!\2\u00ac\u00ae\n\2\2\2\u00ad\u00ab\3\2\2" + "\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b0\3\2\2\2\u00af\u00ad" + "\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00bd\7$\2\2\u00b3" + "\u00b8\7)\2\2\u00b4\u00b7\5A!\2\u00b5\u00b7\n\3\2\2\u00b6\u00b4\3\2\2" + "\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b8\u00b6" + "\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bd\7)\2\2\u00bc" + "\u00aa\3\2\2\2\u00bc\u00b3\3\2\2\2\u00bd@\3\2\2\2\u00be\u00c0\7^\2\2\u00bf" + "\u00c1\t\4\2\2\u00c0\u00bf\3\2\2\2\u00c1B\3\2\2\2\u00c2\u00c3\7*\2\2\u00c3" + "\u00c4\5E#\2\u00c4\u00c5\7+\2\2\u00c5\u00c6\7?\2\2\u00c6\u00c7\7@\2\2" + "\u00c7\u00c8\3\2\2\2\u00c8\u00c9\7*\2\2\u00c9\u00ca\5E#\2\u00ca\u00cb" + "\7+\2\2\u00cb\u00d5\3\2\2\2\u00cc\u00cf\5E#\2\u00cd\u00ce\7~\2\2\u00ce" + "\u00d0\5E#\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2" + "\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d5\5E#\2\u00d4\u00c2" + "\3\2\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5D\3\2\2\2\u00d6" + "\u00dc\t\5\2\2\u00d7\u00db\5I%\2\u00d8\u00db\5=\37\2\u00d9\u00db\t\6\2" + "\2\u00da\u00d7\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00de" + "\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00ddF\3\2\2\2\u00de" + "\u00dc\3\2\2\2\u00df\u00e5\t\7\2\2\u00e0\u00e4\5I%\2\u00e1\u00e4\5=\37" + "\2\u00e2\u00e4\t\6\2\2\u00e3\u00e0\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2" + "\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6" + "H\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\t\b\2\2\u00e9J\3\2\2\2\u00ea" + "\u00ee\7%\2\2\u00eb\u00ed\13\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2" + "\2\2\u00ee\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0" + "\u00ee\3\2\2\2\u00f1\u00f3\7\17\2\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3" + "\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7\f\2\2\u00f5\u00f6\3\2\2\2\u00f6" + "\u00f7\b&\2\2\u00f7L\3\2\2\2\u00f8\u00fa\7\17\2\2\u00f9\u00f8\3\2\2\2" + "\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7\f\2\2\u00fc\u00fd" + "\3\2\2\2\u00fd\u00fe\b\'\2\2\u00feN\3\2\2\2\u00ff\u0101\t\t\2\2\u0100" + "\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2" + "\2\2\u0103\u0104\3\2\2\2\u0104\u0105\b(\2\2\u0105P\3\2\2\2\25\2\u00a1" + "\u00a6\u00ad\u00af\u00b6\u00b8\u00bc\u00c0\u00d1\u00d4\u00da\u00dc\u00e3" + "\u00e5\u00ee\u00f2\u00f9\u0102\3\b\2\2";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
	public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};
	public static String[] modeNames = {"DEFAULT_MODE"};

	static {
		RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
	}

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

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}

	public EuphoniumLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	private static String[] makeRuleNames() {
		return new String[]{"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", "T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", "T__25", "T__26", "BOOL", "INT", "DIGIT", "STRING", "ESC", "TYPE", "TYPENAME", "ID", "LETTER", "COMMENT", "NL", "WS"};
	}

	private static String[] makeLiteralNames() {
		return new String[]{null, "'('", "')'", "'-'", "'+'", "'*'", "'/'", "'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'!'", "'&&'", "'||'", "','", "'if'", "'else'", "'{'", "'}'", "';'", "'let'", "':'", "'='", "'type'", "'fun'"};
	}

	private static String[] makeSymbolicNames() {
		return new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "BOOL", "INT", "STRING", "TYPE", "TYPENAME", "ID", "COMMENT", "NL", "WS"};
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
	public String getGrammarFileName() {
		return "Euphonium.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public String[] getChannelNames() {
		return channelNames;
	}

	@Override
	public String[] getModeNames() {
		return modeNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}
}
