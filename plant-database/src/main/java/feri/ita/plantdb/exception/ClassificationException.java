package feri.ita.plantdb.exception;

public class ClassificationException extends RuntimeException{
    public ClassificationException(String message, String className) {
        super(String.format(message, className));
    }
}
