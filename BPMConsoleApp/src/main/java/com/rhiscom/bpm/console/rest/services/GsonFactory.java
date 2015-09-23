package com.rhiscom.bpm.console.rest.services;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

	public class GsonFactory
	{
	   public static Gson createInstance()
	   {
	      Gson gson = new GsonBuilder()
	        .setDateFormat("yyyy/MM/dd HH:mm")
	        	        .create();
	      return gson;
	   }
	
}
