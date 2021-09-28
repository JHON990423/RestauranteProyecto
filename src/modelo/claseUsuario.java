/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class claseUsuario {

    private String nombreUsuario;
    private int identificador;
    private String contraseña;
    private String rol;
    public ArrayList<claseUsuario> listaUsuarios = new ArrayList<>();
    public File archivoUsuarios;

    //<editor-fold defaultstate="collapsed" desc="Constructor" >
    public claseUsuario(String nombreUsuario, int identificador, String contraseña, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.identificador = identificador;
        this.contraseña = contraseña;
        this.rol = rol;

    }

    public claseUsuario() {
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Get&Set" >
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setArchivoUsuarios(File archivoUsuarios) {
        this.archivoUsuarios = archivoUsuarios;
    }

//</editor-fold>
    public void AddUsuario(claseUsuario Usuario) {
        int cont = 0;

        for (int i = 0; i < listaUsuarios.size(); i++) {
            claseUsuario get = listaUsuarios.get(i);
            if (get.identificador == Usuario.getIdentificador()) {
                cont = cont + 1;

            }

        }//for

        if (cont == 0) {
            this.listaUsuarios.add(Usuario);

        }

    }//metodo

    public void addArchivoUsuario() throws IOException {
        archivoUsuarios = new File("./src/modelo/Usuario.txt");
        if (archivoUsuarios.isFile()) {
            FileWriter writer = new FileWriter(archivoUsuarios, true);
            BufferedWriter bufer = new BufferedWriter(writer);
            for (int i = 0; i < listaUsuarios.size(); i++) {
                claseUsuario getUsuario = listaUsuarios.get(i);
                bufer.append(getUsuario.getIdentificador() + ";"
                        + getUsuario.getNombreUsuario() + ";" +getUsuario.getContraseña()+ ";" + getUsuario.getRol());
                bufer.newLine();
            }
            bufer.close();
            writer.close();
        } else {
            archivoUsuarios = new File("./src/modelo/Usuario.txt");
            FileWriter writer = new FileWriter(archivoUsuarios, true);
            BufferedWriter bufer = new BufferedWriter(writer);
            for (int i = 0; i < listaUsuarios.size(); i++) {
                claseUsuario getUsuario = listaUsuarios.get(i);
                bufer.append(getUsuario.getIdentificador() + ";"
                        + getUsuario.getNombreUsuario() + ";"  +getUsuario.getContraseña()+ ";" + getUsuario.getRol());
                bufer.newLine();
            }
            bufer.close();
            writer.close();
        }
    }
    
    public void leerArchivo() throws FileNotFoundException, IOException {
        archivoUsuarios = new File("./src/modelo/Usuario.txt");
        if (archivoUsuarios.isFile()) {
            FileReader reader = new FileReader(archivoUsuarios);
            BufferedReader bufer = new BufferedReader(reader);
            String lineatexto = "";
            listaUsuarios.clear();

            while ((lineatexto = bufer.readLine()) != null) {
                String datos[] = lineatexto.split(";");
                int id = Integer.parseInt(datos[0]);
                String nombreUsuario = datos[1];
                String contraseña = datos[2];
                String rol = datos[3];
                claseUsuario usuario = new claseUsuario(nombreUsuario, identificador, contraseña, rol);
                listaUsuarios.add(usuario);
            }
            bufer.close();
            reader.close();
        }
    }
    
    

    public boolean loginUsuario(int identificador, String contrasena) {
        
        boolean estado = false;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            claseUsuario usuario = listaUsuarios.get(i);
            if (usuario.getIdentificador() == identificador) {
                if (usuario.getContraseña().equals(contrasena)) {
                    estado = true;
                } else {
                    estado = false;
                }

            } else {
                estado = false;
            }

        }

        return estado;
    }
    
    public String Rol(int identificador){
        String rolUsuario = null;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            claseUsuario usuario = listaUsuarios.get(i);
            if(usuario.getIdentificador() == identificador){
                rolUsuario = usuario.getRol();
            
            }
        }
        return rolUsuario;
    }
    
    
}
