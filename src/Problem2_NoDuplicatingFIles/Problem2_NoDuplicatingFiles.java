import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Problem2_NoDuplicatingFiles {
    private final static File FOLDER = new File("rootDir");
    private static List<File> filesInFolder = new ArrayList<File>();
    private static List<File> uniqueFiles = new ArrayList<File>();

    private static boolean isFolder(final File folder){
        return folder.exists() && folder.isDirectory();
    }

    private static void readFilesFromFolder(final File folder){
        if(isFolder(folder)) {
            for(final File file:folder.listFiles()){
                if(file.isDirectory()) {
                    readFilesFromFolder(file);
                } else {
                    filesInFolder.add(file);
                }
            }
        }
    }

    private static List<byte[]> readContentOfFiles(List<File> uniqueList){
        List<byte[]> contentList = new ArrayList<byte[]>();
        for(File file:uniqueList) {
            byte[] content = null;
            Path path = file.toPath();
            try {
                content = Files.readAllBytes(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            contentList.add(content);
        }
        return contentList;
    }

    private static boolean isUniqueFile(File file){
        List<byte[]> contentInFiles = readContentOfFiles(uniqueFiles);
        boolean isUnique = true;
        byte[] content = null;
        Path path = file.toPath();
        try{
            content = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(byte[] eachFileContent:contentInFiles){
            if(eachFileContent.length==content.length) {
                isUnique=false;
                for (int i = 0; i < content.length; i++) {
                    if(content[i]!=eachFileContent[i]){
                        isUnique=true;
                    }
                }
            }
        }
        return isUnique;
    }

    private static void getUniqueFiles(File file) {
        if(uniqueFiles.size()==0){
            uniqueFiles.add(file);
        } else if(isUniqueFile(file)){
            uniqueFiles.add(file);
        }
    }

    public static void runProgram(){
        readFilesFromFolder(FOLDER);
        for(File f:filesInFolder){
            getUniqueFiles(f);
        }
        System.out.println(uniqueFiles);
    }

    public static void main(String[] args) {
        runProgram();
    }
}
