package ch.hslu.ad.sw01;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Represents an allocation
 */
public final class Allocation implements Serializable, Comparable<Allocation> {
    private final int startAddress;
    private final int size;

    public Allocation(final int startAddress, final int size) {
        this.startAddress = startAddress;
        this.size = size;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

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
    public int compareTo(Allocation o) {
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
