package toy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public abstract class DeliveryToy {
    private static final int EXPECTED_DETAIL_COUNT = 3;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    {
        createToy();
        try {
            printDeliveryInstructions();
            String[] addressDetails = readAddressDetails();
            validateAndPrintAddressDetails(addressDetails);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    abstract void createToy();

    private void printDeliveryInstructions() {
        System.out.println("배송 받을 주소 입력");
        System.out.println("입력 양식");
        System.out.println("주소 세부주소 우편번호");
        System.out.println("Ex) 대구광역시 x구xx로x길 12345");
    }

    private String[] readAddressDetails() throws IOException {
        String[] addressDetails = splitInputIntoDetails(br.readLine());
        while (addressDetails.length != EXPECTED_DETAIL_COUNT) {
            System.out.println("올바른 양식으로 입력해주세요.");
            addressDetails = splitInputIntoDetails(br.readLine());
        }
        return addressDetails;
    }

    private String[] splitInputIntoDetails(String input) {
        StringTokenizer st = new StringTokenizer(input);
        String[] addressDetails = new String[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++) {
            addressDetails[i] = st.nextToken();
        }
        return addressDetails;
    }

    private void validateAndPrintAddressDetails(String[] addressDetails) throws IOException {
        while (!isValidLocation(addressDetails[0])) {
            System.out.println("해당 지역으로는 배송이 불가합니다. 다른 주소를 입력해주세요.");
            addressDetails = readAddressDetails();
        }
        System.out.println(String.join(" ", addressDetails) + " 지역으로 배송합니다.");
    }

    private boolean isValidLocation(String address) {
        return address.startsWith("서울") || address.startsWith("경기");
    }
}

