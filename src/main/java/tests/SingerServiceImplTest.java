package tests;

import app.configuration.DataServiceConfig;
import app.entity.Singer;
import app.service.SingerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataServiceConfig.class})
public class SingerServiceImplTest {

    @Autowired
    SingerService singerService;

    @Test
    public void testFindAll () throws Exception{

        List<Singer> result = singerService.findAll();

        assertNotNull(result);
        assertEquals(3, result.size());
    }
}