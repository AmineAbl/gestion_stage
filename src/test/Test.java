/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.AffectationStage;
import beans.Encadrant;
import beans.Etudiant;
import beans.Stage;
import java.util.Date;
import services.AffectationStageService;
import services.EncadrantService;
import services.EtudiantService;
import services.StageService;


/**
 *
 * @author AMINE
 */
public class Test {
    public static void main(String[] args) {
        StageService sv = new StageService();
        EtudiantService es = new EtudiantService();
        EncadrantService ens = new EncadrantService();
        AffectationStageService ase = new AffectationStageService();
        
        //sv.create(new Stage("meta", "angular", new Date(), new Date()));
        //es.create(new Etudiant("Ahmadi", "Hassan", "hassan@gmail.com"));
        //ens.create(new Encadrant("Berrada", "Karim", "karim@gmail.com"));
        
        
        ase.create(new AffectationStage(sv.findById(1), es.findById(1), ens.findById(1)));
        
        for(Stage s : sv.findAll()){
            System.out.println(s);
        }
        System.out.println("###########");
        for(Etudiant e : es.findAll()){
            System.out.println(e);
        }
        System.out.println("###########");
        for(Encadrant e : ens.findAll()){
            System.out.println(e);
        }
        System.out.println("###########");
        
        for(AffectationStage as : ase.findAll()){
            System.out.println(as);
        }
        
        
    }
    
}
