package spoon.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtConstructorCall;

/**
 * Created by alexandre on 18/11/16.
 */
public class ObjectCreationProcessor  extends AbstractProcessor<CtConstructorCall> {

    public void process(CtConstructorCall element) {

        CtCodeSnippetStatement toPrintBefore = this.getFactory().Code().createCodeSnippetStatement("System.out.println(\"Begin creation\")");
        element.insertBefore(toPrintBefore);

        CtCodeSnippetStatement toPrintAfter = this.getFactory().Code().createCodeSnippetStatement("System.out.println(\"End creation\")");
        element.insertBefore(toPrintAfter);

    }
}
