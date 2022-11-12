package by.ToshibaMastr.FormulaSolver.services.impl;

import by.ToshibaMastr.FormulaSolver.services.FormulaSolverService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FormulaSolverServiceImpl implements FormulaSolverService {

    @Override
    public Float calculateFormula(String string) {

        List<String> encodeStr = new ArrayList<>();
        Stack<Character> operatorStack = new Stack<>();

        char firstChar;
        for (String i : formulaSplit(string)) {
            firstChar = i.charAt(0);
            if (Character.isDigit(firstChar)) {
                encodeStr.add(i);
            } else {
                if (i.equals(")")) {
                    while (operatorStack.peek() != '(' && operatorStack.size() > 0) {
                        encodeStr.add(Character.toString(operatorStack.pop()));
                    }
                    operatorStack.pop();
                } else {
                    while (operatorStack.size() != 0 && operatorStack.peek() != '(' && level(firstChar) <= level(operatorStack.peek())) {
                        encodeStr.add(Character.toString(operatorStack.pop()));
                    }
                    operatorStack.add(firstChar);
                }
            }
        }
        while(!operatorStack.isEmpty()){
            encodeStr.add(Character.toString(operatorStack.pop()));
        }
        firstChar = ' ';
        float num1, num2, answer;
        for(int i = 0; encodeStr.size()!=1; i++){
            firstChar = encodeStr.get(i).charAt(0);
            if(!Character.isDigit(firstChar) && level(firstChar)!=-1){
                i-=2;
                num1 = Float.valueOf(encodeStr.remove(i));
                num2 = Float.valueOf(encodeStr.remove(i));
                answer = use(num1, num2, firstChar);
                encodeStr.set(i, String.valueOf(answer));
            }
        }

        return Float.valueOf(encodeStr.get(0));
    }
    private int level(char operand){
        switch (operand){
            case '-': return 0;
            case '+': return 0;
            case '/': return 1;
            case '*': return 1;
            case '^': return 2;
            case '(': return 3;
            case ')': return 3;
            default: return -1;
        }
    }
    private float use(float x, float y, char operand){
        switch (operand){
            case '-': return x-y;
            case '+': return x+y;
            case '/': return x/y;
            case '*': return x*y;
            case '^': return (float) Math.pow(x, y);
            default: return -1;
        }
    }

    private List<String> formulaSplit(String string){
        return List.of(string.split(" "));
    }

}
