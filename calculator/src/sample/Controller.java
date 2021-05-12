//keyboard entry: the enter will not activate if I clicked the other button


package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;
import java.util.*;


public class Controller {
    @FXML
    private Button Answer;
    @FXML
    private Button CE;
    @FXML
    private Button AC;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button zero;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button multi;
    @FXML
    private Button div;
    @FXML
    private Button dot;
    @FXML
    private Button backspace;
    @FXML
    private Label show;
    @FXML
    private Label label;



    private String input = "";
    private String text = "";
    private ArrayList<String> prev = new ArrayList<String>();
    private ArrayList<String> list = new ArrayList<String>(); //using data structure to calculate the answer
    private Stack<String> opStack = new Stack<String>(); //stack of operator


    public int p(String x){
        if (x == "/" || x == "*")
            return 2;
        else
            return 3;
    }


    public void clickPlus(ActionEvent e){
        if (input.length() == 0)
            return;
        if (input == ".")
            list.add(Double.toString(0.0));
        else
            list.add(input);
        prev.clear();
        text += input;
        text += "+";
        show.setText(text);
        input = "";
        label.setText(input);
        if (opStack.isEmpty())
            opStack.push("+");
        else{
            if (p("+") >= p(opStack.peek())){
                list.add(opStack.peek());
                opStack.pop();
                opStack.push("+");
            }
            else
                opStack.push("+");
        }
    }
    public void clickMinus(ActionEvent e){
        if (input.length() == 0) {
            prev.add(input);
            input += "-";
            label.setText(input);
            return;
        }
        if (input == ".")
            list.add(Double.toString(0.0));
        else
            list.add(input);
        prev.clear();
        text += input;
        text += "-";
        show.setText(text);
        input = "";
        label.setText(input);
        if (opStack.isEmpty())
            opStack.push("-");
        else{
            if (p("-") >= p(opStack.peek())){
                list.add(opStack.peek());
                opStack.pop();
                opStack.push("-");
            }
            else
                opStack.push("-");
        }
    }
    public void clickMulti(ActionEvent e){
        if (input.length() == 0)
            return;
        if (input == ".")
            list.add(Double.toString(0.0));
        else
            list.add(input);
        prev.clear();
        text += input;
        text += "*";
        show.setText(text);
        input = "";
        label.setText(input);
        if (opStack.isEmpty())
            opStack.push("*");
        else {
            if (p("*") < p(opStack.peek())){
                opStack.push("*");
            }
            else {
                list.add(opStack.peek());
                opStack.pop();
                opStack.push("*");
            }
        }
    }
    public void clickDiv(ActionEvent e){
        if (input.length() == 0)
            return;
        if (input == ".")
            list.add(Double.toString(0.0));
        else
            list.add(input);
        prev.clear();
        text += input;
        text += "/";
        show.setText(text);
        input = "";
        label.setText(input);
        if (opStack.isEmpty())
            opStack.push("/");
        else {
            if (p("/") < p(opStack.peek())){
                opStack.push("/");
            }
            else {
                list.add(opStack.peek());
                opStack.pop();
                opStack.push("/");
            }
        }
    }
    public void clickDot(ActionEvent e){
        if (input.charAt(input.length() - 1) == '.' && input.length() != 0)
            return;
        prev.add(input);
        input += ".";
        label.setText(input);
    }



    public void clickCE(ActionEvent e){
        prev.clear();
        input = "";
        label.setText(input);
    }
    public void clickAC(ActionEvent e){
        text = "";
        input = "";
        prev.clear();
        list.clear();
        opStack.clear();
        label.setText(input);
        show.setText(text);
    }
    public void clickBackspace(ActionEvent e){
        input = prev.get(prev.size() - 1);
        prev.remove(prev.size() - 1);
        label.setText(input);
    }



    public void clickOne(ActionEvent e){
        prev.add(input);
        input += "1";
        label.setText(input);
    }
    public void clickTwo(ActionEvent e){
        prev.add(input);
        input += "2";
        label.setText(input);
    }
    public void clickThree(ActionEvent e){
        prev.add(input);
        input += "3";
        label.setText(input);
    }
    public void clickFour(ActionEvent e){
        prev.add(input);
        input += "4";
        label.setText(input);
    }
    public void clickFive(ActionEvent e){
        prev.add(input);
        input += "5";
        label.setText(input);
    }
    public void clickSix(ActionEvent e){
        prev.add(input);
        input += "6";
        label.setText(input);
    }
    public void clickSeven(ActionEvent e){
        prev.add(input);
        input += "7";
        label.setText(input);
    }
    public void clickEight(ActionEvent e){
        prev.add(input);
        input += "8";
        label.setText(input);
    }
    public void clickNine(ActionEvent e){
        prev.add(input);
        input += "9";
        label.setText(input);
    }
    public void clickZero(ActionEvent e){
        prev.add(input);
        input += "0";
        label.setText(input);
    }



    public void clickAnswer(ActionEvent e){
        list.add(input);
        while (!opStack.isEmpty()){
            list.add(opStack.peek());
            opStack.pop();
        }

        //calculate answer
        Stack<Double> cal = new Stack<Double>();
        boolean check = true;

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) != "+" && list.get(i) != "-" && list.get(i) != "*" && list.get(i) != "/"){
                cal.push(Double.parseDouble(list.get(i)));
            }
            else {
                if (list.get(i) == "+"){
                    double tmp2 = cal.peek();
                    cal.pop();
                    double tmp1 = cal.peek();
                    cal.pop();
                    cal.push(tmp1 + tmp2);
                }
                else if (list.get(i) == "-"){
                    double tmp2 = cal.peek();
                    cal.pop();
                    double tmp1 = cal.peek();
                    cal.pop();
                    cal.push(tmp1 - tmp2);
                }
                else if (list.get(i) == "*"){
                    double tmp2 = cal.peek();
                    cal.pop();
                    double tmp1 = cal.peek();
                    cal.pop();
                    cal.push(tmp1 * tmp2);
                }
                else {
                    double tmp2 = cal.peek();
                    cal.pop();
                    double tmp1 = cal.peek();
                    cal.pop();
                    if (tmp2 == 0)
                        check = false;
                    cal.push(tmp1 / tmp2);
                }
            }
        }

        if (check)
            input = Double.toString(cal.peek()); //round
        else
            input = "Error";
        label.setText(input);
        cal.clear();
        text = "";
        show.setText(text);
        prev.clear();
        list.clear();
        opStack.clear();
    }


    //keyboard entry
    public void clickCE(){
        prev.clear();
        input = "";
        label.setText(input);
    }
    public void clickAC(){
        text = "";
        input = "";
        prev.clear();
        list.clear();
        opStack.clear();
        label.setText(input);
        show.setText(text);
    }
    public void clickAnswer(){
        list.add(input);
        while (!opStack.isEmpty()){
            list.add(opStack.peek());
            opStack.pop();
        }

        //calculate answer
        Stack<Double> cal = new Stack<Double>();
        boolean check = true;

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) != "+" && list.get(i) != "-" && list.get(i) != "*" && list.get(i) != "/"){
                cal.push(Double.parseDouble(list.get(i)));
            }
            else {
                if (list.get(i) == "+"){
                    double tmp2 = cal.peek();
                    cal.pop();
                    double tmp1 = cal.peek();
                    cal.pop();
                    cal.push(tmp1 + tmp2);
                }
                else if (list.get(i) == "-"){
                    double tmp2 = cal.peek();
                    cal.pop();
                    double tmp1 = cal.peek();
                    cal.pop();
                    cal.push(tmp1 - tmp2);
                }
                else if (list.get(i) == "*"){
                    double tmp2 = cal.peek();
                    cal.pop();
                    double tmp1 = cal.peek();
                    cal.pop();
                    cal.push(tmp1 * tmp2);
                }
                else {
                    double tmp2 = cal.peek();
                    cal.pop();
                    double tmp1 = cal.peek();
                    cal.pop();
                    if (tmp2 == 0)
                        check = false;
                    cal.push(tmp1 / tmp2);
                }
            }
        }

        //TODO
        if (check)
            input = Double.toString(cal.peek()); //round
        else
            input = "Error";
        label.setText(input);
        cal.clear();
        text = "";
        show.setText(text);
        prev.clear();
        list.clear();
        opStack.clear();
    }
}
