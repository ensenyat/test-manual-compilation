package com.company;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;

/**
 * Created by avd on 2016-12-19.
 */
public class InMemoryJavaFileObject extends SimpleJavaFileObject {
    private final String code;

    /**
     * Construct a SimpleJavaFileObject of the given kind and with the
     * given URI.
     *
     * @param uri  the URI for this file object
     * @param kind the kind of this file object
     */
    public InMemoryJavaFileObject(URI uri, Kind kind, String code) {
        super(uri, kind);
        this.code = code;
    }


}
