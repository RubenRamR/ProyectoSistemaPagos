package utilerias;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;

public class CheckBoxComboBox extends JComboBox<JCheckBox> {
    private final List<String> selectedItems = new ArrayList<>();

    public CheckBoxComboBox(JCheckBox[] items) {
        super(items);
        setRenderer(new ComboBoxRenderer());
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox selectedBox = (JCheckBox) getSelectedItem();
                if (selectedBox != null) {
                    selectedBox.setSelected(!selectedBox.isSelected());
                    updateSelectedItems();
                }
            }
        });
        updateSelectedItems();
    }

    private void updateSelectedItems() {
        selectedItems.clear();
        for (int i = 0; i < getItemCount(); i++) {
            JCheckBox box = getItemAt(i);
            if (box.isSelected()) {
                selectedItems.add(box.getText());
            }
        }
    }

    public List<String> getSelectedItems() {
        return new ArrayList<>(selectedItems); // Return a copy to avoid modification outside
    }

    private class ComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Component) {
                Component component = (Component) value;
                component.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
                component.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
                return component;
            } else {
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        }
    }
}
