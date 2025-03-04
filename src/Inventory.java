package src.Inventory;

import components.sequence.Sequence;

/**
 * The {@code Inventory} interface extends {@code InventoryKernel} and
 * {@code Comparable}, providing additional methods to retrieve elements, filter
 * elements by categories and attributes, and reset the inventory.
 *
 * @param <T>
 *            The data type used for attributes and categories.
 */
public interface Inventory<T> extends InventoryKernel<T> {

    /**
     * Returns the entire element associated with the given ID.
     *
     * @param id
     *            The unique identifier of the element.
     * @return A {@code Sequence} containing all attribute values of the
     *         element.
     * @ensures Returns all attributes associated with the specified element.
     * @requires The element must exist in the inventory.
     */
    Sequence<Object> getElement(String id);

    /**
     * Returns the IDs of elements that have a non-empty value in the specified
     * category.
     *
     * @param name
     *            The name of the category.
     * @return A {@code Sequence} of element IDs that have a non-empty value in
     *         the category.
     * @ensures Returns all element IDs associated with the given category.
     * @requires The category must exist in the inventory.
     */
    Sequence<String> getIDCateogry(String name);

    /**
     * Returns the IDs of elements that have the specified attribute value in
     * the given category.
     *
     * @param name
     *            The name of the category.
     * @param x
     *            The attribute value to search for.
     * @return A {@code Sequence} of element IDs that have the attribute
     *         {@code x} in the category.
     * @ensures Returns all element IDs that match the given attribute value.
     * @requires The category must exist in the inventory.
     */
    Sequence<String> getIDAttribute(String name, T x);

    /**
     * Clears the entire inventory, removing all elements and attributes.
     *
     * @ensures The inventory is emptied, with no elements or attributes
     *          remaining.
     */
    void reset();
}
