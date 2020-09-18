/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author USER
 */
public class FilmCategory {
    private Integer film_id;
    private Integer category_id;
    private Date last_update;
    public FilmCategory(Integer film_id, Integer category_id){
        this.film_id = film_id;
        this.category_id = category_id;
        this.last_update = new Date();        
    }
    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "FilmCategory{" + "film_id=" + film_id + ", category_id=" + category_id + ", last_update=" + last_update + '}';
    }
}
