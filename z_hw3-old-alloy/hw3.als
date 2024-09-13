open util/integer

one sig CyberPhysicalSystem {
	tasks: set Task,
	computers: set Computer
} {
    // All tasks belong to the CPS.
	tasks = Task and
    // All computers belong the the CPS.
	computers = Computer
}

sig Task {
	severity: one Severity,
	reqSlot: one Int,
	allocatedTo: one Computer
} {
    // The number of required slots must be positive.
	reqSlot > 0
}

enum Severity {
	low,
	medium,
	high,
	critical
}

sig Computer {
	defaultSlots: one Int,
	availableSlots: one Int,
	tasks: set Task
} {
    // The number of default slots must be positive.
	defaultSlots > 0 and
    // The number of available slots must not be negative.
	availableSlots >= 0 and
    // The number of available slots is the number of default slots
    // minus the number of slots requires by the allocated tasks.
	availableSlots = sub[defaultSlots, sum t: tasks | t.reqSlot]
}

// The allocatedTo reference is the inverse of the tasks reference.
fact { allocatedTo = ~tasks }

// Generate a model with exactly 5 tasks, up to 5 computers and
// with 4-bit (signed) integers for the number of slots.
run { } for exactly 5 Task, 5 Computer, 4 Int
