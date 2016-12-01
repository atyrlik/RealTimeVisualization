package spoon.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtStatement;
import spoon.reflect.reference.CtTypeReference;

import java.time.Instant;

/**
 * Created by alexandre on 18/11/16.
 */
public class ObjectCreationProcessor extends AbstractProcessor<CtConstructorCall> {

    public void process(CtConstructorCall element) {

        // if affectation ("O o = new O()")
        if(!(element.getParent(CtStatement.class) instanceof CtBlock)){
            addLogs(element.getParent(CtStatement.class), element.getType(), element.getParent(CtStatement.class).getShortRepresentation());
        }
        // if new alone
        else {
            addLogs(element, element.getType());
        }
    }

    // Function to add prints into log (without affectation)
    private void addLogs(CtStatement element, CtTypeReference type){
        CtCodeSnippetStatement toPrintBefore = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"Begin object creation\" , \""+type+"\" , \"anonymous\");"
        );

        CtCodeSnippetStatement toPrintAfter = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"End object creation\" , \""+type+"\" , \"anonymous\");"
        );

        element.insertBefore(toPrintBefore);
        element.insertAfter(toPrintAfter);
    }
    // Function to add prints into log, it prints the name of the object created.
    private void addLogs(CtStatement element, CtTypeReference type, String objectCreatedName){

        CtCodeSnippetStatement toPrintBefore = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"Begin object creation\" , \""+type+"\" , \""+objectCreatedName+"\");"
        );

        CtCodeSnippetStatement toPrintAfter = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"End object creation\" , \""+type+"\" , \""+objectCreatedName+"\");"
        );

        element.insertBefore(toPrintBefore);
        element.insertAfter(toPrintAfter);
    }
}
