package com.panish.mvel;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.integration.Interceptor;
import org.mvel2.integration.VariableResolverFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InterceptorEx {

    public static void main(String[] args) {

        // Create a new ParserContext
        ParserContext context = new ParserContext();

        Map<String, Interceptor> myInterceptors = new HashMap<>();

        // Create a simple interceptor.
        Interceptor myInterceptor = new Interceptor() {
            @Override
            public int doBefore(ASTNode astNode, VariableResolverFactory variableResolverFactory) {
                System.out.println("BEFORE!");
                return 0;
            }

            @Override
            public int doAfter(Object o, ASTNode astNode, VariableResolverFactory variableResolverFactory) {
                System.out.println("AFTER!");
                return 0;
            }
        };

        // add interceptor to map
        myInterceptors.put("Foo", myInterceptor);

        // add interceptor map to parser context
        context.setInterceptors(myInterceptors);

        // Compile the expression.
        Serializable compiledExpression = MVEL.compileExpression("", context);

    }
}
