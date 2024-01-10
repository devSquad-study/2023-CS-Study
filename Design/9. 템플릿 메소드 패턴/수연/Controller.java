import DTO.OrderSheet;
import DTO.Toy;

public class Controller {

    public void isCkeckedAddress(OrderSheet orderSheet){
        if(orderSheet.address().contains("서울") || orderSheet.address().contains("경기도")){
            if(Toy.isCheckedToyName(orderSheet.toy())){
                Toy.runnimgFactory(orderSheet.toy());
            }else{
                System.out.println("TO "+orderSheet.address());
                System.out.println("해당 장난감은 저희 공장에서 생산이 불가능한 장난감입니다.");
            }
        }else{
            System.out.println("TO "+orderSheet.address());
            System.out.println("수도권을 제외한 지역에는 배달을 해드리고 있지않습니다!");
        }
    }
}
