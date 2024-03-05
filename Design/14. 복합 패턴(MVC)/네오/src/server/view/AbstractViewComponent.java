package server.view;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractViewComponent implements ViewComponent {

    protected final Map<String, ViewComponent> children;

    protected AbstractViewComponent() {
        this.children = new HashMap<>();
    }

}
