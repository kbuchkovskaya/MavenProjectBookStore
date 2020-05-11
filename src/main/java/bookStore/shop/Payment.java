package bookStore.shop;

/**
 * Payment type for books
 */
public interface Payment {

    public default String paymentType(){
        return "Possibility to pay by cash ot with credit card";
    }
}

