package com.saraya.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.model.Glass;

@Service //-> stereotype annotation and there are 4 : Controller, Repository, Service and Component
public class GlassService {

	private static ArrayList<Glass> glasses=new ArrayList<Glass>();
	private static int count=10;
	
	static {
		glasses.add(new Glass(1,2019,"Wrap-T","lm","https://images.unsplash.com/photo-1534844978-b859e5a09ad6?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=774&q=80"));
		glasses.add(new Glass(2,2017,"Shield","Browline","https://images.unsplash.com/photo-1483412468200-72182dbbc544?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=873&q=80"));
		glasses.add(new Glass(3,2011,"clubmaster","tres32","https://images.unsplash.com/photo-1603578119639-798b8413d8d7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"));
		glasses.add(new Glass(4,2021,"Butterfly","ourt4","https://images.unsplash.com/photo-1574258495973-f010dfbb5371?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"));
		glasses.add(new Glass(5,2015,"EyeGlass-LENS","frameS","https://images.unsplash.com/photo-1511499767150-a48a237f0083?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=580&q=80"));
		glasses.add(new Glass(6,2020,"GL-glasses","greew","https://images.unsplash.com/photo-1502767089025-6572583495f9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"));
		glasses.add(new Glass(7,2013,"LensLess","M4","https://images.unsplash.com/photo-1508296695146-257a814070b4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80"));
		glasses.add(new Glass(8,2009,"Horn-rimmed","wesr","https://images.unsplash.com/photo-1523754865311-b886113bb8de?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=813&q=80"));
		glasses.add(new Glass(9,2015,"RayBand","Wq90","https://images.unsplash.com/photo-1502929254524-5e4f51903baa?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"));
		glasses.add(new Glass(10,2020,"Goggles","GL","https://images.unsplash.com/photo-1556306535-38febf6782e7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"));
	}
	
	public List<Glass> getAllGlasses(){
		return glasses;
	}
	public void addGlass(int year, String make, String model,String image) {
		glasses.add(new Glass(++count,year,make,model,image));
	}
	public void deleteGlass(int id) {
		Iterator<Glass> iterate=glasses.iterator();
		while(iterate.hasNext()) {
			Glass glass=iterate.next();
			if(glass.getId()==id) {
				iterate.remove();
	}
	
}
}
	public Glass findById(int id) {
	for(Glass g:glasses) {
		if(g.getId()==id) {
			return g;
		}
	}
	return null;
}
	public void updateByGlass(Glass g) {
		glasses.remove(g);
		glasses.add(g);
	}
}