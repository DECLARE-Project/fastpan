package de.fakeller.performance.analysis.result.valueobject;

/**
 * Defines value objects for the results.
 * <p>
 * Note: a class implementing a value object MUST implement {@link Object#equals(Object)} and {@link Object#hashCode()}
 * to be equal if the VALUES of the two objects are equal. The default Java implementation compares the object
 * references, which is not what we want for value objects!
 */
public interface ValueObject {

    /**
     * Turns the value object into a human readable string.
     */
    String toHumanReadable();
}
