package org.example.view.menu;

import org.example.controller.actions.AppAction;
import org.example.controller.factory.MenuState;
import org.example.controller.factory.ShapeType;

public class SwitchShape implements AppCommand{
    private ShapeType shapeType;
    private MenuState state;
    public SwitchShape(ShapeType shapeType, MenuState state) {
        this.shapeType = shapeType;
        this.state= state;
    }

    @Override
    public void execute() {
state.setShapeType(shapeType);
    }
}
