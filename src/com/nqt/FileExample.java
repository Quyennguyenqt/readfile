package com.nqt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileExample {
	private static final String FILE_HEADER = "transaction,date,code";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String COMMA_DELIMITER = ",";
	static List<TranInfo> list = new ArrayList<TranInfo>();
	static TranInfo tranIn;

	public static List<TranInfo> readFile() {
		try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\QUYENNGUYEN\\Desktop\\test.txt"))) {
			String line;
			String str = null;
			while ((line = br.readLine()) != null) {
				tranIn = new TranInfo();
				str = line.toString();
				str = str.replaceAll(",", "");
				long tranfer = Long.valueOf(str.substring(str.indexOf('+'), str.indexOf('V'))).longValue();
				tranIn.setTranfer(tranfer);

				String date = str.substring(str.indexOf("VND") + 3, str.indexOf("SD") - 1);
				tranIn.setDate(date.trim());

				String code = str.substring(str.indexOf("ND:") + 3);
				tranIn.setCode(code.trim());
				list.add(tranIn);

			}
			br.close();
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		return list;
	}

	public static void writeFile(List<TranInfo> listTranInfo) {
		StringBuilder sb1 = new StringBuilder();
		try (FileWriter writer = new FileWriter(new File("C:\\Users\\QUYENNGUYEN\\Desktop\\result.csv"))) {
			sb1.append(FILE_HEADER.toString());
			sb1.append(NEW_LINE_SEPARATOR);
			for (TranInfo tranIn : listTranInfo) {
				sb1.append(String.valueOf(tranIn.getTranfer()));
				sb1.append(COMMA_DELIMITER);
				sb1.append(tranIn.getDate());
				sb1.append(COMMA_DELIMITER);
				sb1.append(tranIn.getCode());
				sb1.append(NEW_LINE_SEPARATOR);
			}
			writer.write(sb1.toString());
			writer.close();
			System.out.println(sb1.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		list = readFile();
		writeFile(list);
	}
}
