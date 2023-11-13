package subject;

import observer.Investor;

public interface StoskSubject {
    //투자자를 등록한느 역할
    public void registerInvestor(Investor investor);
    //투자자를 제거하는 역할
    public void removeInvestor (Investor investor);
    //투자 변동이 있을 때, 모든 투자자들한테 알리기 위해 호출되는 메서드
    public void notifyObservers();
}
