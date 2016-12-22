package com.company;

import org.w3c.dom.Document;

import javax.tools.JavaFileObject;
import java.io.IOException;
import java.net.URL;

/**
 * Created by avd on 2016-12-17.
 */
public class JarUrlTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("jar:file:/d:/java/jdk/src.zip!/" + Document.class.getName().replace(".", "/") + JavaFileObject.Kind.SOURCE.extension);
        System.out.println(url.toString());
        url.openStream().read();
    }
}
