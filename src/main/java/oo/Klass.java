package oo;

import java.util.Objects;

public class Klass {

    public static final Integer UNDEFINED_CLASS_NUMBER = Integer.MIN_VALUE;
    private Integer number;

    public Klass() {
        this.number = UNDEFINED_CLASS_NUMBER;
    }

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return Objects.equals(number, klass.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
