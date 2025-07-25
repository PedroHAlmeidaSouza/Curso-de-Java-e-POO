package sevice;

public class PaypalService implements OnlinePaymentService{

    @Override
    public double paymentFee(double amount) { // Taxa de pagamento
        return amount * 0.02;
    }

    @Override
    public double interest(double amount, int months) { // Calculo de juros
        return amount * 0.01 * months;
    }
}
