package home_work_4_test;

import home_work_4.DataContainer;
import home_work_4.IntegerComparator;
import home_work_4.StringAlphabeticComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Task_test {
    @Test
    @DisplayName("Проверка конструктора")
    public void testConstructor() {
        DataContainer<Integer> emptyContainer = new DataContainer<>(new Integer[0]);
        assertNotNull(emptyContainer.getItems());
        assertEquals(0, emptyContainer.getItems().length);

        DataContainer<Double> doubleContainer = new DataContainer<>(new Double[]{3.5d, 4.3d, 1.1d});
        assertNotNull(doubleContainer.getItems());
        assertEquals(3, doubleContainer.getItems().length);
        assertArrayEquals(new Double[]{3.5d, 4.3d, 1.1d}, doubleContainer.getItems());

        DataContainer<String> stringContainer = new DataContainer<>(new String[4]);
        assertNotNull(stringContainer.getItems());
        assertEquals(4, stringContainer.getItems().length);
        assertArrayEquals(new String[]{null, null, null, null}, stringContainer.getItems());
    }

    @Test
    @DisplayName("Проверка добавления данных")
    public void testAdd() {
        DataContainer<Integer> container = new DataContainer<>(new Integer[0]);

        int position = container.add(777);
        assertEquals(0, position);
        assertEquals(1, container.getItems().length);
        assertArrayEquals(new Integer[]{777}, container.getItems());

        position = container.add(null);
        assertEquals(-1, position);
        assertEquals(1, container.getItems().length);
        assertArrayEquals(new Integer[]{777}, container.getItems());

        position = container.add(345);
        assertEquals(1, position);
        assertEquals(2, container.getItems().length);
        assertArrayEquals(new Integer[]{777, 345}, container.getItems());

        container = new DataContainer<>(new Integer[2]);

        position = container.add(123);
        assertEquals(0, position);
        assertEquals(2, container.getItems().length);
        assertArrayEquals(new Integer[]{123, null}, container.getItems());

        position = container.add(null);
        assertEquals(-1, position);
        assertEquals(2, container.getItems().length);
        assertArrayEquals(new Integer[]{123, null}, container.getItems());

        position = container.add(345);
        assertEquals(1, position);
        assertEquals(2, container.getItems().length);
        assertArrayEquals(new Integer[]{123, 345}, container.getItems());

        position = container.add(567);
        assertEquals(2, position);
        assertEquals(3, container.getItems().length);
        assertArrayEquals(new Integer[]{123, 345, 567}, container.getItems());

        container = new DataContainer<>(new Integer[]{1, null, 3, null, null});

        position = container.add(777);
        assertEquals(1, position);
        assertEquals(5, container.getItems().length);
        assertArrayEquals(new Integer[]{1, 777, 3, null, null}, container.getItems());

        position = container.add(null);
        assertEquals(-1, position);
        assertEquals(5, container.getItems().length);
        assertArrayEquals(new Integer[]{1, 777, 3, null, null}, container.getItems());

        position = container.add(123);
        assertEquals(3, position);
        assertEquals(5, container.getItems().length);
        assertArrayEquals(new Integer[]{1, 777, 3, 123, null}, container.getItems());

        position = container.add(345);
        assertEquals(4, position);
        assertEquals(5, container.getItems().length);
        assertArrayEquals(new Integer[]{1, 777, 3, 123, 345}, container.getItems());

        container = new DataContainer<>(new Integer[]{1, 2, 3, null, null, null});

        position = container.add(777);
        assertEquals(3, position);
        assertEquals(6, container.getItems().length);
        assertArrayEquals(new Integer[]{1, 2, 3, 777, null, null}, container.getItems());

        position = container.add(null);
        assertEquals(-1, position);
        assertEquals(6, container.getItems().length);
        assertArrayEquals(new Integer[]{1, 2, 3, 777, null, null}, container.getItems());

        position = container.add(345);
        assertEquals(4, position);
        assertEquals(6, container.getItems().length);
        assertArrayEquals(new Integer[]{1, 2, 3, 777, 345, null}, container.getItems());

        position = container.add(567);
        assertEquals(5, position);
        assertEquals(6, container.getItems().length);
        assertArrayEquals(new Integer[]{1, 2, 3, 777, 345, 567}, container.getItems());
    }

    @Test
    @DisplayName("Проверка получения элемента по номеру позиции")
    public void testGet() {
        DataContainer<Integer> container = new DataContainer<>(new Integer[0]);
        assertNull(container.get(-1));
        assertNull(container.get(0));

        DataContainer<String> strContainer = new DataContainer<>(new String[]{"Test1", null, "Test3"});
        assertNull(strContainer.get(-1));
        assertEquals("Test1", strContainer.get(0));
        assertEquals(null, strContainer.get(1));
        assertEquals("Test3", strContainer.get(2));
        assertNull(strContainer.get(3));

        strContainer.add("Test2");
        assertEquals("Test2", strContainer.get(1));

        strContainer.add("Test4");
        assertEquals("Test4", strContainer.get(3));
        assertNull(strContainer.get(4));
    }

    @Test
    @DisplayName("Проверка получения массива данных")
    public void testGetItems() {
        DataContainer<Integer> emptyContainer = new DataContainer<>(new Integer[0]);
        assertNotNull(emptyContainer.getItems());
        assertEquals(0, emptyContainer.getItems().length);

        DataContainer<String> stringContainer = new DataContainer<>(new String[]{"Test1", null, "Test2"});
        assertEquals(3, stringContainer.getItems().length);
        assertArrayEquals(new String[]{"Test1", null, "Test2"}, stringContainer.getItems());

        DataContainer<Double> doubleContainer = new DataContainer<>(new Double[2]);
        assertEquals(2, doubleContainer.getItems().length);
        assertArrayEquals(new Double[]{null, null}, doubleContainer.getItems());
    }

    @Test
    @DisplayName("Проверка удаления элемента по индексу")
    public void testDeleteByIndex() {
        DataContainer<String> container = new DataContainer<>(new String[]{"Test1", null, "Test2", "Test3"});

        assertFalse(container.delete(-1));
        assertNotNull(container.getItems());
        assertEquals(4, container.getItems().length);
        assertArrayEquals(new String[]{"Test1", null, "Test2", "Test3"}, container.getItems());

        assertFalse(container.delete(4));
        assertNotNull(container.getItems());
        assertEquals(4, container.getItems().length);
        assertArrayEquals(new String[]{"Test1", null, "Test2", "Test3"}, container.getItems());

        assertTrue(container.delete(1));
        assertNotNull(container.getItems());
        assertEquals(3, container.getItems().length);
        assertArrayEquals(new String[]{"Test1", "Test2", "Test3"}, container.getItems());

        assertTrue(container.delete(1));
        assertNotNull(container.getItems());
        assertEquals(2, container.getItems().length);
        assertArrayEquals(new String[]{"Test1", "Test3"}, container.getItems());

        assertTrue(container.delete(1));
        assertNotNull(container.getItems());
        assertEquals(1, container.getItems().length);
        assertArrayEquals(new String[]{"Test1"}, container.getItems());

        assertTrue(container.delete(0));
        assertNotNull(container.getItems());
        assertEquals(0, container.getItems().length);
        assertArrayEquals(new String[]{}, container.getItems());

        assertFalse(container.delete(0));
        assertNotNull(container.getItems());
        assertEquals(0, container.getItems().length);
    }

    @Test
    @DisplayName("Проверка удаления элемента")
    public void testDeleteByItem() {
        DataContainer<String> container = new DataContainer<>(new String[]{"Test1", null, "Test2", "Test3", "Test2"});

        assertFalse(container.delete(""));
        assertNotNull(container.getItems());
        assertEquals(5, container.getItems().length);
        assertArrayEquals(new String[]{"Test1", null, "Test2", "Test3", "Test2"}, container.getItems());

        assertFalse(container.delete("Test4"));
        assertNotNull(container.getItems());
        assertEquals(5, container.getItems().length);
        assertArrayEquals(new String[]{"Test1", null, "Test2", "Test3", "Test2"}, container.getItems());

        assertFalse(container.delete(null));
        assertNotNull(container.getItems());
        assertEquals(5, container.getItems().length);
        assertArrayEquals(new String[]{"Test1", null, "Test2", "Test3", "Test2"}, container.getItems());

        assertTrue(container.delete("Test2"));
        assertNotNull(container.getItems());
        assertEquals(4, container.getItems().length);
        assertArrayEquals(new String[]{"Test1", null, "Test3", "Test2"}, container.getItems());

        assertTrue(container.delete("Test2"));
        assertNotNull(container.getItems());
        assertEquals(3, container.getItems().length);
        assertArrayEquals(new String[]{"Test1", null, "Test3"}, container.getItems());

        assertTrue(container.delete("Test1"));
        assertNotNull(container.getItems());
        assertEquals(2, container.getItems().length);
        assertArrayEquals(new String[]{null, "Test3"}, container.getItems());

        assertTrue(container.delete("Test3"));
        assertNotNull(container.getItems());
        assertEquals(1, container.getItems().length);
        assertArrayEquals(new String[]{null}, container.getItems());

        DataContainer<Integer> intContainer = new DataContainer<>(new Integer[]{55, null, 33});

        assertFalse(intContainer.delete(null));
        assertNotNull(intContainer.getItems());
        assertEquals(3, intContainer.getItems().length);
        assertArrayEquals(new Integer[]{55, null, 33}, intContainer.getItems());

        assertFalse(intContainer.delete(Integer.valueOf(44)));
        assertNotNull(intContainer.getItems());
        assertEquals(3, intContainer.getItems().length);
        assertArrayEquals(new Integer[]{55, null, 33}, intContainer.getItems());

        assertTrue(intContainer.delete(Integer.valueOf(55)));
        assertNotNull(intContainer.getItems());
        assertEquals(2, intContainer.getItems().length);
        assertArrayEquals(new Integer[]{null, 33}, intContainer.getItems());

        assertTrue(intContainer.delete(Integer.valueOf(33)));
        assertNotNull(intContainer.getItems());
        assertEquals(1, intContainer.getItems().length);
        assertArrayEquals(new Integer[]{null}, intContainer.getItems());
    }

    @Test
    @DisplayName("Проверка сортировки")
    public void testSort() {
        DataContainer<String> container = new DataContainer<>(new String[]{"Привет", null, "Как дела", "Работаю", null, "Давай потом"});
        container.sort(new StringAlphabeticComparator());
        assertEquals(6, container.getItems().length);
        assertArrayEquals(new String[]{null, null, "Давай потом", "Как дела", "Привет", "Работаю"}, container.getItems());

        DataContainer<Integer> intContainer = new DataContainer<>(new Integer[]{55, 77, 33, 99});
        intContainer.sort(new IntegerComparator());
        assertEquals(4, intContainer.getItems().length);
        assertArrayEquals(new Integer[]{33, 55, 77, 99}, intContainer.getItems());

        intContainer = new DataContainer<>(new Integer[]{});
        intContainer.sort(new IntegerComparator());
        assertEquals(0, intContainer.getItems().length);
        assertArrayEquals(new Integer[]{}, intContainer.getItems());

        intContainer = new DataContainer<>(new Integer[]{0, 0, 0});
        intContainer.sort(new IntegerComparator());
        assertEquals(3, intContainer.getItems().length);
        assertArrayEquals(new Integer[]{0, 0, 0}, intContainer.getItems());
    }

    @Test
    @DisplayName("Проверка печати массива")
    public void testToString() {
        DataContainer<Integer> intContainer = new DataContainer<>(new Integer[]{55, 77, 33});
        assertEquals("[55, 77, 33]", intContainer.toString());

        intContainer = new DataContainer<>(new Integer[]{55, null, 33});
        assertEquals("[55, 33]", intContainer.toString());

        intContainer = new DataContainer<>(new Integer[0]);
        assertEquals("[]", intContainer.toString());

        intContainer = new DataContainer<>(new Integer[]{null, null});
        assertEquals("[]", intContainer.toString());

        DataContainer<String> strContainer = new DataContainer<>(new String[]{"Привет", null, "Как дела", "Работаю", null, "Давай потом"});
        assertEquals("[Привет, Как дела, Работаю, Давай потом]", strContainer.toString());
    }
}
