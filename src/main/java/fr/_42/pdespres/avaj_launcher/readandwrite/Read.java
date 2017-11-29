package fr._42.pdespres.avaj_launcher.readandwrite;

import fr._42.pdespres.avaj_launcher.exceptions.*;
import java.io.*;
import java.util.ArrayList;

public class Read {

	private String				path;
	public ArrayList<String>	sourceLst;

	public Read(String path) throws FileReadException {
		this.sourceLst = new ArrayList<>();
		this.path = path;
		try {
			BufferedReader 		source = new BufferedReader(new FileReader(path));
			String 				line;
			while ((line = source.readLine()) != null) {
				sourceLst.add(line);
			}
			source.close();
		} catch (FileNotFoundException e) {
			throw new FileReadException("Can't find file " + path + ".");
		} catch (IOException e) {
			throw new FileReadException("Can't read file: " + path + ".");
		}
	}
}