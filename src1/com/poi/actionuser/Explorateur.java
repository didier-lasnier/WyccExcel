package com.poi.actionuser;

import java.lang.reflect.*;

public class Explorateur {
	public Explorateur() {
	}

	public void explorerChamps(Object o) {
		Field[] f = null;
		Class c = null;

		c = o.getClass();
		f = c.getFields();
		consulterChamps(f, o);
	}

	public void explorerMethodes(Object o) {
		Method[] m = null;
		Class c = null;

		c = o.getClass();
		m = c.getMethods();
		consulterMethodes(m);
	}

	private void consulterChamps(Field[] f, Object o) {
		for (int i = 0; i < f.length; ++i) {
			System.out.print(Modifier.toString(f[i].getModifiers()));
			System.out.print(" ");
			System.out.print(f[i].getType().getName());
			System.out.print(" ");
			System.out.print(f[i].getName());
			System.out.print(" = ");
			try {
				System.out.println(f[i].get(o));
			} catch (IllegalAccessException e) {
				System.out.println("Valeur non consultable");
			}
		}
	}

	private void consulterMethodes(Method[] m) {
		Class[] params = null;
		for (int i = 0; i < m.length; ++i) {
			if (isGetter(m[i])) {

				System.out.print(Modifier.toString(m[i].getModifiers()));
				System.out.print(" ");
				System.out.print(m[i].getReturnType().getName());
				System.out.print(" ");
				System.out.print(m[i].getName());
				System.out.print("(");
				params = m[i].getParameterTypes();

				for (int j = 0; j < params.length; ++j) {

					System.out.print(params[j].getName());
				}

				System.out.println(")");
			}
		}
	}

	public static boolean isGetter(Method method) {
		boolean result = method.getName().startsWith("get") && (method.getParameterTypes().length == 0)
				&& (!Void.class.equals(method.getReturnType()));
		return result;
	}

	public static boolean isSetter(Method method) {
		boolean result = (method.getName().startsWith("set")) && (method.getParameterTypes().length == 1);
		return result;

	}

}