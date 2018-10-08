package training.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
	private List<String> extensions;
	private String[] fileNames;
	private final String DIR_PATH = "D:\\Ó÷¸áà\\iba\\test"; 
	private File parentDirectory; 
	private File[] fileList;
	
	public void doTask() {
		parentDirectory = new File(DIR_PATH);
		if (parentDirectory.isDirectory()) {
			fileNames = parentDirectory.list();
			fileList = parentDirectory.listFiles();
		}
		extensions = new ArrayList<>();
		for (String names : fileNames) {
			extensions.addAll(getExtensionByStringHandling(names));
		}
		Set<String> extensionsSet = new HashSet<>();
		extensionsSet.addAll(extensions);
		extensions.clear();
		extensions.addAll(extensionsSet);
		extensionsSet = null;
		createDirectories(extensions);
				
	}
	
	private List<String> getExtensionByStringHandling(String filename) {
		Stream<String> nameStream = Stream.of(filename);
	    return nameStream
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(filename.lastIndexOf(".") + 1))
	      .collect(Collectors.toList());
	}
	
	private void createDirectories(List<String> extensions) {
		for (int i = 0; i < extensions.size(); i++) {
			if (!new File(parentDirectory, extensions.get(i).toString()).mkdir()) {
				System.out.println("Cannot create directory");
			}
		}
		try {
			moveFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void moveFiles() throws IOException {
		for (File file : fileList) {
			for (String extension : extensions) {
				if (file.getName().substring(file.getName().lastIndexOf(".") + 1).equals(extension)) {
					file.renameTo(new File(parentDirectory.getAbsolutePath() + File.separator + extension 
							+ File.separator + file.getName()));
				}
			}
		}
		
	}
	

}
