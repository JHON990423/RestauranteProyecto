/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.*;

/**
 *
 * @author User
 */
public class claseArchivos {

    private String ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public claseArchivos(String ruta) {
        this.ruta = ruta;
    }

    public String leer() {
        String resultado = "";
        try {
            FileReader lectura = new FileReader(ruta);
            BufferedReader br = new BufferedReader(lectura);
            String linea = br.readLine();
            while (linea != null) {
                resultado += linea;
                linea = br.readLine();
            }
            br.close();
            lectura.close();
        } catch (Exception e) {
            resultado = e.getMessage();

        }

        return resultado;
    }

    public boolean Escribir(String linea_p) {
        try {
            FileWriter escritura = new FileWriter(ruta);
            escritura.write(linea_p + "\n");
            escritura.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
