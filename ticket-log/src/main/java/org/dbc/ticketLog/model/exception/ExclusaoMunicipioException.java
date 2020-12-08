package org.dbc.ticketLog.model.exception;

public class ExclusaoMunicipioException extends BaseException {

    public ExclusaoMunicipioException() {
        super("Municípios no Rio Grande do Sul (RS) não podem ser excluídos");
    }
}
