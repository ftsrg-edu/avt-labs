package hu.bme.mit.ca.bmc;

import hu.bme.mit.theta.core.stmt.AssignStmt;
import hu.bme.mit.theta.core.stmt.AssumeStmt;
import hu.bme.mit.theta.core.stmt.HavocStmt;
import hu.bme.mit.theta.core.type.Expr;
import hu.bme.mit.theta.core.type.Type;
import hu.bme.mit.theta.core.utils.VarIndexing;

/*
Task 1: Define Semantics of Statements

You have to define the semantics of needed statements in the `StmtToExprVisitor` class. For each
statement, you need to return an expression describing the semantics of the statement and the
(potentially) updated indexing as a StmtUnfoldResult object.

Hints:
- First, explore the available properties of the different statements: it might help you find out
  what you need to do.
- A `VarIndexing` object associates indices (versions) to variables. The VarIndexing argument of the
  visit methods specifies the indexing before applying the statement. The `inc` method of
  VarIndexing returns a new VarIndexing where the version of the specified variable is incremented
  (relevant for writing the semantics of assign and havoc statements).
- `ExprUtils.applyPrimes(expr, indexing)` replaces each variable in the expression with its
  corresponding primed version primed as many times as defined by the indexing (e.g., if the index 2
  is associated to `x` in the indexing, then occurrences of `x` in `expr` will be replaced by `x''`)
  and returns the new expression.
- `AbstractExprs.Eq(expr1, expr2)` creates an equality expression between `expr1` and `expr2`.
- `BoolExprs.True()` creates an expression representing true.
 */

// Visitor pattern
public class StmtToExprVisitor extends StmtToExprVisitorBase {
    // Singleton pattern
    public static final StmtToExprVisitor INSTANCE = new StmtToExprVisitor();

    private StmtToExprVisitor() {
    }

    @Override
    public <DeclType extends Type> StmtToExprResult visit(AssignStmt<DeclType> stmt, VarIndexing indexing) {
        Expr<DeclType> lhs = stmt.getVarDecl().getRef(); // reference to assigned variable
        Expr<DeclType> rhs = stmt.getExpr(); // expression to be assigned
        // replace variables with indexed versions, update indexing, create equality expression...
        throw new UnsupportedOperationException("TODO: Implement me!");
    }

    @Override
    public <DeclType extends Type> StmtToExprResult visit(HavocStmt<DeclType> stmt, VarIndexing indexing) {
        throw new UnsupportedOperationException("TODO: Implement me!");
    }

    @Override
    public StmtToExprResult visit(AssumeStmt stmt, VarIndexing indexing) {
        throw new UnsupportedOperationException("TODO: Implement me!");
    }
}
