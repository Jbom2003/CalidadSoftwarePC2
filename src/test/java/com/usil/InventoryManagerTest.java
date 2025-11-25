package com.usil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    InventoryManager manager;

    @BeforeEach
    void setup() {
        manager = new InventoryManager();
    }

    // Prueba 1: Agregar ítem nuevo exitosamente
    @Test
    void testAddItemNew() {
        manager.addItem("Laptop", 5);
        assertEquals(5, manager.getStock("Laptop"));
    }

    // Prueba 2: Acumular stock de producto existente (Branch coverage)
    @Test
    void testAddItemAccumulate() {
        manager.addItem("Mouse", 10);
        manager.addItem("Mouse", 5);
        assertEquals(15, manager.getStock("Mouse"));
    }

    // Prueba 3: Validar nombre inválido (Nulo, Vacío, Solo espacios)
    @Test
    void testInvalidNameFormat() {
        assertThrows(IllegalArgumentException.class, () -> manager.addItem(null, 5));
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("", 5));
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("   ", 5));
    }

    // Prueba 4: Validar longitud de nombre inválida
    @Test
    void testInvalidNameLength() {
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("A", 5)); // Menor a 2
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("A".repeat(51), 5)); // Mayor a 50
    }

    // Prueba 5: Validar cantidad inválida (Cero o Negativos)
    @Test
    void testInvalidQuantityLow() {
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("Screen", 0));
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("Screen", -1));
    }

    // Prueba 6: Validar límite máximo de stock
    @Test
    void testQuantityLimitExceeded() {
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("Keyboard", 1001));
    }
}