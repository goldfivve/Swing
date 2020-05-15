package Package;

public class Medium extends Level {
    Medium() {
        super();
        this.size = 16;
        this.percent = 0.15625;
        this.mineNumber = (int) (size*size*percent);
    }
}
