package asuHelloWorldJavaFX;

// JAVA FX IMPORTS
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// JAVA IMPORTS
import java.util.*;

public class ASUHelloWorldJavaFX extends Application {

  /* Hard-coded Database */
  StaffRecords sRecord = new StaffRecords();
  PatientRecords pRecord= new PatientRecords();
  
  /* MAIN CLASS*/
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Welcome to CSE360_Project_Fall");
    Label messageLabel = new Label();

    /*
      LOGIN AND CREATE ACCOUNT SCREENS
    */
    
    // Login text components
    Label loginTitle = new Label("Login Existing User");
    TextField usernameField = new TextField();
    usernameField.setPromptText("Username");
    PasswordField passwordField = new PasswordField();
    passwordField.setPromptText("Password");

    // Create Account text components
    Label createTitle = new Label("Create Patient Account");
    TextField newUsername = new TextField();
    newUsername.setPromptText("New Username");
    PasswordField newPassword = new PasswordField();
    newPassword.setPromptText("New Password");
    PasswordField checkPassword = new PasswordField();
    checkPassword.setPromptText("Confirm Password");
    
    // Doctor's View 
    

    // Login buttons
    Button loginButton = new Button("Login");
    RadioButton selectDoctor = new RadioButton();
    Label selectD = new Label("Doctor");
    RadioButton selectNurse = new RadioButton();
    Label selectN = new Label("Nurse");
    RadioButton selectPatient = new RadioButton();
    Label selectP = new Label("Patient");

    // Create Account buttons
    Button createButton = new Button("Create Account");
    
    // Select Buttons
    ToggleGroup select = new ToggleGroup();
    selectDoctor.setToggleGroup(select);
    selectNurse.setToggleGroup(select);
    selectPatient.setToggleGroup(select);
    
    // Layout for login form
    HBox selectButtons = new HBox(10);
    selectButtons.setPadding(new Insets(20));
    selectButtons.getChildren().addAll(selectDoctor, selectD, selectNurse, selectN, selectPatient, selectP);
    
    VBox loginLayout = new VBox(10);
    loginLayout.setPadding(new Insets(20));
    loginLayout.getChildren().addAll(loginTitle, usernameField, passwordField, selectButtons, loginButton);

    // Layout for create account
    VBox createLayout = new VBox(10);
    createLayout.setPadding(new Insets(20));
    createLayout.getChildren().addAll(createTitle, newUsername, newPassword, checkPassword, createButton);

    // Initial screen layout
    HBox initialScreen = new HBox(10);
    initialScreen.setPadding(new Insets(20));
    initialScreen.getChildren().addAll(createLayout, loginLayout);

    VBox initScreen = new VBox(10);
    initScreen.setPadding(new Insets(20));
    initScreen.getChildren().addAll(initialScreen, messageLabel);
    
    Scene homeScreen = new Scene(initScreen, 600, 500);
    

    /*
      ADDITIONAL PATIENT ACCOUNT INFO SCREEN
    */
    Label CAIS_ERROR = new Label();

    Label addAccountWelcome = new Label("Welcome! Please complete the following form.");
    
    TextField firstName = new TextField();
    firstName.setPromptText("First Name");
    TextField lastName = new TextField();
    lastName.setPromptText("Last Name");
    
    Label dobTitle = new Label("Enter Date of Birth:");
    TextField month = new TextField();
    month.setPromptText("MM");
    TextField day = new TextField();
    day.setPromptText("DD");
    TextField year = new TextField();
    year.setPromptText("YYYY");

    HBox dateOfBirth = new HBox(10);
    dateOfBirth.setPadding(new Insets(20));
    dateOfBirth.getChildren().addAll(month, day, year);

    Button caisEnterButton = new Button("Enter Info");
    
    VBox createAccountInfoScreen = new VBox(10);
    createAccountInfoScreen.setPadding(new Insets(20));
    createAccountInfoScreen.getChildren().addAll(addAccountWelcome, firstName, lastName, dobTitle, dateOfBirth, caisEnterButton, CAIS_ERROR);

    /*
    PATIENT VIEW SCREEN
  */
    
  Label welcomePV = new Label("Patient View.");
  HBox titleBoxPV = new HBox(welcomePV);

  //Patients list 
  ListView<String> visitListPV = new ListView<>();
  visitListPV.getItems().addAll("February 15th 2024", "March 10th 2024", "July 21 2023");
  TextField searchedPatientFieldPV = new TextField();
  searchedPatientFieldPV.setPromptText("Search Visits");
  Button searchPatientPV = new Button("Search");
  Button patientLogout = new Button("Logout");
  VBox searchPatientBoxPV = new VBox(searchedPatientFieldPV, visitListPV,  searchPatientPV, patientLogout);

  //Tabs for patients - center
  TabPane patientDetailsTabsPV = new TabPane();
  Tab summaryOfVisit = new Tab("Summary of Visit");
  summaryOfVisit.setClosable(false);
  Tab patientHistoryTabPV = new Tab("Patient History");
  patientHistoryTabPV.setClosable(false);
  Tab insuranceTabPV = new Tab("Insurance");
  insuranceTabPV.setClosable(false);
  patientDetailsTabsPV.getTabs().addAll(summaryOfVisit, patientHistoryTabPV, insuranceTabPV);

  /*
    Center information 
  */
  
    Label date = new Label("Date: " );

    
  
  //Patients - Inbox and Send Message
  TabPane emailTabPanePV = new TabPane();

  //Inbox
  Tab inboxTabPV = new Tab("Inbox");
  inboxTabPV.setClosable(false);
  ListView<String> inboxPV = new ListView<>();
  inboxPV.getItems().addAll("Message 1", "Message 2", "Message 3");
  inboxTabPV.setContent(inboxPV);

  //Send a Message
  Tab sendMessageTabPV = new Tab("Send a Message");
  sendMessageTabPV.setClosable(false);

  emailTabPanePV.getTabs().addAll(inboxTabPV, sendMessageTabPV);

  TextField typeMessagePV = new TextField();
  typeMessagePV.setPromptText("Type your message here:");
  Label sendAMessageToLabelPV = new Label( "Send a message to: ");
  RadioButton doctorButtonPV = new RadioButton("Doctor");
  RadioButton nurseButtonPV = new RadioButton("Nurse");
  ToggleGroup sendMessageToPV = new ToggleGroup();
  doctorButtonPV.setToggleGroup(sendMessageToPV);
  nurseButtonPV.setToggleGroup(sendMessageToPV);

  HBox sendMessageToPVBox = new HBox(10, doctorButtonPV, nurseButtonPV);

  Label usernameSendToPV = new Label("Username:");
  TextField usernameSendToPVField = new TextField();

  HBox user_sendToPV = new HBox(10);
  user_sendToPV.setPadding(new Insets(20));
  user_sendToPV.getChildren().addAll(usernameSendToPV, usernameSendToPVField);

  Label passwordSendToPV = new Label("Password:");
  PasswordField passwordSendToPVField = new PasswordField();

  HBox pass_sendToPV = new HBox(10);
  pass_sendToPV.setPadding(new Insets(20));
  pass_sendToPV.getChildren().addAll(passwordSendToPV, passwordSendToPVField);

  CheckBox urgentPV = new CheckBox("Check if Urgent");
  Button submitPV = new Button("Submit");

  HBox buttonsBoxPV = new HBox(10);
  buttonsBoxPV.setPadding(new Insets(20));
  buttonsBoxPV.getChildren().addAll(urgentPV, submitPV);

  VBox sendMessagePV = new VBox(10);
  sendMessagePV.setPadding(new Insets(20));
  sendMessagePV.getChildren().addAll(emailTabPanePV,
                                     typeMessagePV, 
                                     sendAMessageToLabelPV, 
                                     sendMessageToPVBox, 
                                     user_sendToPV, 
                                     pass_sendToPV, 
                                     buttonsBoxPV);

  sendMessageTabPV.setContent(sendMessagePV);

  BorderPane patientView = new BorderPane();
  patientView.setTop(titleBoxPV);
  patientView.setLeft(searchPatientBoxPV);
  patientView.setCenter(patientDetailsTabsPV);
  patientView.setRight(emailTabPanePV);

  Scene patientViewScene = new Scene(patientView, 600, 500);

  // Patient Logout Check 
  patientLogout.setOnAction(e -> {
    primaryStage.setScene(homeScreen);
    usernameField.clear();
    passwordField.clear();
    newUsername.clear();
    newPassword.clear();
    checkPassword.clear();
    messageLabel.setText("");
  });


  /*
    MY PROFILE PATIENT VIEW 
  */

  //Labels 
  Label myProfileTitlePV = new Label("My Profile");
  Label myProfileNamePV = new Label("Name: ");
  Label myProfileBirthdayPV = new Label("Date of Birth: ");
  Label myProfilePhonePV = new Label("Phone Number: ");
  Label myProfileEmailPV = new Label("Email: ");
  Label myProfileSpecialNotesPV = new Label("Special Notes: ");

  //Text Fields 
  TextField myProfileNameFieldPV = new TextField("Jane Smith");
  TextField myProfileBirthdayFieldPV = new TextField("12/12/1990");
  TextField myProfilePhoneFieldPV = new TextField("123-456-7890");
  TextField myProfileEmailFieldPV = new TextField("oqibz@example.com");
  TextField myProfileSpecialNotesFieldPV = new TextField("I am a patient");

  //Buttons 
  Button myProfileConfirmButtonPV = new Button("Confirm");

  //HBox
  HBox myProfileNameHBoxPV = new HBox(10);
  myProfileNameHBoxPV.getChildren().addAll(myProfileNamePV, myProfileNameFieldPV);
  HBox myProfileBirthdayHBoxPV = new HBox(10);
  myProfileBirthdayHBoxPV.getChildren().addAll(myProfileBirthdayPV, myProfileBirthdayFieldPV);
  HBox myProfilePhoneHBoxPV = new HBox(10);
  myProfilePhoneHBoxPV.getChildren().addAll(myProfilePhonePV, myProfilePhoneFieldPV);
  HBox myProfileEmailHBoxPV = new HBox(10);
  myProfileEmailHBoxPV.getChildren().addAll(myProfileEmailPV, myProfileEmailFieldPV);
  HBox myProfileSpecialNotesHBoxPV = new HBox(10);
  myProfileSpecialNotesHBoxPV.getChildren().addAll(myProfileSpecialNotesPV, myProfileSpecialNotesFieldPV);

  //VBox
  VBox myProfileVBoxPV = new VBox(10);
  myProfileVBoxPV.getChildren().addAll(myProfileTitlePV, myProfileNameHBoxPV, myProfileBirthdayHBoxPV, myProfilePhoneHBoxPV, myProfileEmailHBoxPV, myProfileSpecialNotesHBoxPV, myProfileConfirmButtonPV);

  



  /*
    DOCTOR VIEW
  */
  Label welcomeDV = new Label("Doctor View.");
  HBox titleBoxDV = new HBox(welcomeDV);

  //Patients list
  ListView<String> patientListDV = new ListView<>();
  patientListDV.getItems().addAll("Patient 1", "Patient 2", "Patient 3");
  TextField searchedPatientFieldDV = new TextField();
  searchedPatientFieldDV.setPromptText("Search Patient");
  Button searchPatientDV = new Button("Search");
  Button docLogout = new Button("Logout");
  VBox searchPatientBoxDV = new VBox(searchedPatientFieldDV, patientListDV,  searchPatientDV, docLogout);

  //Tabs for patients - center
  TabPane patientDetailsTabsDV = new TabPane();
  Tab examinationTabDV = new Tab("Exam results");
  examinationTabDV.setClosable(false);
  Tab patientHistoryTabDV = new Tab("Patient History");
  patientHistoryTabDV.setClosable(false);
  patientDetailsTabsDV.getTabs().addAll(examinationTabDV, patientHistoryTabDV);

  //Patients - Inbox and Send Message
  TabPane emailTabPaneDV = new TabPane();

  //Inbox
  Tab inboxTabDV = new Tab("Inbox");
  inboxTabDV.setClosable(false);
  ListView<String> inboxDV = new ListView<>();
  inboxDV.getItems().addAll("Message 1", "Message 2", "Message 3");
  inboxTabDV.setContent(inboxDV);

  //Send a Message
  Tab sendMessageTabDV = new Tab("Send a Message");
  sendMessageTabDV.setClosable(false);

  emailTabPaneDV.getTabs().addAll(inboxTabDV, sendMessageTabDV);
  
  TextField typeMessageDV = new TextField();
  typeMessageDV.setPromptText("Type your message here:");
  Label sendAMessageToLabelDV = new Label( "Send a message to: ");
  RadioButton doctorButtonDV = new RadioButton("Patient");
  ToggleGroup sendMessageToDV = new ToggleGroup();
  doctorButtonDV.setToggleGroup(sendMessageToDV);
  

  HBox sendMessageToDVBox = new HBox(10, doctorButtonDV);

  Label usernameSendToDV = new Label("Username:");
  TextField usernameSendToDVField = new TextField();

  HBox user_sendToDV = new HBox(10);
  user_sendToDV.setPadding(new Insets(20));
  user_sendToDV.getChildren().addAll(usernameSendToDV, usernameSendToDVField);

  Label passwordSendToDV = new Label("Password:");
  PasswordField passwordSendToDVField = new PasswordField();

  HBox pass_sendToDV = new HBox(10);
  pass_sendToDV.setPadding(new Insets(20));
  pass_sendToDV.getChildren().addAll(passwordSendToDV, passwordSendToDVField);

  CheckBox urgentDV = new CheckBox("Check if Urgent");
  Button submitDV = new Button("Submit");

  HBox buttonsBoxDV = new HBox(10);
  buttonsBoxDV.setPadding(new Insets(20));
  buttonsBoxDV.getChildren().addAll(urgentDV, submitDV);

  VBox sendMessageDV = new VBox(10);
  sendMessageDV.setPadding(new Insets(20));
  sendMessageDV.getChildren().addAll(emailTabPaneDV,
                                     typeMessageDV, 
                                     sendAMessageToLabelDV, 
                                     sendMessageToDVBox, 
                                     user_sendToDV, 
                                     pass_sendToDV, 
                                     buttonsBoxDV);

  sendMessageTabDV.setContent(sendMessageDV);

  BorderPane doctorView = new BorderPane();
  doctorView.setTop(titleBoxDV);
  doctorView.setLeft(searchPatientBoxDV);
  doctorView.setCenter(patientDetailsTabsDV);
  doctorView.setRight(emailTabPaneDV);

  Scene doctorViewScene = new Scene(doctorView, 600, 500);

  // Doctor Logout //
  docLogout.setOnAction(e -> {
    primaryStage.setScene(homeScreen);
    usernameField.clear();
    passwordField.clear();
    newUsername.clear();
    newPassword.clear();
    checkPassword.clear();
    messageLabel.setText("");
  });

  /*
    NURSE VIEW
  */
  Label welcomeNV = new Label("Nurse View.");
  HBox titleBoxNV = new HBox(welcomeNV);

  //Patients list
  ListView<String> patientListNV = new ListView<>();
  patientListNV.getItems().addAll("Patient 1", "Patient 2", "Patient 3");
  TextField searchedPatientFieldNV = new TextField();
  searchedPatientFieldNV.setPromptText("Search Patient");
  Button searchPatientNV = new Button("Search");
  Button nurseLogout = new Button("Logout");
  VBox searchPatientBoxNV = new VBox(searchedPatientFieldNV, patientListNV,  searchPatientNV, nurseLogout);


  //Tabs for patients - center
  TabPane patientDetailsTabsNV = new TabPane();
  Tab examinationTabNV = new Tab("Exam results");
  examinationTabNV.setClosable(false);
  Tab patientHistoryTabNV = new Tab("Patient History");
  patientHistoryTabNV.setClosable(false);
  patientDetailsTabsNV.getTabs().addAll(examinationTabNV, patientHistoryTabNV);

  //Patients - Inbox and Send Message
  TabPane emailTabPaneNV = new TabPane();

  //Inbox
  Tab inboxTabNV = new Tab("Inbox");
  inboxTabNV.setClosable(false);
  ListView<String> inboxNV = new ListView<>();
  inboxNV.getItems().addAll("Message 1", "Message 2", "Message 3");
  inboxTabNV.setContent(inboxNV);

  //Send a Message
  Tab sendMessageTabNV = new Tab("Send a Message");
  sendMessageTabNV.setClosable(false);

  emailTabPaneNV.getTabs().addAll(inboxTabNV, sendMessageTabNV);

  TextField typeMessageNV = new TextField();
  typeMessageNV.setPromptText("Type your message here:");
  Label sendAMessageToLabelNV = new Label( "Send a message to: ");
  
  ToggleGroup sendMessageToNV = new ToggleGroup();

  RadioButton patientButtonPV = new RadioButton("Nurse");
  patientButtonPV.setToggleGroup(sendMessageToNV);

  HBox sendMessageToNVBox = new HBox(10, patientButtonPV);

  Label usernameSendToNV = new Label("Username:");
  TextField usernameSendToNVField = new TextField();

  HBox user_sendToNV = new HBox(10);
  user_sendToNV.setPadding(new Insets(20));
  user_sendToNV.getChildren().addAll(usernameSendToNV, usernameSendToNVField);

  Label passwordSendToNV = new Label("Password:");
  PasswordField passwordSendToNVField = new PasswordField();

  HBox pass_sendToNV = new HBox(10);
  pass_sendToNV.setPadding(new Insets(20));
  pass_sendToNV.getChildren().addAll(passwordSendToNV, passwordSendToNVField);

  Button submitNV = new Button("Submit");

  HBox buttonsBoxNV = new HBox(10);
  buttonsBoxNV.setPadding(new Insets(20));
  buttonsBoxNV.getChildren().addAll(submitNV);

  VBox sendMessageNV = new VBox(10);
  sendMessageNV.setPadding(new Insets(20));
  sendMessageNV.getChildren().addAll(emailTabPaneNV,
                                     typeMessageNV, 
                                     sendAMessageToLabelNV, 
                                     sendMessageToNVBox, 
                                     user_sendToNV, 
                                     pass_sendToNV, 
                                     buttonsBoxNV);

  sendMessageTabNV.setContent(sendMessageNV); //user_sendToNV, pass_sendToNV, buttonsBoxV

  BorderPane nurseView = new BorderPane();
  nurseView.setTop(titleBoxNV);
  nurseView.setLeft(searchPatientBoxNV);
  nurseView.setCenter(patientDetailsTabsNV);
  nurseView.setRight(emailTabPaneNV);

  Scene nurseViewScene = new Scene(nurseView, 600, 500);
  //Nurse Logout//
  nurseLogout.setOnAction(e -> {
    primaryStage.setScene(homeScreen);
    usernameField.clear();
    passwordField.clear();
    newUsername.clear();
    newPassword.clear();
    checkPassword.clear();
    messageLabel.setText("");
  });

   
    /* Set actions for login button and logout button */

    // Create Account Check
    createButton.setOnAction(e -> { 
      String name = newUsername.getText();
      String pass1 = newPassword.getText();
      String pass2 = checkPassword.getText();
      
      if (name.equals("")) {
        messageLabel.setText("Please Enter Username");
      }

      else if (pass1.equals("")) {
        messageLabel.setText("Please Enter Password");
      }

      else {
        if (pass1.equals(pass2)) {
          messageLabel.setText("CREATED ACCOUNT :)");
          Patient newAccount = new Patient();
          newAccount.setUser(name);
          newAccount.setPass(pass1);
          pRecord.addPatient(newAccount);

          primaryStage.setScene(new Scene(createAccountInfoScreen, 300, 200));
        } else {
          messageLabel.setText("Passwords do not match >:(");
        }
      }
    });
    
    // Login Check
    loginButton.setOnAction(e -> {
      String username = usernameField.getText();
      String password = passwordField.getText();
      if (isValidUser(username, password)) {
        primaryStage.setScene(new Scene(patientView, 300, 200));
      } else {
        messageLabel.setText("Invalid username or password");
      }
    });

    // Add Patient Account Info Check
    caisEnterButton.setOnAction(e -> {
      
      String username = newUsername.getText();
      String patient_name = firstName.getText() + lastName.getText();
      String patient_dob = month.getText() + "/" + day.getText() + "/" + year.getText();

      /* FIXME: ETC CHECKS */
      
      int idx = 0;
      while ((username.equals(pRecord.getRecords().get(idx).getUser())) == false) {
        ++idx;
      }
      
      pRecord.getRecords().get(idx).setName(patient_name);
      pRecord.getRecords().get(idx).setDOB(patient_dob);

      CAIS_ERROR.setText("Successfully Added Info");
      
      primaryStage.setScene(new Scene(patientView, 800, 600));
    });


    // Patient Logout Check
    patientLogout.setOnAction(e -> {
      primaryStage.setScene(new Scene(initScreen, 800, 600));
      usernameField.clear();
      passwordField.clear();
      newUsername.clear();
      newPassword.clear();
      checkPassword.clear();
      messageLabel.setText("");
    });

    // Set initial scene
    primaryStage.setScene(new Scene(initScreen, 600, 500));
    primaryStage.show();
  }

  // Username + Password Check Method
  private boolean isValidUser(String username, String password) {

    int idx = 0;
    while ((username.equals(pRecord.getRecords().get(idx).getUser())) == false) {
      ++idx;
    }

    if (password.equals(pRecord.getRecords().get(idx).getPass())) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isUnique(String username) {
    
    int len = pRecord.getRecords().size();
    for (int i = 0; i < len; i++) {
      Patient val = new Patient();
      
      val = pRecord.getRecords().get(i);
      String user = val.getUser();
      if (user.equals(username)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    launch(args);
  }
}

class Doctor {
  /* Attributes */
  private String name;
  private String username;
  private String password;

  /* Methods */
  public void setName(String update) {
    name = update;
  }

  public void setUser(String update) {
    username = update;
  }

  public void setPass(String update) {
    password = update;
  }
}

class Nurse {
  /* Attributes */
  private String name;
  private String username;
  private String password;

  /* Methods */
  public void setName(String update) {
    name = update;
  }

  public void setUser(String update) {
    username = update;
  }

  public void setPass(String update) {
    password = update;
  }
}

class Patient {
  /* Attributes */
  private String name;
  private String username;
  private String password;
  private String dob;

  /* Methods */
  public void setName(String update) {
    name = update;
  }

  public String getName() {
    return name;
  }

  public void setUser(String update) {
    username = update;
  }

  public String getUser() {
    return username;
  }

  public void setPass(String update) {
    password = update;
  }

  public String getPass() {
    return password;
  }

  public void setDOB(String update) {
    dob = update;
  }

  public String getDOB() {
    return dob;
  }
}

class StaffRecords {
  /* Attributes */
  ArrayList<Doctor> doctors = new ArrayList<Doctor>();
  ArrayList<Nurse> nurses = new ArrayList<Nurse>();

  /* Methods */
}

class PatientRecords {
  /* Attributes */
  ArrayList<Patient> patients = new ArrayList<Patient>();

  /* Methods */
  public ArrayList<Patient> getRecords() {
    return patients;
  }

  public void addPatient(Patient newPatient) {
    patients.add(newPatient);
  }
}
