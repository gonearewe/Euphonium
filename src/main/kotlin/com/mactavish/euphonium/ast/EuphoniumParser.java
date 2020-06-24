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
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, BOOL = 28, INT = 29, STRING = 30, TYPE = 31, TYPENAME = 32, ID = 33, COMMENT = 34, NL = 35, WS = 36;
	public static final int RULE_expr = 0, RULE_exprStatement = 1, RULE_vardecl = 2, RULE_typedecl = 3, RULE_fundecl = 4;
	public static final String[] ruleNames = makeRuleNames();
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&u\4\2\t\2\4\3\t\3" + "\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3" + "\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2\3\2\3\2\3\2" + "\3\2\3\2\3\2\3\2\5\2-\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2" + "\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2C\n\2\f\2\16\2F\13\2\3\2\3\2\7" + "\2J\n\2\f\2\16\2M\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5" + "\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6j\n\6" + "\f\6\16\6m\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\2\3\2\7\2\4\6\b\n\2\5\3\2" + "\5\6\3\2\7\t\3\2\n\17\2\u0081\2,\3\2\2\2\4N\3\2\2\2\6Q\3\2\2\2\bY\3\2" + "\2\2\n_\3\2\2\2\f\r\b\2\1\2\r\16\7\3\2\2\16\17\5\2\2\2\17\20\7\4\2\2\20" + "-\3\2\2\2\21\22\t\2\2\2\22-\5\2\2\20\23\24\7\20\2\2\24-\5\2\2\f\25\26" + "\7\24\2\2\26\27\7\3\2\2\27\30\5\2\2\2\30\31\7\4\2\2\31\32\5\2\2\2\32\33" + "\7\25\2\2\33\34\5\2\2\b\34-\3\2\2\2\35\"\7\26\2\2\36!\5\6\4\2\37!\5\4" + "\3\2 \36\3\2\2\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2" + "$\"\3\2\2\2%&\5\4\3\2&\'\7\27\2\2\'-\3\2\2\2(-\7#\2\2)-\7 \2\2*-\7\37" + "\2\2+-\7\36\2\2,\f\3\2\2\2,\21\3\2\2\2,\23\3\2\2\2,\25\3\2\2\2,\35\3\2" + "\2\2,(\3\2\2\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-K\3\2\2\2./\f\17\2\2/\60" + "\t\3\2\2\60J\5\2\2\20\61\62\f\16\2\2\62\63\t\2\2\2\63J\5\2\2\17\64\65" + "\f\r\2\2\65\66\t\4\2\2\66J\5\2\2\16\678\f\13\2\289\7\21\2\29J\5\2\2\f" + ":;\f\n\2\2;<\7\22\2\2<J\5\2\2\13=>\f\t\2\2>?\7\3\2\2?D\5\2\2\2@A\7\23" + "\2\2AC\5\2\2\2B@\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2" + "\2\2GH\7\4\2\2HJ\3\2\2\2I.\3\2\2\2I\61\3\2\2\2I\64\3\2\2\2I\67\3\2\2\2" + "I:\3\2\2\2I=\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\3\3\2\2\2MK\3\2\2" + "\2NO\5\2\2\2OP\7\30\2\2P\5\3\2\2\2QR\7\31\2\2RS\7#\2\2ST\7\32\2\2TU\7" + "!\2\2UV\7\33\2\2VW\5\2\2\2WX\7\30\2\2X\7\3\2\2\2YZ\7\34\2\2Z[\7\"\2\2" + "[\\\7\33\2\2\\]\7!\2\2]^\7\30\2\2^\t\3\2\2\2_`\7\35\2\2`a\7#\2\2ab\7\3" + "\2\2bc\7#\2\2cd\7\32\2\2dk\7!\2\2ef\7\23\2\2fg\7#\2\2gh\7\32\2\2hj\7!" + "\2\2ie\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7\4" + "\2\2op\7\32\2\2pq\7!\2\2qr\7\33\2\2rs\5\2\2\2s\13\3\2\2\2\t \",DIKk";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

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

	public EuphoniumParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	private static String[] makeRuleNames() {
		return new String[]{"expr", "exprStatement", "vardecl", "typedecl", "fundecl"};
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
	public ATN getATN() {
		return _ATN;
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

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
				setState(42);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
					case T__0: {
						setState(11);
						match(T__0);
						setState(12);
						expr(0);
						setState(13);
						match(T__1);
					}
					break;
					case T__2:
					case T__3: {
						setState(15);
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
						setState(16);
						expr(14);
					}
					break;
					case T__13: {
						setState(17);
						((ExprContext) _localctx).op = match(T__13);
						setState(18);
						expr(10);
					}
					break;
					case T__17: {
						setState(19);
						match(T__17);
						setState(20);
						match(T__0);
						setState(21);
						expr(0);
						setState(22);
						match(T__1);
						setState(23);
						expr(0);
						setState(24);
						match(T__18);
						setState(25);
						expr(6);
					}
					break;
					case T__19: {
						setState(27);
						match(T__19);
						setState(32);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
						while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
							if (_alt == 1) {
								{
									setState(30);
									_errHandler.sync(this);
									switch (_input.LA(1)) {
										case T__22: {
											setState(28);
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
											setState(29);
											exprStatement();
										}
										break;
										default:
											throw new NoViableAltException(this);
									}
								}
							}
							setState(34);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
						}
						setState(35);
						exprStatement();
						setState(36);
						match(T__20);
					}
					break;
					case ID: {
						setState(38);
						match(ID);
					}
					break;
					case STRING: {
						setState(39);
						match(STRING);
					}
					break;
					case INT: {
						setState(40);
						match(INT);
					}
					break;
					case BOOL: {
						setState(41);
						match(BOOL);
					}
					break;
					default:
						throw new NoViableAltException(this);
				}
				_ctx.stop = _input.LT(-1);
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null) {
							triggerExitRuleEvent();
						}
						_prevctx = _localctx;
						{
							setState(71);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
								case 1: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(44);
									if (!(precpred(_ctx, 13))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 13)");
									}
									setState(45);
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
									setState(46);
									expr(14);
								}
								break;
								case 2: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(47);
									if (!(precpred(_ctx, 12))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 12)");
									}
									setState(48);
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
									setState(49);
									expr(13);
								}
								break;
								case 3: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(50);
									if (!(precpred(_ctx, 11))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 11)");
									}
									setState(51);
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
									setState(52);
									expr(12);
								}
								break;
								case 4: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(53);
									if (!(precpred(_ctx, 9))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 9)");
									}
									setState(54);
									((ExprContext) _localctx).op = match(T__14);
									setState(55);
									expr(10);
								}
								break;
								case 5: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(56);
									if (!(precpred(_ctx, 8))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									}
									setState(57);
									((ExprContext) _localctx).op = match(T__15);
									setState(58);
									expr(9);
								}
								break;
								case 6: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(59);
									if (!(precpred(_ctx, 7))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									}
									setState(60);
									match(T__0);
									setState(61);
									expr(0);
									setState(66);
									_errHandler.sync(this);
									_la = _input.LA(1);
									while (_la == T__16) {
										{
											{
												setState(62);
												match(T__16);
												setState(63);
												expr(0);
											}
										}
										setState(68);
										_errHandler.sync(this);
										_la = _input.LA(1);
									}
									setState(69);
									match(T__1);
								}
								break;
							}
						}
					}
					setState(75);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
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
				setState(76);
				expr(0);
				setState(77);
				match(T__21);
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
				setState(79);
				match(T__22);
				setState(80);
				match(ID);
				setState(81);
				match(T__23);
				setState(82);
				match(TYPE);
				setState(83);
				match(T__24);
				setState(84);
				expr(0);
				setState(85);
				match(T__21);
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
		enterRule(_localctx, 6, RULE_typedecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(87);
				match(T__25);
				setState(88);
				match(TYPENAME);
				setState(89);
				match(T__24);
				setState(90);
				match(TYPE);
				setState(91);
				match(T__21);
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
		enterRule(_localctx, 8, RULE_fundecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(93);
				match(T__26);
				setState(94);
				match(ID);
				setState(95);
				match(T__0);
				setState(96);
				match(ID);
				setState(97);
				match(T__23);
				setState(98);
				match(TYPE);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__16) {
					{
						{
							setState(99);
							match(T__16);
							setState(100);
							match(ID);
							setState(101);
							match(T__23);
							setState(102);
							match(TYPE);
						}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(108);
				match(T__1);
				setState(109);
				match(T__23);
				setState(110);
				match(TYPE);
				setState(111);
				match(T__24);
				setState(112);
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
				return precpred(_ctx, 13);
			case 1:
				return precpred(_ctx, 12);
			case 2:
				return precpred(_ctx, 11);
			case 3:
				return precpred(_ctx, 9);
			case 4:
				return precpred(_ctx, 8);
			case 5:
				return precpred(_ctx, 7);
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

		public TerminalNode ID() {
			return getToken(EuphoniumParser.ID, 0);
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

		public List<TerminalNode> TYPE() {
			return getTokens(EuphoniumParser.TYPE);
		}

		public TerminalNode TYPE(int i) {
			return getToken(EuphoniumParser.TYPE, i);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
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
