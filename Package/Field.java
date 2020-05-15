package Package;

public class Field {
   public boolean isMine;
   public boolean isFlag;
   public boolean isCovered;
   int minesAround;

    Field(boolean isMine){
       this.isMine=isMine;
       this.isFlag=false;
       this.isCovered=true;
       this.minesAround = 0;
    }

}
