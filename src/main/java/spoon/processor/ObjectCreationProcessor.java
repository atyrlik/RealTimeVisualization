package spoon.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtStatement;

/**
 * Created by alexandre on 18/11/16.
 */
public class ObjectCreationProcessor  extends AbstractProcessor<CtConstructorCall> {

    public void process(CtConstructorCall element) {

        // create log messages
        CtCodeSnippetStatement toPrintBefore = this.getFactory().Code().createCodeSnippetStatement("System.out.println(\"Begin creation\")");
        CtCodeSnippetStatement toPrintAfter = this.getFactory().Code().createCodeSnippetStatement("System.out.println(\"End creation\")");

        if(!(element instanceof CtStatement)){
            element.getParent(CtStatement.class).insertBefore(toPrintBefore);
            element.getParent(CtStatement.class).insertAfter(toPrintAfter);
        }
        else{
            element.insertBefore(toPrintBefore);
            element.insertAfter(toPrintAfter);
        }



    }
}
