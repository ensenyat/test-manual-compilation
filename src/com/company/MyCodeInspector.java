package com.company;

import com.sun.source.util.Trees;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by avd on 2016-12-16.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("*")
public class MyCodeInspector extends AbstractProcessor {

    private Trees trees;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.trees = Trees.instance(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(roundEnv.processingOver()){
        }
        for (Element e : roundEnv.getRootElements()) {
            Element enclosingElement = e.getEnclosingElement();
            System.out.println(e.getEnclosingElement().getEnclosedElements());
            System.out.println("Element is " + e.getSimpleName());
//            e.accept()

        }
        return true;
    }
}
