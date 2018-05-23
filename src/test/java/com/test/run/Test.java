package com.test.run;

import java.lang.invoke.MethodHandle;
import static java.lang.invoke.MethodHandles.lookup;
import java.lang.invoke.MethodType;

public class Test {
	static class ClassA {
		public void println(String s) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, Throwable {
		System.out.println(System.currentTimeMillis()%2 );
       Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
       getPrintlnMH(obj).invokeExact("demaxiya");
	}
	
	private static MethodHandle getPrintlnMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException {
		MethodType mt= MethodType.methodType(void.class, String.class);
		return lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(reveiver);
	}
}
