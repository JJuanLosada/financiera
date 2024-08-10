package com.example.financiera.constante;

public class MensajeRespuestaGenerico {
    public static final String  MENSAJE_ERROR_ID= "Cliente no existe";
    public static final String MENSAJE_ERROR_BORRADO_CLIENTE = "No se puede elimina porque tiene productos";
    public static final String MENSAJE_ERROR_NOMBRE_CLIENTE="Ese nombre o apellido es muy corto, tiene que ser mayor a 2 caracteres: ";
    public static final String MENSAJE_ERROR_EDAD_CLIENTE="No eres mayor de edad";
    public static final String MENSAJE_ERROR_CORREO_CLIENTE="El correo electrónico no tiene un formato válido";
    public static final String MENSAJE_ERROR_TIPO_CUENTA_PRODUCTO="Tipo de cuenta debe ser corriente o ahorro";
    public static final String MENSAJE_ERROR_SALDO_PRODUCTO="El saldo de cuenta de ahorro no puede ser menor a 0";
    public static final String MENSAJE_ERROR_ASOCIADO_PRODUCTO="El producto no esta asociado a un cliente";
    public static final String MENSAJE_ERROR_ESTADO_PRODUCTO="La cuenta debe estar en estado : ACTIVA , INACTIVA o CANCELADA";
    public static final String MENSAJE_ERROR_CANCELAR_PRODUCTO="El saldo deba estar en 0 para cancelar la cuenta";
}
