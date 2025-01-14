package comprobadorEmail;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEmail {

	ComprobadorEmail comprobador = new ComprobadorEmail(); // Instancia del comprobador

    // PE 001: Estructura incorrecta del correo electrónico
    @Test
    void testEstructuraCorreo() {
        String email = "ainoa.gmail.com";
        assertFalse(comprobador.emailValido(email), "Error en la comprobación de estructura del correo electrónico");
    }

    // PE 002: Nombre con caracteres no permitidos
    @Test
    void testNombreConCaracteresInvalidos() {
        String email = "ainoa/lopez@gmaial.com";
        assertFalse(comprobador.emailValido(email), "Error en la validación de caracteres no permitidos en el nombre");
    }

    // PE 003: Nombre termina con un punto
    @Test
    void testNombreTerminaConPunto() {
        String email = "ainhoa.@gmail.com";
        assertFalse(comprobador.emailValido(email), "Error en la validación de nombre terminando con un punto");
    }

    // PE 004: Nombre excede 64 caracteres
    @Test
    void testNombreExcede64Caracteres() {
        String email = "usuario_ainoa_lopez_lizana_extra_super_largo_con_mas_datos_adicionales_123456789@gmail.com";
        assertFalse(comprobador.emailValido(email), "Error en la validación del límite de longitud del nombre");
    }

    // PE 005: Puntos consecutivos en el nombre
    @Test
    void testPuntosConsecutivosEnNombre() {
        String email = "ainhoa..lopez@gmail.com";
        assertFalse(comprobador.emailValido(email), "Error en la validación de puntos consecutivos en el nombre");
    }

    // PE 006: Dominio con caracteres no permitidos
    @Test
    void testDominioConCaracteresInvalidos() {
        String email = "ainoa@mi_gmail.com";
        assertFalse(comprobador.emailValido(email), "Error en la validación de caracteres no permitidos en el dominio");
    }

    // PE 007: Dominio empieza o termina con guion
    @Test
    void testDominioEmpiezaTerminaConGuion() {
        String email = "ainoa@gmail-.com";
        assertFalse(comprobador.emailValido(email), "Error en la validación del dominio empezando o terminando con guion");
    }

    // PE 008: Dominio excede 255 caracteres
    @Test
    void testDominioExcede255Caracteres() {
        String email = "ainoa@el-dominio-mas-largo-del-mundo-es-este123456789012345678901234567890123456789012345678901234567890123456780123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890.com";
        assertFalse(comprobador.emailValido(email), "Error en la validación del límite de longitud del dominio");
    }
    
    // PE 009: Dominio no debe empezar con punto
    @Test
    void testDominioEmpiezaConPunto() {
        String email = "ainoa@.gmail.com";
        assertFalse(comprobador.emailValido(email), "Error en la validación del dominio empezando con punto");
    }

    // PE 010: Tamaño total del correo excede 320 caracteres
    @Test
    void testTamañoCompletoCorreoExcede320Caracteres() {
        String email = "usuario_ainoa_lopez_lizana_extra_super_largo_con_mas_datos_adicionales_123456789@el-dominio-mas-largo-del-mundo-es-este123456789012345678901234567890123456789012345678901234567890123456780123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890.com";
        assertFalse(comprobador.emailValido(email), "Error en la validación del tamaño total del correo");
    }

}
