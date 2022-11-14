package com.company.Saska.task5.objects;

import javacalculus.core.CALC;
import javacalculus.core.CalcParser;
import javacalculus.evaluator.CalcSUB;
import javacalculus.exception.CalcSyntaxException;
import javacalculus.struct.CalcDouble;
import javacalculus.struct.CalcObject;
import javacalculus.struct.CalcSymbol;

import static com.company.Saska.task5.Main.Program.A;
import static com.company.Saska.task5.Main.Program.B;
import static com.company.Saska.task5.methods.Trapezium.n;

public class Function {
    private String expression;

    private String variable = "x";

    public Function(String expression) {

        expression = expression.replace("sin", "SIN");
        expression = expression.replace("cos", "COS");

        String temp = expression.replace("a", Double.toString(A));
        temp = temp.replace("b", Double.toString(B));
        temp = temp.replace("n", Double.toString(n));
//        System.out.println(temp);

        this.expression = temp;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }


    public double getValueIn(double valueX) {
        CalcObject result = parseFunction(expression);

        result = subst(result, "x", valueX);
        result = CALC.SYM_EVAL(result);

        return Double.parseDouble(String.valueOf(result));
    }


    public double getIntegrate(double valueX) {
        String command = "INT(" + expression + ", " + variable + ")";
        CalcObject result = parseFunction(command);

        result = subst(result, "x", valueX);
        result = subst(result, "C", 0);
        result = CALC.SYM_EVAL(result);

        return Double.parseDouble(String.valueOf(result));
    }


    public double getSecondDifferentiateIn(double valueX) {
        String command = "DIFF(DIFF(" + expression + ", " + variable + "), " + variable + " )";
        CalcObject result = parseFunction(command);

        result = subst(result, "x", valueX);
        result = CALC.SYM_EVAL(result);

        return Double.parseDouble(String.valueOf(result));
    }

    public double getFirstDifferentiateIn(double valueX) {
        String command = "DIFF(" + expression + ", " + variable + ")";
        CalcObject result = parseFunction(command);

        result = subst(result, "x", valueX);
        result = CALC.SYM_EVAL(result);

        return Double.parseDouble(String.valueOf(result));
    }


    private CalcObject parseFunction(String command) {
        CalcParser parser = new CalcParser();
        CalcObject parsed = null;
        try {
            parsed = parser.parse(command);
        } catch (CalcSyntaxException e) {
            e.printStackTrace();
        }

        CalcObject result = null;
        try {
            result = parsed.evaluate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    private static CalcObject subst(CalcObject input, String var, double number)
    {
        CalcSymbol symbol = new CalcSymbol(var);
        CalcDouble value = new CalcDouble(number);
        return CalcSUB.numericSubstitute(input, symbol, value);
    }


}
