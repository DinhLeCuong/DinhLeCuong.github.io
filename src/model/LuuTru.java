package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class LuuTru {
	public static String sukien = "data//sukien.json";
	
	public static List<LichSu> getData(String path) {
		List<LichSu> listSuKien = new ArrayList<>();
		SuKien sk;
		Gson gson = new Gson();
		try {
			FileReader fr = new FileReader(path); 
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				sk = gson.fromJson(line, SuKien.class);
				listSuKien.add(sk);
				line = br.readLine();
			}
			br.close();
			fr.close();
		}	catch (Exception e) {
			e.printStackTrace();
		}
		return listSuKien;
	}
}