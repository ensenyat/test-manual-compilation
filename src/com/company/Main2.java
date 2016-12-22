package com.company;

import org.w3c.dom.Document;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

/**
 * Created by avd on 2016-12-17.
 */
public class Main2 {

    private static URI ORG_W3C_DOM_URI = URI.create("string:///org/w3c/dom/package_info.java");

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        System.out.println("soud");
        UrlSimpleJavaFileObject document = new UrlSimpleJavaFileObject(new URL("jar:file:///d:/java/jdk/src.zip!/" + Document.class.getName().replace(".", "/") + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);

        List<UrlSimpleJavaFileObject> compilationUnits = Collections.singletonList(document);
        JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, null, null, null, null, compilationUnits);
        task.setProcessors(Collections.singleton(new MyCodeInspector()));
//        System.out.println(instance);
        task.call();
//        System.out.println(instance);

    }
}
