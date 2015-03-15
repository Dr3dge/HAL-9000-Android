package com.whatsmename.hal9000;

import java.io.DataOutputStream;
import java.io.IOException;

public class Shutdown {
	public static void shutdown_sys()
	{
	    Process chperm;
	    try {
	        chperm=Runtime.getRuntime().exec("su");
	          DataOutputStream os = 
	              new DataOutputStream(chperm.getOutputStream());

	              os.writeBytes("shutdown\n");
	              os.flush();

	              chperm.waitFor();

	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void reboot_sys()
	{
	    Process chperm;
	    try {
	        chperm=Runtime.getRuntime().exec("su");
	          DataOutputStream os = 
	              new DataOutputStream(chperm.getOutputStream());

	              os.writeBytes("reboot\n");
	              os.flush();

	              chperm.waitFor();

	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
