package tests;

import app.configuration.RestClientConfig;
import app.entity.Singers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestClientConfig.class})
public class RestClientTest {

    private static Logger logger = LoggerFactory.getLogger(RestClientTest.class);

    private static final String URL_GET_ALL_SINGERS = "http://localhost:8080/rest/singer/listdata";

    @Autowired
    RestTemplate restTemplate;

    @Before
    public void setUp(){
        assertNotNull(restTemplate);
    }

    @Test
    public void testFindAll(){
        logger.info("-->Testing retrieve all singers");
        Singers singers = restTemplate.getForObject(URL_GET_ALL_SINGERS, Singers.class);
        assertTrue(singers.getSingers().size()==3);
        listSingers(singers);
    }

    private void listSingers(Singers singers) {
        singers.getSingers().forEach(s->logger.info(s.toString()));
    }
}