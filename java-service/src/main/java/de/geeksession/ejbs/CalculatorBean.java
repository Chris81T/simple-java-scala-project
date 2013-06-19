package de.geeksession.ejbs;

import de.geeksession.Calculator;
import de.geeksession.CalculatorService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 6/1/13
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CalculatorBean implements CalculatorService {

    @Override
    public int add(int a, int b) {
        return Calculator.add(a, b); // use the scala backend
    }

    @Override
    public int sub(int a, int b) {
        return Calculator.sub(a, b); // use the scala backend
    }

    @Override
    public int mul(int a, int b) {
        return Calculator.mul(a, b); // use the scala backend
    }

    @Override
    public int div(int a, int b) {
        return Calculator.div(a, b); // use the scala backend
    }

    @Override
    public int mod(int a, int b) {
        return Calculator.mod(a, b); // use the scala backend
    }
}
