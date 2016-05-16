package controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*Seguro que hay formas más elegantes de hacerlo*/


@RunWith(Suite.class)
@SuiteClasses({ LoginTest1.class, LoginTest2.class, LoginTest3.class })
public class GeneralLoginTest {
}
