/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.ActorDAO;
import model.Actor;
import util.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ActorDAOImplement implements ActorDAO{
    @Override
    public boolean insertar(Actor a) throws Exception{
        boolean retn = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO actor VALUES(?,?,?,?)";
        conn = Conexion.getConexion();
        ps = conn.prepareStatement(sql);
        ps.setInt(1,a.getActor_id());
        ps.setString(2,a.getFirst_name());
        ps.setString(3,a.getLast_name());
        ps.setString(4,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(a.getLast_update()));
        ps.executeUpdate();
        ps.close();
        conn.close();
        retn = true;
        return retn;
    }
    @Override
    public List<Actor> listar(){
        List<Actor> retn = new ArrayList<>();
        Actor x = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM actor";
        Connection conn = null;
        try {
            conn = Conexion.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                x = new Actor(rs.getString(2),rs.getString(3));
                x.setActor_id(rs.getInt(1));
                x.setLast_update(rs.getDate(4));
                retn.add(x);
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR ACTORES");
            e.printStackTrace();
        }
        return retn;
    }
}
