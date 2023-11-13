package observer;

import subject.StockManager;
import subject.StoskSubject;

public class Human implements Investor{

    private float stock;
    private StoskSubject stoskSubject;

    public Human (StoskSubject stoskSubject){
        this.stoskSubject = stoskSubject;
        stoskSubject.registerInvestor(this);
    }

    @Override
    public void update(float stock) {
        this.stock = stock;
    }
}
