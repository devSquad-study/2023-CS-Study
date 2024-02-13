package strategy.adventuregame;

public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("활 뿅뿅");
    }
}
