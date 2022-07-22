package exception;

public class ColecaoException extends Exception{

    public ColecaoException(String meng){
        super(meng);

    }

    public ColecaoException(Throwable t){
        super(t);
    }

}
