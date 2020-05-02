import java.util.List;
import java.io.*;
public class CsvAddComma {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("test.csv"));//檔案讀取路徑
            BufferedReader reader = new BufferedReader(isr);
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("Raw CSV data: " + line);
                
                String[] splitData;
                String tepString = "";
                
                if(line.contains("\"")){
                    splitData = line.split("\\\"");
                    for(int i=0;i<splitData.length;i++){
                        if(!splitData[i].endsWith(",") && !splitData[i].startsWith(",")) {
                            splitData[i] = splitData[i] = splitData[i].replaceAll(","," ");
                        }
                        tepString = tepString + splitData[i];
                    }
                } else {
                    tepString = line;
                }
                System.out.println("tepString: "+tepString);

                splitData = tepString.split(",");
                System.out.println("data1:"+splitData[0]+"\ndata2:"+ splitData[1]+"\ndata3: "+ splitData[2]+"\ndata4:"+ splitData[3]+"\ndata5:"+ splitData[4]+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
