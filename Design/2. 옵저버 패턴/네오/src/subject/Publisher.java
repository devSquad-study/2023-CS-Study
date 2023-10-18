package subject;

import observer.Observable;

public interface Publisher {

    void registerObserver(Observable observable);
    void withdrawObserver(Observable observable);
    void notifyObserver();

}
