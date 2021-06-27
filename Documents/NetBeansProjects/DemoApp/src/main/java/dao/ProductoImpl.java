package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;


public class ProductoImpl extends connectionbd implements ICRUD<Producto>{

    @Override
    public void registrar(Producto producto) throws Exception {
        
        try{
            String sql = "INSERT INTO PRODUCTO\n" 
                    + "(NOMPROD, PREPROD, TIPPROD, TAMPROD, STOCKPROD, ESTPROD)\n"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, producto.getNOMPRO());
            ps.setDouble(2, producto.getPRECIO());
            ps.setString(3, producto.getTIPO());
            ps.setString(4, producto.getTAMANO());
            ps.setInt(5, producto.getSTOCK());
            ps.setString(6, producto.getESTADO());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            System.out.println("No se ha registrado producto DAO " + e.getMessage());
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(Producto productoj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Producto producto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cambiarEstado(Producto producto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarTodos(char estado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<String> autocompleteTamano(String consulta) throws SQLException, Exception{
        List<String> lista = new ArrayList<>();
        String sql = "select top 5 tamprod as tamano  from producto where tamprod like ?";
        try{
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, "%" + consulta + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                lista.add(rs.getString("tamano"));
            }
        }catch (Exception e){
            System.out.println("Error en autocompletar " + e.getMessage());
        }
        return lista;
    }
}

