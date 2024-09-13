package hu.bme.mit.ca.bmc;

import hu.bme.mit.theta.core.stmt.Stmt;
import hu.bme.mit.theta.core.type.Expr;
import hu.bme.mit.theta.core.type.booltype.BoolType;
import hu.bme.mit.theta.core.utils.PathUtils;
import hu.bme.mit.theta.core.utils.VarIndexing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

final class StmtToExprTransformer {

    public static Collection<Expr<BoolType>> unfold(final List<? extends Stmt> stmts) {
        final Collection<Expr<BoolType>> exprs = new ArrayList<>();
        // maps variables to their actual index of occurrence: initially the first version (0) of all variables
        VarIndexing indexing = VarIndexing.all(0);

        for (final Stmt stmt : stmts) {
            // converts the statement to expressions with the current indexing
            final StmtToExprResult result = stmt.accept(StmtToExprVisitor.INSTANCE, indexing);
            // collects the expressions
            exprs.add(result.expr);
            // updates the indexing
            indexing = result.indexing;
        }
        return exprs.stream().map(e -> PathUtils.unfold(e, 0)).collect(toList());
    }
}
