package com.accp.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNoReiteration {
	/**
	 * 
	    * @Title: getRandom
	    * @Description: 初始化 避免重复随机数
	    * @param @param size 数组大小 
	    * @param @param scope 随机值范围
	    * @return Object[]    返回类型
	    * @throws
	 */
	public static Object[] getRandomInfo(int size,int scope) {
		Set<Integer> set = new HashSet<Integer>();
		Random random=new Random();	
		while(set.size()<size){
			int a = random.nextInt(scope);
			set.add(a);
			if(set.size() == scope) {
				break;
			}
		}
		Object[] ints = set.toArray();
		return ints;
	}
	
//	public static Object[] Random_Removing_duplication(Object[] objs,int size,int scope) {
//		Set<Integer> set = new HashSet<Integer>();
//		for (int i = 0; i < objs.length; i++) {
//			set.add((Integer) objs[i]);
//		}
//		Random random=new Random();	 //使用Random函数产生随机数；
//		while(set.size()<size){
//			int a = random.nextInt(scope);
//			set.add(a);
//		}
//		Object[] ints = set.toArray();
//		return ints;
//	}\
}
