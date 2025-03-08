/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Stage;
import java.util.Date;
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
        
        sv.create(new Stage("oracle", "react", new Date(), new Date()));
    }
    
}
