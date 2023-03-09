package ru.mikheev.kirill.jlessons.march05.lesson.shape;

import ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden.Rectangle;
import ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden.ShapeFactory;
import ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden.Triangle;

//import static jdk.internal.logger.DefaultLoggerFinder.SharedLoggers.system;

public class ShapeTest {

    public static void main(String[] args) {
        Rectangle rectangle = ShapeFactory.createRectangle(1.0, 1.0, 6.0, 3.0);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println();

        Triangle triangle = ShapeFactory.createTriangle(9.0, 2.0, 4.0, 6.0, 5.0, 5.0);
        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimeter());
        System.out.println();
    }
}
