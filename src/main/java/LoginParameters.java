/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrador
 */
public class LoginParameters {

    private String NumeroEmpleado;
    private String Password;
    private String Tipo_Usuario;

    public String getNumeroEmpleado() {
        return NumeroEmpleado;
    }

    public void setNumeroEmpleado(String NumeroEmpleado) {
        this.NumeroEmpleado = NumeroEmpleado;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    public void setTipo_Usuario(String Tipo_Usuario) {
        this.Tipo_Usuario = Tipo_Usuario;
    }

    public LoginParameters(String NumeroEmpleado,String Tipo_Usuario) {
        super();
        this.NumeroEmpleado = NumeroEmpleado;
        this.Tipo_Usuario = Tipo_Usuario;
    }

    public LoginParameters() {
        super();
    }
}
