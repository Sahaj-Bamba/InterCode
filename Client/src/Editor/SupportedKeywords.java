package Editor;

import java.util.ArrayList;

/**
 * <h1>A class to store the programming language keywords and
 * provide access to them.</h1>
 *
 * <p>Makes multiple language support possible and makes adding new language
 * support convenient. To add more keywords, add a string array and getters
 * to this class. Then, update the switch statement in UI.java.</p>
 */
public class SupportedKeywords {

    private String[] keywords = {
            //  Java keywords
            "abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "System", "out",
            "new", "null", "package", "private", "protected", "public", "interface",
            "long", "native", "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while", "String",
            // cpp keywords
            "auto", "const", "double", "float", "int", "short",
            "struct", "unsigned", "break", "continue", "else", "for", "long", "signed",
            "switch", "void", "case", "default", "enum", "goto", "register", "sizeof",
            "typedef", "volatile", "char", "do", "extern", "if", "return", "static",
            "union", "while", "asm", "dynamic_cast", "namespace", "reinterpret_cast", "try",
            "bool", "explicit", "new", "static_cast", "typeid", "catch", "false", "operator",
            "template", "typename", "class", "friend", "private", "this", "using", "const_cast",
            "inline", "public", "throw", "virtual", "delete", "mutable", "protected", "true" };


    private String[] brackets = { "{", "(" };
    private String[] bCompletions = { "}", ")" };

    public String[] getKeywords(){
        return keywords;
    }

    public ArrayList<String> getbracketCompletions() {
        ArrayList<String> al = new ArrayList<>();
        for(String completion : bCompletions) {
            al.add(completion);
        }
        return al;
    }

    public ArrayList<String> getbrackets() {
        ArrayList<String> al = new ArrayList<>();
        for(String completion : brackets) {
            al.add(completion);
        }
        return al;
    }

    public ArrayList<String> setKeywords(String[] arr) {
        ArrayList<String> al = new ArrayList<>();
        for(String words : arr) {
            al.add(words);
        }
        return al;
    }

}
