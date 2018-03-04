package ch.hslu.ad.sw01;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Represents an allocation.
 */
public final class Allocation implements Serializable, Comparable<Allocation> {
    private final int startAddress;
    private final int size;

    /**
     * Create a new Allocation.
     * @param startAddress the start address of the allocation
     * @param size the size of the allocation
     */
    public Allocation(final int startAddress, final int size) {
        this.startAddress = startAddress;
        this.size = size;
    }

    /**
     * Return the start address of the allocation.
     */
    public int getStartAddress() {
        return startAddress;
    }

    /**
     * Return the size of the allocation
     */
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Allocation that = (Allocation) o;

        return new EqualsBuilder()
                .append(startAddress, that.startAddress)
                .append(size, that.size)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(startAddress)
                .append(size)
                .toHashCode();
    }

    @Override
    public int compareTo(final Allocation o) {
        return Integer.compare(this.startAddress, o.startAddress);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("startAddress", startAddress)
                .append("size", size)
                .toString();
    }

}
