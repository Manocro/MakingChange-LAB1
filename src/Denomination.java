
public record Denomination(String name, double amt, String form, String img) {
    //PREDEFINED DENOMINATIONS
    //BILLS
    public static final Denomination HUNDRED_BILL = new Denomination("Hundred Dollar Bill", 100.0, "bill", "hundred_note.png");
    public static final Denomination FIFTY_BILL = new Denomination("Fifty Dollar Bill", 50.0, "bill", "fifty_note.png");
    public static final Denomination TWENTY_BILL = new Denomination("Twenty Dollar Bill", 20.0, "bill", "twenty_note.png");
    public static final Denomination TEN_BILL = new Denomination("Ten Dollar Bill", 10.0, "bill", "ten_note.png");
    public static final Denomination FIVE_BILL = new Denomination("Five Dollar Bill", 5.0, "bill", "five_note.png");
    public static final Denomination ONE_BILL = new Denomination("One Dollar Bill", 1.0, "bill", "one_note.png");
    //COINS
    public static final Denomination QUARTER = new Denomination("Quarter", 0.25, "coin", "quarter.png");
    public static final Denomination DIME = new Denomination("Dime", 0.10, "coin", "dime.png");
    public static final Denomination NICKLE = new Denomination("Nickle", 0.05, "coin", "nickle.png");
    public static final Denomination PENNY = new Denomination("Penny", 0.01, "coin", "penny.png");


    public String toString() {
        return String.format("Denomination[name=%s, amt=%.2f, form=%s, img=%s]", name, amt, form, img);
    }
}
