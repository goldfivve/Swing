package Package;

abstract public class Level {

    public static int size;
    int mineNumber;
    double percent;

    Level(){
        this.size=size;
        this.percent=percent;
        this.mineNumber= (int)(size*size*percent);
    }


}
