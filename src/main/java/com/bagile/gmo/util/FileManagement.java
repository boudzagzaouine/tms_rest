package com.bagile.gmo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagement {

    public static Path createDirectory(String dossierCode, String settingPath) throws IOException {
        Path path = Paths.get(settingPath);
        Path newDirectory = path.resolve(dossierCode);
        String uri = newDirectory.toString();
        if (!exist(uri)) {
            newDirectory = Files.createDirectories(newDirectory);
            System.out.println("newDirectory = " + newDirectory);
        } else
            System.out.println("newDirectory = " + newDirectory + " existe deja");
        return newDirectory;
    }

    public static void createFile(String fileName, Path directory, byte[] bytes) throws IOException {
        String uri = directory.resolve(fileName).toString().replace("/", File.separator);
        if (!exist(uri)) {
            Path newFile = Files.createFile(directory.resolve(fileName));
            Files.write(newFile, bytes);
            System.out.println("newFile = " + newFile);
        }
    }

    public static boolean exist(String uri) {
        Path path = Paths.get(uri);
        return Files.exists(path);
    }

    public static void delete(Path path) throws IOException {
        Files.delete(path);
    }

    public static void moveFile(Path originalFile, String settingPath) throws IOException {
        Files.move(originalFile, Paths.get(settingPath).resolve(originalFile.getFileName().toString()));
    }

    public static void copyFile(Path originalFile, Path destination) throws IOException {
        Files.copy(originalFile, destination);
    }

    public static void createFileFromByte(String path, byte[] bytes) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(bytes);
        fos.close();
    }

    public static byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);

        byte[] byteArray = Files.readAllBytes(file.toPath());
        return byteArray;
    }
}
