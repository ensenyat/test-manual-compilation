package com.company;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.logging.Logger;

/**
 * Created by avd on 2016-12-17.
 */
public class UrlSimpleJavaFileObject extends SimpleJavaFileObject {
    public static final Logger LOGGER = Logger.getLogger(UrlSimpleJavaFileObject.class.getName());
    private final URL url;

    /**
     * Construct a SimpleJavaFileObject of the given kind and with the
     * given URI.
     *
     * @param url  the URI for this file object
     * @param kind the kind of this file object
     */
    protected UrlSimpleJavaFileObject(URL url, Kind kind) throws URISyntaxException {
        super(URI.create(url.getPath()), kind);
        this.url = url;
    }

    @Override
    public InputStream openInputStream() throws IOException {
        LOGGER.info("InputStream was called");
        return this.url.openStream();
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        CharBuffer cb = CharBuffer.allocate(10000);
        InputStreamReader isr = new InputStreamReader(openInputStream());
        int read;
        StringBuilder sb = new StringBuilder();
        do {
            cb.clear();
            read = isr.read(cb);
            if(read!=-1) {
                cb.flip();
                sb.append(cb.toString());
            }
        } while(read!=-1);
        return sb.toString();
    }
}
