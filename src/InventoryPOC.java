import components.map.Map;
import components.map.Map.Pair;
import components.map.MapSecondary;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.set.Set;
import components.set.Set1L;

public class InventoryPOC {

    public static void main(String[] args) {
        Set<String> ElementIDStorage = new Set1L<>();
        Sequence<Set<Map.Pair<String, String>>> AttributeListStorage = new Sequence1L<>();
        Sequence<String> AttributeList = new Sequence1L<>();

    }

    public static void addCategory(
            Sequence<Set<Map.Pair<String, String>>> AttributeListStorage,
            Sequence<String> AttributeList, String name) {
        Set<Map.Pair<String, String>> newCategory = new Set1L<>();
        AttributeListStorage.add(AttributeListStorage.length(), newCategory);
        AttributeList.add(AttributeList.length(), name);
    }

    public static void addElement(Set<String> ElementIDStorage,
            Sequence<Set<Map.Pair<String, String>>> AttributeListStorage,
            String ElementID) {
        ElementIDStorage.add(ElementID);
    }

    public static void addAttribute(
            Sequence<Set<Map.Pair<String, String>>> AttributeListStorage,
            Sequence<String> AttributeList, String name, String value,
            int AttributePosition) {
        Pair<String, String> newAttribute = new SimplePair<>(name, value);
        AttributeListStorage.entry(AttributePosition).add(newAttribute);
    }

}