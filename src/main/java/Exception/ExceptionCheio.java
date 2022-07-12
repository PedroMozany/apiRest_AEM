package exception;

public class ExceptionCheio extends Exception {


   public ExceptionCheio(String meng){
        super(meng);
   }


    public ExceptionCheio(Throwable t){
        super(t);
    }



}
