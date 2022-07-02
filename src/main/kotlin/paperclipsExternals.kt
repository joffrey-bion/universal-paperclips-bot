// Those are variables found in the paperclip JS code

/** The current number of paperclips */
external val clips: Number
/** Makes clips */
external fun clipClick(quantity: Long)

/** The current money */
external val funds: Number

/** The current amount of wire */
external val wire: Number
/** The price of 1 spool of wire */
external val wireCost: Number
/** The amount of wire received when buying one spool */
external val wireSupply: Number
/** Buys one spool of wire */
external fun buyWire()

/** The current amount of trust */
external val trust: Number
/** The current number of processors */
external val processors: Number
/** The current amount of memory */
external val memory: Number

/** Spends 1 trust to add 1 processor */
external fun addProc()
/** Spends 1 trust to add 1 unit of memory */
external fun addMem()

/** All possible quantum chips */
external val qChips: Array<QChip>

/** A quantum chip */
external interface QChip {
    /** Whether this QChip is generating ops (meaning it was bought). Boolean as 0 or 1. */
    val active: Number
    /** The current value of this QChip */
    val value: Number
}

/** Runs quantum computation and yields ops based on the current [qChips] alignments. */
external fun qComp()
