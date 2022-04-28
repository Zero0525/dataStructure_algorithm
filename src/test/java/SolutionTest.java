import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class SolutionTest {
    private Solution solution = null;
    private long start;
    private long end;


    @Test
    public void TestSolution() throws Exception {


        String s = solution.decodeString("bc2[ac]");
        System.out.println(s);
        //Assert.assertEquals(true,res);
    }


    @Before
    public void before() {
        solution = new Solution();
        start = System.currentTimeMillis();
    }

    @After
    public void After() {
        end = System.currentTimeMillis();
        System.out.println("题解耗时:" + (end - start) + "ms");
    }


}
