package org.example.controller.actions;

import org.example.controller.factory.ShapeCreation;
import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;

public class ActionDraw implements AppAction {
    private Model model;
    private MyShape shape;
    private ShapeCreation shapeCreation;
    private Point2D firstPoint;
    private Point2D secondPoint;
    MyShape drawableShape;
    MyShape sampleShape;

    public MyShape getShape() {
        return shape;
    }

    public ActionDraw(Model model, MyShape shape) {
        this.model = model;
        this.shape = shape;
        shapeCreation = ShapeCreation.getInstance();
    }
    public  void  stretchShape (Point point){
        firstPoint = point;
        shape.setFrame(firstPoint, secondPoint);
        model.update();

    }

    public void createShape (Point point){
        secondPoint = point;
        shape = shape.clone();
        model.createCurrentShape(shape);
        model.update();

    }
    @Override
    public void mouseDragged(Point point){
        secondPoint = point;
        shape.setFrame(firstPoint, secondPoint);
        model.update();
    }

    @Override
    public void execute() {
        model.addCurrentShape(drawableShape);
        model.update();
    }
    @Override
    public void unexecute() {
        drawableShape = model.getLastShape();
        model.removeLastShape();
        model.update();
    }
    @Override
    public AppAction cloneAction() {
        ActionDraw actionDraw = new ActionDraw(model,shape);
        actionDraw.sampleShape = sampleShape.clone();
        actionDraw.drawableShape = drawableShape;
        return actionDraw;
    }

    @Override
    public void mousePressed(Point point){
        firstPoint = point;
        shape = shapeCreation.createShape();
        model.addCurrentShape(shape);
        model.update();
    }

}
