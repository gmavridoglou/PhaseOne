package utility;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import exception.ProperOptionValue;

public class SubMenu {
	
	static File rootPath= new File("/Users/gmavridoglou/Desktop/PhaseOneEndProject/PhaseOneEndProject/FileFolder");
	
	public static void subMenuOptions() throws IOException {
		
		File ff = new File("/Users/gmavridoglou/Desktop/PhaseOneEndProject/PhaseOneEndProject/FileFolder");
		
		Scanner sc= new Scanner(System.in);
		String con;

		do {
		System.out.println("File Options");
		System.out.println("1: Create file");
		System.out.println("2: Delete file");
		System.out.println("3: Search file");
		System.out.println("4: Exit to Main Menu");
		System.out.println("5: Exit application");
		
		int choice=sc.nextInt();
		switch(choice) {
		case 1: System.out.println("Type the file name you want to create");
		String fileName = sc.next();
		
		String newPath = ff.getPath()+"/"+fileName;
		
		File newFile = new File(newPath);
		if(newFile.exists()) {
			System.out.println("This file already exists");
		}else {
			newFile.createNewFile();
			System.out.println("New file created with name as "+fileName);
		}
		break;
		
		case 2: System.out.println("Type the name of the file you want to delete");
		String fileName1 = sc.next();

		File[] files = ff.listFiles();

		if (files != null) {
		    boolean fileFound = false;

		    for (File file : files) {
		        if (file.getName().equals(fileName1)) { // Case-sensitive comparison
		            fileFound = true;
		            if (file.delete()) {
		                System.out.println("File successfully deleted");
		            } else {
		                System.out.println("Failed to delete the file");
		            }
		            break;
		        }
		    }

		    if (!fileFound) {
		        System.out.println("No file is present with the name " + fileName1);
		    }
		} else {
		    System.out.println("Directory not found or empty!");
		}

			//for no case sensitivity
//			System.out.println("Type the name of the file you want to delete");
//		String fileName1= sc.next();
//		
//		File fileToDelete = new File(ff.getPath() + "/" + fileName1);
//		if(fileToDelete.exists()) {
//				fileToDelete.delete();
//				System.out.println("File successfully deleted");
//		}else {
//			
//			System.out.println("No file is present with the name "+fileName1);
//		}
		break;
		
		case 3: System.out.println("Type the name of the file you want to search(Case sensitive)");
		String fileName2 = sc.next();

		File[] files1 = ff.listFiles();

		if (files1 != null) {
		    boolean filePresent = false;

		    for (File file : files1) {
		        if (file.getName().equals(fileName2)) { // Case-sensitive comparison
		            filePresent = true;
		            break;
		        }
		    }

		    if (filePresent) {
		        System.out.println("File present!");
		    } else {
		        System.out.println("File not present!");
		    }
		} else {
		    System.out.println("Directory not found or empty!");
		}
			//if you don't want it case sensitive
//			System.out.println("Type the name of the file you want to search");
//		String fileName2= sc.next();
//		
//		File searchFile = new File(ff.getPath() + "/" + fileName2);
//		if(searchFile.exists()) {
//				System.out.println("File present!");
//		}else {
//				System.out.println("File not present!");
//		}
		break;
		
		case 4: MainMenu.menuOptions();
		break;
		
		case 5: System.exit(0);
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
		
	}




