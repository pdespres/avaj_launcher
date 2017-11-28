package fr._42.pdespres.avaj_launcher;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

public class main {

    public static void main(String[] args) {

        List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(args[1]), StandardCharsets.UTF_8);

        // getalgorithm class message digest 128 bits 32 octet
    }
}
