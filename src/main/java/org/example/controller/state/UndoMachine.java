package org.example.controller.state;

import lombok.Setter;
import org.example.controller.actions.AppAction;

import javax.swing.*;
import java.util.LinkedList;

public class UndoMachine {
    private UndoRedoState undoRedoState;
    @Setter
    private AbstractAction undoActionListener;
    @Setter
    private AbstractAction redoActionListener;



    public UndoMachine() {
        LinkedList<AppAction> undoList = new LinkedList<>();
        LinkedList<AppAction> redoList = new LinkedList<>();
        undoRedoState = new StateDisableUndoDisableRedo(undoList, redoList);
    }

    public void executeRedo() {
        undoRedoState = undoRedoState.redo();
    }

    public void executeUndo() {
        undoRedoState = undoRedoState.undo();
    }

    public boolean isEnableUndo() {
        return undoRedoState.getUndoActivityList().size() > 0;
    }


    public boolean isEnableRedo() {
        return undoRedoState.getRedoActivityList().size() > 0;
    }

    public void add(AppAction action) {
        undoRedoState.clearHistory();
        undoRedoState.addAction(action);
        //TODO: Определить переход по состоянию
        //undoRedoState = ;
    }

    public void updateButtons() {
        undoActionListener.setEnabled(isEnableUndo());
        redoActionListener.setEnabled(isEnableRedo());
    }


}
