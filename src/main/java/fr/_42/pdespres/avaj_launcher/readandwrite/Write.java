package fr._42.pdespres.avaj_launcher.readandwrite;

import fr._42.pdespres.avaj_launcher.exceptions.*;
import java.io.*;

public class Write {

	private static File		target;

	public Write(String path) throws FileCreateException {
		try {
			Write.target = new File(path);
			if (Write.target.exists()) {
				Write.target.delete();
			}
			Write.target.createNewFile();
		} catch (Exception e) {
			throw new FileCreateException("Can't create file " + path + ".");
		}
	}

	public static void writeToTarget(String string) throws FileWriteException{
		BufferedWriter 		bw = null;
		FileWriter 			fw = null;
		try {
			fw = new FileWriter(Write.target.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(string + "\n");
		} catch (Exception e) {
			throw new FileWriteException("Can't write to file " + target.getAbsolutePath() + ".");
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}