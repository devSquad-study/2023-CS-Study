package strategy.adventuregame;

public class KnifeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("칼 얍얍");
    }
}
