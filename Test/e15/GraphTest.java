package e15;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class GraphTest {

    private static Graph graph;
    private static UserInfoBo userInfoBo;
    private static UserInfoDTO userInfoDTO;

    @BeforeClass
    public static void initializeGraph(){
        graph = new Graph();
        userInfoDTO= new UserInfoDTO();
        userInfoDTO.setId(1);
        userInfoDTO.setName("amad");
        userInfoBo= new UserInfoBo(1, "amad", "siria","26","programmer", "single");
        userInfoBo.setUserInfoDTO(userInfoDTO);
        Node node= new Node(userInfoBo);
        graph.addNodes(node);
    }
    @Test
    public void searchAmplitudeTest () throws NotFoundUserException {

        assertEquals("amad", graph.searchAmplitude("amad", 1).getName());
    }
    @Test()
    public void searchAmplitudeExpectedNotFoundUserTest (){
      //  Assertions.assertThrows(NotFoundUserException.class,() -> graph.searchAmplitude("rami", 0) );

    }
}
