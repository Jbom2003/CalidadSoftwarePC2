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

    // Prueba 1: Agregar item nuevo
    @Test
    void testAddItemLaptop() {
        manager.addItem("Laptop", 5);
        assertEquals(5, manager.getStock("Laptop"));
    }

    // Prueba 2: Agregar item repetido
    @Test
    void testAddExistingItem() {
        manager.addItem("Mouse", 2);
        manager.addItem("Mouse", 3);
        assertEquals(5, manager.getStock("Mouse"));
    }

    // Prueba 3: Agregar otro producto
    @Test
    void testAddKeyboard() {
        manager.addItem("Keyboard", 10);
        assertEquals(10, manager.getStock("Keyboard"));
    }

    // Prueba 4: Agregar producto con nombre largo
    @Test
    void testAddLongNameProduct() {
        manager.addItem("Gaming Monitor 4K Ultra HD", 1);
        assertEquals(1, manager.getStock("Gaming Monitor 4K Ultra HD"));
    }

    // Prueba 5: Agregar cantidad mínima permitida
    @Test
    void testAddMinQuantity() {
        manager.addItem("USB", 1);
        assertEquals(1, manager.getStock("USB"));
    }

    // Prueba 6: Consultar algo que no existe
    @Test
    void testGetNonExistent() {
        assertEquals(0, manager.getStock("Tablet"));
    }
}