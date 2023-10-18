package observer;

public interface Investor {
    // 주가가 변경이 되렀을 때, 투자자한테 전달되는 값
    public void update(float stock);
}
