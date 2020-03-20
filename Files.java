package game.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Files {
	private File file;
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private  BufferedReader br;

	public Files (String path) throws Exception {
		file = new File(path);
		fw = new FileWriter(file, true);
		bw = new BufferedWriter(fw);
		fr=  new FileReader(file);
		br = new BufferedReader(fr);
	}

	public void createFile() throws Exception {
		if(!file.exists()) {
			file.createNewFile();
		}
	}

	public String readLineFromFile() throws Exception {
		String line= br.readLine();
		fr.close();
		return line;  
	}

	public void writeToFile(String data) throws Exception {
		String dataWithNewLine= data+System.getProperty("line.separator");
		bw.write(dataWithNewLine);
		bw.close();
		fw.close();
	}

	public boolean exist() {
		return file.exists();
	}

	public void delete() {
		if(file.exists()) {
			file.delete();
		}
	}
}
