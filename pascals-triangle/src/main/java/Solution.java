import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(1));
        addRow(list, numRows - 1);
        return list;
    }

    // Adds new row based on last row
    private void addRow(List<List<Integer>> list, int rowsLeftToAdd) {
        if (rowsLeftToAdd == 0) return;
        List<Integer> lastRow = list.get(list.size() - 1);
        List<Integer> newRow = new ArrayList<>(lastRow.size() + 1);
        newRow.add(1);
        for (int i = 1; i < lastRow.size(); i++) {
            newRow.add(lastRow.get(i - 1) + lastRow.get(i));
        }
        newRow.add(1);

        list.add(newRow);
        addRow(list, rowsLeftToAdd - 1);
    }
}