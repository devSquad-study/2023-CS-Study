package strategy.adventuregame;

public class Main {
    public static void main(String[] args) {
        Character king = new King();
        king.setWeaponBehavior(new SwordBehavior());
        king.fight();

        Character queen = new Queen();
        queen.setWeaponBehavior(new BowAndArrowBehavior());
        queen.fight();

        Character knight = new Knight();
        knight.setWeaponBehavior(new KnifeBehavior());
        knight.fight();

        Character troll = new Troll();
        troll.setWeaponBehavior(new AxeBehavior());
        troll.fight();
    }
}
