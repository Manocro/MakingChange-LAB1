package Logic;

import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash;

    public Purse() {
        this.cash = new HashMap<>();
    }

    public void add(Denomination type, int num) {
        if (num <=0 ){
            throw new IllegalArgumentException("Empty Purse!");
        }
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num) {
        if (num <=0 ){
            throw new IllegalArgumentException("EmptyPurse!!");
        }
        int currentCount = cash.getOrDefault(type, 0);
        if (currentCount < num){
            throw new IllegalArgumentException("Not enough to remove");
        }
        cash.put(type, currentCount - num);
        if(cash.get(type) == 0){
            cash.remove(type);
        }
        return type.amt()* num;
    }

    public double getValue() {
        return cash.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    public Map<Denomination, Integer> getCash() {
        return new HashMap<>(cash);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Purse contents:\n");
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(String.format("%s: %d\n", entry.getKey().name(), entry.getValue()));
        }
        sb.append(String.format("Total value: $%.2f", getValue()));
        return sb.toString();
    }
}
