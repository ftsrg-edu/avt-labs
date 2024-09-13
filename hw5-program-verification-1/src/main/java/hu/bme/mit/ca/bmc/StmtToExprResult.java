package hu.bme.mit.ca.bmc;

import hu.bme.mit.theta.core.type.Expr;
import hu.bme.mit.theta.core.type.booltype.BoolType;
import hu.bme.mit.theta.core.utils.VarIndexing;

public final class StmtToExprResult {
    final Expr<BoolType> expr;
    final VarIndexing indexing;

    private StmtToExprResult(Expr<BoolType> expr, VarIndexing indexing) {
        this.expr = expr;
        this.indexing = indexing;
    }

    public static StmtToExprResult of(Expr<BoolType> expr, VarIndexing indexing) {
        return new StmtToExprResult(expr, indexing);
    }
}