package au.com.borner.salesforce.plugin.apex.lexer;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static au.com.borner.salesforce.plugin.apex.psi.ApexTypes.*;

%%

%{
  public _ApexLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _ApexLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

LINE_COMMENT="//".*
COMMENT="/"\*(.|\n)*\*"/"
IDENTIFIER=[a-zA-Z$_][a-zA-Z0-9$_]*
STRING_LITERAL='(\\b|\\t|\\n|\\f|\\r|\\'|\'|\\|.)*'
INTEGER_LITERAL=-?[0-9]*
DECIMAL_LITERAL=-?[0-9]*\.[0-9]*
LONG_LITERAL=-?[0-9]*L

%%
<YYINITIAL> {
  {WHITE_SPACE}          { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "class"                { return CLASS_KEYWORD; }
  "("                    { return LPAREN; }
  ")"                    { return RPAREN; }
  "{"                    { return LBRACE; }
  "}"                    { return RBRACE; }
  "["                    { return LBRACK; }
  "]"                    { return RBRACK; }
  ";"                    { return SEMI; }
  ","                    { return COMMA; }
  "."                    { return DOT; }
  "@"                    { return AT_SIGN; }
  "="                    { return OPERATOR_ASSIGNMENT; }
  ">"                    { return OPERATOR_GREATER_THAN; }
  "<"                    { return OPERATOR_LESS_THAN; }
  "!"                    { return OPERATOR_NOT; }
  "?"                    { return OPERATOR_TERNARY; }
  ":"                    { return OPERATOR_COLON; }
  "=="                   { return OPERATOR_EQUALITY; }
  "==="                  { return OPERATOR_EXACT_EQUALITY; }
  "<="                   { return OPERATOR_LESS_THAN_EQUAL; }
  ">="                   { return OPERATOR_GREATER_THAN_EQUAL; }
  "!="                   { return OPERATOR_INEQUALITY; }
  "!=="                  { return OPERATOR_EXACT_INEQUALITY; }
  "&&"                   { return OPERATOR_AND; }
  "||"                   { return OPERATOR_OR; }
  "++"                   { return OPERATOR_INCREMENT; }
  "--"                   { return OPERATOR_DECREMENT; }
  "+"                    { return OPERATOR_ADDITION; }
  "-"                    { return OPERATOR_SUBTRACTION; }
  "*"                    { return OPERATOR_MULTIPLICATION; }
  "/"                    { return OPERATOR_DIVSION; }
  "&"                    { return OPERATOR_BITWISE_AND; }
  "|"                    { return OPERATOR_BITWISE_OR; }
  "+="                   { return OPERATOR_ADDITION_ASSIGNMENT; }
  "-="                   { return OPERATOR_SUBTRACTION_ASSIGNMENT; }
  "*="                   { return OPERATOR_MULTIPLICATION_ASSIGNMENT; }
  "/="                   { return OPERATOR_DIVISION_ASSIGNMENT; }
  "&="                   { return OPERATOR_AND_ASSIGNMENT; }
  "|="                   { return OPERATOR_OR_ASSIGNMENT; }
  "^="                   { return OPERATOR_BITWISE_EXCLUSIVE_OR2; }
  "^"                    { return OPERATOR_BITWISE_EXCLUSIVE_OR1; }
  "<<="                  { return OPERATOR_BITWISE_SHIFT_LEFT_ASSIGNMENT; }
  ">>="                  { return OPERATOR_BITWISE_SHIFT_RIGHT_ASSIGNMENT; }
  ">>>="                 { return OPERATOR_BITWISE_SHIFT_RIGHT_UNSIGNED_ASSIGNMENT; }
  "public"               { return PUBLIC; }
  "private"              { return PRIVATE; }
  "global"               { return GLOBAL; }
  "protected"            { return PROTECTED; }
  "virtual"              { return VIRTUAL; }
  "abstract"             { return ABSTRACT; }
  "with"                 { return WITH; }
  "sharing"              { return SHARING; }
  "without"              { return WITHOUT; }
  "extends"              { return EXTENDS; }
  "implements"           { return IMPLEMENTS; }
  "interface"            { return INTERFACE; }
  "trigger"              { return TRIGGER; }
  "on"                   { return ON; }
  "before"               { return BEFORE; }
  "insert"               { return INSERT; }
  "update"               { return UPDATE; }
  "delete"               { return DELETE; }
  "after"                { return AFTER; }
  "undelete"             { return UNDELETE; }
  "enum"                 { return ENUM; }
  "static"               { return STATIC; }
  "void"                 { return VOID; }
  "transient"            { return TRANSIENT; }
  "Blob"                 { return BLOB; }
  "Boolean"              { return BOOLEAN; }
  "Date"                 { return DATE; }
  "Datetime"             { return DATETIME; }
  "Decimal"              { return DECIMAL; }
  "Double"               { return DOUBLE; }
  "ID"                   { return ID; }
  "Integer"              { return INTEGER; }
  "Long"                 { return LONG; }
  "String"               { return STRING; }
  "Time"                 { return TIME; }
  "List"                 { return LIST; }
  "Set"                  { return SET; }
  "Map"                  { return MAP; }
  "final"                { return FINAL; }
  "return"               { return RETURN; }
  "throw"                { return THROW; }
  "break"                { return BREAK; }
  "continue"             { return CONTINUE; }
  "if"                   { return IF; }
  "else"                 { return ELSE; }
  "for"                  { return FOR; }
  "while"                { return WHILE; }
  "do"                   { return DO; }
  "try"                  { return TRY; }
  "catch"                { return CATCH; }
  "finally"              { return FINALLY; }
  "instanceof"           { return INSTANCEOF; }
  "new"                  { return NEW; }
  "this"                 { return THIS; }
  "super"                { return SUPER; }
  "typeList"             { return TYPELIST; }
  "typeArguments"        { return TYPEARGUMENTS; }
  "null"                 { return NULL; }
  "true"                 { return TRUE; }
  "false"                { return FALSE; }

  {LINE_COMMENT}         { return LINE_COMMENT; }
  {COMMENT}              { return COMMENT; }
  {IDENTIFIER}           { return IDENTIFIER; }
  {STRING_LITERAL}       { return STRING_LITERAL; }
  {INTEGER_LITERAL}      { return INTEGER_LITERAL; }
  {DECIMAL_LITERAL}      { return DECIMAL_LITERAL; }
  {LONG_LITERAL}         { return LONG_LITERAL; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
