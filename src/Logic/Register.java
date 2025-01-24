package Logic;

import java.util.List;
import java.util.Scanner;

public class Register {
    private static final List<Denomination> DENOMINATIONS = List.of(
            Denomination.HUNDRED_BILL,
            Denomination.FIFTY_BILL,
            Denomination.TWENTY_BILL,
            Denomination.TEN_BILL,
            Denomination.FIVE_BILL,
            Denomination.ONE_BILL,
            Denomination.QUARTER,
            Denomination.DIME,
            Denomination.NICKLE,
            Denomination.PENNY
    );

    public Purse makeChange(double amt) {
        if (amt < 0.005) {
            throw new IllegalArgumentException("Empty Purse!");
        }

        Purse purse = new Purse();
        for (Denomination denom : DENOMINATIONS) {
            int count = (int) (amt / denom.amt());
            if (count > 0) {
                purse.add(denom, count);
                amt -= count * denom.amt();
                amt = Math.round(amt * 100.0) / 100.0; //JUST TO AVOID FLOATING-POINT ISSUES
            }
        }

        // Round the amount up to the nearest penny if it's at least 0.005
        amt = Math.ceil(amt * 100.0) / 100.0;
        if (amt >= 0.01) {  // Only add penny if the remainder is at least 1 cent
            purse.add(Denomination.PENNY, (int) (amt * 100));
        }
        return purse;
    }

    public static void main(String[] args) {
        Register register = new Register();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount of to make change for: $");
        double amount = scanner.nextDouble();
        try {
            Purse changePurse = register.makeChange(amount);

            System.out.println("Change for $" + amount + ":");
            System.out.println(changePurse);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
