package com.company;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

/**
 * Created by avd on 2016-12-17.
 */
class JavaSourceFromString extends SimpleJavaFileObject {
    final String code;

    JavaSourceFromString(String className, String code) {
        super(URI.create("string:///" + className.replace(".", "/") + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return code;
    }
}
