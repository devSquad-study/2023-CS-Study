package order.state;

import order.Order;

public enum DefaultOrderState implements OrderState {

    NEW {
        @Override
        public void accept(Order order) {
            System.out.println("주문을 수락합니다.");
            order.setState(PROCESSING);
        }

        @Override
        public void deny(Order order) {
            System.out.println("주문을 거절합니다.");
            order.setState(FAILED);
        }
    },
    PROCESSING {
        @Override
        public void accept(Order order) {
            System.out.println("주문이 성공적으로 처리됐습니다.");
            order.setState(FINISHED);
        }

        @Override
        public void deny(Order order) {
            System.out.println("주문에 실패했습니다.");
            order.setState(FAILED);
        }
    },
    FINISHED {
        @Override
        public void accept(Order order) {
            throw new IllegalStateException("이미 처리된 주문입니다.");
        }

        @Override
        public void deny(Order order) {
            throw new IllegalStateException("이미 처리된 주문입니다.");
        }
    },
    FAILED {
        @Override
        public void accept(Order order) {
            throw new IllegalStateException("이미 처리된 주문입니다.");
        }

        @Override
        public void deny(Order order) {
            throw new IllegalStateException("이미 처리된 주문입니다.");
        }
    }

}
