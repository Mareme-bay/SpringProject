package io.bootify.wallet.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ErrorResponseTest {
    private ErrorResponse errorResponse;

    @BeforeEach
    public void setUp() {
        errorResponse = new ErrorResponse();
    }

    @Test
    void testGetHttpStatus() {
        assertNull(errorResponse.getHttpStatus()); // Le code HTTP devrait être null initialement

        Integer httpStatus = 404;
        errorResponse.setHttpStatus(httpStatus);

        assertEquals(httpStatus, errorResponse.getHttpStatus()); // Vérifiez que getHttpStatus() renvoie la valeur définie
    }

    @Test
    void testGetException() {
        assertNull(errorResponse.getException()); // L'exception devrait être null initialement

        String exception = "ResourceNotFoundException";
        errorResponse.setException(exception);

        assertEquals(exception, errorResponse.getException()); // Vérifiez que getException() renvoie la valeur définie
    }

    @Test
    void testGetMessage() {
        assertNull(errorResponse.getMessage()); // Le message devrait être null initialement

        String message = "La ressource demandée est introuvable.";
        errorResponse.setMessage(message);

        assertEquals(message, errorResponse.getMessage()); // Vérifiez que getMessage() renvoie la valeur définie
    }

    @Test
    void testGetFieldErrors() {
        assertNull(errorResponse.getFieldErrors()); // La liste d'erreurs de champ devrait être null initialement

        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(new FieldError());
        errorResponse.setFieldErrors(fieldErrors);

        assertEquals(fieldErrors, errorResponse.getFieldErrors()); // Vérifiez que getFieldErrors() renvoie la liste définie
    }

}