package tableTennisInstructor.util;

import org.springframework.web.multipart.MultipartFile;
import tableTennisInstructor.constants.KieConstants;

import java.io.*;
import java.util.Date;

public class MyFile {


    public static String basePath = "src/main/resources/newRules/";

    public static String readFile(MultipartFile file) throws Exception {
        BufferedReader br;
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
        return sb.toString();
    }

    public static void writeToKjarFile(MultipartFile file) throws Exception {
        String fileStr = readFile(file);
        String fileName = "new_rules_" + new Date().toString();
        try (PrintWriter out = new PrintWriter(KieConstants.BASE_PATH_NEW_RULES + fileName + KieConstants.DRL_FILE_EXTENSION)) {
            out.println(fileStr);
        }
    }
}
