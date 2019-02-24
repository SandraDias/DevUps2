package org.academiadecodigo.bootcamp.DevOops.cell;

public enum DiferentAliens {
    ALIEN1("resources/alien1.png"),
    ALIEN2("resources/alien2.png"),
    ALIEN3("resources/alien3.png"),
    ALIEN4("resources/alien4.png");

    private String name;

    DiferentAliens(String name) {
        this.name = name;
    }

    public static String pickAlien() {
        int number = (int) (Math.random() * 4);
        return DiferentAliens.values()[number].name;
    }
}
