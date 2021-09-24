package org.vikulin.test;

import java.util.Arrays;

import com.elephantdrive.ThreadPool;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Test
     */
    public void testNumberOfThreadsPerJobDivisibilityTrue()
    {
    	ThreadPool.THREAD_POOL_SIZE=10;
    	ThreadPool.active_jobs = new Boolean[]{true, true, true, true, true};
    	ThreadPool.main(null);
        assertTrue( Arrays.equals(ThreadPool.threads, new long[] {2l, 2l, 2l, 2l, 2l}));
    }
    
    
    public void testNumberOfThreadsPerJobDivisibilityFalse()
    {
    	ThreadPool.THREAD_POOL_SIZE=10;
    	ThreadPool.active_jobs = new Boolean[]{true, true, true, true, true, true};
    	ThreadPool.main(null);
        assertTrue(Arrays.equals(ThreadPool.threads, new long[] {1l, 1l, 1l, 1l, 1l, 1l}));
    }
    
    public void testNumberOfThreadsLessJobNumber()
    {
    	ThreadPool.THREAD_POOL_SIZE=5;
    	ThreadPool.active_jobs = new Boolean[]{true, true, true, true, true, true, true};
    	ThreadPool.main(null);
        assertTrue(Arrays.equals(ThreadPool.threads, new long[] {1l, 1l, 1l, 1l, 1l, 0l, 0l}));
    }
}
