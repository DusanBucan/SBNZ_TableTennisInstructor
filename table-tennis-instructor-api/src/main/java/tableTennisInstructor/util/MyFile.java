package tableTennisInstructor.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.multipart.MultipartFile;
import tableTennisInstructor.constants.KieConstants;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class MyFile {


    public static String basePath = "src/main/resources/newRules/";



    public static ArrayList<SkillExecutionEvent> readSkilleExecutionsFromJsonFile(MultipartFile file) throws Exception{
        ArrayList<SkillExecutionEvent> retVal = new ArrayList<>();
        BufferedReader br;
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
        String fileContent = sb.toString();

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<SkillExecutionEvent>>() {
        }.getType();
        ArrayList<SkillExecutionEvent> executionEvents = gson.fromJson(fileContent, type);
        for(SkillExecutionEvent sk : executionEvents){
            if(sk != null && sk.deltaAngle != null && sk.deltaSpeed != null && sk.rightBodyMovement != null ) {
                retVal.add(sk);
            }
        }

        return  retVal;
    }

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
