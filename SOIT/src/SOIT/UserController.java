package SOIT;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class UserController extends Features implements Initializable {

    @FXML
    private StackPane stkReport;
    @FXML
    private Pane pnReported;
    @FXML
    private Button reportToHome;
    @FXML
    private Pane pnIssue;
    @FXML
    private TextArea txtIssue;
    @FXML
    private Button reportSubmit;
    @FXML
    private Pane pnTable;
    @FXML
    private ImageView iconTableToReport;
    @FXML
    private TableView<Hospital> table;
    @FXML
    private TableColumn<Hospital, String> colName;
    @FXML
    private TableColumn<Hospital, String> colLoc;
    @FXML
    private TableColumn<Hospital, String> colICU;
    @FXML
    private TableColumn<Hospital, String> colOxy;
    @FXML
    private TableColumn<Hospital, String> colContact;
    @FXML
    private TableColumn<Hospital, String> colUpdate;
    @FXML
    private TextField searchBar;
    @FXML
    private Label tableToReport;
    @FXML
    private ImageView issueToTable;

    @FXML
    private CheckBox chkICU;

    @FXML
    private CheckBox chkOxygen;

    @FXML
    private ImageView btnReload;

    ArrayList<TableColumn<Hospital, String>> AllColumns = new ArrayList<>();

    void fetchData(){
        AllColumns.add(colName);
        AllColumns.add(colLoc);
        AllColumns.add(colICU);
        AllColumns.add(colOxy);
        AllColumns.add(colContact);
        AllColumns.add(colUpdate);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File f = ReadFile("data.csv");
        fetchData();
        TableManager(f, AllColumns,table, 2);

        SearchingContent(searchBar, table);
    }

    @FXML
    void showChkResult(MouseEvent event) {
        boolean icu = chkICU.isSelected();
        boolean oxy = chkOxygen.isSelected();

        int filter = 2;

        if(!icu && oxy) filter =  0;
        else if(!oxy && icu) filter = 1;

        File f = ReadFile("data.csv");

        fetchData();

        TableManager(f, AllColumns,table, filter);

        SearchingContent(searchBar, table);
    }


    @FXML
    private void tableToReport (MouseEvent event) {
        if(event.getSource().equals(tableToReport) || event.getSource().equals(iconTableToReport)) {
            stkReport.toFront();
            pnIssue.toFront();
        }
    }

    @FXML
    private void issueToTable(MouseEvent event) {
        if(event.getSource().equals(issueToTable)) {
            pnTable.toFront();
        }
    }

    @FXML
    public void switchToHome(MouseEvent event) throws IOException {
        Parent switchHome = LoadFXML(event.getSource(), "home.fxml");
    }

    @FXML
    public void switchToHome2(ActionEvent event) throws IOException {
        Parent switchHome2 = LoadFXML(event.getSource(), "home.fxml");
    }

    @FXML
    private void reportSubmit(ActionEvent event) throws IOException {
        if(event.getSource().equals(reportSubmit)) {
            pnReported.toFront();
            String data = ">> " + txtIssue.getText() + "\n";

            if(txtIssue.getText() == null){
                return;
            }
            else{
                File fp = ReadFile("Report.txt");
                WriteFile(fp, data, true);
            }
        }
    }

}