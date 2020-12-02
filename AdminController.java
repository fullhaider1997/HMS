
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.LoginSystemController.DEFAULT_PORT;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Controllers.admin.HosptialEmployeesController;
import Controllers.admin.PatientViewController;
import client.Client;
import common.ChatIF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utilities.Utilities;

/**
 * FXML Controller class
 *
 * @author Haider
 */
public class AdminController implements Initializable, ChatIF {

	static Client adminClient;
	static String name;
	// final public static int DEFAULT_PORT = 5555;
	String host = "";
	@FXML
	private Label StatusField;
	Utilities utility = new Utilities();
	static Object msg;

	public void setUserName(String username) throws IOException {

		AdminController.name = username;
		StatusField.setText(username);

	}

	public static void setClient(Client client) throws IOException {

		AdminController.adminClient = client;

	}

	public static void setMsg(Object msg) throws IOException {

		AdminController.msg = msg;
	}

	public void ButtonGoToLogin(ActionEvent event) throws IOException {

		Parent parentScene = FXMLLoader.load(getClass().getResource("/Usergui/FXMLLoginSystem.fxml"));
		Scene NextScene = new Scene(parentScene);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(NextScene);
		window.show();

	}

	public void PatientTab(ActionEvent event) throws IOException {

		adminClient.sendToServer("Hello from patient tab");

		PatientViewController.setScreen("home");

		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLPatientView.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	public void EmployeeTab(ActionEvent event) throws IOException {

		adminClient.sendToServer("Hello from employee tab");

		HosptialEmployeesController.setScreen("home");
		
		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	public void HosptialArragmentTab(ActionEvent event) throws IOException {

		adminClient.sendToServer("Hello from hosptial tab");

		//HosptialArrangmentController.setScreen("home");
		
		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialArrangment.fxml",
				"/Usergui/Admin/FXMLAdmin.fxml");

	}

	public void AdminGuideTab(ActionEvent event) throws IOException {

		adminClient.sendToServer("Hello from adminguide tab");

		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLAdminGuide.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	public void ManageAppointmentsTab(ActionEvent event) throws IOException {

		adminClient.sendToServer("Hello from ManageAppointmenttab");

		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLManagingAppointments.fxml",
				"/Usergui/Admin/FXMLAdmin.fxml");

	}

	public void ExportDataTab(ActionEvent event) throws IOException {

		adminClient.sendToServer("Exporttab");

		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLExportData.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	public static void Main(String[] args) throws IOException {
		System.out.println("Admin controller 1");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		{

			System.out.println("initalize admin controller");

			try {
				adminClient = new Client(host, DEFAULT_PORT, this);

				adminClient.openConnection();
			} catch (IOException ex) {
				Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}

	public static Object getMsg() {
		return msg;
	}

	public static Client getClient() {
		return adminClient;
	}

	@Override
	public void display(String message) {
		System.out.println(message);
	}
}
