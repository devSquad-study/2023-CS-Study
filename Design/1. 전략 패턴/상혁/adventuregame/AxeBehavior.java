package strategy.adventuregame;

public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("도끼");
    }
}
