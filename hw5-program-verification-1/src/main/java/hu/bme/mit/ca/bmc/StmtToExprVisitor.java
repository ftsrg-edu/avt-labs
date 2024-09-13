package hu.bme.mit.ca.bmc;

import hu.bme.mit.theta.core.stmt.AssignStmt;
import hu.bme.mit.theta.core.stmt.AssumeStmt;
import hu.bme.mit.theta.core.stmt.HavocStmt;
import hu.bme.mit.theta.core.type.Type;
import hu.bme.mit.theta.core.utils.VarIndexing;

// Visitor pattern
public class StmtToExprVisitor extends StmtToExprVisitorBase {
    // Singleton pattern
    public static final StmtToExprVisitor INSTANCE = new StmtToExprVisitor();

    private StmtToExprVisitor() {
    }


    @Override
    public StmtToExprResult visit(AssumeStmt stmt, VarIndexing indexing) {
        throw new UnsupportedOperationException("TODO: Implement me!");
    }

    @Override
    public <DeclType extends Type> StmtToExprResult visit(AssignStmt<DeclType> stmt, VarIndexing indexing) {
        throw new UnsupportedOperationException("TODO: Implement me!");
    }

    @Override
    public <DeclType extends Type> StmtToExprResult visit(HavocStmt<DeclType> stmt, VarIndexing indexing) {
        throw new UnsupportedOperationException("TODO: Implement me!");
    }
}
