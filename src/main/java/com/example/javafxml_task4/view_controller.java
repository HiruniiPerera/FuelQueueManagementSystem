//Student name: Hiruni Perera Student ID: w1898953
package com.example.javafxml_task4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class view_controller implements Initializable {
    @FXML
    private TextField searchbox;
    @FXML
    private TableColumn<Passenger, Integer> amt_fuel;
    @FXML
    private TableColumn<Passenger, String> fname;
    @FXML
    private TableColumn<Passenger,String> sname;
    @FXML
    private TableView<Passenger> table;
    @FXML
    private TableColumn<Passenger, String> vehnum;
    @FXML
    private TableColumn<Passenger, Integer> amt_fuel2;
    @FXML
    private TableColumn<Passenger, String> fname2;
    @FXML
    private TableColumn<Passenger,String> sname2;
    @FXML
    private TableView<Passenger> table2;
    @FXML
    private TableColumn<Passenger, String> vehnum2;
    @FXML
    private TableColumn<Passenger, Integer> amt_fuel3;
    @FXML
    private TableColumn<Passenger, String> fname3;
    @FXML
    private TableColumn<Passenger,String> sname3;
    @FXML
    private TableView<Passenger> table3;
    @FXML
    private TableColumn<Passenger, String> vehnum3;
    @FXML
    private TableColumn<Passenger, Integer> amt_fuel4;
    @FXML
    private TableColumn<Passenger, String> fname4;
    @FXML
    private TableColumn<Passenger,String> sname4;
    @FXML
    private TableView<Passenger> table4;
    @FXML
    private TableColumn<Passenger, String> vehnum4;
    @FXML
    private TableColumn<Passenger, Integer> amt_fuel5;
    @FXML
    private TableColumn<Passenger, String> fname5;
    @FXML
    private TableColumn<Passenger,String> sname5;
    @FXML
    private TableView<Passenger> table5;
    @FXML
    private TableColumn<Passenger, String> vehnum5;
    @FXML
    private TableColumn<Passenger, Integer> amt_fuelwait;
    @FXML
    private TableColumn<Passenger, String> fnamewait;
    @FXML
    private TableColumn<Passenger,String> snamewait;
    @FXML
    private TableView<Passenger> tablewait;
    @FXML
    private TableColumn<Passenger, String> vehnumwait;

//creates a method to create observable list for each queue
    private static ObservableList<Passenger> getlist(FuelQueue FQ) {
        final ObservableList<Passenger> Quedetails = FXCollections.observableArrayList();
        for (int i = 0; i < FQ.getQueues().size(); i++) {
            Passenger viewpass = FQ.getpass(i);
            Quedetails.add(viewpass);
        }
        return Quedetails;
    }
    private final ObservableList<Passenger>Q1details=getlist(mainclass.Q1);
    private final ObservableList<Passenger>Q2details=getlist(mainclass.Q2);
    private final ObservableList<Passenger>Q3details=getlist(mainclass.Q3);
    private final ObservableList<Passenger>Q4details=getlist(mainclass.Q4);
    private final ObservableList<Passenger>Q5details=getlist(mainclass.Q5);
    private final ObservableList<Passenger>waitdetails=getlist(mainclass.wait_list);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    try {


        fname.setCellValueFactory(new PropertyValueFactory<Passenger,String>("fname"));
        sname.setCellValueFactory(new PropertyValueFactory<Passenger, String>("sname"));
        vehnum.setCellValueFactory(new PropertyValueFactory<Passenger,String>("vehiclenum"));
        amt_fuel.setCellValueFactory(new PropertyValueFactory<Passenger,Integer>("liters"));


        FilteredList<Passenger> table_data = new FilteredList<>(Q1details, b -> true);

        searchbox.textProperty().addListener((Observable, oldValue, newValue) -> {
            table_data.setPredicate(Passenger -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String filter = newValue.toLowerCase();
                if (Passenger.getFname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getSname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getVehiclenum().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (String.valueOf(Passenger.getLiters()).indexOf(filter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });

        });
        SortedList<Passenger> sorteddata = new SortedList<>(table_data);

        sorteddata.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sorteddata);

        fname2.setCellValueFactory(new PropertyValueFactory<Passenger,String >("fname"));
        sname2.setCellValueFactory(new PropertyValueFactory<Passenger,String>("sname"));
        vehnum2.setCellValueFactory(new PropertyValueFactory<Passenger,String>("vehiclenum"));
        amt_fuel2.setCellValueFactory(new PropertyValueFactory<Passenger,Integer>("liters"));

        FilteredList<Passenger> table_data2 = new FilteredList<>(Q2details, c -> true);

        searchbox.textProperty().addListener((Observable, oldValue, newValue) -> {
                    table_data2.setPredicate(Passenger -> {

                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String filter = newValue.toLowerCase();
                        if (Passenger.getFname().toLowerCase().indexOf(filter) != -1) {
                            return true;
                        } else if (Passenger.getSname().toLowerCase().indexOf(filter) != -1) {
                            return true;
                        } else if (Passenger.getVehiclenum().toLowerCase().indexOf(filter) != -1) {
                            return true;
                        } else if (String.valueOf(Passenger.getLiters()).indexOf(filter) != -1) {
                            return true;
                        } else {
                            return false;
                        }

                    });
        });

        SortedList<Passenger> sorteddata2 = new SortedList<>(table_data2);

        sorteddata2.comparatorProperty().bind(table2.comparatorProperty());

        table2.setItems(sorteddata2);

        fname3.setCellValueFactory(new PropertyValueFactory<>("fname"));
        sname3.setCellValueFactory(new PropertyValueFactory<>("sname"));
        vehnum3.setCellValueFactory(new PropertyValueFactory<>("vehiclenum"));
        amt_fuel3.setCellValueFactory(new PropertyValueFactory<>("liters"));


        FilteredList<Passenger> table_data3 = new FilteredList<>(Q3details, a -> true);

        searchbox.textProperty().addListener((Observable, oldValue, newValue) -> {
            table_data3.setPredicate(Passenger -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String filter = newValue.toLowerCase();
                if (Passenger.getFname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getSname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getVehiclenum().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (String.valueOf(Passenger.getLiters()).indexOf(filter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });

        });
        SortedList<Passenger> sorteddata3 = new SortedList<>(table_data3);

        sorteddata3.comparatorProperty().bind(table3.comparatorProperty());

        table3.setItems(sorteddata3);


        fname4.setCellValueFactory(new PropertyValueFactory<Passenger,String>("fname"));
        sname4.setCellValueFactory(new PropertyValueFactory<Passenger, String>("sname"));
        vehnum4.setCellValueFactory(new PropertyValueFactory<Passenger,String>("vehiclenum"));
        amt_fuel4.setCellValueFactory(new PropertyValueFactory<Passenger,Integer>("liters"));


        FilteredList<Passenger> table_data4 = new FilteredList<>(Q4details, d -> true);

        searchbox.textProperty().addListener((Observable, oldValue, newValue) -> {
            table_data4.setPredicate(Passenger -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String filter = newValue.toLowerCase();
                if (Passenger.getFname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getSname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getVehiclenum().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (String.valueOf(Passenger.getLiters()).indexOf(filter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });

        });
        SortedList<Passenger> sorteddata4 = new SortedList<>(table_data4);

        sorteddata4.comparatorProperty().bind(table4.comparatorProperty());

        table4.setItems(sorteddata4);

        fname5.setCellValueFactory(new PropertyValueFactory<Passenger,String>("fname"));
        sname5.setCellValueFactory(new PropertyValueFactory<Passenger, String>("sname"));
        vehnum5.setCellValueFactory(new PropertyValueFactory<Passenger,String>("vehiclenum"));
        amt_fuel5.setCellValueFactory(new PropertyValueFactory<Passenger,Integer>("liters"));


        FilteredList<Passenger> table_data5 = new FilteredList<>(Q5details, e -> true);

        searchbox.textProperty().addListener((Observable, oldValue, newValue) -> {
            table_data5.setPredicate(Passenger -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String filter = newValue.toLowerCase();
                if (Passenger.getFname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getSname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getVehiclenum().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (String.valueOf(Passenger.getLiters()).indexOf(filter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });

        });
        SortedList<Passenger> sorteddata5 = new SortedList<>(table_data5);

        sorteddata5.comparatorProperty().bind(table5.comparatorProperty());

        table5.setItems(sorteddata5);

        fnamewait.setCellValueFactory(new PropertyValueFactory<Passenger,String>("fname"));
        snamewait.setCellValueFactory(new PropertyValueFactory<Passenger, String>("sname"));
        vehnumwait.setCellValueFactory(new PropertyValueFactory<Passenger,String>("vehiclenum"));
        amt_fuelwait.setCellValueFactory(new PropertyValueFactory<Passenger,Integer>("liters"));


        FilteredList<Passenger> table_datawait = new FilteredList<>(waitdetails, e -> true);

        searchbox.textProperty().addListener((Observable, oldValue, newValue) -> {
            table_datawait.setPredicate(Passenger -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String filter = newValue.toLowerCase();
                if (Passenger.getFname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getSname().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (Passenger.getVehiclenum().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (String.valueOf(Passenger.getLiters()).indexOf(filter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });

        });
        SortedList<Passenger> sorteddatawait = new SortedList<>(table_datawait);

        sorteddatawait.comparatorProperty().bind(tablewait.comparatorProperty());

        tablewait.setItems(sorteddatawait);
    }catch(Exception e){
        System.out.println("Unable tp produce GUI");
    }


    }
}
