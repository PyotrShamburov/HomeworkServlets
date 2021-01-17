package model;

public class Calculator {

    public String calculate(int num1, int num2, String sign){
        switch (sign){
            case "sum":
                return String.valueOf(sum(num1,num2));
            case "div":
                if (num2!=0){
                    return String.valueOf(div(num1,num2));
                }else{
                    return "Division by zero!";
                }
            case "dif":
                return String.valueOf(dif(num1, num2));
            case "mul":
                return String.valueOf(mul(num1, num2));
        }
        return "Wrong type of arithmetic operation!";
    }


    private int sum(int num1, int num2 ){
        return (num1+num2);
    }

    private int div(int num1, int num2 ){
        return num1/num2;
    }

    private int dif(int num1, int num2 ){
        return (num1-num2);
    }

    private int mul(int num1, int num2 ){
        return num1*num2;
    }
}
