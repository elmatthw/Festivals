package by.iba.training.entity;


public enum Festival {
    MUSIC(0), FOOD(1), BEER(2), DANCE(3), ART(4), MOVIE(5);

    Festival(int code) {
        this.code = code;
    }

    private int code;

    public int getCode() {
        return code;
    }

    public static Festival valueOf(int i){
        for (Festival f : values()){
            if (f.code == i){
                return f;
            }
        }
        throw new IllegalArgumentException("No matching constant for " + i);
    }
}
