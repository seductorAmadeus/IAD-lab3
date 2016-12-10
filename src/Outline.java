public class Outline {

    private double radius;

    Outline(double radius) {
        this.radius = radius;
    }

    public boolean checkValue(Nokta nokta) {
        float x = nokta.getX(), y = nokta.getY();
        return (((x >= -this.radius / 2.0) && (x <= 0)) && ((y >= -this.radius / 2.0) && (y <= 0)) &&
                ((Math.pow(x, 2) + Math.pow(y, 2) <= (Math.pow(this.radius, 2)))) ||
                ((x <= this.radius / 2) && (x >= 0) && (y <= this.radius) && (y >= 0)) ||
                ((x >= -this.radius / 2.0) && (x <= 0) && (y <= this.radius) && (y >= 0) && (y <= x + this.radius / 2.0)));
    }
}
