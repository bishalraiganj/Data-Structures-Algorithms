package HashTable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Stack.*;

//T extends Object is unnecessary because even without explicitly extending T by default implicitly extends  Object
//because , Only use of T means raw use which allows every type to be the type argument , and every type by default/implicitly
//inherits object , just because T implicitly extends Object , when we give  type parameter like just 'T' (also called raw use)
//we are able to  pass any type as type argument
//so , explicitly doing T extends Object is unnecessary
public class SimpleHashTable<T extends Object,S extends Object > {

	private final Class<T> keyClazz; //This is for runtime type - safety
	private final Class<S> valueClazz; // This is for runtime type - safety ( generally not used, because of complexity and memory and other overheads)
	private Entry<T,S>[] hashTable;
	private int capacity;

	public SimpleHashTable(Class<T> keyClazz,Class<S> valueClazz,int capacity) {


		this.keyClazz = keyClazz;
		this.valueClazz = valueClazz;

		hashTable =(Entry<T,S>[]) Array.newInstance(Entry.class,capacity);
		this.capacity = capacity;
	}



	public void put(T key, S value) {



		int hashValue = this.hashValue(key);
		int stopIndex = hashValue(key);

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


		// When execution control flow comes  here, there are two possibilities
		//1. hashValue found checkSpace true / null / empty position
		//2.hashValue reached stopIndex / hashValue == stopIndex

		if (hashTable[hashValue] == null) {
			hashTable[hashValue] = new Entry<T,S>(keyClazz,valueClazz,key,value);
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

		int resultIndex = findCorrectKeyIndex(key);
		if(resultIndex == -1)
		{
			throw new NoSuchElementException("Key not found");
		}
		 return hashTable[resultIndex].getValue();
	}



	public S removeFirst(T key) {
		int hashValue = this.hashValue(key);
		if (hashTable[hashValue] != null && hashTable[hashValue].getKey().equals(key))
		{
			S matchedValue =  hashTable[hashValue].getValue();
			hashTable[hashValue] = null;
			return matchedValue;
		}
		else  {
			int stopIndex = hashValue;

			if(hashValue == capacity - 1)
			{
				hashValue = 0;
			}
			else{
				hashValue++;
			}


			while ( hashValue != stopIndex)
			{
				if(hashTable[hashValue] != null && hashTable[hashValue].getKey().equals(key))
				{
					S matchedValue = hashTable[hashValue].getValue();
					hashTable[hashValue] = null;
					return matchedValue;
				}

				hashValue = (hashValue + 1 ) % capacity;

			}
		}

		throw new NoSuchElementException("Key not found");

	}



	public int findCorrectKeyIndex(T key)
	{
		int hashValue = this.hashValue(key);


		if(!checkSpace(hashValue) && hashTable[hashValue].getKey().equals(key))
		{
			return hashValue;
		}

		else{

			int stopIndex = hashValue;

			if(hashValue == capacity - 1)
			{
				hashValue = 0;
			}
			else{
				hashValue++;
			}



			//rehashing during removal might be a better choice than not stopping the while loop(for looking) at null positions,
			//because , assuming removal's are less likely to occur than get's
			// so if we rehash at each removal then there is will be no  chance for a null value to be before
			// the element/value we are looking , cause null is never added at removal's and put adds values/elements in the first null position
			while(hashValue != stopIndex )
			{

				if(hashTable[hashValue] !=null && hashTable[hashValue].getKey().equals(key))
				{
					return hashValue;
				}
					hashValue = (hashValue + 1) % capacity;

			}

			// when control of execution comes here , we have one possibilities .
			//1. we reached stopIndex

			return -1;

		}

	}

	public void printHashTable()
	{

		int counter = 0;
		for(Entry<T,S> entry : hashTable)
		{
			System.out.println("index(" + counter++ +"):" +entry);
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
			// If primitive's such as int's floats's doubles's are key's then toString() is
			// invoked on their auto-boxed versions and their decimal string version is returned
			return key.toString().length() % capacity;
		}


	}






}
