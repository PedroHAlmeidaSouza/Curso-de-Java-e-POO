package entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double baseTaxRate = super.getAnualIncome() < 20000 ? 0.15 : 0.25;
        double tax = super.getAnualIncome() * baseTaxRate;

        tax -= healthExpenditures * 0.5;

        return tax;
    }

    @Override
    public String toString() {
        return super.getName() + ": $ " + String.format("%.2f", tax());
    }
}
