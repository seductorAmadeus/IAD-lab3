public class Outline {

    private double radius;

    Outline(double radius) {
        this.radius = radius;
    }

    public boolean checkValue(Nokta nokta) {
        return !(((nokta.getX() >= radius / 2) || (nokta.getX() <= (-1) * radius / 2)) || (
                (nokta.getY() >= radius) || (nokta.getY() <= -radius / 2)
        ));
    }

}
