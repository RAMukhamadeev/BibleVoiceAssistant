public class StringNumber {
    enum GRAMMAR_TYPE {
        WOMAN,
        MAN,
        NO
    }

    public String stringValue;
    public int intValue;
    public int pow;
    public GRAMMAR_TYPE grammarType;
    public boolean allowRightAddition;

    public StringNumber(String stringValue, int intValue, int pow, GRAMMAR_TYPE grammarType, boolean allowRightAddition) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.pow = pow;
        this.grammarType = grammarType;
        this.allowRightAddition = allowRightAddition;
    }
}
