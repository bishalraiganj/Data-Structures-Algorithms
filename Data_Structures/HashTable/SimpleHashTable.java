package HashTable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import Stack.*;

//T extends Object is unnecessary because even without explicitly extending T by default implicitly extends  Object
//because , Only use of T means raw use which allows every type to be the type argument , and every type by default/implicitly
//inherits object , just because T implicitly extends Object , when we give  type parameter like just 'T' (also called raw use)
//we are able to  pass any type as type argument
//so , explicitly doing T extends Object is unnecessary
public class SimpleHashTable<T extends Object,S extends Object > {

	private S[] hashTable;
	private int capacity;

	public SimpleHashTable(Class<T> clazz, int capacity) {
		hashTable = (S[]) Array.newInstance(clazz, capacity);
		this.capacity = capacity;
	}


	public void put(T key, S value) {


		int hashValue = hashValue(key);
		int stopIndex = this.hashValue(key);

		if(!checkSpace(hashValue)) {
			if (hashValue == capacity - 1) {
				hashValue = 0;
			} else {
				hashValue++;
			}
		}

		while(!checkSpace(hashValue) &&  hashValue !=stopIndex)
		{
			hashValue =  ( hashValue + 1 ) % capacity;
		}



		if (hashTable[hashValue] == null) {
			hashTable[hashValue] = value;
		} else {
			System.out.println("Same key already exists or  key is generating same hashValue and conflict's are not managed !");
		}

	}

	private boolean checkSpace(int hashValue)
	{
		return  hashTable[hashValue]==null;
	}



	public S get(T key)
	{
		 return hashTable[hashValue(key)];
	}


	public void printHashTable()
	{
		for(S val : hashTable)
		{
			System.out.println(val);
		}

	}


	// we will treat this hash value as the index of the hashTable array
	private  int hashValue(T key)
	{

		if(key instanceof Employee)
		{
			Employee e = (Employee) key;

			return e.lastName().length() % capacity;
		}
		else if(key instanceof String)
		{
			String str = (String) key;
			return str.length() % capacity;
		}
		else
		{
			return key.toString().length() % capacity;
		}

	}






}
