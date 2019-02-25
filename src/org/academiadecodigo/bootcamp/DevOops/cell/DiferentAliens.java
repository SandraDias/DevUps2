package org.academiadecodigo.bootcamp.DevOops.cell;


public enum DiferentAliens {
    ALIEN1("alien1.png"),
    ALIEN2("alien2.png"),
    ALIEN3("alien3.png"),
    ALIEN4("alien4.png"),
    ALIEN5("chili.png");

    private String name;
    private static int number = 3;

    DiferentAliens(String name) {
        this.name = name;
    }

    public static String pickAlien() {
        int rand = 0;

        if(number == 3) {

            rand = (int) (Math.random() * (number) + 1);
        }

        if(number == 4){

            return values()[values().length - 1].name;

        }

        return DiferentAliens.values()[rand].name;
    }

    public static void setNumber(int number) {
        DiferentAliens.number = number;
    }
}



