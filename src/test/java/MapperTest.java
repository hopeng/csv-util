import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hopeng on 18/3/18.
 */
public class MapperTest {

    @Test
    public void test() {

        Map map = new LinkedHashMap();

        map.put("abc", 1);
        map.put("abcd", 1);
        map.put("abcd", null);
        map.put("eee", null);

        System.out.println(map);

    }
}
