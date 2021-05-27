public class StringNumber {
    public String stringValue;
    public int intValue;
    public boolean allowRightAddition;

    public int getPow() {
        return String.valueOf(intValue).length();
    }

    public StringNumber() {

    }

    public StringNumber(String stringValue, int intValue, boolean allowRightAddition) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.allowRightAddition = allowRightAddition;
    }
}
