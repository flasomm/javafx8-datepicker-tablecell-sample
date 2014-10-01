package com.physalix.jfx;

import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Main class.
 *
 * @author Fabrice Sommavilla <fs@physalix.com>
 */
public class Main extends Application {

    private static final String STYLESHEET_PATH = "/styles/styles.css";

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        scene.getStylesheets().add(STYLESHEET_PATH);
        stage.setTitle("DatePicker TableCell Sample");
        stage.setWidth(315);
        stage.setHeight(450);

        final ObservableList<BirthdayEvent> dataList
                = FXCollections.observableArrayList(
                        new BirthdayEvent("Jacob", new Date()),
                        new BirthdayEvent("Isabella", new Date()),
                        new BirthdayEvent("Ethan", new Date()),
                        new BirthdayEvent("Emma", new Date()),
                        new BirthdayEvent("Michael", new Date()));

        TableView table = new TableView();
        table.setEditable(true);

        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setPrefWidth(90);
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<BirthdayEvent, String>("name"));

        TableColumn dateColumn = new TableColumn("Date");
        dateColumn.setEditable(true);
        dateColumn.setPrefWidth(75);
        dateColumn.setMinWidth(200);

        dateColumn.setCellValueFactory(new PropertyValueFactory<BirthdayEvent, Date>("date"));
        dateColumn.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                DatePickerCell datePick = new DatePickerCell(dataList);
                return datePick;
            }
        });

        table.getColumns().addAll(nameColumn, dateColumn);
        table.setItems(dataList);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().add(table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    // ---------- ---------- ---------- ---------- ----------
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
