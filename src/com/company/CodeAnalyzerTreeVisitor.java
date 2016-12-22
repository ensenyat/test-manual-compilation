package com.company;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;

/**
 * Created by avd on 2016-12-16.
 */
public class CodeAnalyzerTreeVisitor extends TreePathScanner<Object, Trees> {
    @Override
    public Object visitClass(ClassTree classTree, Trees trees) {
        return super.visitClass(classTree, trees);
    }

    @Override
    public Object visitMethod(MethodTree methodTree, Trees trees) {
        return super.visitMethod(methodTree, trees);
    }
}
