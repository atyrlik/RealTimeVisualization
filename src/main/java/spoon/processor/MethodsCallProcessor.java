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

        CtCodeSnippetStatement toPrintBefore = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"Begin method\" , \""+element.getSimpleName()+"\" , \""+element.getSimpleName()+"\", "+0+");"
        );
        element.getBody().insertBegin(toPrintBefore);

        CtCodeSnippetStatement toPrintAfter = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"End method\" , \""+element.getSimpleName()+"\" , \""+element.getSimpleName()+"\", "+0+");"
        );
        element.getBody().insertBefore(new ReturnOrThrowFilter(),toPrintAfter);
    }

}
