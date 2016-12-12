package Adapter;

import Model.Messages;
//coooment
public interface AdapterInterface {

	
	/**
	 * @author Oleg,Dimitar,Todor;
	 * 
	 */
	/**
	 * this is the Adapter  class. It is an interface  from which the class Adapter calls its methods
	 * the class is necessary for the implementation of the Adapter pattern as it provides the backbone of the adapter. 
	 */
	public void Write(Messages list);
	public void Read();
}
