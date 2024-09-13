package hu.bme.mit.ca.bmc;

import static hu.bme.mit.theta.core.decl.Decls.Var;
import static hu.bme.mit.theta.core.stmt.Stmts.Assign;
import static hu.bme.mit.theta.core.stmt.Stmts.Assume;
import static hu.bme.mit.theta.core.type.inttype.IntExprs.Geq;
import static hu.bme.mit.theta.core.type.inttype.IntExprs.Int;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import hu.bme.mit.theta.core.decl.VarDecl;
import hu.bme.mit.theta.core.model.Valuation;
import hu.bme.mit.theta.core.stmt.Stmt;
import hu.bme.mit.theta.core.type.Expr;
import hu.bme.mit.theta.core.type.booltype.BoolType;
import hu.bme.mit.theta.core.type.inttype.IntType;
import hu.bme.mit.theta.solver.Solver;
import hu.bme.mit.theta.solver.z3.Z3SolverFactory;

public final class FrameworkTest {

	@Test
	public void test() {
		final VarDecl<IntType> x = Var("x", Int());
		final VarDecl<IntType> y = Var("y", Int());

		final List<Stmt> stmts = Arrays.asList(

				Assume(Geq(y.getRef(), Int(0))),

				Assign(x, Int(1)),

				Assign(y, x.getRef()),

				Assume(Geq(y.getRef(), Int(0))));

		System.out.println(stmts);

		final Collection<Expr<BoolType>> exprs = StmtToExprTransformer.unfold(stmts);

		System.out.println(exprs);

		final Solver solver = Z3SolverFactory.getInstance().createSolver();

		solver.add(exprs);
		solver.check();

		assertTrue(solver.getStatus().isSat());

		final Valuation model = solver.getModel();

		System.out.println(model);
	}

}
