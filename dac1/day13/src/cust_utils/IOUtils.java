package cust_utils;

import java.io.*;

import static com.app.core.CustomerComplaint.*;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.core.CustomerComplaint;

public class IOUtils {
	public static void storeInfo(HashMap<Integer, CustomerComplaint> hm) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("complaints.ser"))) {
			// write number list
			out.writeObject(getNums());
			// write index
			out.writeInt(getIndex());
			// write map
			out.writeObject(hm);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static HashMap<Integer, CustomerComplaint> restoreInfo() {
		HashMap<Integer, CustomerComplaint> hm = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"complaints.ser"))) {
			// retrieve num list & set it to CustomerComplaint class
			setNums((ArrayList<Integer>) in.readObject());
			System.out.println("re-stored list "+getNums());
			// retrieve index & set it to CustomerComplaint class
			setIndex(in.readInt());
			System.out.println("re-stored index "+getIndex());
			// retrieve HM of complaints & ret the same to the caller
			hm = (HashMap<Integer, CustomerComplaint>) in.readObject();

		} catch (Exception e) {
			if (e instanceof FileNotFoundException) {
				// generate num list
				initNumbers();
				// create empty hm
			
			}
			hm = new HashMap<>();
			e.printStackTrace();
		}
		System.out.println("restored HM "+hm);
		return hm;
	}
	public static HashMap<String, String> restoreExpertInfo()
	{
		HashMap<String, String> hm=null;
		try (ObjectInputStream in=new ObjectInputStream(new FileInputStream("users.ser")))
		
		{
			hm=(HashMap<String, String>)in.readObject();
		} catch (Exception e) {
			
			e.printStackTrace();
			hm=new HashMap<>();
		}
		System.out.println("restored expert info "+hm);
		return hm;
	}
}
