package hu.bme.mit.ca.bmc

import hu.bme.mit.theta.core.decl.Decls.Var
import hu.bme.mit.theta.core.stmt.Stmts.Assign
import hu.bme.mit.theta.core.stmt.Stmts.Assume
import hu.bme.mit.theta.core.type.inttype.IntExprs.Geq
import hu.bme.mit.theta.core.type.inttype.IntExprs.Int
import hu.bme.mit.theta.solver.z3.Z3SolverFactory
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*

class FrameworkTest2 {

	@Test
	fun test() {
		val x = Var("x", Int())
		val y = Var("y", Int())

		val stmts = Arrays.asList(

				Assume(Geq(y.ref, Int(0))),

				Assign(x, Int(1)),

				Assign(y, x.ref),

				Assume(Geq(y.ref, Int(0))))

		println(stmts)

		val exprs = StmtToExprTransformer.unfold(stmts)

		println(exprs)

		val solver = Z3SolverFactory.getInstance().createSolver()

		solver.add(exprs)
		solver.check()

		assertTrue(solver.status.isSat)

		val model = solver.model

		println(model)
	}

}
