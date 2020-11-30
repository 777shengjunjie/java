import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssmweb.domain.Item;
import ssmweb.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class TestSSM {

    @Autowired
    private ItemService itemService;

    @Test
    public void Test1(){
        Item item = itemService.findById(1);
        System.out.println(item);
    }

}
