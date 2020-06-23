grammar Euphonium;

expr:   '(' expr ')'
    |   op = ('-'|'+') expr
    |   expr op = ('*'|'/'|'%') expr
    |   expr op = ('+'|'-') expr
    |   expr op = ('>'|'>='|'<'|'<='|'=='|'!=') expr
    |   op = '!' expr
    |   expr op = '&&' expr
    |   expr op = '||' expr
    |   expr '(' expr (',' expr)* ')'              // call function
    |   'if' '(' expr ')' expr 'else' expr
    |   '{' (vardecl|exprStatement)* exprStatement '}'
    |   ID
    |   STRING
    |   INT
    |   BOOL
    ;

exprStatement : expr ';' ;
//expr:   '(' expr ')'
//    |   expr op = BINARY_OP expr
//    |   op = UNARY_OP expr
//    |   expr '(' expr (',' expr)* ')'              // call function
//    |   'if' '(' expr ')' expr 'else' expr
//    |   '{' (vardecl|expr)* expr '}'
//    |   expr ';'
//    |   ID
//    |   STRING
//    |   INT
//    |   BOOL
//    ;
//
//UNARY_OP :  '!'   ;
//
//BINARY_OP : '+'|'-'
//          | '*'|'/'|'%'
//          | '>'|'>='|'<'|'<='|'=='|'!='
//          | '&&'|'||'
//          ;

// function level declration

vardecl : 'let' ID ':' TYPE '=' expr ';' ;

// top level declration

typedecl : 'type' TYPENAME '=' TYPE ';' ;

fundecl : 'fun' ID '(' ID ':' TYPE (',' ID ':' TYPE)* ')' ':' TYPE '=' expr ;

//sublist : sub (',' sub)* ;
//sub :   expr
//    |   ID '='
//    |   ID '=' expr
//    |   STRING '='
//    |   STRING '=' expr
//    |   'NULL' '='
//    |   'NULL' '=' expr
//    |   '...'
//    |
//    ;
BOOL : 'true' | 'false' ;

INT :   DIGIT+ ;

fragment
DIGIT:  '0'..'9' ;

STRING
    :   '"' ( ESC | ~[\\"] )*? '"'
    |   '\'' ( ESC | ~[\\'] )*? '\''
    ;

fragment
ESC :   '\\' ([abtnfrv]|'"'|'\'')   ;

TYPE : '(' TYPENAME ')' '=>' '(' TYPENAME ')'
     | TYPENAME ('|' TYPENAME)+
     | TYPENAME
     ;

TYPENAME : [A-Z] (LETTER|DIGIT|'_'|'$')* ;

//ID  :   '.' (LETTER|'_'|'.') (LETTER|DIGIT|'_'|'.')*
//    |   LETTER (LETTER|DIGIT|'_'|'.')*
//    ;
ID  :   [a-z] (LETTER|DIGIT|'_'|'$')*  ;

fragment LETTER  : [a-zA-Z] ;

COMMENT :   '#' .*? '\r'? '\n' -> skip ;

// Match both UNIX and Windows newlines
NL      :   '\r'? '\n' -> skip ;

WS      :   [ \t]+ -> skip ;
