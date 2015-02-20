package Problem2_NoDuplicatingFIles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class noDuplicatingFiles {

    private final static File FOLDER = new File("rootDir");
    private static List<File> filesInFolder = new ArrayList<File>();

    private static boolean isFolder(final File folder){
        if(folder.exists()&&folder.isDirectory()){
            return true;
        }
        return false;
    }

    private static List<File> readFilesFromFolder(final File folder){
        if(isFolder(folder)) {
            for(final File file:folder.listFiles()){
                if(file.isDirectory()) {
                    readFilesFromFolder(file);
                } else {
                    filesInFolder.add(file);
                }
            }
        }
        return filesInFolder;
    }

    public static void removeDuplicatingFiles(){
        readFilesFromFolder(FOLDER);
        System.out.println(filesInFolder);
    }

    public static void main(String[] args) {
        removeDuplicatingFiles();
    }
}
