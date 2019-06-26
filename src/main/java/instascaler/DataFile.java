package instascaler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DataFile {
    ArrayList categoryList;
    DataFile() {
        ArrayList<String> categoryList=new ArrayList<>();
    }

    public void addToFile(ArrayList<Campaign> campaignList) {

        try {
            File file = new File("Data.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            try (PrintWriter pw = new PrintWriter(file)) {
                for (int i = 0; i < campaignList.size(); i++) {
                    pw.print(campaignList.get(i).getCountry() + "|" + campaignList.get(i).getCategory());
                    pw.println();
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public HashMap<String, String> readFromFile() {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bf = null;

        try {
            bf = new BufferedReader(new FileReader("Data.txt"));
            String line;
            String[] str;

            while ((line = bf.readLine()) != null) {
                str = line.split("|");
                map.put(str[0], str[1]);
                categoryList.add(str[1]);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
  return map;
    }


    public int computeCategoryValue(String category) {
        int value=0;
       for(int i=0;i<categoryList.size();i++){
          if(categoryList.get(i).equals(category))
          {
              value++;
          }
       }
       return value;
    }
}

