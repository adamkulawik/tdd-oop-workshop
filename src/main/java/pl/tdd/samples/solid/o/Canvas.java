package pl.tdd.samples.solid.o;

import java.util.List;

public class Canvas {

    public void draw(List<Shape> shapes) {
        shapes.forEach(shape -> shape.draw());
    }

    private class Shape {
        public void draw(){

        }
    }
}
