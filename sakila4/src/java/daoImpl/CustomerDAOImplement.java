/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.CustomerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

/**
 *
 * @author USER
 */
public class CustomerDAOImplement implements CustomerDAO{
    @Override
    public List<String[]> listar(){
        Connection conn = null;
        ArrayList<String[]> retn = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql ="select p.amount,p.payment_date,r.rental_date,c.first_name,c.last_name,a.address,ci.city,co.country,f.title\n" +
                    "from payment p\n" +
                    "join rental r\n" +
                    "on p.rental_id = r.rental_id\n" +
                    "join customer c\n" +
                    "on r.customer_id = r.customer_id\n" +
                    "join address a\n" +
                    "on c.address_id = a.address_id\n" +
                    "join city ci\n" +
                    "on a.city_id = ci.city_id\n" +
                    "join country co\n" +
                    "on ci.country_id = co.country_id\n" +
                    "join inventory i\n" +
                    "on r.inventory_id = i.inventory_id\n" +
                    "join film f\n" +
                    "on i.film_id = f.film_id\n" +
                    "limit 2000;";
        try {
            conn = Conexion.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String[] temp = new String[9];
                temp[0] = rs.getString(1);
                temp[1] = rs.getString(2);
                temp[2] = rs.getString(3);
                temp[3] = rs.getString(4);
                temp[4] = rs.getString(5);
                temp[5] = rs.getString(6);
                temp[6] = rs.getString(7);
                temp[7] = rs.getString(8);
                temp[8] = rs.getString(9);
                retn.add(temp);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL DEVOLVER ACTORES DE FILM");
        }
        return retn;
    };
}
