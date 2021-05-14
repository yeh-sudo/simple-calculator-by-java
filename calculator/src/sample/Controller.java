//keyboard entry: the enter will not activate if I clicked the other button


package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.util.*;


public class Controller {
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
    private Label show;
    @FXML
    private Label label;



    private boolean ch = false;
    private String input = "";
    private String text = "";
    private ArrayList<String> prev = new ArrayList<String>();
    private ArrayList<String> list = new ArrayList<String>(); //using data structure to calculate the answer
    private Stack<String> opStack = new Stack<String>(); //stack of operator


    private void keyPress(){
        one.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
        two.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
        three.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
        four.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
        five.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
        six.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
        seven.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
        eight.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
        nine.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
        zero.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                        clickAnswer();
                        break;
                    default:
                        break;
                }
            }
        });
    }


    public int p(String x){
        if (x == "/" || x == "*")
            return 2;
        else
            return 3;
    }


    public void clickPlus(ActionEvent e){
        ch = false;
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
        ch = false;
        if (input.length() == 1 && input.charAt(0) == '-' && (text.charAt(text.length() - 1) == '+' || text.charAt(text.length() - 1) == '-' || text.charAt(text.length() - 1) == '*' || text.charAt(text.length() - 1) == '/'))
            return;
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
        ch = false;
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
        ch = false;
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
        if (input.length() != 0 && input.charAt(input.length() - 1) == '.')
            return;
        if (prev.isEmpty() && input.length() >= 2 && input.charAt(input.length() - 2) == '.')
            return;
        prev.add(input);
        input += ".";
        label.setText(input);
    }



    public void clickCE(ActionEvent e){
        ch = false;
        if (input.isEmpty()){
            text = "";
            input = "";
            prev.clear();
            list.clear();
            opStack.clear();
            label.setText(input);
            show.setText(text);
        }
        else {
            prev.clear();
            input = "";
            label.setText(input);
        }
    }
    public void clickAC(ActionEvent e){
        ch = false;
        text = "";
        input = "";
        prev.clear();
        list.clear();
        opStack.clear();
        label.setText(input);
        show.setText(text);
    }
    public void clickBackspace(ActionEvent e){
        ch = false;
        if (prev.isEmpty()){
            if (text.isEmpty())
                return;
            text = text.replaceFirst(".$", "");
            show.setText(text);
            return;
        }
        input = prev.get(prev.size() - 1);
        prev.remove(prev.size() - 1);
        label.setText(input);
    }



    public void clickOne(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "1";
        label.setText(input);
    }
    public void clickTwo(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "2";
        label.setText(input);
    }
    public void clickThree(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "3";
        label.setText(input);
    }
    public void clickFour(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "4";
        label.setText(input);
    }
    public void clickFive(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "5";
        label.setText(input);
    }
    public void clickSix(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "6";
        label.setText(input);
    }
    public void clickSeven(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "7";
        label.setText(input);
    }
    public void clickEight(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "8";
        label.setText(input);
    }
    public void clickNine(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "9";
        label.setText(input);
    }
    public void clickZero(ActionEvent e){
        keyPress();
        if (input == "Error")
            return;
        if (prev.isEmpty() && input.length() > 2 && input.charAt(input.length() - 2) == '.')
            return;
        if (ch)
            return;
        prev.add(input);
        input += "0";
        label.setText(input);
    }



    public void clickAnswer(ActionEvent e){
        ch = false;
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

        if (check) {
            double output = cal.peek();
            if (output - (int)output != 0)
                input = Double.toString(Math.round(cal.peek() * 10.0) / 10.0); //round
            else {
                input = Integer.toString((int) output);
                ch = true;
            }
        }
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
        ch = false;
        if (input.isEmpty()){
            text = "";
            input = "";
            prev.clear();
            list.clear();
            opStack.clear();
            label.setText(input);
            show.setText(text);
        }
        else {
            prev.clear();
            input = "";
            label.setText(input);
        }
    }
    public void clickAC(){
        ch = false;
        text = "";
        input = "";
        prev.clear();
        list.clear();
        opStack.clear();
        label.setText(input);
        show.setText(text);
    }
    public void clickAnswer(){
        ch = false;
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

        if (check) {
            double output = cal.peek();
            if (output - (int)output != 0)
                input = Double.toString(Math.round(cal.peek() * 10.0) / 10.0); //round
            else {
                input = Integer.toString((int) output);
                ch = true;
            }
        }
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
