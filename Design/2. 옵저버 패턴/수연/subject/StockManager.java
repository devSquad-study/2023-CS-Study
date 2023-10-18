package subject;

import observer.Investor;

import java.util.ArrayList;

public class StockManager implements StoskSubject{
    private ArrayList<Investor> investors;
    private float stock;

    public StockManager(){
        investors = new ArrayList<>();
    }

    @Override
    public void registerInvestor(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void removeInvestor(Investor investor) {
        investors.remove(investor);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i< investors.size(); i++){
            Investor investor = investors.get(i);
            investor.update(stock);
            System.out.println("주식 값: "+stock);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setStock(float stock){
        this.stock = stock;
        measurementsChanged();
    }
}
