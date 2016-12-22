package com.company;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Main {




    public static void main(String[] args) throws IOException {
        ZipFile zipFile = new ZipFile("D:\\java\\jdk\\src.zip");
        String name = Document.class.getName().replace(".", "/") + JavaFileObject.Kind.SOURCE.extension;
        String source = readZipEntry(zipFile, name);
        System.out.println(source);
//
//        Enumeration<JarEntry> entries = jarFile.entries();
//
//        while(entries.hasMoreElements()){
//            System.out.println(entries.nextElement());
//        }
        System.out.println(DOMConfiguration.class.getName());
        javax.tools.JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        PrintWriter pw = new PrintWriter(System.out);


        JavaCompiler.CompilationTask task = compiler.getTask(null, null, null, null, null, Arrays.asList(new JavaSourceFromString("my.Main", "package my;\n" +
                "\n" +
                "public class Main {\n" +
                "    \n" +
                "}")));
        task.setProcessors(Arrays.asList(new MyCodeInspector()));
        task.call();
    }

    private static String readZipEntry(ZipFile zipFile, String name) throws IOException {
        ZipEntry entry = zipFile.getEntry(name);
        System.out.println(entry);
        InputStream inputStream = zipFile.getInputStream(entry);
        InputStreamReader isr = new InputStreamReader(inputStream);
        CharBuffer charBuffer = CharBuffer.allocate(10000);
        StringBuilder sb = new StringBuilder();
        int read;
        do {
            charBuffer.clear();
            read = isr.read(charBuffer);
            if(read> 0) {
                charBuffer.flip();
                sb.append(charBuffer);
            }
        } while(read!=-1);
        return sb.toString();
    }
}
