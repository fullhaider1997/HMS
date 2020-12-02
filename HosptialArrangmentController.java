/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.admin;

import java.net.URL;
import java.util.ResourceBundle;

import DataModelLayer.Room;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utilities.QueryRequest;

public class HosptialArrangmentController implements Initializable {

	@FXML
	private Label label;
	@FXML
	private TextField filterFieldRooms;
	@FXML
	private TableView<Room> tabelViewRooms;

	private final ObservableList<Room> roomDataList = QueryRequest.GetAllRooms();

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		TableColumn<Room, Integer> roomID = new TableColumn<Room, Integer>("Room ID");
		TableColumn<Room, Integer> bedcount = new TableColumn<Room, Integer>("Bed Count");
		TableColumn<Room, String> type = new TableColumn<Room, String>("Room Type");
		TableColumn<Room, String> status = new TableColumn<Room, String>("Status");

		roomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
		bedcount.setCellValueFactory(new PropertyValueFactory<>("NumOfBeds"));
		type.setCellValueFactory(new PropertyValueFactory<>("type"));
		status.setCellValueFactory(new PropertyValueFactory<>("StatusAvailability"));

		tabelViewRooms.getColumns().addAll(roomID, bedcount, type, status);

		FilteredList<Room> filterdData = new FilteredList<>(roomDataList, b -> true);

		filterFieldRooms.textProperty().addListener((observable, oldValue, newValue) -> {
			filterdData.setPredicate(Room -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (Integer.toString(Room.getRoomID()).contains(lowerCaseFilter)) {
					return true;
				} else if (Room.getType().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Room.getStatusAvailability().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Integer.toString(Room.getNumOfBeds()).contains(lowerCaseFilter)) {
					return true;
				} else
					return false;

			});

		});

		SortedList<Room> sortedData = new SortedList<Room>(filterdData);

		sortedData.comparatorProperty().bind(tabelViewRooms.comparatorProperty());

		tabelViewRooms.setItems(sortedData);

	}

}
