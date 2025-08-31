package HashTable;

import java.lang.reflect.Array;

public class Entry<T,S> {

	private final T[] key;
	private final S[] value;

	public Entry(Class<T> keyClazz,Class<S> valueClazz,T key,S value)
	{

		this.key =   (T[]) Array.newInstance(keyClazz,1);
		this.key[0] = key;
		this.value = (S[]) Array.newInstance(valueClazz,1);
		this.value[0] = value;
	}

	public T getKey()
	{
		return key[0];
	}
	public S getValue()
	{
		return value[0];
	}


	@Override
	public String toString()
	{
		return "( Key: "+key[0]+", value: " +value[0]+")";
	}

}
