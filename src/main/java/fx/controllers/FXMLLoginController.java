/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.User;
import services.UserService;
import utils.Constantes;

/**
 * FXML Controller class
 *
 * @author Laura
 */
public class FXMLLoginController implements Initializable {


    // Esto es para poder coger lo que pone en ese campo y meterlo en este caso en el atributo usuario
    // del controlador principal.
    @FXML
    private TextField fxUser;
    @FXML
    private TextField passBox;
    @FXML
    private Label errorBox;
    
    //Referencia al controlador principal para poder acceder a el, junto con su set para poder cambiarlo.
    private FXMLPrincipalController principal;

    public void setPrincipal(FXMLPrincipalController principal) {
        this.principal = principal;
    }
    
    
    public void cleckLogin(){
        UserService serviceUser = new UserService();
        User user = serviceUser.checkUser(fxUser.getText(),passBox.getText());
        if (user != null){
            principal.setIdUser(user.getIdUser());
            principal.setUsername(fxUser.getText());
            principal.chargeWelcome();
        }else{
            errorBox.setText(Constantes.PASSWORD_IS_WRONG);
        }


        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
