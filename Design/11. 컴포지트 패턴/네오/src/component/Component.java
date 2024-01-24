package component;

public interface Component {

    default Component add(Component component) {
        throw new UnsupportedOperationException();
    }

    default Component remove(int index) {
        throw new UnsupportedOperationException();
    }

    default void printInfo(int tab) {
        throw new UnsupportedOperationException();
    }

    default Component get(int index) {
        throw new UnsupportedOperationException();
    }

    default ComponentType getType() {
        throw new UnsupportedOperationException();
    }

}
