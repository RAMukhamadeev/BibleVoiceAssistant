public class StringNumber {
    public String stringValue;
    public int intValue;
    public int pow;
    public boolean allowRightAddition;

    public StringNumber(String stringValue, int intValue, boolean allowRightAddition) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.pow = String.valueOf(intValue).length();
        this.allowRightAddition = allowRightAddition;
    }
}
