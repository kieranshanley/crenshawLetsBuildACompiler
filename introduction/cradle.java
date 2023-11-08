import java.io.IOException;

public class cradle {

    static char TAB = '\t';

    static char Look; // Lookahead Character

    // Read New Character From Input Stream
    private static void GetChar() throws IOException {
        Look = (char) System.in.read();
    }

    // Report an Error
    private static void Error(String s) {
        System.out.println();
        System.out.println("Error: " + s + ".");
    }

    // Report Error and Halt
    private static void Abort(String s) {
        Error(s);
        System.exit(1);
    }

    // Report What Was Expected
    private static void Expected(String s) {
        Abort(s + " Expected");
    }

    // Match a Specific Input Character
    private static void Match(char x) throws IOException {
        if (Look == x) {
            GetChar();
        } else {
            Expected("\'" + x + "\'");
        }
    }

    // Recognize an Alpha Character
    private static boolean IsAlpha(char c) {
        char upper = Character.toUpperCase(c);
        return upper >= 'A' && upper <= 'Z';
    }

    // Recognize a Decimal Digit
    private static boolean IsDigit(char c) {
        return Character.isDigit(c);
    }

    //Get an Identifier }
    private static char GetName() throws IOException {
        if (!IsAlpha(Look)) {
            Expected("Name");
        }
        char returnVal = Character.toUpperCase(Look);
        GetChar();
        return returnVal;
    }

    private static char GetNum() throws IOException {
        if (!IsDigit(Look)) {
            Expected("Integer");
            return Look;
        }
        char returnVal = Character.toUpperCase(Look);
        GetChar();
        return returnVal;
    }

    // Output a String with Tab
    private static void Emit(String s) {
        System.out.println(TAB + s);
    }

    // Output a String with Tab and CRLF
    private static void EmitLn(String s) {
        Emit(s);
        System.out.println();
    }

    private static void init() throws IOException {
        GetChar();
    }

    public static void main(String[] args) throws IOException {
        init();
    }

}
