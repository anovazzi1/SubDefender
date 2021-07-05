package com.subdefender.game;

import java.io.*;

public class CSVHandling {
	private String dataSource;
	private String dataExport;
	private String[] commands;
	private String[] state;

	public CSVHandling() {
		this.commands = null;
		this.dataSource = null;
		this.dataExport = null;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
		if (dataSource == null) {
			commands = null;
		} else
			readCSV();
	}

   public String getDataExport() {
      return dataExport;
   }

   public void setDataExport(String dataExport) {
      if(dataExport!= null)
         this.dataExport = dataExport;
   }

	public String[] requestCommands() {
		return commands;
	}

   public void exportState(String[] state) {
      this.state = state;
      writeCSV();
   }

   private void readCSV() {
		try {
			BufferedReader file = new BufferedReader(new FileReader(dataSource));

			String line = file.readLine();
			if (line != null) {
				commands = line.split(",");
				line = file.readLine();
			}
			file.close();
		} catch (IOException erro) {
			erro.printStackTrace();
		}
	}
	
	private void writeCSV(){
		try {
			PrintWriter fileExport = new PrintWriter(new FileWriter(dataExport, true));
			if (state != null)
				for (String value : state) fileExport.println(value);
			fileExport.close();
		}catch(IOException erro){
			erro.printStackTrace();
		}
	}
}