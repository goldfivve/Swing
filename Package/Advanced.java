package Package;

public class Advanced extends Level {
    Advanced() {
        super();
        this.size = 24;
        this.percent = 0.25;
        this.mineNumber = (int) (size*size*percent);
    }
}
