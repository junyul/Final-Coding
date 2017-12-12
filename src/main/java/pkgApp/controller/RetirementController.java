package main.java.pkgApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import main.java.pkgApp.RetirementApp;
import main.java.pkgCore.Retirement;
/**
 * Description: The class for controller
 * <p>
 * User: admin
 * Date: 2017-12-10
 * JDK: 1.8
 * <p>
 *
 * @author admin
 * @version 1.0
 */
public class RetirementController implements Initializable {
    private RetirementApp mainApp = null;
    /**
     * get all the textField
     */
    @FXML
    private TextField txtYearsToWork;
    @FXML
    private TextField txtAnnualReturnWorking;
    @FXML
    private TextField txtYearsRetired;
    @FXML
    private TextField txtAnnualReturnRetired;
    @FXML
    private TextField txtRequiredIncome;
    @FXML
    private TextField txtMonthlySSI;
    /**
     * get all the label
     */
    @FXML
    private Label labSaveEachMonth;
    @FXML
    private Label labTotalSaved;
    @FXML
    private Label labYearsToWork;
    @FXML
    private Label labAnnualReturnWorking;
    @FXML
    private Label labYearsRetired;
    @FXML
    private Label labAnnualReturnRetired;
    @FXML
    private Label labRequiredIncome;
    @FXML
    private Label labMonthlySSI;


    public RetirementApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(RetirementApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**
         * Monitor the value of the textField yearsToWork changes
         */
        txtYearsToWork.textProperty().addListener((observable,oldValue,newValue) -> {
            /**
             * Use regular expressions to determine if the input is legal
             * Only allow to enter the between 0-120
             */
            Pattern pattern = Pattern.compile("(([0-9])|([1-9][0-9])|(1[0-1][0-9])|(120))");
            if (pattern.matcher(newValue).matches()) {
                labYearsToWork.setText("");
            }else {
                labYearsToWork.setText("Invalid input");
                labYearsToWork.setTextFill(Color.web("#f04220"));
            }
        });
        /**
         * Monitor the value of the textField annualReturnWorking changes
         */
        txtAnnualReturnWorking.textProperty().addListener((observable, oldValue, newValue) -> {
            /**
             * Use regular expressions to determine if the input is legal
             * Only allow to enter the number between 0%-20%
             */
            Pattern p = Pattern.compile("(([0-9]\\.\\d+)|(1[0-9]\\.\\d+)|([0-9])|(1[0-9])|(20)|(20\\.00))%");
            if (p.matcher(newValue).matches()) {
                labAnnualReturnWorking.setText("");
            }else {
                labAnnualReturnWorking.setText("Invalid input");
                labAnnualReturnWorking.setTextFill(Color.web("#f04220"));
            }
        });
        /**
         * Monitor the value of the textField yearsRetired changes
         */
        txtYearsRetired.textProperty().addListener((observable, oldValue, newValue) -> {
            /**
             * Use regular expressions to determine if the input is legal
             * Only allow to enter the number between 0-120
             */
            Pattern pattern = Pattern.compile("(([0-9])|([1-9][0-9])|(1[0-1][0-9])|(120))");
            if (pattern.matcher(newValue).matches()) {
                labYearsRetired.setText("");
            }else {
                labYearsRetired.setText("Invalid input");
                labYearsRetired.setTextFill(Color.web("#f04220"));
            }
        });
        /**
         * Monitor the value of the textField annualReturnRetired changes
         */
        txtAnnualReturnRetired.textProperty().addListener((observable, oldValue, newValue) -> {
            /**
             * Use regular expressions to determine if the input is legal
             * Only allow to enter the number between 0%-3%
             */
            Pattern pattern = Pattern.compile("(([0-3])|([0-2]\\.\\d+)|(3\\.00))%");
            if (pattern.matcher(newValue).matches()) {
                labAnnualReturnRetired.setText("");
            }else {
                labAnnualReturnRetired.setText("Invalid input");
                labAnnualReturnRetired.setTextFill(Color.web("#f04220"));
            }
        });
        /**
         * Monitor the value of the textField requiredIncome changes
         */
        txtRequiredIncome.textProperty().addListener((observable, oldValue, newValue) -> {
            /**
             * Use regular expressions to determine if the input is legal
             * Only allow to enter the number with 2 decimals or 0 decimals
             */
            Pattern pattern = Pattern.compile("((\\d*\\.\\d{2})|(\\d*))");
            if (pattern.matcher(newValue).matches()) {
                labRequiredIncome.setText("");
            }else {
                labRequiredIncome.setText("Invalid input");
                labRequiredIncome.setTextFill(Color.web("#f04220"));
            }
        });
        /**
         * Monitor the value of the textField monthlySSI changes
         */
        txtMonthlySSI.textProperty().addListener((observable, oldValue, newValue) -> {
            /**
             * Use regular expressions to determine if the input is legal
             * Only allow to enter the number with 2 decimals or 0 decimals
             */
            Pattern pattern = Pattern.compile("((\\d*\\.\\d{2})|(\\d*))");
            if (pattern.matcher(newValue).matches()) {
                labMonthlySSI.setText("");
            }else {
                labMonthlySSI.setText("Invalid input");
                labMonthlySSI.setTextFill(Color.web("#f04220"));
            }
        });
    }

    /**
     * to handler clear function
     * @param event press event
     */
    @FXML
    public void btnClear(ActionEvent event) {
        System.out.println("Clear pressed");
        /**
         * clear textField
         */
        txtYearsToWork.clear();
        txtAnnualReturnWorking.clear();
        txtAnnualReturnRetired.clear();
        txtMonthlySSI.clear();
        txtRequiredIncome.clear();
        txtYearsRetired.clear();
        /**
         * clear label
         */
        labSaveEachMonth.setText("");
        labTotalSaved.setText("");
        labYearsToWork.setText("");
        labAnnualReturnRetired.setText("");
        labYearsRetired.setText("");
        labMonthlySSI.setText("");
        labRequiredIncome.setText("");
        labAnnualReturnWorking.setText("");
        //	TODO: Clear all the text inputs
    }

    /**
     * to handler calculate function
     * @param event press event
     */
    @FXML
    public void btnCalculate(ActionEvent event) {
        System.out.println("Calculate pressed");
        /**
         * judge the any input if is null
         */
        if (txtMonthlySSI.getText().equals("") || txtRequiredIncome.getText().equals("") || txtAnnualReturnRetired.getText().equals("") || txtYearsRetired.getText().equals("") || txtAnnualReturnWorking.getText().equals("") || txtYearsToWork.getText().equals("")) {
            System.out.println("any input cannot be null");
        }else {
            /**
             * get the input of years to work
             */
            int iYearsToWork = Integer.parseInt(txtYearsToWork.getText().trim());
            /**
             * get the input of annual return at working time
             */
            double dAnnualReturnWorking = new Double(txtAnnualReturnWorking.getText().trim().substring(0,txtAnnualReturnWorking.getText().trim().indexOf("%"))) / 100.0;
            /**
             * get the input of years to retired
             */
            int iYearsToRetired = Integer.parseInt(txtYearsRetired.getText().trim());
            /**
             * get the input of annual return at retired time
             */
            double dAnnualReturnRetired = new Double(txtAnnualReturnRetired.getText().trim().substring(0,txtAnnualReturnRetired.getText().trim().indexOf("%"))) / 100.0;
            /**
             * get the input of required income
             */
            double dRequiredIncome = Double.parseDouble(txtRequiredIncome.getText().trim());
            /**
             * get the input of Monthly SSI
             */
            double dMonthlySSI = Double.parseDouble(txtMonthlySSI.getText().trim());
            /**
             * calculate
             */
            Retirement retirement = new Retirement(iYearsToWork, dAnnualReturnWorking, iYearsToRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
            /**
             * get the saveEachMonth money
             * and set 2 decimals
             */
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            String dSaveEachMonth = decimalFormat.format(retirement.AmountToSave());
            /**
             * get the total save
             */
            String dTotalSave = decimalFormat.format(retirement.TotalAmountSaved());
            /**
             * show the result of calculation on the screen
             */
            labSaveEachMonth.setText("$ " + dSaveEachMonth);
            labTotalSaved.setText("$ " + dTotalSave);
        }
    }


}
