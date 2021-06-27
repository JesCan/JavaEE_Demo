
package controlador;

import dao.ProductoImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Producto;

@Named(value = "productoC")
@SessionScoped
public class ProductoC implements Serializable{
    
    private Producto producto;
    ProductoImpl dao;
    
    
    public ProductoC() {
        producto = new Producto();
        dao = new ProductoImpl();
    }
    
    
    public void registrar() throws Exception {
        try {
            dao.registrar(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con Exito"));
//            limpiar();
//            System.out.println("Este es el metodo registrar");
//            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Falta Completar Datos"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    private void limpiar() {
        try{
            producto = new Producto();
        }catch (Exception e){
            throw e;
        }
        
    }

    private void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<String> completeTamano(String query) throws SQLException, Exception{
        ProductoImpl daoTamano = new ProductoImpl();
        return daoTamano.autocompleteTamano(query);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoImpl getDao() {
        return dao;
    }

    public void setDao(ProductoImpl dao) {
        this.dao = dao;
    }
    
}
