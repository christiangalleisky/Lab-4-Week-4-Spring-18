package edu.gcccd.csis;

import org.junit.*;

import static org.junit.Assert.*;

public class LazyCtorTest {

    static final boolean use_cache = false;

    // runs before each textMethod
    @Before
    public void setUp() throws Exception {
        System.out.println("beforeMethod");
        if (use_cache) {
            // make sure instances are cached
            assertEquals(LazyCtor.getNumOfInstancesAllowed(), LazyCtor.getNumOfInstancesCreated());
        } else {
            // make sure instances are NOT cached
            assertEquals(0, LazyCtor.getNumOfInstancesCreated());
        }
    }

    // runs after each textMethod
    @After
    public void tearDown() throws Exception {
        System.out.println("afterMethod");
    }

    @Test
    public void testGetInstance() throws Exception {
        System.out.println("testGetInstance");
        // make sure, not more than K instances are generated
        for (int i = 0; i < LazyCtor.getNumOfInstancesAllowed(); i++) {
            LazyCtor y = LazyCtor.getInstance();
            assertEquals(i, y.getId());
        }
        assertNull(LazyCtor.getInstance());
    }

}

