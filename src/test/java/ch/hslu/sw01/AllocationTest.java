package ch.hslu.sw01;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;
import static org.assertj.core.api.Assertions.*;

import ch.hslu.ad.sw01.Allocation;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * Unittests for @{@link ch.hslu.ad.sw01.Allocation}
 */
public class AllocationTest {
    @Test
    public void test_constructor() {
        // Arrange
        int startAddress = 12;
        int size = 5;

        // Act
        Allocation allocation = new Allocation(12,5);

        // Assert
        assertThat(allocation.getStartAddress()).isEqualTo(startAddress);
        assertThat(allocation.getSize()).isEqualTo(size);
    }

    @Test
    public void test_equals() {
        EqualsVerifier.forClass(Allocation.class).verify();
    }

    @Test
    public void test_immutable() {
        assertImmutable(Allocation.class);
    }

}
