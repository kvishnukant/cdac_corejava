Bytecode verifier

A basic philosophy of Java is that it is inherently "safe" from the standpoint that no user program can "crash" the host machine or otherwise interfere inappropriately with other operations on the host machine, and that it is possible to protect certain functions and data structures belonging to "trusted" code from access or corruption by "untrusted" code executing within the same JVM. Furthermore, common programmer errors that often lead to data corruption or unpredictable behavior such as accessing off the end of an array or using an uninitialized pointer are not allowed to occur. Several features of Java combine to provide this safety, including the class model, the garbage-collected heap, and the verifier.

The JVM verifies all bytecode before it is executed. This verification consists primarily of three types of checks:

    * Branches are always to valid locations
    * Data is always initialized and references are always type-safe
    * Access to "private" or "package private" data and methods is rigidly controlled.

The first two of these checks take place primarily during the "verification" step that occurs when a class is loaded and made eligible for use. The third is primarily performed dynamically, when data items or methods of a class are first accessed by another class.

The verifier permits only some bytecode sequences in valid programs, e.g. a jump (branch) instruction can only target an instruction within the same function or method. Furthermore, the verifier ensures that any given instruction operates on a fixed stack location[6], allowing the JIT compiler to transform stack accesses into fixed register accesses. Because of this, the fact that JVM is a stack architecture does not imply a speed penalty for emulation on register-based architectures when using a JIT compiler. In the face of the code-verified JVM architecture, it makes no difference to a JIT compiler whether it gets named imaginary registers or imaginary stack positions that need to be allocated to the target architecture's registers. In fact, code verification makes the JVM different from a classic stack architecture whose efficient emulation with a JIT compiler is more complicated and typically carried out by a slower interpreter.

Code verification also ensures that arbitrary bit patterns cannot get used as an address. Memory protection is achieved without the need for a Memory management unit (MMU). Thus, JVM is an efficient way of getting memory protection on simple architectures that lack an MMU. 
This is analogous to managed code in Microsoft's .NET Common Language Runtime.