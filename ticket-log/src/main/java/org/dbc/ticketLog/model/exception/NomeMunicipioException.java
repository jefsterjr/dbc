package org.dbc.ticketLog.model.exception;

public class NomeMunicipioException extends BaseException {

    public NomeMunicipioException() {
        super("Já existe um município com o mesmo nome neste estado!");
    }
}
