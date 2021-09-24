package com.elephantdrive;

import java.util.Arrays;

public class ThreadPool {
	
	public static int THREAD_POOL_SIZE = 40;
	
	public static Boolean[] active_jobs = {true, true, true, true, true}; 
	public static long[] threads;

	public static void main(String[] args) {
		
		/**
		 * 1. find number of active jobs
		 * 2. find number of threads per job
		 * 3. 
		 */
		threads = new long[active_jobs.length];
		long activeJobNumber = Arrays.stream(active_jobs).filter(is_active->is_active).count();
		long threadsPerJob = THREAD_POOL_SIZE/activeJobNumber;
		if(threadsPerJob>0) {
			Arrays.fill(threads, threadsPerJob);
		} else {
			Arrays.fill(threads, 0, THREAD_POOL_SIZE, 1);
		}
		System.out.println(Arrays.toString(threads));
	}

}
