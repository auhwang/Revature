package com.revature.day3.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//When naming classes, we start every word in the name with a capital letter.
//This is called PascalCasing
public class Driver {
	
	private String FILE_NAME = "myfile.txt";
	private FileOutputStream fos = null;
	private FileInputStream fis = null;
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedWriter bw = null;
	private BufferedReader br = null;
	
	//Method names should always start with a lowercase letter, then every word after the
	//first should be uppercase
	//IE camelCasing
	public static void main(String[] args) {
		/*
		 * Note: When specifying directories, if your directory starts with a forward
		 * slash (/) you are specifying absolute path. (Meaning you place the
		 * full path starting from the root folder of your OS).
		 * If you do not start with a forward slash, you are using relative paths, which
		 * start from current folder, or a different predetermined local space. In Eclipse,
		 * this local space starts with the project folder, just before 'src'
		 */
		Driver d = new Driver();
		try {
			d.fosExample();
			d.fisExample();
			d.fileWriterAndFileReaderExample();
			d.bufferedExample();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End of execution");

	}
		/*
		 * FileInput/FileOutputStreams
		 * -These streams are able to write data/read data one BYTE at a time
		 */
		public void fosExample() throws IOException{
			try {
				fos = new FileOutputStream(FILE_NAME);
				char rand;
				for(int i = 0; i < 15; i++) {
					for(int j = 0;j<30;j++) {
						if(j==16) {
							fos.write('b');
						}else {
							rand = (char)((Math.random()*26) + 'A');
							fos.write((byte) rand);
						}
						if(j<29) {
							fos.write(44);
						}
					}
					fos.write('\n');
				}
				/*
				 * Since Input/Output stream reads in only bytes, it is limited to
				 * generic ascii table of characters that you can write. If you write anything
				 * that is greater than 127 in value, you will overflow into negative
				 * space and get weird characters in return
				 */
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fos != null) {
					fos.close();
					//Always close streams
					 //You will risk memory leaks if you don't close streams you open
				}
			}
		}
		public void fisExample() throws IOException{
			try {
				fis = new FileInputStream(FILE_NAME);
				byte in;
				while((in = (byte)fis.read()) != -1) {
					System.out.println((char)in);
				}
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}finally{
				fis.close();
			}
		}
		
		/*
		 * FileReader/FileWriter
		 * -The underlying difference between a file reader/writer and an input/output stream
		 *  is that the reader and writer cater to the streams one character at a time as opposed
		 *  to one byte at a time
		 *  This handles at double the speed. (Essentially)
		 */
		public void fileWriterAndFileReaderExample() throws IOException{
			try {
				fr = new FileReader(FILE_NAME);
				fw = new FileWriter(FILE_NAME.split("\\.")[0] + "_lowerCase" + "." +
									FILE_NAME.split("\\.")[1]);
				int in;
				/*
				 * Every time the read() method is invoked, the cursor reading the stream is moved
				 * to the next letter. So read() can only be called once per letter
				 */
				while((in = fr.read()) != -1) {
					if(in == 10 || in == 44) {
						fw.write((char)in);
					}else {
						fw.write((char)(in+32));
					}
				}
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				if(fr != null) {
					fr.close();
				}
				if(fw != null) {
					fw.close();
				}
			}
		}
		
		/*
		 * Buffered readers/writers
		 * -These classes are especially useful for reading and writing files since they use
		 * a buffer to read and write with. What this means is that you can set the
		 * amount of characters you read/write at a time
		 * By default, you read by entire lines at a time
		 * Or you can write entire strings at a time
		 */
		public void bufferedExample() throws IOException{
			try {
				//Note, we wrap a bufferedReader around a fileReader
				br = new BufferedReader(new FileReader(FILE_NAME));
				bw = new BufferedWriter(new FileWriter(FILE_NAME.split("\\.")[0] +
														"_chaos." +
														FILE_NAME.split("\\.")[1]));
				String input = "";
				while((input = br.readLine())!=null){
					input = input.replaceAll("A", "Hey, I found an A over here");
					input += '\n';
					bw.write(input);
				}
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
}
