/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.test;

import itstep.pojo.Group;
import itstep.service.GroupService;
import java.net.URI;
import java.net.URISyntaxException;
import org.itstep.app.App;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author admin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroupControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private GroupService groupService;

    public void testSaveGroup() {
        Group group = new Group();
        group.setGroupName("J16");
        group.setCourse(2);
        when(groupService.createAndUpdateGroup(group)).thenReturn(group);
        when(groupService.isUnique(Mockito.<Group>any())).thenReturn(true);
        RequestEntity<Group> reqEntity = null;
        try {
            reqEntity = new RequestEntity<Group>(group, HttpMethod.POST, new URI("/group"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<Group> respEntyty = testRestTemplate.exchange(reqEntity, Group.class);
        assertEquals(HttpStatus.CREATED, respEntyty.getStatusCode());

        verify(groupService, Mockito.times(1)).createAndUpdateGroup(Mockito.<Group>any());
    }

    @Test

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
