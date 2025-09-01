package HashTable;

import Stack.Employee;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.StringJoiner;


//Achieving both compile time type safety by using generics and
// run time type safety by using reflection api's method's and Array's reification
//through making the Entry type's key and value field's actual run time to be
//a single sized Array created with reflection method's to reify the type information for Entry instances/objects
public class ChainedHashTable<T extends Object,S extends Object>{
	//T and S type parameter's extending Object is unnecessary since by default they
	// become Object references but for learning purposes i still extended
	// and run time type (actual type) of the values/object's these references described by fields with generics
	// may vary as assigned

	private LinkedList<Entry<T,S>>[] hashTable;
	private final Class<T> keyClazz;
	private final Class<S> valueClazz;
	private int capacity;

	public ChainedHashTable(Class<T> keyClazz,Class<S> valueClazz,int capacity)
	{
		this.keyClazz = keyClazz;
		this.valueClazz = valueClazz;
		this.capacity = capacity;
		this.hashTable =   (LinkedList<Entry<T,S>>[])   Array.newInstance(LinkedList.class,capacity);
	}

	public void put(T key,S value)
	{

		int hashValue= this.hashValue(key);

		if(hashTable[hashValue] == null)
		{
			LinkedList<Entry<T,S>> ls = new LinkedList<Entry<T,S>> ();
			ls.add(new Entry<T,S>(keyClazz,valueClazz,key,value));
			hashTable[hashValue]=ls;
		}
		else
		{
			hashTable[hashValue].add(new Entry<T,S>(keyClazz,valueClazz,key,value));
		}
	}

	public S get(T key )
	{
		int hashValue = this.hashValue(key);


		if(hashTable[hashValue] != null)
		{
			int index = -1;

			ListIterator<Entry<T,S>> lt = hashTable[hashValue].listIterator();
			while(lt.hasNext() )
			{
				index++;
				Entry<T,S> entry = lt.next();
				if(entry.getKey().equals(key))
				{
					return entry.getValue();
				}
			}
			//when flow of execution control comes here there are two possibilities
			//1.reached a null value in the LinkedList
			//2.Reached the end of the LinedList
			return null;

		}

		return null;


	}


	public S remove(T key)
	{
		int hashValue = this.hashValue(key);
		if(hashTable[hashValue] != null)
		{

			int index = -1;
			ListIterator<Entry<T,S>> lt  = hashTable[hashValue].listIterator();
			if(lt.hasNext())
			{
				while(lt.hasNext()   )
				{
					index++;
					Entry<T,S> entry = lt.next();
					if(entry.getKey().equals(key))
					{
						hashTable[hashValue].remove(index);
						return entry.getValue();
					}
				}

				return null;


			}


		}
			return null;







	}




	public int hashValue(T key)
	{
		if( key instanceof Employee)
		{
			Employee e = (Employee) key;
			return e.lastName().length() % capacity ;

		}
		else if( key instanceof String)
		{
			 String s = (String) key;
			return s.length() % capacity ;
		}
		// Otherwise , key is either primitive or custom object/type/class
		else
		{
			//even though key is generic and  type argument is erased at runtime
			// the type reference is of Object by default allowing to store any custom type or any type/object
			//since every object will have either inherited toString() or overriden toString()
			//compiler knows that , invoking toString on this generic key is safe
		 return key.toString().length() % capacity;
		 // or we can do return ""+key.length() % capacity ;
			//cause concatenating with empty string will implicitly call to String on the key object/instance and
			//concatenate with the empty string

		}
	}

	public void printHashTable()
	{
		StringJoiner sj = new StringJoiner("\n","-".repeat(50)+"HashTable Start"+"-".repeat(50)+"\n",
				"\n"+"-".repeat(50)+"HashTable END"+"-".repeat(50)+"\n");

		for(int i = 0 ; i <capacity ; i++)
		{

			if(hashTable[i]!=null  )
			{
				ListIterator<Entry<T,S>> lt = hashTable[i].listIterator();
				StringJoiner sj2 =  new StringJoiner(" -> ","index"+i+":"+(lt.hasNext()?" [":""),(lt.hasNext()?"->null ]":""));

				if(lt.hasNext())
				{
					while(lt.hasNext())
					{

						sj2.add(lt.next().toString());
					}
				}
				else{
					sj2.add(" empty");
				}

				sj.add(sj2.toString());
			}
			else
			{
				sj.add("index"+i+": empty");
			}
		}
		System.out.println(sj.toString());
	}
}
