
package kardex.vistas;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.*;
import java.text.*;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.image.*;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;

public class Form_Barra_De_Titulo {
    private ImageView icono;
    private Image imagenFondo;
    private BackgroundImage fondo;
    private BorderPane titulo;

    public Form_Barra_De_Titulo(Node nombre, Node cerrar) {
        imagenFondo=new Image("file:src\\kardex\\multimedia\\images\\barratitulo.jpg");
        fondo=new BackgroundImage(imagenFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        cerrar.setStyle("-fx-background-color: lightpink");
        icono=new ImageView(new Image("file:ssrc\\kardex\\multimedia\\images\\micasa.png", 40, 40, true, true));
        titulo = new BorderPane();
        titulo.setLeft(icono);
        titulo.setCenter(nombre);
        titulo.setRight(cerrar);
        titulo.setBackground(new Background(fondo));
        titulo.setStyle("-fx-border-color: orange; -fx-border-width: 2px");
    }

    public Node getBarra() {
        return titulo;
    }

}
