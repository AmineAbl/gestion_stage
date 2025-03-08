/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Stage;
import connexion.Connexion;
import dao.IDao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMINE
 */
public class StageService implements IDao<Stage> {
    private Connexion connexion;
    
    public StageService(){
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Stage o) {
        String req ="insert into Stage(id,entreprise,sujet,date_debut,date_fin) values (null,?,?,?,?)";
        
        try{
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getEntreprise());
            ps.setString(2, o.getSujet());
            ps.setDate(3, new Date(o.getDate_debut().getTime()));
            ps.setDate(4, new Date(o.getDate_fin().getTime()));
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Stage o) {
        String req = "delete from Stage where id = ?";
        
        try{
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Stage o) {
        String req = "update Stage set entreprise = ? , sujet = ? , date_debut = ? , date_fin = ? where id = ?";
        
        try{
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getEntreprise());
            ps.setString(2, o.getSujet());
            ps.setDate(3, new Date(o.getDate_debut().getTime()));
            ps.setDate(4, new Date(o.getDate_fin().getTime()));
            ps.executeUpdate();
            return true;
            
        }   catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Stage findById(int id) {
        String req = "select * from Stage where id = ? ";
        try{
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Stage(rs.getInt("id"), rs.getString("entreprise"), rs.getString("sujet"), rs.getDate("date_debut"), rs.getDate("date_fin"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Stage> findAll() {
        List<Stage> stages = new ArrayList<>();
        String req = "select * from Stage";
        try{
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                stages.add(new Stage(rs.getInt("id"), rs.getString("entreprise"), rs.getString("sujet"), rs.getDate("date_debut"), rs.getDate("date_fin")));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return stages;
    }
    
    
}
