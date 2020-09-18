/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.FilmDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Film;
import util.Conexion;

/**
 *
 * @author USER
 */
public class FilmDAOImplement implements FilmDAO{
    @Override
    public boolean insertar(Film film) {
        Connection conn = null;
        boolean registrar = false;
        PreparedStatement ps = null;
        String sql = "INSERT INTO film VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = Conexion.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,film.getFilm_id());
            ps.setString(2,film.getTitle());
            if (film.getDescription() == null)
                ps.setNull(3,Types.VARCHAR);
            else
                ps.setString(3,String.valueOf(film.getDescription()));
            if (film.getRelease_year() == null)
                ps.setNull(4, Types.INTEGER);
            else
                ps.setInt(4,film.getRelease_year());
            ps.setString(5,film.getLanguage_id().toString());
            if (film.getOriginal_language_id() == null)
                ps.setNull(6, Types.INTEGER);
            else
                ps.setString(6,String.valueOf(film.getOriginal_language_id()));
            ps.setInt(7,film.getRental_duration());
            ps.setDouble(8,film.getRental_rate());
            if (film.getLongitud() == null)
                ps.setNull(9,Types.INTEGER);
            else
                ps.setInt(9,film.getLongitud());
            ps.setDouble(10,film.getReplacement_cost());
            ps.setString(11,film.getRating());
            if (film.getSpecial_features() == null)
                ps.setNull(12, Types.VARCHAR);
            else
                ps.setString(12,film.getSpecial_features());
            ps.setString(13,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(film.getLast_update()));
            ps.execute();
            registrar = true;
            conn.close();
           
        } catch (Exception e) {
            System.out.println("ERROR AL INSERTAR FILM");
        }
        return registrar;
    }

    @Override
    public ArrayList<Film> listar() {
        ArrayList<Film> retn = new ArrayList<>();
        Connection conn = null;
        Film x = null;
        try {
            conn = Conexion.getConexion();
            String sql = "SELECT * from Film";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                x = new Film(rs.getInt(1),rs.getString(2),rs.getInt(5));
                x.setDescription(rs.getString(3));
                x.setRelease_year(rs.getInt(4));
                x.setOriginal_language_id(rs.getInt(6));
                x.setRental_duration(rs.getInt(7));
                x.setRental_rate(rs.getDouble(8));
                x.setLongitud(rs.getInt(9));
                x.setReplacement_cost(rs.getDouble(10));
                x.setRating(rs.getString(11));
                x.setSpecial_features(rs.getString(12));
                x.setLast_update(rs.getDate(13));
                retn.add(x);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTA FILMS");
        }
        return retn;
    }
    
}
