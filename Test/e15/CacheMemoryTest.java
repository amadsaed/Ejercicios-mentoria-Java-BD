package e15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CacheMemoryTest {

    private static CacheMemory cacheMemory;
    private static Node node;

    @BeforeAll
    public static void setAttributes(){
        node =new Node(1, "amad", "siria", "26","programmer" , "single");
        cacheMemory = new CacheMemory();
        cacheMemory.addToMemory(node.getName(),node);
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
