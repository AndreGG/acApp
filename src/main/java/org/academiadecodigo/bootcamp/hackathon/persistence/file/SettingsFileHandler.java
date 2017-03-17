package org.academiadecodigo.bootcamp.hackathon.persistence.file;

import java.io.*;

/**
 * Created by codecadet on 3/16/17.
 */
public class SettingsFileHandler {

    private File settingsFile;
    private String settings;
    private final String SETTINGS_FILE_PATH = "." + File.separator + "acApp";

    public SettingsFileHandler() {

        settingsFile = new File(SETTINGS_FILE_PATH);
        settings = "";

        if(!settingsFile.exists()) {

            try {
                settingsFile.createNewFile();
                writeDefaultSettings();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        settingsFile.getAbsolutePath();
    }

    public String getSettings() {

        FileReader fileReader = null;
        BufferedReader bReader = null;

        try {

            fileReader = new FileReader(settingsFile.getPath());
            bReader = new BufferedReader(fileReader);

            String settingsLine = null;

            while((settingsLine = bReader.readLine()) != null) {
                settings += settingsLine + "\r\n";
            }

            fileReader.close();
            bReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return settings;
    }

    public void writeDefaultSettings() {

            PrintWriter pWriter = null;

        try {

            pWriter = new PrintWriter(settingsFile.getPath());

            pWriter.write(SettingsMessages.bootcamp + SettingsMessages.defaultValue + "\r\n");

            pWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(pWriter != null) {
                pWriter.close();
            }
        }

    }
}
