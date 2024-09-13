package hu.bme.mit.ca.bmc;


import hu.bme.mit.theta.core.stmt.IfStmt;
import hu.bme.mit.theta.core.stmt.LoopStmt;
import hu.bme.mit.theta.core.stmt.NonDetStmt;
import hu.bme.mit.theta.core.stmt.OrtStmt;
import hu.bme.mit.theta.core.stmt.SequenceStmt;
import hu.bme.mit.theta.core.stmt.SkipStmt;
import hu.bme.mit.theta.core.stmt.StmtVisitor;
import hu.bme.mit.theta.core.utils.VarIndexing;

// We do not need to implement all methods of the interface, only the ones used in this lab.
// You can ignore this file and implement the methods missing in the StmtToExprVisitor class.

abstract class StmtToExprVisitorBase implements StmtVisitor<VarIndexing, StmtToExprResult> {

    @Override
    public StmtToExprResult visit(SkipStmt skipStmt, VarIndexing varIndexing) {
        throw new UnsupportedOperationException("SkipStmt is not needed");
    }

    @Override
    public StmtToExprResult visit(SequenceStmt sequenceStmt, VarIndexing varIndexing) {
        throw new UnsupportedOperationException("SequenceStmt is not needed");
    }

    @Override
    public StmtToExprResult visit(NonDetStmt nonDetStmt, VarIndexing varIndexing) {
        throw new UnsupportedOperationException("NonDetStmt is not needed");
    }

    @Override
    public StmtToExprResult visit(OrtStmt ortStmt, VarIndexing varIndexing) {
        throw new UnsupportedOperationException("OrtStmt is not needed");
    }

    @Override
    public StmtToExprResult visit(LoopStmt loopStmt, VarIndexing varIndexing) {
        throw new UnsupportedOperationException("LoopStmt is not needed");
    }

    @Override
    public StmtToExprResult visit(IfStmt ifStmt, VarIndexing varIndexing) {
        throw new UnsupportedOperationException("IfStmt is not needed");
    }
}
