package e15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CacheMemoryTest {

    private static CacheMemory cacheMemory;
    private static Node node;
    private static UserInfoBo userInfoBo;
    private static UserInfoDTO userInfoDTO;

    @BeforeAll
    public static void setAttributes(){
        userInfoDTO= new UserInfoDTO();
        userInfoDTO.setName("amad");
        userInfoBo= new UserInfoBo(1,"amad","siria","26","programacion","single");
        userInfoBo.setUserInfoDTO(userInfoDTO);
        node =new Node(userInfoBo);
        cacheMemory = new CacheMemory();
        cacheMemory.addToMemory("amad",node);
    }

    @Test
    public  void isInMemoryTest (){
        assertEquals(true, cacheMemory.isInMemory("amad"));
    }

    @Test
    public void getNodeFromMemoryTest(){
        assertEquals("amad",cacheMemory.getNodeFromMemory("amad").getName());
    }
    @Test
    public void getFailureNodeFromMemoryTest(){
        assertNull(cacheMemory.getNodeFromMemory("pablo"));
    }

    @Test
    public void isNotInMemoryTest(){
        assertEquals(false, cacheMemory.isInMemory("pablo"));

    }



}
