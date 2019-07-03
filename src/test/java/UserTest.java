import com.cdut.App;
import com.cdut.dao.UserMapper;
import com.cdut.model.User;
import com.cdut.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes=App.class)
@RunWith(SpringRunner.class)
public class UserTest {
    @Resource
    private IUserService userService;
    @Autowired
    private RedisTemplate<String,String> template;
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("刘林");
        user.setPasswd("997763");
        userService.save(user);
    }

    @Test
    public void testFindAll(){

        List<User> all = userService.getAll();
        for (User user:all){
            System.out.println(user);
        }

    }
    @Test
    public void testRedis(){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set("sex","man");
        String sex = ops.get("name");
        System.out.println(sex);
    }

}
