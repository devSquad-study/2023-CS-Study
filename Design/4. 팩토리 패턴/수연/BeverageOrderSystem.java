import beverage.Beverage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BeverageOrderSystem {

    public List<String> orderBerverage(){
        System.out.println("어서오세요. 저희 카페는 아메리카노, 카페라떼만을 받고 있습니다");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> berverages = new ArrayList<>();

        try {
            String name = reader.readLine();
            while (!name.equals("end")) {
                berverages.add(name);
                name = reader.readLine();
            }
            System.out.println(berverages);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return berverages;
    }

    public void printBerverageReceipt(List<Beverage> berverages){
        int sum = 0;
        System.out.println("------------------ 영 수 증 ------------------");
        for (int i = 0; i<berverages.size(); i++){
            System.out.println(berverages.get(i));
            sum += berverages.get(i).cost();
        }
        System.out.println("총합:     "+sum);

    }
}
