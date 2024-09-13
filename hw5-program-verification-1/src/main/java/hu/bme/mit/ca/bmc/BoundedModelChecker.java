package hu.bme.mit.ca.bmc;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.google.common.base.Stopwatch;

import hu.bme.mit.theta.cfa.CFA;
import hu.bme.mit.theta.cfa.CFA.Edge;
import hu.bme.mit.theta.cfa.CFA.Loc;
import hu.bme.mit.theta.solver.Solver;
import hu.bme.mit.theta.solver.z3.Z3SolverFactory;

public final class BoundedModelChecker implements SafetyChecker {

    private final CFA cfa;
    private final int bound;
    private final int timeout;

    private BoundedModelChecker(final CFA cfa, final int bound, final int timeout) {
        checkArgument(bound >= 0);
        checkArgument(timeout >= 0);
        this.cfa = checkNotNull(cfa);
        this.bound = bound;
        this.timeout = timeout;
    }

    public static BoundedModelChecker create(final CFA cfa, final int bound, final int timeout) {
        return new BoundedModelChecker(cfa, bound, timeout);
    }

    @Override
    public SafetyResult check() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        while (stopwatch.elapsed(TimeUnit.SECONDS) < timeout) {
            // TODO Implement bounded model checker:
            // 		by building an unwinding of the program,
            // 		search for error paths with length not greater than the bound,
            // 		and check their feasibility using the SMT solver.
            // 		See FrameworkTest for an example of how to use solvers and the unfold method.
            // 		Pay attention to use an exploration method that does not unroll loops early.
            throw new UnsupportedOperationException("TODO: Implement me!");
        }

        stopwatch.stop();

        return SafetyResult.TIMEOUT;
    }

}
