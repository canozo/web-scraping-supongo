package textmining;

%%

%unicode
%int
%public
%line
%column
%class Cleaner
%state TAG
%state ENDL

%{
  public static String archivoInput = "inputs/home.html";
  public StringBuffer buffer = new StringBuffer();
%}

%eof{
%eof}

endline = (\r|\n|\r\n)+
espacios = [ \t]+

%%

<YYINITIAL> {
  "<"        { yybegin(TAG); }
  "</"       { yybegin(TAG); }
  {endline}  { yybegin(ENDL); }
  {espacios} { buffer.append(' '); }
  .          { buffer.append(yytext()); }
}

<TAG> {
  ">"        { yybegin(YYINITIAL); }
  "/>"       { yybegin(YYINITIAL); }
  {endline}  { /* skip saltos de linea */ }
   .         { /* skip texto dentro del tag */ }
}

<ENDL> {
  {endline}  { /* skip saltos de linea */ }
  {espacios} { /* skip espacios */ }
  .          {
          if (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) != '\n') {
              buffer.append('\n');
          }
          yypushback(yylength());
          yybegin(YYINITIAL);
      }
}

[^] {
  System.out.println("Error!");
  System.out.println("Linea " + yyline);
  System.out.println("Columna " + yycolumn);
  System.out.println("Input " + yytext());

  throw new Error("Error, caracter ilegal!");
}
