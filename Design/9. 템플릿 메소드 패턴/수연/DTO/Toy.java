package DTO;

import factory.*;

import java.util.Arrays;

public enum Toy {
    CHANGE_CAR("변신 자동차",new ChangeCarFactory()),
    GAMEMACHINE_PECILECASE("게임기 필통", new GameMachinePecileCase()),
    KONGSUNI_PLAYDOCTOR("콩순이 의사놀이", new KongsuniPlayDoctor()),
    TEDDY_BEAR("곰돌이", new TeddyBear()),
    EMPTY("없음",new EmptyFactory());


    Toy(String toy,ToyFactory toyFactory){
        this.toy = toy;
        this.toyFactory = toyFactory;
    }
    private String toy;
    private ToyFactory toyFactory;

    public static void runnimgFactory(String toyName){
        Toy toy = Arrays.stream(Toy.values()).filter(toy1 -> toy1.toy.equals(toyName))
                .findFirst().get();

        toy.toyFactory.runFactory();
    }

    public static boolean isCheckedToyName(String toyName){
        Toy toy = Arrays.stream(Toy.values()).filter(toy1 -> toy1.getToy().equals(toyName))
                .findFirst().orElse(Toy.EMPTY);
        if(toy.getToy().equals("없음")){
            return false;
        }else{
            return true;
        }
    }

    public String getToy() {
        return toy;
    }
}
