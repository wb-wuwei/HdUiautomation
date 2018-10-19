package tianquestudy.da01.com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    //数据驱动
    @DataProvider(name = "qudong")
    public  Object [] [] testDate(){
        return new Object[][]{
                {"1","q"},
                {"2","w"},
                {"3","e"}
        };
    }

    @Test(dataProvider ="qudong" )
    public  void testGetData(String a,String b){
        System.out.print(a+"加"+b);
        System.out.println( );

    }

    @DataProvider(name = "test1")
    public  Object[][] data(){
        //记得return返回的后面要加引号，必须是Object类
        return new Object[][]{
                {"1","aa"},
                {"2","bb"},
                {"3","cc"}
        };
    }
    @Test(dataProvider = "test1")
    public void testData(String i,String j){
        System.out.print("i="+i+"和j="+j);
        System.out.print("\n");
    }

}
