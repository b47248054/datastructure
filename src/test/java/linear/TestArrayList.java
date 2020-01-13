package linear;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author liuzhongxu
 * @date 2020/1/13
 */
public class TestArrayList {


    @Test
    public void testGet() {
        ArrayList list = new ArrayList(5);
        System.out.println(list.toString());
        list.insertData("0", 0);
        Assert.assertEquals(list.get(0), "0");
        System.out.println(list.toString());
        list.insertData("1", 1);
        Assert.assertEquals(list.get(0), "0");
        Assert.assertEquals(list.get(1), "1");
        System.out.println(list.toString());
        String l0 = list.deleteData(0);
        Assert.assertEquals(l0,"0");
        System.out.println(list.toString());
    }
}
