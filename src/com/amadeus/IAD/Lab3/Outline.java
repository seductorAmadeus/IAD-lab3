package com.amadeus.IAD.Lab3;

public class Outline {

    private double R;

    Outline(double R) {
        this.R = R;
    }

    public boolean checkValue(Nokta nokta) {
        return !(((nokta.getX() >= R / 2) || (nokta.getX() <= (-1) * R / 2)) || (
                (nokta.getY() >= R) || (nokta.getY() <= -R / 2)
        ));
    }

}
