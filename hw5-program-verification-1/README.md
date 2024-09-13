# Program verification 1: Bounded Model Checking (BMC)

## Buiding with Gradle

- `./gradlew build`

Make sure to run the tests with Gradle so that the library path is set correctly. If you get an unsatisfied link error on Windows, try installing/updating the [Microsoft Visual C++ Redistributable Packages 2012](https://www.microsoft.com/en-us/download/details.aspx?id=30679).

Expect the build to fail at the beginning due to missing implementation and failing tests. To make sure there is no other problem with the build, you can comment the assertions in `BoundedModelCheckerTest` class. Don't forget to uncomment them after finishing the implementation.

## Tasks

### Task 1: Define Semantics of Statements

You have to define the semantics of needed statements in the `StmtToExprVisitor` class. For each statement, you need to return an expression describing the semantics of the statement and the (potentially) updated indexing as a StmtUnfoldResult object.
 
Hints:
- First, explore the available properties of the different statements: it might help you find out what you need to do.
- Use the `inc` method of VarIndexing to increment the version of a variable when assigned.
- `ExprUtils.applyPrimes(expr, indexing)` replaces each variable in the expression with its corresponding primed version primed as many times as defined by the indexing (e.g., if the index 2 is associated to `x` in the indexing, then occurrences of `x` in `expr` will be replaced by `x''`) and returns the new expression.
- `AbstractExprs.Eq(expr1, expr2)` creates an equality expression between `expr1` and `expr2`.
- `BoolExprs.True()` creates an expression representing true.

### Task 2: Implement the Bounded Model Checking Algorithm
Implement the BMC algorithm in the `check` method of the `BoundedModelChecker` class.

Passing all tests in `BoundedModelCheckerTest` is a necessary condition for passing the assignment. Also, avoid using any external libraries in your implementation other than the ones already defined. Do not unwind the CFA in a depth-first manner.

Remember: you only need to modify the code of the `BoundedModelChecker` and `StmtToExprVisitor` classes.