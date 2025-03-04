package src.Inventory;

import components.map.Map;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.set.Set;
import components.set.Set1L;
import components.standard.Standard;

/**
 * The {@code InventoryKernel} interface defines the core operations for
 * managing an inventory system, including creating elements, handling
 * attributes, and interacting with storage files.
 *
 * @param <T>
 *            The data type used for attributes and categories.
 */
public interface InventoryKernel<T> extends Standard<Inventory> {

    /**
     * Storage for element IDs.
     */
    Set<String> ElementIDStorage = new Set1L<>();

    /**
     * Storage for attribute lists of elements.
     */
    Sequence<Set<Map.Pair<String, String>>> AttributeListStorage = new Sequence1L<>();

    /**
     * Storage for attribute categories.
     */
    Sequence<String> AttributeList = new Sequence1L<>();

    /**
     * Creates an attributeless element with the given name and stores its
     * unique ID in {@code ElementIDStorage}.
     *
     * @param name
     *            The name of the element to create.
     * @ensures A new element is created, assigned a unique ID, and stored
     *          properly.
     */
    void createElement(String name);

    /**
     * Removes the element associated with the given ID.
     *
     * @param id
     *            The unique identifier of the element to remove.
     * @ensures The element with the specified ID is deleted from the inventory.
     * @requires The element must exist in the inventory.
     * @return A Sequence of the removed element's attributes.
     */
    Sequence<Object> removeElement(String id);

    /**
     * Creates a new category for attributes in the inventory and assigns a
     * default value.
     *
     * @param name
     *            The name of the new category.
     * @param x
     *            The default attribute value for the category.
     * @ensures A new attribute category is added to the inventory with a
     *          default value; Stores the category name in
     *          {@code AttributeList}.
     */
    void createCategory(String name, T x);

    /**
     * Adds an attribute value to an existing element.
     *
     *
     * @param id
     *            The unique identifier of the element.
     * @param x
     *            The attribute value to be assigned.
     * @param name
     *            The name of the attribute category.
     * @ensures The attribute of the specified element is set to {@code x}; The
     *          attribute is added {@code AttributeListStorage}.
     * @requires The element must exist in the inventory and that the category
     *           exists
     */
    void addAttribute(String id, T x, String name);

    /**
     * Retrieves the attribute value of a given element.
     *
     *
     * @param id
     *            The unique identifier of the element.
     * @param name
     *            The name of the attribute.
     * @return The attribute value of the specified element.
     * @ensures Returns the current attribute value of the element.
     * @requires The element and attribute must exist in the inventory.
     */
    T getAttribute(String id, String name);

    /**
     * Returns the data type acceptable for a given category.
     *
     *
     * @param name
     *            The name of the category.
     * @return The data type associated with the category.
     * @ensures Returns the expected data type of the specified category.
     */
    T returnTypeCategory(String name);

    /**
     * Populates the inventory from a given text file.
     *
     *
     * @param name
     *            The name of the text file.
     *
     * @return {@code true} if the file is successfully loaded; {@code false}
     *         otherwise.
     * @ensures The inventory is populated with data from the file if
     *          successful.
     * @requires The file must exist and follow the correct format.
     */
    boolean fillFromTxt(String name);

    /**
     * Stores the current inventory data into a text file.
     *
     *
     * @param name
     *            The name of the text file.
     *
     * @return {@code true} if the inventory data is successfully saved;
     *         {@code false} otherwise.
     * @ensures The inventory data is stored in the specified file if
     *          successful.
     */
    boolean storeToTxt(String name);
}
