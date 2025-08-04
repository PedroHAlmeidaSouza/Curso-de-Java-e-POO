package db.exceptions;

public class DbIntegrityException extends RuntimeException{

    // Exceção personalizada de integridade referencial
    public DbIntegrityException(String msg){
        super(msg);
    }
}
