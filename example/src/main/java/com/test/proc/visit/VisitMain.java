package com.test.proc.visit;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class VisitMain {

    public static void main(String[] args) throws IOException, URISyntaxException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        VisitTreeProcessor processor = new VisitTreeProcessor();

        StandardJavaFileManager manager = compiler.getStandardFileManager(diagnostics, null, null);
        File file = new File("example/src/main/java/com/test/proc/visit/VisitProcessor.java");
        Iterable<? extends JavaFileObject> sources = manager.getJavaFileObjectsFromFiles(Arrays.asList(file));

        CompilationTask task = compiler.getTask(null, manager, diagnostics, Arrays.asList("-d", "example/target/classes"), null, sources);
        task.setProcessors(Arrays.asList(processor));
        task.call();

        manager.close();

    }
}
