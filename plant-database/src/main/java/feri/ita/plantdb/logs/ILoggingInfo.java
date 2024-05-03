package feri.ita.plantdb.logs;

public interface ILoggingInfo {
    void logInfoRetrieveAll();

    void logInfoRetrieveSpecific(String entityName);

    void errorEntityNotFound(String entityName);

    void errorEntityAlreadyExists(String entityName);
}
