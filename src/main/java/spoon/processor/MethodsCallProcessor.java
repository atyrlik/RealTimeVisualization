package spoon.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.ReturnOrThrowFilter;

/**
 * Created by alexandre on 05/12/16.
 */

/*
Spoon processor to add Logger call in source code.
It insert Logger call before and after methods call.
 */
public class MethodsCallProcessor extends AbstractProcessor<CtMethod>{

    // Called for each method call
    public void process(CtMethod element) {

        // Code to insert
        CtCodeSnippetStatement toPrintBefore = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.logBeginMethodCall(\""+element.getSimpleName()+"\");"
        );

        CtCodeSnippetStatement toPrintAfter = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.logEndMethodCall(\""+element.getSimpleName()+"\");"
        );

        // Insert at the beginning of the method body
        element.getBody().insertBegin(toPrintBefore);

        // Insert before a return or a a throw if not void method
        if(element.getType().getSimpleName() != "void") {
            element.getBody().insertBefore(new ReturnOrThrowFilter(),toPrintAfter);
        }
        // Insert at the end of the method body (in case of void method)
        else {
            element.getBody().insertEnd(toPrintAfter);
        }
    }

}
