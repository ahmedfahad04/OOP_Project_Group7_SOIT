package SOIT;


import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

public interface Dependencies {

    void SearchingContent(TextField tf, TableView tb);

    File ReadFile(String fileName);

    void TableManager(File fp, ArrayList<TableColumn<Hospital, String>> x, TableView tb);

    <T> Parent LoadFXML(T event, String fxmlName) throws IOException;

    void WriteFile(File fp, String content, boolean b) throws IOException;

    StringBuffer SaveData(String key, String ICU, String Oxygen, String Contact) throws IOException;

}