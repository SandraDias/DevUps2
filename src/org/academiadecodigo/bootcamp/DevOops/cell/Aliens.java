package org.academiadecodigo.bootcamp.DevOops.cell;

public enum Aliens {
    ALIEN1("resources/alien1.png"),
    ALIEN2("resources/alien2.png"),
    ALIEN3("resources/alien3.png"),
    ALIEN4("resources/alien4.png");

    private String name;

    Aliens(String name) {
        this.name = name;
    }

    public static String pickAlien() {
        int number = (int) (Math.random() * 4);
        return Aliens.values()[number].name;
    }
}
