package utility;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import exception.ProperOptionValue;


public class MainMenu {
	
	static File rootPath= new File("/Users/gmavridoglou/Desktop/PhaseOneEndProject/PhaseOneEndProject/FileFolder");
	
	public static void menuOptions() {
		Scanner sc= new Scanner(System.in);
				String con;
		
				do {
					System.out.println("1: Display all the files(ascending order)");
					System.out.println("2: File Options");
					System.out.println("3: Exit");
					System.out.println("Please enter your choice.");
					
					int choice= sc.nextInt();
					switch(choice) {
					
					case 1: displayAllFiles();
					break;
					
					case 2: try {
							SubMenu.subMenuOptions();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 3: System.exit(0);
					}
					
					System.out.println("Do you want to continue?(y/n)");
					con= sc.next();
					
					try {
		                if (!con.equals("y") && !con.equals("n")) {
		                    throw new ProperOptionValue("Please enter Y or N");
		                }
		            } catch (ProperOptionValue e) {
		                System.out.println(e.getMessage());
		            }
		        } while (con.equalsIgnoreCase("y"));
		    }

		    public static void displayAllFiles() {
		        File[] files = rootPath.listFiles();
		        if (files != null) {
		            Arrays.sort(files);
		            for (File file : files) {
		                if (file.isFile()) {
		                    System.out.println(file.getName());
		                }
		            }
		        }
		    }
}
