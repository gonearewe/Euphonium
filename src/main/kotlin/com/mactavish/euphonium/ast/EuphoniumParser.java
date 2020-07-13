// Generated from E:/MyProjects/Euphonium/src/main/kotlin/com/mactavish/euphonium/grammar\Euphonium.g4 by ANTLR 4.8
package com.mactavish.euphonium.ast;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EuphoniumParser extends Parser {
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, BOOL = 30, INT = 31, STRING = 32, TYPE = 33, TYPENAME = 34, ID = 35, COMMENT = 36, NL = 37, WS = 38;

	protected static final DFA[] _decisionToDFA;
	public static final int RULE_expr = 0, RULE_exprStatement = 1, RULE_vardecl = 2, RULE_structdecl = 3, RULE_typedecl = 4, RULE_fundecl = 5;
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0094\4\2\t\2\4" + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2" + "\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2#\n\2\f\2\16\2&\13" + "\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2/\n\2\f\2\16\2\62\13\2\3\2\3\2\3\2\3" + "\2\3\2\3\2\3\2\5\2;\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3" + "\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2Q\n\2\f\2\16\2T\13\2\3\2\3\2\7\2" + "X\n\2\f\2\16\2[\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3" + "\5\3\5\3\5\3\5\3\5\3\5\6\5o\n\5\r\5\16\5p\3\5\3\5\3\6\3\6\3\6\3\6\3\6" + "\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0085\n\7\f\7\16\7\u0088" + "\13\7\5\7\u008a\n\7\3\7\3\7\3\7\5\7\u008f\n\7\3\7\3\7\3\7\3\7\2\3\2\b" + "\2\4\6\b\n\f\2\5\3\2\5\6\3\2\7\t\3\2\n\17\2\u00a4\2:\3\2\2\2\4\\\3\2\2" + "\2\6_\3\2\2\2\bg\3\2\2\2\nt\3\2\2\2\fz\3\2\2\2\16\17\b\2\1\2\17\20\7\3" + "\2\2\20\21\5\2\2\2\21\22\7\4\2\2\22;\3\2\2\2\23\24\t\2\2\2\24;\5\2\2\21" + "\25\26\7\20\2\2\26;\5\2\2\r\27\30\7\24\2\2\30\31\7\3\2\2\31\32\5\2\2\2" + "\32\33\7\4\2\2\33\34\5\2\2\2\34\35\7\25\2\2\35\36\5\2\2\t\36;\3\2\2\2" + "\37$\7\26\2\2 #\5\6\4\2!#\5\4\3\2\" \3\2\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3" + "\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\5\4\3\2()\7\27\2\2);\3\2\2\2" + "*+\7\3\2\2+\60\7%\2\2,-\7\23\2\2-/\7%\2\2.,\3\2\2\2/\62\3\2\2\2\60.\3" + "\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\64\7\4\2\2\64\65\7" + "\30\2\2\65;\5\2\2\7\66;\7%\2\2\67;\7\"\2\28;\7!\2\29;\7 \2\2:\16\3\2\2" + "\2:\23\3\2\2\2:\25\3\2\2\2:\27\3\2\2\2:\37\3\2\2\2:*\3\2\2\2:\66\3\2\2" + "\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;Y\3\2\2\2<=\f\20\2\2=>\t\3\2\2>X\5" + "\2\2\21?@\f\17\2\2@A\t\2\2\2AX\5\2\2\20BC\f\16\2\2CD\t\4\2\2DX\5\2\2\17" + "EF\f\f\2\2FG\7\21\2\2GX\5\2\2\rHI\f\13\2\2IJ\7\22\2\2JX\5\2\2\fKL\f\n" + "\2\2LM\7\3\2\2MR\5\2\2\2NO\7\23\2\2OQ\5\2\2\2PN\3\2\2\2QT\3\2\2\2RP\3" + "\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7\4\2\2VX\3\2\2\2W<\3\2\2\2W?\3" + "\2\2\2WB\3\2\2\2WE\3\2\2\2WH\3\2\2\2WK\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3" + "\2\2\2Z\3\3\2\2\2[Y\3\2\2\2\\]\5\2\2\2]^\7\31\2\2^\5\3\2\2\2_`\7\32\2" + "\2`a\7%\2\2ab\7\33\2\2bc\7#\2\2cd\7\34\2\2de\5\2\2\2ef\7\31\2\2f\7\3\2" + "\2\2gh\7\35\2\2hi\7$\2\2ij\7\34\2\2jn\7\26\2\2kl\7%\2\2lm\7\33\2\2mo\7" + "#\2\2nk\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7\27\2\2s\t" + "\3\2\2\2tu\7\36\2\2uv\7$\2\2vw\7\34\2\2wx\7#\2\2xy\7\31\2\2y\13\3\2\2" + "\2z{\7\37\2\2{|\7%\2\2|\u0089\7\3\2\2}~\7%\2\2~\177\7\33\2\2\177\u0086" + "\7#\2\2\u0080\u0081\7\23\2\2\u0081\u0082\7%\2\2\u0082\u0083\7\33\2\2\u0083" + "\u0085\7#\2\2\u0084\u0080\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2" + "\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0089" + "}\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\7\4\2\2" + "\u008c\u008d\7\33\2\2\u008d\u008f\7#\2\2\u008e\u008c\3\2\2\2\u008e\u008f" + "\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\34\2\2\u0091\u0092\5\2\2\2" + "\u0092\r\3\2\2\2\r\"$\60:RWYp\u0086\u0089\u008e";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	public static final String[] ruleNames = makeRuleNames();
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	static {
		RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
	}

	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
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

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	public EuphoniumParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	private static String[] makeRuleNames() {
		return new String[]{"expr", "exprStatement", "vardecl", "structdecl", "typedecl", "fundecl"};
	}

	private static String[] makeLiteralNames() {
		return new String[]{null, "'('", "')'", "'-'", "'+'", "'*'", "'/'", "'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'!'", "'&&'", "'||'", "','", "'if'", "'else'", "'{'", "'}'", "'=>'", "';'", "'let'", "':'", "'='", "'struct'", "'type'", "'fun'"};
	}

	private static String[] makeSymbolicNames() {
		return new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "BOOL", "INT", "STRING", "TYPE", "TYPENAME", "ID", "COMMENT", "NL", "WS"};
	}

	@Override
	public String getGrammarFileName() {
		return "Euphonium.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames; }

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN; }

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(56);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
					case 1: {
						setState(13);
						match(T__0);
						setState(14);
						expr(0);
						setState(15);
						match(T__1);
					}
					break;
					case 2: {
						setState(17);
						((ExprContext) _localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if (!(_la == T__2 || _la == T__3)) {
							((ExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
						} else {
							if (_input.LA(1) == Token.EOF) {
								matchedEOF = true;
							}
							_errHandler.reportMatch(this);
							consume();
						}
						setState(18);
						expr(15);
					}
					break;
					case 3: {
						setState(19);
						((ExprContext) _localctx).op = match(T__13);
						setState(20);
						expr(11);
					}
					break;
					case 4: {
						setState(21);
						match(T__17);
						setState(22);
						match(T__0);
						setState(23);
						expr(0);
						setState(24);
						match(T__1);
						setState(25);
						expr(0);
						setState(26);
						match(T__18);
						setState(27);
						expr(7);
					}
					break;
					case 5: {
						setState(29);
						match(T__19);
						setState(34);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
						while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
							if (_alt == 1) {
								{
									setState(32);
									_errHandler.sync(this);
									switch (_input.LA(1)) {
										case T__23: {
											setState(30);
											vardecl();
										}
										break;
										case T__0:
										case T__2:
										case T__3:
										case T__13:
										case T__17:
										case T__19:
										case BOOL:
										case INT:
										case STRING:
										case ID: {
											setState(31);
											exprStatement();
										}
										break;
										default:
											throw new NoViableAltException(this);
									}
								}
							}
							setState(36);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
						}
						setState(37);
						exprStatement();
						setState(38);
						match(T__20);
					}
					break;
					case 6: {
						setState(40);
						match(T__0);
						setState(41);
						match(ID);
						setState(46);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == T__16) {
							{
								{
									setState(42);
									match(T__16);
									setState(43);
									match(ID);
								}
							}
							setState(48);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(49);
						match(T__1);
						setState(50);
						match(T__21);
						setState(51);
						expr(5);
					}
					break;
					case 7: {
						setState(52);
						match(ID);
					}
					break;
					case 8: {
						setState(53);
						match(STRING);
					}
					break;
					case 9: {
						setState(54);
						match(INT);
					}
					break;
					case 10: {
						setState(55);
						match(BOOL);
					}
					break;
				}
				_ctx.stop = _input.LT(-1);
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null) {
							triggerExitRuleEvent();
						}
						_prevctx = _localctx;
						{
							setState(85);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
								case 1: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(58);
									if (!(precpred(_ctx, 14))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 14)");
									}
									setState(59);
									((ExprContext) _localctx).op = _input.LT(1);
									_la = _input.LA(1);
									if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0))) {
										((ExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF) {
											matchedEOF = true;
										}
										_errHandler.reportMatch(this);
										consume();
									}
									setState(60);
									expr(15);
								}
								break;
								case 2: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(61);
									if (!(precpred(_ctx, 13))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 13)");
									}
									setState(62);
									((ExprContext) _localctx).op = _input.LT(1);
									_la = _input.LA(1);
									if (!(_la == T__2 || _la == T__3)) {
										((ExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF) {
											matchedEOF = true;
										}
										_errHandler.reportMatch(this);
										consume();
									}
									setState(63);
									expr(14);
								}
								break;
								case 3: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(64);
									if (!(precpred(_ctx, 12))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 12)");
									}
									setState(65);
									((ExprContext) _localctx).op = _input.LT(1);
									_la = _input.LA(1);
									if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0))) {
										((ExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF) {
											matchedEOF = true;
										}
										_errHandler.reportMatch(this);
										consume();
									}
									setState(66);
									expr(13);
								}
								break;
								case 4: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(67);
									if (!(precpred(_ctx, 10))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 10)");
									}
									setState(68);
									((ExprContext) _localctx).op = match(T__14);
									setState(69);
									expr(11);
								}
								break;
								case 5: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(70);
									if (!(precpred(_ctx, 9))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 9)");
									}
									setState(71);
									((ExprContext) _localctx).op = match(T__15);
									setState(72);
									expr(10);
								}
								break;
								case 6: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(73);
									if (!(precpred(_ctx, 8))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									}
									setState(74);
									match(T__0);
									setState(75);
									expr(0);
									setState(80);
									_errHandler.sync(this);
									_la = _input.LA(1);
									while (_la == T__16) {
										{
											{
												setState(76);
												match(T__16);
												setState(77);
												expr(0);
											}
										}
										setState(82);
										_errHandler.sync(this);
										_la = _input.LA(1);
									}
									setState(83);
									match(T__1);
								}
								break;
							}
						}
					}
					setState(89);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public final ExprStatementContext exprStatement() throws RecognitionException {
		ExprStatementContext _localctx = new ExprStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exprStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(90);
				expr(0);
				setState(91);
				match(T__22);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(93);
				match(T__23);
				setState(94);
				match(ID);
				setState(95);
				match(T__24);
				setState(96);
				match(TYPE);
				setState(97);
				match(T__25);
				setState(98);
				expr(0);
				setState(99);
				match(T__22);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final StructdeclContext structdecl() throws RecognitionException {
		StructdeclContext _localctx = new StructdeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(101);
				match(T__26);
				setState(102);
				match(TYPENAME);
				setState(103);
				match(T__25);
				setState(104);
				match(T__19);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(105);
							match(ID);
							setState(106);
							match(T__24);
							setState(107);
							match(TYPE);
						}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while (_la == ID);
				setState(112);
				match(T__20);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final TypedeclContext typedecl() throws RecognitionException {
		TypedeclContext _localctx = new TypedeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typedecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(114);
				match(T__27);
				setState(115);
				match(TYPENAME);
				setState(116);
				match(T__25);
				setState(117);
				match(TYPE);
				setState(118);
				match(T__22);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final FundeclContext fundecl() throws RecognitionException {
		FundeclContext _localctx = new FundeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fundecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(120);
				match(T__28);
				setState(121);
				match(ID);
				setState(122);
				match(T__0);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == ID) {
					{
						setState(123);
						match(ID);
						setState(124);
						match(T__24);
						setState(125);
						match(TYPE);
						setState(132);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == T__16) {
							{
								{
									setState(126);
									match(T__16);
									setState(127);
									match(ID);
									setState(128);
									match(T__24);
									setState(129);
									match(TYPE);
								}
							}
							setState(134);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
					}
				}

				setState(137);
				match(T__1);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__24) {
					{
						setState(138);
						match(T__24);
						setState(139);
						match(TYPE);
					}
				}

				setState(142);
				match(T__25);
				setState(143);
				expr(0);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
			case 0:
				return expr_sempred((ExprContext) _localctx, predIndex);
		}
		return true;
	}

	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
			case 0:
				return precpred(_ctx, 14);
			case 1:
				return precpred(_ctx, 13);
			case 2:
				return precpred(_ctx, 12);
			case 3:
				return precpred(_ctx, 10);
			case 4:
				return precpred(_ctx, 9);
			case 5:
				return precpred(_ctx, 8);
		}
		return true;
	}

	public static class ExprContext extends ParserRuleContext {
		public Token op;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class, i);
		}

		public List<ExprStatementContext> exprStatement() {
			return getRuleContexts(ExprStatementContext.class);
		}

		public ExprStatementContext exprStatement(int i) {
			return getRuleContext(ExprStatementContext.class, i);
		}

		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}

		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class, i);
		}

		public List<TerminalNode> ID() {
			return getTokens(EuphoniumParser.ID);
		}

		public TerminalNode ID(int i) {
			return getToken(EuphoniumParser.ID, i);
		}

		public TerminalNode STRING() {
			return getToken(EuphoniumParser.STRING, 0);
		}

		public TerminalNode INT() {
			return getToken(EuphoniumParser.INT, 0);
		}

		public TerminalNode BOOL() {
			return getToken(EuphoniumParser.BOOL, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_expr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).enterExpr(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).exitExpr(this);
			}
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof EuphoniumVisitor) {
				return ((EuphoniumVisitor<? extends T>) visitor).visitExpr(this);
			} else {
				return visitor.visitChildren(this);
			}
		}
	}

	public static class ExprStatementContext extends ParserRuleContext {
		public ExprStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_exprStatement;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).enterExprStatement(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).exitExprStatement(this);
			}
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof EuphoniumVisitor) {
				return ((EuphoniumVisitor<? extends T>) visitor).visitExprStatement(this);
			} else {
				return visitor.visitChildren(this);
			}
		}
	}

	public static class VardeclContext extends ParserRuleContext {
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode ID() {
			return getToken(EuphoniumParser.ID, 0);
		}

		public TerminalNode TYPE() {
			return getToken(EuphoniumParser.TYPE, 0);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_vardecl;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).enterVardecl(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).exitVardecl(this);
			}
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof EuphoniumVisitor) {
				return ((EuphoniumVisitor<? extends T>) visitor).visitVardecl(this);
			} else {
				return visitor.visitChildren(this);
			}
		}
	}

	public static class StructdeclContext extends ParserRuleContext {
		public StructdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode TYPENAME() {
			return getToken(EuphoniumParser.TYPENAME, 0);
		}

		public List<TerminalNode> ID() {
			return getTokens(EuphoniumParser.ID);
		}

		public TerminalNode ID(int i) {
			return getToken(EuphoniumParser.ID, i);
		}

		public List<TerminalNode> TYPE() {
			return getTokens(EuphoniumParser.TYPE);
		}

		public TerminalNode TYPE(int i) {
			return getToken(EuphoniumParser.TYPE, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_structdecl;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).enterStructdecl(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).exitStructdecl(this);
			}
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof EuphoniumVisitor) {
				return ((EuphoniumVisitor<? extends T>) visitor).visitStructdecl(this);
			} else {
				return visitor.visitChildren(this);
			}
		}
	}

	public static class TypedeclContext extends ParserRuleContext {
		public TypedeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode TYPENAME() {
			return getToken(EuphoniumParser.TYPENAME, 0);
		}

		public TerminalNode TYPE() {
			return getToken(EuphoniumParser.TYPE, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_typedecl;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).enterTypedecl(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).exitTypedecl(this);
			}
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof EuphoniumVisitor) {
				return ((EuphoniumVisitor<? extends T>) visitor).visitTypedecl(this);
			} else {
				return visitor.visitChildren(this);
			}
		}
	}

	public static class FundeclContext extends ParserRuleContext {
		public FundeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<TerminalNode> ID() {
			return getTokens(EuphoniumParser.ID);
		}

		public TerminalNode ID(int i) {
			return getToken(EuphoniumParser.ID, i);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public List<TerminalNode> TYPE() {
			return getTokens(EuphoniumParser.TYPE);
		}

		public TerminalNode TYPE(int i) {
			return getToken(EuphoniumParser.TYPE, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_fundecl;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).enterFundecl(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof EuphoniumListener) {
				((EuphoniumListener) listener).exitFundecl(this);
			}
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof EuphoniumVisitor) {
				return ((EuphoniumVisitor<? extends T>) visitor).visitFundecl(this);
			} else {
				return visitor.visitChildren(this);
			}
		}
	}
}
