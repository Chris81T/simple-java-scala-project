package de.geeksession;

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 6/1/13
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CalculatorService {

    static final String JNDI = "java:global/simple-ear/java-service/CalculatorBean!de.geeksession.CalculatorService";

    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);
    int mod(int a, int b);

}
