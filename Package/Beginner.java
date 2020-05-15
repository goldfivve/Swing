package Package;

public class Beginner extends Level {
    Beginner() {
        super();
        size=8;
        percent =  0.15625;
        mineNumber = (int) (size*size*percent);
    }

}
