package stone;

public class Stone{
    private static final int MIN_CLR = 1;
    private static final int MAX_CLR = 10;

    private int weightInCarats;
    private int priceInUSDByCarat;
    private int clarity;

    public Stone(int weight, int price, int clarity) {
        this.weightInCarats = weight;
        this.priceInUSDByCarat = price;
        validateClarity(clarity);
        this.clarity = clarity;
    }

    public void validateClarity(int clarity) {
        if ((clarity < MIN_CLR) || (clarity > MAX_CLR)) {
            throw new IllegalArgumentException("Clarity must be 1-10");
        }
    }

    public int getWeight() {
        return weightInCarats;
    }

    public int getPrice() {
        return priceInUSDByCarat * weightInCarats * clarity / MAX_CLR;
    }

    public int getClarity() {
        return clarity;
    }

    public boolean equals(Stone stone) {
        if (this == stone) {
            return true;
        }

        if (stone == null || getClass() != stone.getClass()) {
            return false;
        }

        return stone.hashCode() == this.hashCode();
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + weightInCarats;
        result = 31 * result + priceInUSDByCarat;
        result = 31 * result + clarity;
        return result;
    }
}

class PreciousStone extends Stone{
    PreciousStone(int weight, int price, int clarity) {
        super(weight, price, clarity);
    }
}

class SemiPreciousStone extends Stone{
    SemiPreciousStone(int weight, int price, int clarity) {
        super(weight, price, clarity);
    }
}
