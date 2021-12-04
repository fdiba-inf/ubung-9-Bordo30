package exercise9;

import jdk.jshell.execution.Util;

public class Ellipse {
    private Point startPoint;
    private double a;
    private double b;

    public Ellipse() {
        startPoint = new Point(0, 0);
        a = 1;
        b = 1;
    }

    public Ellipse(Point startPoint, double a, double b) {
        this.startPoint = new Point(startPoint);
        this.a = a;
        this.b = b;
    }

    public Ellipse(Ellipse otherEllipse) {
        startPoint = new Point(otherEllipse.startPoint);
        a = otherEllipse.a;
        b = otherEllipse.b;
    }

    public boolean isValid() {
        return a > 0 && b > 0;
    }

    public void initialize() {
        do {
            System.out.println("Start point: ");
            startPoint.initialize();
            System.out.print("Enter a: ");
            a = Utils.INPUT.nextDouble();
            System.out.print("Enter b: ");
            b = Utils.INPUT.nextDouble();
        }while(!isValid());
    }

    public double calculatePerimeter() {
        return Math.PI*(3*(a + b) - Math.sqrt((3*a+b)*(a+3*b)));
    }

    public double calculateArea() {
        return Math.PI*a*b;
    }

    public String getType() {
        if(a == b) {
            return "Circle";
        } else {
            return "Ellipse";
        }
    }

    public String toString() {
        return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, a, b, getType(), calculatePerimeter(), calculateArea());
    }

    public boolean equals(Ellipse otherEllipse) {
        boolean aEqual = Utils.equals(a, otherEllipse.a);
        boolean bEqual = Utils.equals(b, otherEllipse.b);
        boolean aEqualReversed = Utils.equals(a, otherEllipse.b);
        boolean bEqualReversed = Utils.equals(b, otherEllipse.a);

        return (aEqual && bEqual) || (aEqualReversed && bEqualReversed);
    }
}
