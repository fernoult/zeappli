package fre.mmm.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fre.mmm.resources.enums.EnumMessageDisplayer;

public class CSVUtils {

	private static CSVUtils CSVU_INSTANCE;
	
	private CSVUtils(){
		
	}
	
	public static CSVUtils getInstance(){
		
		// Le Singleton qui va bien.
		if (CSVU_INSTANCE == null) {
			CSVU_INSTANCE = new CSVUtils();
		}
		
		return CSVU_INSTANCE;
	}
	
	public String getResourcePath(String fileName_){
		final File file = new File("");
		final String dossierPath = file.getAbsolutePath() + File.separator + fileName_;
		return dossierPath;
	}
	
	public File getFileToCsv(String fileName_){
//		final String comppleteFileName = getResourcePath(fileName_);
		File file = new File(fileName_);
		return file;
	}
	
	public List<String> readFile(File file_){
		
		List<String> liste = new ArrayList<String>();
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file_);
			br = new BufferedReader(fr);
			
			for (String line = br.readLine();  line != null; line = br.readLine()) {
				liste.add(line);
			}
			
		} catch (FileNotFoundException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		} catch (IOException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		} finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return liste;
	}
}
