package iaf.perf.course.day5;

import java.io.*;



public class FinalProject {

	public static void main(String[] args) {
		try {
			long st = System.nanoTime();
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream("C:\\Users\\BOAZ\\GitHub\\perf-class\\course\\src\\test\\java\\iaf\\perf\\course\\day5\\head_of_vcf");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String strLine;
			vcf[] dataArr = new vcf[10000000];
			int ObjCounter = 0;

			//Read File Line By Line until #chrom
			while ((strLine = br.readLine()) != null)   {
				if(strLine.contains("#CHROM")) break;
			}
			while ((strLine = br.readLine()) != null)   {
				String[] parsedOut = strLine.split("	");
				dataArr[ObjCounter] = new vcf(parsedOut[0],Integer.parseInt(parsedOut[1]),parsedOut[3],parsedOut[4],Float.parseFloat(parsedOut[5]));
				ObjCounter++;
			}
			
			/*
			for(int i = 0; i<ObjCounter;i++)
				System.out.println(dataArr[i].getRef());
			*/
			
			try (FileOutputStream fos = new FileOutputStream("C:\\Users\\BOAZ\\GitHub\\perf-class\\course\\src\\test\\java\\iaf\\perf\\course\\day5\\vcf.bin");ObjectOutputStream oos = new ObjectOutputStream(fos);){
				for(int i = 0; i<ObjCounter;i++)
					oos.writeObject(dataArr[i]);
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
			
			long en = System.nanoTime();
			System.out.println("Time: " + (en-st)/1E6+"ms");
			
			//Close the input stream
			in.close();
			}
		catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}