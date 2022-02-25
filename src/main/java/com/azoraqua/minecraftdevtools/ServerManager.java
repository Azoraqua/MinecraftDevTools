package com.azoraqua.minecraftdevtools;

import org.jdesktop.swingx.JXDialog;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public final class ServerManager {

    private static final ServerManager instance = new ServerManager();

    private ServerManager() {
    }

    public static ServerManager getInstance() {
        return instance;
    }

    public void createServer(MinecraftVersion version) {
        try {
            JOptionPane.showMessageDialog(null, downloadBuildTools() ? "BuildTools downloaded!" : "BuildTools not downloaded!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroyServer() {
        new File("data", "BuildTools.jar").delete();
    }

    private synchronized boolean downloadBuildTools() throws IOException {
        final File dir = new File("data");
        final File file = new File(dir, "BuildTools.jar");

        if (file.exists()) {
            return false;
        }

        final String url = "https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar";
        final HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        try (InputStream in = conn.getInputStream()) {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            final BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));

            int curr;

            while ((curr = reader.read()) != -1) {
                writer.write(curr);
            }
        }

        JOptionPane.showMessageDialog(null, file.getAbsolutePath());
        return true;
    }
}
