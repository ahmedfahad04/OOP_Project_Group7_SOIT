package SOIT;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Dependencies {

    abstract void SearchEngine(TextField tf, TableView tb);
    abstract File ReadFile(String fileName);
    abstract void WriteFile(File fp, String content, boolean b) throws IOException;
    abstract void TableManager(File fp, ArrayList<TableColumn<Hospital, String>> x, TableView tb, int filter);
    abstract <T> void LoadFXML(T event, String fxmlName) throws IOException;
    abstract StringBuffer SaveData(String key, String ICU, String Oxygen, String Contact) throws IOException;

}