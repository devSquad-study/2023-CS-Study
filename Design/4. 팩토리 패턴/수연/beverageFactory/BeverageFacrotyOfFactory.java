package beverageFactory;

import beverage.Beverage;
import beverage.CafeLatte;
import beverage.Espresso;

public class BeverageFacrotyOfFactory implements BeverageFactory {
    @Override
    public Beverage createBeverage(String name) {
        String[] berverage = name.split(" ");
        switch (berverage[0]){
            case "에소프레소":
                return new Espresso(Integer.parseInt(berverage[1]));
            case "카페라떼":
                return new CafeLatte(Integer.parseInt(berverage[1]));
        }
        throw new IllegalArgumentException();
    }
}
