/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Producto {
    
    private String NOMPRO;
    private Double PRECIO;
    private String TIPO;
    private String TAMANO;
    private Integer STOCK;
    private String ESTADO;

    public Producto() {

    }

    public String getNOMPRO() {
        return NOMPRO;
    }

    public void setNOMPRO(String NOMPRO) {
        this.NOMPRO = NOMPRO;
    }

    public Double getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(Double PRECIO) {
        this.PRECIO = PRECIO;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getTAMANO() {
        return TAMANO;
    }

    public void setTAMANO(String TAMANO) {
        this.TAMANO = TAMANO;
    }

    public Integer getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(Integer STOCK) {
        this.STOCK = STOCK;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public Producto(String NOMPRO, Double PRECIO, String TIPO, String TAMANO, Integer STOCK, String ESTADO) {
        this.NOMPRO = NOMPRO;
        this.PRECIO = PRECIO;
        this.TIPO = TIPO;
        this.TAMANO = TAMANO;
        this.STOCK = STOCK;
        this.ESTADO = ESTADO;
    }

    @Override
    public String toString() {
        return "Producto{" + "NOMPRO=" + NOMPRO + ", PRECIO=" + PRECIO + ", TIPO=" + TIPO + ", TAMANO=" + TAMANO + ", STOCK=" + STOCK + ", ESTADO=" + ESTADO + '}';
    }
    
    
}
