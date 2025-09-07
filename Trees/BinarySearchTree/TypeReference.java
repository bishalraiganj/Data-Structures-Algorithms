package BinarySearchTree;

import java.lang.reflect.*;

public class TypeReference<T> {

	private final Type  type;
	private final Type returnType;

	protected TypeReference()
	{
		this.type = this.getClass().getGenericSuperclass();
		 returnType = ((ParameterizedType) type).getActualTypeArguments()[0];
	}

	public Type getType()
	{
		return returnType;
	}





}
