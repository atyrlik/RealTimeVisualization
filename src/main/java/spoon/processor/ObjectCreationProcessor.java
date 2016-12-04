package spoon.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtStatement;
import spoon.reflect.reference.CtTypeReference;

/**
 * Created by alexandre on 18/11/16.
 */

/*
Spoon processor to add Logger call in source code.
It insert Logger call before and after each constructor call.
 */
public class ObjectCreationProcessor extends AbstractProcessor<CtConstructorCall> {

    // variable to keep track of constructor call with an unique id
    static long id = 0;

    // Called for each constructor call
    public void process(CtConstructorCall element) {

        // if affectation ("O o = new O()")
        if(!(element.getParent(CtStatement.class) instanceof CtBlock)){
            addLogs(element.getParent(CtStatement.class), element.getType(), element.getParent(CtStatement.class).getShortRepresentation());
        }
        // if new alone ("new O()")
        else {
            addLogs(element, element.getType());
        }

        // update id
        id++;
    }

    // Add Logger call before and after constructor call (without affectation)
    private void addLogs(CtStatement element, CtTypeReference type){
        CtCodeSnippetStatement toPrintBefore = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"Begin object creation\" , \""+type+"\" , \"anonymous\", "+id+");"
        );

        CtCodeSnippetStatement toPrintAfter = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"End object creation\" , \""+type+"\" , \"anonymous\", "+id+");"
        );

        element.insertBefore(toPrintBefore);
        element.insertAfter(toPrintAfter);
    }
    // Add Logger call before and after constructor call (with affectation)
    private void addLogs(CtStatement element, CtTypeReference type, String objectCreatedName){

        CtCodeSnippetStatement toPrintBefore = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"Begin object creation\" , \""+type+"\" , \""+objectCreatedName+"\", "+id+");"
        );

        CtCodeSnippetStatement toPrintAfter = this.getFactory().Code().createCodeSnippetStatement(
                "Logger.log(\"End object creation\" , \""+type+"\" , \""+objectCreatedName+"\", "+id+");"
        );

        element.insertBefore(toPrintBefore);
        element.insertAfter(toPrintAfter);
    }
}
