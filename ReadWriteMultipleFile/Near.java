package InterviewQuestions;

import java.io.*;

public class Near {
    private static int count =0;
    static String total = "";
    private static BufferedWriter bufferedWriter = null;
    private static BufferedReader br = null;
    public static void main(String[] args){
        File folder = new File("D:\\Near");
        listAllFiles(folder);
    }

    private static void listAllFiles(File folder) {
        File[] files = folder.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                listAllFiles(file);
            }else{
                try {
                     readContent(file);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readContent(File file) throws IOException {
        try{
                System.out.println("read file " + file.getCanonicalPath());
                File file1 = new File("D:\\OutPut.csv");
                br = new BufferedReader(new FileReader(file));
                FileWriter fileWriter = new FileWriter(file1, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                String strLine = null;
                while ((strLine = br.readLine()) != null) {
                    if(count<1){
                        fileWriter.write("THE FILE READ IS : " + file.getCanonicalPath());
                        fileWriter.append("\n");
                        count+=1;
                    }
                    System.out.println(strLine);
                    fileWriter.write(strLine);
                    fileWriter.append("\n");
                }
                System.out.println();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if(br != null){
                    br.close();
                }
                if(bufferedWriter != null){
                    bufferedWriter.append("\n");
                    count=0;
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            }
    }
}
