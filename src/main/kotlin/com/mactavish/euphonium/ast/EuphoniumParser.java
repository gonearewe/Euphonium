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
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, BOOL = 29, INT = 30, STRING = 31, TYPE = 32, TYPENAME = 33, ID = 34, COMMENT = 35, NL = 36, WS = 37;
	public static final int RULE_expr = 0, RULE_exprStatement = 1, RULE_vardecl = 2, RULE_typedecl = 3, RULE_fundecl = 4;
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0085\4\2\t\2\4" + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2" + "\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2\3\2\3" + "\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\61\n\2\f\2\16\2\64\13\2\3\2" + "\3\2\3\2\3\2\3\2\3\2\3\2\5\2=\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2" + "\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2S\n\2\f\2\16\2V\13\2\3" + "\2\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4" + "\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7" + "\6z\n\6\f\6\16\6}\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\2\3\2\7\2\4\6\b\n\2" + "\5\3\2\5\6\3\2\7\t\3\2\n\17\2\u0093\2<\3\2\2\2\4^\3\2\2\2\6a\3\2\2\2\b" + "i\3\2\2\2\no\3\2\2\2\f\r\b\2\1\2\r\16\7\3\2\2\16\17\5\2\2\2\17\20\7\4" + "\2\2\20=\3\2\2\2\21\22\t\2\2\2\22=\5\2\2\21\23\24\7\20\2\2\24=\5\2\2\r" + "\25\26\7\24\2\2\26\27\7\3\2\2\27\30\5\2\2\2\30\31\7\4\2\2\31\32\5\2\2" + "\2\32\33\7\25\2\2\33\34\5\2\2\t\34=\3\2\2\2\35\"\7\26\2\2\36!\5\6\4\2" + "\37!\5\4\3\2 \36\3\2\2\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#" + "%\3\2\2\2$\"\3\2\2\2%&\5\4\3\2&\'\7\27\2\2\'=\3\2\2\2()\7\3\2\2)*\7$\2" + "\2*+\7\30\2\2+\62\7\"\2\2,-\7\23\2\2-.\7$\2\2./\7\30\2\2/\61\7\"\2\2\60" + ",\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62" + "\3\2\2\2\65\66\7\4\2\2\66\67\7\31\2\2\67=\5\2\2\78=\7$\2\29=\7!\2\2:=" + "\7 \2\2;=\7\37\2\2<\f\3\2\2\2<\21\3\2\2\2<\23\3\2\2\2<\25\3\2\2\2<\35" + "\3\2\2\2<(\3\2\2\2<8\3\2\2\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=[\3\2\2\2>" + "?\f\20\2\2?@\t\3\2\2@Z\5\2\2\21AB\f\17\2\2BC\t\2\2\2CZ\5\2\2\20DE\f\16" + "\2\2EF\t\4\2\2FZ\5\2\2\17GH\f\f\2\2HI\7\21\2\2IZ\5\2\2\rJK\f\13\2\2KL" + "\7\22\2\2LZ\5\2\2\fMN\f\n\2\2NO\7\3\2\2OT\5\2\2\2PQ\7\23\2\2QS\5\2\2\2" + "RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\4\2\2" + "XZ\3\2\2\2Y>\3\2\2\2YA\3\2\2\2YD\3\2\2\2YG\3\2\2\2YJ\3\2\2\2YM\3\2\2\2" + "Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\3\3\2\2\2][\3\2\2\2^_\5\2\2\2_`\7\32" + "\2\2`\5\3\2\2\2ab\7\33\2\2bc\7$\2\2cd\7\30\2\2de\7\"\2\2ef\7\34\2\2fg" + "\5\2\2\2gh\7\32\2\2h\7\3\2\2\2ij\7\35\2\2jk\7#\2\2kl\7\34\2\2lm\7\"\2" + "\2mn\7\32\2\2n\t\3\2\2\2op\7\36\2\2pq\7$\2\2qr\7\3\2\2rs\7$\2\2st\7\30" + "\2\2t{\7\"\2\2uv\7\23\2\2vw\7$\2\2wx\7\30\2\2xz\7\"\2\2yu\3\2\2\2z}\3" + "\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7\4\2\2\177\u0080" + "\7\30\2\2\u0080\u0081\7\"\2\2\u0081\u0082\7\34\2\2\u0082\u0083\5\2\2\2" + "\u0083\13\3\2\2\2\n \"\62<TY[{";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
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
		return new String[]{"expr", "exprStatement", "vardecl", "typedecl", "fundecl"};
	}

	private static String[] makeLiteralNames() {
		return new String[]{null, "'('", "')'", "'-'", "'+'", "'*'", "'/'", "'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'!'", "'&&'", "'||'", "','", "'if'", "'else'", "'{'", "'}'", "':'", "'=>'", "';'", "'let'", "'='", "'type'", "'fun'"};
	}

	private static String[] makeSymbolicNames() {
		return new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "BOOL", "INT", "STRING", "TYPE", "TYPENAME", "ID", "COMMENT", "NL", "WS"};
	}

	@Override
	public String getGrammarFileName() {
		return "Euphonium.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN;
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
				setState(58);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
					case 1: {
						setState(11);
						match(T__0);
						setState(12);
						expr(0);
						setState(13);
						match(T__1);
					}
					break;
					case 2: {
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
						expr(15);
					}
					break;
					case 3: {
						setState(17);
						((ExprContext) _localctx).op = match(T__13);
						setState(18);
						expr(11);
					}
					break;
					case 4: {
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
						expr(7);
					}
					break;
					case 5: {
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
										case T__24: {
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
					case 6: {
						setState(38);
						match(T__0);
						setState(39);
						match(ID);
						setState(40);
						match(T__21);
						setState(41);
						match(TYPE);
						setState(48);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == T__16) {
							{
								{
									setState(42);
									match(T__16);
									setState(43);
									match(ID);
									setState(44);
									match(T__21);
									setState(45);
									match(TYPE);
								}
							}
							setState(50);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(51);
						match(T__1);
						setState(52);
						match(T__22);
						setState(53);
						expr(5);
					}
					break;
					case 7: {
						setState(54);
						match(ID);
					}
					break;
					case 8: {
						setState(55);
						match(STRING);
					}
					break;
					case 9: {
						setState(56);
						match(INT);
					}
					break;
					case 10: {
						setState(57);
						match(BOOL);
					}
					break;
				}
				_ctx.stop = _input.LT(-1);
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null) {
							triggerExitRuleEvent();
						}
						_prevctx = _localctx;
						{
							setState(87);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
								case 1: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(60);
									if (!(precpred(_ctx, 14))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 14)");
									}
									setState(61);
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
									setState(62);
									expr(15);
								}
								break;
								case 2: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(63);
									if (!(precpred(_ctx, 13))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 13)");
									}
									setState(64);
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
									setState(65);
									expr(14);
								}
								break;
								case 3: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(66);
									if (!(precpred(_ctx, 12))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 12)");
									}
									setState(67);
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
									setState(68);
									expr(13);
								}
								break;
								case 4: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(69);
									if (!(precpred(_ctx, 10))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 10)");
									}
									setState(70);
									((ExprContext) _localctx).op = match(T__14);
									setState(71);
									expr(11);
								}
								break;
								case 5: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(72);
									if (!(precpred(_ctx, 9))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 9)");
									}
									setState(73);
									((ExprContext) _localctx).op = match(T__15);
									setState(74);
									expr(10);
								}
								break;
								case 6: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(75);
									if (!(precpred(_ctx, 8))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									}
									setState(76);
									match(T__0);
									setState(77);
									expr(0);
									setState(82);
									_errHandler.sync(this);
									_la = _input.LA(1);
									while (_la == T__16) {
										{
											{
												setState(78);
												match(T__16);
												setState(79);
												expr(0);
											}
										}
										setState(84);
										_errHandler.sync(this);
										_la = _input.LA(1);
									}
									setState(85);
									match(T__1);
								}
								break;
							}
						}
					}
					setState(91);
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
				setState(92);
				expr(0);
				setState(93);
				match(T__23);
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
				setState(95);
				match(T__24);
				setState(96);
				match(ID);
				setState(97);
				match(T__21);
				setState(98);
				match(TYPE);
				setState(99);
				match(T__25);
				setState(100);
				expr(0);
				setState(101);
				match(T__23);
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
				setState(103);
				match(T__26);
				setState(104);
				match(TYPENAME);
				setState(105);
				match(T__25);
				setState(106);
				match(TYPE);
				setState(107);
				match(T__23);
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
				setState(109);
				match(T__27);
				setState(110);
				match(ID);
				setState(111);
				match(T__0);
				setState(112);
				match(ID);
				setState(113);
				match(T__21);
				setState(114);
				match(TYPE);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__16) {
					{
						{
							setState(115);
							match(T__16);
							setState(116);
							match(ID);
							setState(117);
							match(T__21);
							setState(118);
							match(TYPE);
						}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				match(T__1);
				setState(125);
				match(T__21);
				setState(126);
				match(TYPE);
				setState(127);
				match(T__25);
				setState(128);
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

		public List<TerminalNode> TYPE() {
			return getTokens(EuphoniumParser.TYPE);
		}

		public TerminalNode TYPE(int i) {
			return getToken(EuphoniumParser.TYPE, i);
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
