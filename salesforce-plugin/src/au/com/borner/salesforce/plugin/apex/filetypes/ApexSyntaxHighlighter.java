/*
 * Copyright 2014 Mark Borner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package au.com.borner.salesforce.plugin.apex.filetypes;

import au.com.borner.salesforce.plugin.apex.lexer.ApexLexer;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static au.com.borner.salesforce.plugin.apex.psi.ApexTypes.*;

/**
 * An Apex Syntax Highlighter for highlighting keywords and literals
 *
 * Created by mark
 */
public class ApexSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Map<IElementType, TextAttributesKey> textAttributeMap;

    static {
        textAttributeMap = new HashMap<IElementType, TextAttributesKey>();

        fillMap(textAttributeMap, getKeywordTokens(), DefaultLanguageHighlighterColors.KEYWORD);
        fillMap(textAttributeMap, getPrimitives(), DefaultLanguageHighlighterColors.KEYWORD);

        textAttributeMap.put(COMMA, DefaultLanguageHighlighterColors.COMMA);
        textAttributeMap.put(SEMI, DefaultLanguageHighlighterColors.SEMICOLON);
        textAttributeMap.put(DOT, DefaultLanguageHighlighterColors.DOT);

        fillMap(textAttributeMap, TokenSet.create(LBRACE, RBRACE), DefaultLanguageHighlighterColors.BRACES);
        fillMap(textAttributeMap, TokenSet.create(LBRACK, RBRACK), DefaultLanguageHighlighterColors.BRACKETS);
        fillMap(textAttributeMap, TokenSet.create(INTEGER_LITERAL, LONG_LITERAL, DECIMAL_LITERAL), DefaultLanguageHighlighterColors.NUMBER);
        textAttributeMap.put(STRING_LITERAL, DefaultLanguageHighlighterColors.STRING);

        textAttributeMap.put(IDENTIFIER, DefaultLanguageHighlighterColors.IDENTIFIER);

        textAttributeMap.put(COMMENT, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
        textAttributeMap.put(LINE_COMMENT, DefaultLanguageHighlighterColors.LINE_COMMENT);

        textAttributeMap.put(TokenType.BAD_CHARACTER, HighlighterColors.BAD_CHARACTER);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ApexLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(textAttributeMap.get(tokenType));
    }

    private static TokenSet getKeywordTokens() {
        return TokenSet.create(CLASS_KEYWORD, TRUE, FALSE, PRIVATE, PUBLIC, GLOBAL,
                VIRTUAL, ABSTRACT, WITH, SHARING, WITHOUT, EXTENDS, IMPLEMENTS, INTERFACE, TRIGGER,
                ON, BEFORE, INSERT, UPDATE, DELETE, AFTER, UNDELETE, VOID, STATIC, RETURN, THROW,
                BREAK, CONTINUE, IF, ELSE, FOR, WHILE, TRY, CATCH, FINALLY, FINAL, SUPER, THIS,
                TRANSIENT, ENUM);
    }

    private static TokenSet getPrimitives() {
        return TokenSet.create(BLOB, BOOLEAN, DATE, DATETIME, DECIMAL, DOUBLE, ID, INTEGER, LONG, STRING,
                TIME, MAP, LIST, SET);
    }

}
