package exception;

public class ConexaoException extends Exception{

   public ConexaoException(String meng){
       super(meng);

    }
    public ConexaoException(Throwable t){
       super(t);

    }

}
