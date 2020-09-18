/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Actor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ActorDAO {
    public boolean insertar(Actor a) throws Exception;
    public List<Actor> listar();
}
