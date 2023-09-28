package io.bootify.wallet.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FieldErrorTest {
    private FieldError fieldError;

    @BeforeEach
    public void setUp() {
        fieldError = new FieldError();
    }

    @Test
    void testGetField() {
        assertNull(fieldError.getField()); // Le champ devrait être null initialement

        String fieldName = "email";
        fieldError.setField(fieldName);

        assertEquals(fieldName, fieldError.getField()); // Vérifiez que getField() renvoie la valeur définie
    }

    @Test
    void testGetErrorCode() {
        assertNull(fieldError.getErrorCode()); // Le code d'erreur devrait être null initialement

        String errorCode = "NotEmpty";
        fieldError.setErrorCode(errorCode);

        assertEquals(errorCode, fieldError.getErrorCode()); // Vérifiez que getErrorCode() renvoie la valeur définie
    }

}