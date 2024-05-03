package feri.ita.plantdb.logs.impl;

import feri.ita.plantdb.logs.ILoggingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingInfo implements ILoggingInfo{
    private static Logger LOG = null;

  public LoggingInfo(Class<?> clazz)
  {
      this.LOG = LoggerFactory.getLogger(clazz);
  }


    @Override
    public void logInfoRetrieveAll() {
        LOG.info("Retrieving all {}.", LOG.getName());
    }


    @Override
    public void logInfoRetrieveSpecific(String entityName) {
        LOG.info("Retrieving [{}] by name [{}].", LOG.getName(), entityName);
    }

    /**
     * @param entityName
     */
    @Override
    public void errorEntityNotFound(String entityName) {
        LOG.info("Entity [{}] with name [{}] not found.", LOG.getName(), entityName);
    }

    /**
     * @param entityName
     */
    @Override
    public void errorEntityAlreadyExists(String entityName) {
        LOG.info("Entity [{}] with name [{}] already exists.", LOG.getName(), entityName);
    }
}
