grammar Euphonium;

expr:   ('-'|'+') expr
    |   expr ('*'|'/'|'%') expr
    |   expr ('+'|'-') expr
    |   expr ('>'|'>='|'<'|'<='|'=='|'!=') expr
    |   '!' expr
    |   expr '&&' expr
    |   expr '||' expr
    |   expr '(' expr (',' expr)* ')'              // call function
    |   'if' '(' expr ')' expr 'else' expr
    |   '{' (vardecl|(expr NL))* expr NL? '}'
    |   ID
    |   STRING
    |   INT
    |   BOOL
    ;

// function level declration

vardecl : 'let' ID ':' TYPE '=' expr NL;

// top level declration

typedecl : 'type' TYPENAME '=' TYPE NL ;

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

COMMENT :   '#' .*? '\r'? '\n' -> type(NL) ;

// Match both UNIX and Windows newlines
NL      :   '\r'? '\n' ;

WS      :   [ \t]+ -> skip ;
