package tianquestudy.da01.com;

import org.testng.annotations.*;

public class AnnotationTest {

    @BeforeMethod
    public void beforMethodTest(){
        System.out.println("------这是beforMethodTest------");
    }

    @Test
    public  void testCase1(){
        System.out.println("-------这是testCase1-------");
    }

    @Test
    public  void testCase2(){
        System.out.println("-------这是testCase2-------");
    }

    @AfterMethod
  public void  afterMethodTest(){
        System.out.println("-------这是afterMethodTest-------");
  }

}
