package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private ListView<String> listView;
    private TextField newInfoTextField;
    private Map<String, String> labelData;

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();

            // SE CREA EL ANCHORPANE PARA LAS IMÁGENES Y ETIQUETAS
            AnchorPane leftPane = new AnchorPane();

            // SE CARGAN LAS IMÁGENES DESDE LA CARPETA AVATARS
            Image imagen1 = new Image(getClass().getResource("/avatars/avatar1.jpg").toExternalForm());
            Image imagen2 = new Image(getClass().getResource("/avatars/avatar2.jpg").toExternalForm());
            Image imagen3 = new Image(getClass().getResource("/avatars/avatar3.png").toExternalForm());
            Image imagen4 = new Image(getClass().getResource("/avatars/avatar4.png").toExternalForm());
            Image imagen5 = new Image(getClass().getResource("/avatars/avatar5.png").toExternalForm());

            // SE CREA IMAGEVIEWS Y AJUSTAR TAMAÑO
            double imageWidth = 90;
            double imageHeight = 90;
            ImageView imageView1 = new ImageView(imagen1);
            ImageView imageView2 = new ImageView(imagen2);
            ImageView imageView3 = new ImageView(imagen3);
            ImageView imageView4 = new ImageView(imagen4);
            ImageView imageView5 = new ImageView(imagen5);
            imageView1.setFitWidth(imageWidth);
            imageView1.setFitHeight(imageHeight);
            imageView2.setFitWidth(imageWidth);
            imageView2.setFitHeight(imageHeight);
            imageView3.setFitWidth(imageWidth);
            imageView3.setFitHeight(imageHeight);
            imageView4.setFitWidth(imageWidth);
            imageView4.setFitHeight(imageHeight);
            imageView5.setFitWidth(imageWidth);
            imageView5.setFitHeight(imageHeight);

            // SE CREAN ETIQUETAS PARA LAS IMÁGENES
            Label usuario1 = new Label("CAMILA LISBETH CHOEZ GARCIA", imageView1);
            Label usuario2 = new Label("CARLOS ANTONIO DOMINGUEZ RIVERA", imageView2);
            Label usuario3 = new Label("MARCO ANTONIO FRANCO TOALA", imageView3);
            Label usuario4 = new Label("LIZ ABIGAIL MERCHAN COOX", imageView4);
            Label usuario5 = new Label("CAMILO STEVEN GARCIA PEREZ", imageView5);

            // SE CREAN LOS DATOS ALMACENADOS PARA CADA ETIQUETA
            labelData = new HashMap<>();
            labelData.put("Etiqueta 1", "CÉDULA: 12345678, EDAD: 34, DIRECCIÓN: Av. Principal #123");
            labelData.put("Etiqueta 2", "CÉDULA: 87654321, EDAD: 33, DIRECCIÓN: Calle Secundaria #456");
            labelData.put("Etiqueta 3", "CÉDULA: 11223344, EDAD: 32, DIRECCIÓN: Av. Central #789");
            labelData.put("Etiqueta 4", "CÉDULA: 55667788, EDAD: 31, DIRECCIÓN: Calle Principal #1011");
            labelData.put("Etiqueta 5", "CÉDULA: 55667788, EDAD: 31, DIRECCIÓN: Av. Norte #1213");

            // SE CREA EL MANEJO DE EVENTOS PARA CLICS EN LAS ETIQUETAS
            usuario1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> listView.getItems().add(labelData.get("Etiqueta 1")));
            usuario2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> listView.getItems().add(labelData.get("Etiqueta 2")));
            usuario3.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> listView.getItems().add(labelData.get("Etiqueta 3")));
            usuario4.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> listView.getItems().add(labelData.get("Etiqueta 4")));
            usuario5.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> listView.getItems().add(labelData.get("Etiqueta 5")));

            // SE UBICAN ELEMENTOS EN EL ANCHORPANE
            leftPane.getChildren().addAll(usuario1, usuario2, usuario3, usuario4, usuario5);

            // SE POSICIONAN LAS ETIQUETAS DE FORMA VERTICAL SIN TOCARSE
            AnchorPane.setTopAnchor(usuario1, 20.0);
            AnchorPane.setLeftAnchor(usuario1, 20.0);

            AnchorPane.setTopAnchor(usuario2, 120.0);
            AnchorPane.setLeftAnchor(usuario2, 20.0);

            AnchorPane.setTopAnchor(usuario3, 220.0);
            AnchorPane.setLeftAnchor(usuario3, 20.0);

            AnchorPane.setTopAnchor(usuario4, 320.0);
            AnchorPane.setLeftAnchor(usuario4, 20.0);

            AnchorPane.setTopAnchor(usuario5, 420.0);
            AnchorPane.setLeftAnchor(usuario5, 20.0);

            // SE CONFIGURA LA PARTE DERECHA DEL BORDERPANE
            AnchorPane rightPane = new AnchorPane();

            listView = new ListView<>();
            rightPane.getChildren().add(listView);

            AnchorPane.setTopAnchor(listView, 20.0);
            AnchorPane.setLeftAnchor(listView, 20.0);
            AnchorPane.setRightAnchor(listView, 20.0);
            AnchorPane.setBottomAnchor(listView, 80.0);

            newInfoTextField = new TextField();
            newInfoTextField.setPromptText("REGISTRE NUEVA INFORMACION ..");
            rightPane.getChildren().add(newInfoTextField);

            AnchorPane.setBottomAnchor(newInfoTextField, 20.0);
            AnchorPane.setLeftAnchor(newInfoTextField, 10.0);
            AnchorPane.setRightAnchor(newInfoTextField, 20.0);

            // SE GUARDA INFORMACIÓN AL PRESIONAR ENTER
            newInfoTextField.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    String newText = newInfoTextField.getText();
                    if (!newText.isEmpty()) {
                        listView.getItems().add(newText);
                        newInfoTextField.clear();
                    }
                }
            });

            root.setLeft(leftPane);
            root.setRight(rightPane);

            // SE CREA LA INTERFAZ GRÁFICA Y SE MUESTRA
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setTitle("JavaFX");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
